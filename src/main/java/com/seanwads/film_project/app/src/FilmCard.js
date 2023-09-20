import { useEffect, useState } from 'react';
import { Navbar, NavbarBrand, Container, Button, Card, CardBody, CardTitle, CardText, ButtonGroup, Form, FormGroup, Label, Input } from 'reactstrap';

export default function FilmCard({ filmInfo, fetchFilms }){

    const initialUpdateDiv = (" ");
  
    const[updateDiv, setUpdateDiv] = useState(initialUpdateDiv);
  
  
    let updateActive = false;
  
  
    const handleSubmit = async (event) => {
      event.preventDefault();
  
      await fetch('http://localhost:8080/demo/updateFilm', {
        method:'PUT',
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify({
          "id": filmInfo.id,
          "title": event.target.nameEditInput.value,
          "description": filmInfo.description,
          "year": filmInfo.year,
          "language_id": filmInfo.language_id
        })
      });
  
      fetchFilms();
      setUpdateDiv(initialUpdateDiv);
      updateActive = false;
  
    }
  
  
    async function deleteFilm(){
      await fetch('http://localhost:8080/demo/deleteFilm?id=' + filmInfo.id, {method:'DELETE'});
      fetchFilms();
    }
  
    async function updateFilm(){
  
      if(updateActive){
        setUpdateDiv(initialUpdateDiv);
        updateActive = false;
      }
      else{
        setUpdateDiv(
          <Form inline onSubmit={handleSubmit}>
              <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
                <Label for="nameEditInput" className='mr-sm-2'>Change Title:</Label>
                <Input type="text" name="nameEditInput" id="nameEditInput"/>
              </FormGroup>
              <Button type='submit' color='success' outline>Submit</Button>
            </Form>
        ) 
        updateActive = true;
      }
    }
  
    
    return(
      <Card key={filmInfo.id}>
      <CardBody>
              <CardTitle>
                {filmInfo.id}. { filmInfo.title } 
              </CardTitle>
              <CardText>
                {filmInfo.description}
              </CardText>
  
              <ButtonGroup>
              <Button color='primary' outline onClick={() => updateFilm(filmInfo.id)}>Update</Button>
              <Button color='danger' outline onClick={() => deleteFilm(filmInfo.id)}>Delete</Button>
              </ButtonGroup>
  
              {updateDiv}
  
            </CardBody>
    </Card>
    )
  }