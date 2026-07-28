import React from 'react'

export default function VehicleCard({vehicle}) {
  return (
    <div className='card'>
        
        <h3>{vehicle.registrationNumber}</h3>
        <p>{vehicle.brand}</p>
        <p>{vehicle.model}</p>
        <p>{vehicle.manufacturingYear}</p>
       
    </div>
  )
}
