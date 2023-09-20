import { useEffect, useState } from 'react';
import { Navbar, NavbarBrand, Container, Button, Card, CardBody, CardTitle, CardText, ButtonGroup, Form, FormGroup, Label, Input } from 'reactstrap';

export default function AddCard({ updateFilms}){

  
    const[cardContent, setCardContent] = useState(<Button onClick={() => {initAddCardMenu()}}>Add</Button>);
  


    function initAddCardMenu(){
        setCardContent(
        <Form inline onSubmit={submitForm}>
  
            <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
              <Label for="title-input" className='mr-sm-2'>Film Title:</Label>
              <Input type="text" placeholder="GARFIELD: THE MOVIE" name="titleInput" id="titleInput" />
            </FormGroup>
  
            <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
              <Label for="description-input" className='mr-sm-2'>Film Description:</Label>
              <Input type="text" placeholder="A family movie about a cat" name="descriptionInput" id="descriptionInput" />
            </FormGroup>
  
            <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
              <Label for="year-input" className='mr-sm-2'>Release Year:</Label>
              <Input type="number" placeholder="2004" name="yearInput" id="yearInput"/>
            </FormGroup>
  
            <Button type='submit'>Submit</Button>
  
          </Form>
      );
    }
  
    const submitForm = async(event) => {
  
      event.preventDefault();
  
      await fetch('http://localhost:8080/demo/createFilm', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
          "id": "0",
          "title": event.target.titleInput.value,
          "description": event.target.descriptionInput.value,
          "release_year": event.target.yearInput.value,
          "language_id": "1"
        })});
  
        updateFilms();
  
    }
  
  
    return(
      <Card id="add-card">
        <CardTitle>ADD FILM</CardTitle>
        <CardBody>
          {cardContent}
        </CardBody>
      </Card>
    )
}