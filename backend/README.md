# Vehicle Service Management System

A simple Spring Boot REST API project to manage Customers, Vehicles and Service Records.

## Tech Stack
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Entities
- Customer (owns many Vehicles)
- Vehicle (belongs to a Customer, has many Service Records)
- ServiceRecord (belongs to a Vehicle)

## Setup
1. Create a MySQL database named `vsms`.
2. Update `src/main/resources/application.properties` with your MySQL username and password.
3. Run the application (`Dyp1Application` style main class: `VsmsApplication`).
4. App runs on port `8081`.

## APIs

### Customer (`/customer`)
- POST `/save`
- GET `/getAll`
- GET `/get/{id}`
- PUT `/update`
- DELETE `/delete/{id}`

### Vehicle (`/vehicles`)
- POST `/save` (body: customerId, registrationNumber, brand, model, manufacturingYear)
- GET `/getAll`
- GET `/get/{id}`
- PUT `/update`
- DELETE `/delete/{id}`

### Service Record (`/servicerecords`)
- POST `/save` (body: vehicleId, serviceType, description, serviceCost, status)
- GET `/getAll`
- GET `/get/{id}`
- PUT `/update`
- DELETE `/delete/{id}`
