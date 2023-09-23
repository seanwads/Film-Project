import {  useState } from 'react';
import { Button, Card, CardBody, CardTitle, CardText, ButtonGroup, Form, FormGroup, Label, Input } from 'reactstrap';

export default function FilmCard({ filmInfo, fetchFilms, updateCardCount }){
  
    const[updateActive, setUpdateActive] = useState(false);
  
  
    async function updateCard(){
        setUpdateActive(!updateActive);
    }
    

    return (
        <Card key={filmInfo.film_id} data-testid={'film-card-' + filmInfo.film_id}>
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
        await fetch('http://localhost:8080/demo/deleteFilmByID?id=' + film.film_id, {method:'DELETE'});
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
                <Button color='primary' outline onClick={() => updateFilm(film.film_id)}>Update</Button>
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
            "film_id": film.film_id,
            "title": event.target.nameEditInput.value,
            "description": film.description,
            "releaseYear": film.year,
            "languageId": film.language_id
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