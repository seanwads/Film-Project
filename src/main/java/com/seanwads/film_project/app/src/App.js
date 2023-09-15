import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import { Navbar, NavbarBrand, Container, Button } from 'reactstrap';

export default function App() {

  const[filmResponse, setFilmResponse] = useState([]);
  let isLoading = true;

  useEffect(() => {
    if(isLoading){
      fetchData('http://localhost:8080/demo/allFilms');
      isLoading=false;
    }
    
  }, [])

  async function fetchData(link) {
    const response = await fetch(link);
    const body = await response.json();
    setFilmResponse(body);
  }

  function FetchFilteredList(i){
    fetchData('http://localhost:8080/demo/filterFilmsByCategory?id=' + i);
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
      {filmList.map(film =>
        <div key={film.film_id}>
          {film.title}
        </div>
      )}
    </div>
  );
}

function FilterBar({ getFilteredList }){

  function getFilter(i){
    getFilteredList(i);
  }

  return(
    <Container fluid>
      <h2>Filter by category:</h2>
      <Button onClick={() => getFilter(0)}>All</Button>
      <Button onClick={() => getFilter(1)}>Action</Button>
      <Button onClick={() => getFilter(2)}>Animation</Button>
      <Button onClick={() => getFilter(3)}>Children</Button>
      <Button onClick={() => getFilter(4)}>Classics</Button>
      <Button onClick={() => getFilter(5)}>Comedy</Button>
      <Button onClick={() => getFilter(6)}>Documentary</Button>
      <Button onClick={() => getFilter(7)}>Drama</Button>
      <Button onClick={() => getFilter(8)}>Family</Button>
      <Button onClick={() => getFilter(9)}>Foreign</Button>
      <Button onClick={() => getFilter(10)}>Games</Button>
      <Button onClick={() => getFilter(11)}>Horror</Button>
      <Button onClick={() => getFilter(12)}>Music</Button>
      <Button onClick={() => getFilter(13)}>New</Button>
      <Button onClick={() => getFilter(14)}>Sci-Fi</Button>
      <Button onClick={() => getFilter(15)}>Sports</Button>
      <Button onClick={() => getFilter(16)}>Travel</Button>
    </Container>
  )
  
}
