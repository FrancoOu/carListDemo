// src/components/SearchBar.js
import React, { useState } from 'react';

const SearchBar = ({ onSearch }) => {
    const [maker, setMaker] = useState('');
    const [model, setModel] = useState('');
    const [year, setYear] = useState('');

    const handleSearch = () => {
        onSearch({ maker, model, year });
    };

    return (
        <div className="search-bar">
            <input
                type="text"
                placeholder="Maker (e.g., Audi)"
                value={maker}
                onChange={(e) => setMaker(e.target.value)}
            />
            <input
                type="text"
                placeholder="Model (e.g., A5)"
                value={model}
                onChange={(e) => setModel(e.target.value)}
            />
            <input
                type="number"
                placeholder="Year (e.g., 2020)"
                value={year}
                onChange={(e) => setYear(e.target.value)}
            />
            <button onClick={handleSearch}>Search</button>
        </div>
    );
};

export default SearchBar;
