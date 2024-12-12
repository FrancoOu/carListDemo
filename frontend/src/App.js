// src/App.js
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import SearchBar from './components/SearchBar';
import CarList from './components/CarList';
import './App.css';

const App = () => {
    const [cars, setCars] = useState([]);
    const [page, setPage] = useState(1);
    const [hasMore, setHasMore] = useState(true);
    const [filters, setFilters] = useState({});

    const fetchCars = async (newFilters, append=false) => {
        try {
            if(!append){
                setPage(1);
            }
            const params = {
                page: append ? page:1,
                size: 10,
            };
            if (newFilters.maker) {
                params.maker = newFilters.maker
                setFilters({maker:newFilters.maker})
            };
            if (newFilters.model) {
                params.model = newFilters.model;
                setFilters({model:newFilters.model})
            }
            if (newFilters.year) {
                params.year = newFilters.year;
                setFilters({year:newFilters.year})
            }
            const response = await axios.get('http://localhost:8000/car', { params });
            const newCars = response.data.data.cars;
            setCars((prevCars)=>{
                if (append){
                    return [...prevCars, ...newCars];
                }else {
                    return newCars;
                }
            })

            setHasMore(response.data.data.totalPages > params.page);
        } catch (error) {
          console.error('Error fetching cars:', error);
        }
      };

    const loadMore = () => {
        setPage((prevPage) => prevPage + 1);
    };
    useEffect(()=>{
        fetchCars(filters, true);
    },[page])
      return (
          <div className="App">
            <h1>Car Search</h1>
            <SearchBar onSearch={(filters) => {
                fetchCars(filters, false);
            }} />
            <CarList cars={cars} />
              {hasMore && (
                  <button onClick={loadMore} className="load-more">
                      Load More
                  </button>
              )}
          </div>

      );
    };

export default App;
