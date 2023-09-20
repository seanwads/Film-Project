import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import { Navbar, NavbarBrand, Container, Button, Card, CardBody, CardTitle, CardText, ButtonGroup, Form, FormGroup, Label, Input } from 'reactstrap';
import FilmCard from './FilmCard';
import FilterBar from './FilterBar';
import AddCard from './AddCard';

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

      <div className='film-list'>
      <AddCard 
        totalFilms={filmResponse}
        updateFilms={() => FetchFilteredList(0)}
        />

      { filmResponse.map(film =>
        <FilmCard 
        filmInfo={film}
          fetchFilms={() => FetchFilteredList(0)} 
          />
      )}
    </div>

      </div>
    </div>
  );
}



