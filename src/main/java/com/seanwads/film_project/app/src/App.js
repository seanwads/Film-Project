import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';

export default function App() {

  const[filmResponse, setFilmResponse] = useState([]);

  useEffect(() => {
    fetchData();
  }, [])

  async function fetchData() {
    const response = await fetch('http://localhost:8080/demo/allFilms');
    const body = await response.json();
    setFilmResponse(body);
  }


  return (
    <div className="App">
      <header className="App-header">
        <FilmList filmList={ filmResponse } />
      </header>
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
