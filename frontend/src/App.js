import { useEffect, useState } from 'react';
import './App.css';
import CustomerForm from './Components/CustomerForm';
import api from './Services/api';
import Navbar from './Components/Navbar';
import VehicleForm from './Components/VehicleForm';
import ServiceRecordsForm from './Components/ServiceRecordsForm';
import CustomerCard from './Components/CustomerCard';
import VehicleCard from './Components/VehicleCard';

import CustomerVehicleTable from "./Components/CustomerVehicleTable";
import "./Components/CustomerVehicleTable.css";
import ServiceRecordsTable from "./Components/ServiceRecordsTable";

function App() {

const [customers, setCustomers] = useState([]);
const [vehicles, setVehicles] = useState([]);
const [serviceRecords, setserviceRecords] = useState([]);


const loadCustomers = async () => {
  const res = await api.get("/customer/getAll");
  setCustomers(res.data);
}

const loadVehicles = async () => {
  const res = await api.get("/vehicles/getAll");
  setVehicles(res.data);
}

const loadServiceRecords = async () => {
  const res = await api.get("/servicerecords/getAll");
  setserviceRecords(res.data);
}

useEffect ( () => {
  loadCustomers();
  loadVehicles();
  loadServiceRecords();
}, [])


  return (
  <div className="hero">

    <Navbar title="Vehicle Service Management System" />

    {/* Top Forms */}
    <div className="form-grid">

      <section className="box">
        <h2>Add Customer</h2>
        <CustomerForm refresh={loadCustomers} />
      </section>

      <section className="box">
        <h2>Add Vehicle</h2>
        <VehicleForm refresh={loadVehicles} />
      </section>

    </div>

    {/* Service Form */}
    <section className="box service-box">
      <h2>Add Service Record</h2>
      <ServiceRecordsForm refresh={loadServiceRecords} />
    </section>

    {/* Customers */}
    <section className="box">
  <h2>Customer Vehicle Details</h2>

  <CustomerVehicleTable
    customers={customers}
    vehicles={vehicles}
  />
</section>


<section className="box">
  <h2>Service Records</h2>

  <ServiceRecordsTable
    serviceRecords={serviceRecords}
  />
</section>

  </div>
);
}

export default App;
