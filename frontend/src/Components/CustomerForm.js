import React, { useState } from 'react'
import api from '../Services/api';

export default function CustomerForm() {

    const [customer, setCustomer] = useState({
        name: "",
        phone: "",
        email: "",
        address: ""
    });

    const submit = async (e) => {
        e.preventDefault();
        // creating a post req to save the customer by making post req to backend
        await api.post("/customer/save", customer);
        alert("Customer Saved");
    }

    return (
        <form onSubmit={submit}>
            <input
                placeholder='Name'
                value={customer.name}
                onChange={(e) => setCustomer({
                    ...customer, name: e.target.value
                })
                }
            />

            <input
                placeholder='Phone Number'
                value={customer.phone}
                onChange={(e) => setCustomer({
                    ...customer, phone: e.target.value
                })
                }
            />

            <input
                placeholder='Email Address'
                value={customer.email}
                onChange={(e) => setCustomer({
                    ...customer, email: e.target.value
                })
                }
            />

            <input
                placeholder='Address'
                value={customer.address}
                onChange={(e) => setCustomer({
                    ...customer, address: e.target.value
                })
                }
            />


                <button>Add Customer</button>


        </form>
    )
}
