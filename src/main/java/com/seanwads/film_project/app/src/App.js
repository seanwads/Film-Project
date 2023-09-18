import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import { Navbar, NavbarBrand, Container, Button, Card, CardBody, CardTitle, CardText, ButtonGroup, Form, FormGroup, Label, Input } from 'reactstrap';

export default function App() {

  const[filmResponse, setFilmResponse] = useState([]);
  let isLoading = true;

  useEffect(() => {
    if(isLoading){
      fetchFilmData('http://localhost:8080/demo/allFilms');
      isLoading=false;
    }
    
  }, [])

  async function fetchFilmData(link) {
    const response = await fetch(link);
    const body = await response.json();
    setFilmResponse(body);
  }

  function FetchFilteredList(i){
    fetchFilmData('http://localhost:8080/demo/filterFilmsByCategory?id=' + i);
  }


  return (
    <div className="App">
      <Navbar color='dark'>
        <NavbarBrand>Totally Real And Not Auto-Generated Movies</NavbarBrand>
      </Navbar>
      <div className='list'>
      <div className='filter-bar'>
        <FilterBar getFilteredList={FetchFilteredList} />
      </div>
        <FilmList filmList={ filmResponse } />
      </div>
    </div>
  );
}

function FilmList({ filmList }){

  
  return(
    <div className='film-list'>
      <AddCard totalFilms={filmList}/>
      {filmList.map(film =>
        <FilmCard idKey={film.film_id} filmInfo={film} />
      )}
    </div>
  );
}

function FilmCard({ idKey, filmInfo }){

  const initialUpdateDiv = (" ");
  const[updateDiv, setUpdateDiv] = useState(initialUpdateDiv);
  let updateActive = false;

  const handleSubmit = (event) => {
    event.preventDefault();
  }


  async function deleteFilm(id){
    await fetch('http://localhost:8080/demo/deleteFilm?id=' + id, {method:'DELETE'});
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
              <Label for="name_edit_input" className='mr-sm-2'>Change Title:</Label>
              <Input type="number" name="name_edit_input" id="name_edit_input"/>
            </FormGroup>
            <Button type='submit'>Submit</Button>
          </Form>
      ) 
      updateActive = true;
    }
  }
  
  return(
    <Card key={idKey}>
    <CardBody>
            <CardTitle>
              {filmInfo.title}
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


//controls to filter films by categories
function FilterBar({ getFilteredList }){

  function getFilter(i){
    getFilteredList(i);
  }

  const [rSelected, setRSelected] = useState(null);

  return(
    <Container fluid>
      <h2 style={{ padding:5}}>Filter by category:</h2>

      <ButtonGroup>
        <FilterButton 
          clickGetFilter={() => getFilter(0)} 
          clickSelected={() => setRSelected(0)} 
          categoryName={"All"}
          categoryId={0}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(1)} 
          clickSelected={() => setRSelected(1)} 
          categoryName={"Action"}
          categoryId={1}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(2)} 
          clickSelected={() => setRSelected(2)} 
          categoryName={"Adventure"}
          categoryId={2}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(3)} 
          clickSelected={() => setRSelected(3)} 
          categoryName={"Children"}
          categoryId={3}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(4)} 
          clickSelected={() => setRSelected(4)} 
          categoryName={"Classics"}
          categoryId={4}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(5)} 
          clickSelected={() => setRSelected(5)} 
          categoryName={"Comedy"}
          categoryId={5}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(6)} 
          clickSelected={() => setRSelected(6)} 
          categoryName={"Documentary"}
          categoryId={6}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(7)} 
          clickSelected={() => setRSelected(7)} 
          categoryName={"Drama"}
          categoryId={7}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(8)} 
          clickSelected={() => setRSelected(8)} 
          categoryName={"Family"}
          categoryId={8}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(9)} 
          clickSelected={() => setRSelected(9)} 
          categoryName={"Foreign"}
          categoryId={9}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(10)} 
          clickSelected={() => setRSelected(10)} 
          categoryName={"Games"}
          categoryId={10}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(11)} 
          clickSelected={() => setRSelected(11)} 
          categoryName={"Horror"}
          categoryId={10}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(12)} 
          clickSelected={() => setRSelected(12)} 
          categoryName={"Music"}
          categoryId={12}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(13)} 
          clickSelected={() => setRSelected(13)} 
          categoryName={"New"}
          categoryId={13}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(14)} 
          clickSelected={() => setRSelected(14)} 
          categoryName={"Sci-Fi"}
          categoryId={14}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(15)} 
          clickSelected={() => setRSelected(15)} 
          categoryName={"Sports"}
          categoryId={15}
          isSelected={rSelected}/>
        <FilterButton 
          clickGetFilter={() => getFilter(16)} 
          clickSelected={() => setRSelected(16)} 
          categoryName={"Travel"}
          categoryId={16}
          isSelected={rSelected}/>
      </ButtonGroup>
      
    </Container>
  )
}

//individual filter button as part of overall filter bar
function FilterButton({ clickGetFilter, clickSelected, categoryName, categoryId, isSelected}){

  function handleClick(filter, selected){
    filter();
    selected();
  }

  return(
    <Button 
      className='filterButton'
      color="primary"
      size='sm'
      outline
      onClick={() => {handleClick(clickGetFilter, clickSelected)}}
      active={isSelected===categoryId}
      >
        <div className='category-name'>
          {categoryName}
        </div>

      </Button>
  )
}

function AddCard({ totalFilms }){

  const[nextID, setNextID] = useState(1001);

  const[cardContent, setCardContent] = useState(<Button onClick={() => {initAddCardMenu()}}>Add</Button>);

  const initialFormState = {
    id: '',
    title: '',
    description:'',
    year: ''
  };

  const[film, setFilm] = useState(initialFormState);

  function initAddCardMenu(){
    setCardContent(
      <Form inline onSubmit={submitForm}>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="id-input" className='mr-sm-2'>Film Id:</Label>
            <Input type="number" name="id-name" id="id-input" min={nextID} value={film.id || ''} onChange={handleChange}/>
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="title-input" className='mr-sm-2'>Film Title:</Label>
            <Input type="text" placeholder="GARFIELD: THE MOVIE" name="title-name" id="title-input" value={film.title || ''} onChange={handleChange}/>
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="description-input" className='mr-sm-2'>Film Description:</Label>
            <Input type="text" placeholder="A family movie about a cat" name="description-name" id="description-input" value={film.description || ''} onChange={handleChange}/>
          </FormGroup>
          <FormGroup className="mb-2 mr-sm-2 mb-sm-0">
            <Label for="year-input" className='mr-sm-2'>Release Year:</Label>
            <Input type="number" placeholder="2004" name="year-name" id="year-input" value={film.year || ''} onChange={handleChange}/>
          </FormGroup>
          <Button type='submit'>Submit</Button>
        </Form>
    );
  }

  const handleChange = (event) => {
    const { name, value} = event.target;
    setFilm({...film, [name]: value});
  }


  const submitForm = async(event) => {
    event.preventDefault();

    await fetch('http://localhost:8080/demo/createFilm', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',

      },
      body: JSON.stringify(film)
    });
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
