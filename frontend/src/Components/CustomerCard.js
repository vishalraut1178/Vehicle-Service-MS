import React from 'react'

export default function CustomerCard({ customer }) {
  return (
    <div className='card'>
        <h3>{customer.name}</h3>
        <p>{customer.phone}</p>
        <p>{customer.email}</p>
        <p>{customer.address}</p>
        
    </div>
  )
}
