import {  useState } from 'react';
import { Button, Card, CardBody, CardTitle, CardText, ButtonGroup, Form, FormGroup, Label, Input } from 'reactstrap';

export default function FilmCard({ filmInfo, fetchFilms, updateCardCount }){
  
    const[updateActive, setUpdateActive] = useState(false);
  
  
    async function updateCard(){
        setUpdateActive(!updateActive);
    }
    

    return (
        <Card key={filmInfo.id} data-testid={'film-card-' + filmInfo.id}>
            {updateActive
                ? <UpdateForm 
                    film={filmInfo}
                    updateFilm={() => updateCard()}
                    fetchFilmList={() => fetchFilms(0)}/>
                : <InfoCard
                    film={filmInfo}
                    updateFilm={() => updateCard()}
                    fetchFilmList={() => fetchFilms(0)}/>
            }
        </Card>
    )
    
}

function InfoCard({ film, updateFilm, fetchFilmList }){

    async function deleteFilm(){
        await fetch('http://localhost:8080/demo/deleteFilmByID?id=' + film.id);
        fetchFilmList();
      }

    return(
        <div>
            <CardBody>
                <CardTitle>
                    { film.title } 
                </CardTitle>

                <CardText>
                    {film.description}
                </CardText>

                <ButtonGroup>
                <Button color='primary' outline onClick={() => updateFilm(film.id)}>Update</Button>
                <Button color='danger' outline onClick={() => deleteFilm()}>Delete</Button>
                </ButtonGroup>

            </CardBody>
        </div>
    )
}

function UpdateForm({ film, updateFilm, fetchFilmList }){

    const handleSubmit = async (event) => {
        event.preventDefault();
    
        await fetch('http://localhost:8080/demo/updateFilm', {
          method:'PUT',
          headers:{'Content-Type': 'application/json'},
          body: JSON.stringify({
            "id": film.id,
            "title": event.target.nameEditInput.value,
            "description": film.description,
            "year": film.year,
            "language_id": film.language_id
          })
        });
    
        fetchFilmList();
        updateFilm();
    }

    return(
        <div>
            <Form inline onSubmit={handleSubmit}>
              <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
                <Label for="nameEditInput" className='mr-sm-2'>Change Title:</Label>
                <Input type="text" name="nameEditInput" id="nameEditInput" defaultValue={film.title}/>
              </FormGroup>
              <Button type='submit' color='success' outline>Submit</Button>
            </Form>
        </div>
    )
}