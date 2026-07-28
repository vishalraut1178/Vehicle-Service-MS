import React, { useState } from 'react'
import api from '../Services/api';

export default function ServiceRecordsForm({refresh}) {

    const [service, setService] = useState({
        vehicleId:0,
        serviceType: "",
        description: "",
        serviceCost: 0,
        status: ""
    });

    const submit = async (e) => {
        e.preventDefault();

        await api.post("/servicerecords/save", service);
        alert("Service Record Added");
        refresh();
    }

    return (
        <form onSubmit={submit}>

            <input
                placeholder='Vehicle ID'
                value={service.vehicleId}
                onChange={(e) => setService({
                    ...service, vehicleId: e.target.value
                })
                }
            />


            <input
                placeholder='Service Type'
                value={service.serviceType}
                onChange={(e) => setService({
                    ...service, serviceType: e.target.value
                })
                }
            />

            <input
                placeholder='Description'
                value={service.description}
                onChange={(e) => setService({
                    ...service, description: e.target.value
                })
                }
            />

            <input
                placeholder='Service Cost'
                value={service.serviceCost}
                onChange={(e) => setService({
                    ...service, serviceCost: e.target.value
                })
                }
            />

            <input
                placeholder='Service Status'
                value={service.status}
                onChange={(e) => setService({
                    ...service, status: e.target.value
                })
                }
            />

            <button>Add Service</button>

        </form>
    )
}
