import React, { useState } from 'react'
import api from '../Services/api';

export default function VehicleForm({refresh}) {

    const [vehicle, setVehicle] = useState({
        customerId:0,
        registrationNumber: "",
        brand: "",
        model: "",
        manufacturingYear: 0
    });


    const submit = async (e) => {
        e.preventDefault();
        // creating a post req to save the customer by making post req to backend
        await api.post("/vehicles/save", vehicle);
        alert("Vehicle Added Successfully.!");
        refresh();
    }

    return (
        <form onSubmit={submit}>
            <input
                placeholder='Customer ID'
                value={vehicle.customerId}
                onChange={(e) => setVehicle({
                    ...vehicle, customerId: e.target.value
                })
                }
            />


            <input
                placeholder='Regestration Number'
                value={vehicle.registrationNumber}
                onChange={(e) => setVehicle({
                    ...vehicle, registrationNumber: e.target.value.toUpperCase()
                })
                }
            />

            <input
                placeholder='Vehicle Brand'
                value={vehicle.brand}
                onChange={(e) => setVehicle({
                    ...vehicle, brand: e.target.value
                })
                }
            />

            <input
                placeholder='Vehicle Model'
                value={vehicle.model}
                onChange={(e) => setVehicle({
                    ...vehicle, model: e.target.value
                })
                }
            />

            <input
                placeholder='Manufacturing Year'
                value={vehicle.manufacturingYear}
                onChange={(e) => setVehicle({
                    ...vehicle, manufacturingYear: e.target.value
                })
                }
            />

            

            <button>Add Vehicle</button>

        </form>
    )
}
