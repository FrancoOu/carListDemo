// src/components/CarList.js
import React from 'react';

const CarList = ({ cars }) => {
    return (
        <div className="car-list">
            {cars.length > 0 ? (
                cars.map((car) => (
                    <div key={car.id} className="car-item">
                        <h3>
                            {car.id}
                            {car.maker} {car.model} ({car.year})
                        </h3>
                        <p>Price: ${car.price}</p>
                        <p>Color: {car.color}</p>
                        <p>Mileage: {car.mileage} km</p>
                    </div>
                ))
            ) : (
                <p>No cars found.</p>
            )}
        </div>
    );
};

export default CarList;
