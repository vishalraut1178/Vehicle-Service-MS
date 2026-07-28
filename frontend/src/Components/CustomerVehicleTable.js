import React from "react";

const CustomerVehicleTable = ({ customers, vehicles }) => {
  // Create a map of customerId -> customer
  const customerMap = customers.reduce((map, customer) => {
    map[customer.id] = customer;
    return map;
  }, {});

  return (
    <div className="table-container">
      <table className="customer-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Mobile</th>
            <th>Email</th>
            <th>Address</th>
            <th>Vehicle Number</th>
            <th>Company</th>
            <th>Model</th>
            <th>Year</th>
          </tr>
        </thead>

        <tbody>
          {vehicles.length > 0 ? (
            vehicles.map((vehicle) => {
              const customer = customerMap[vehicle.owner.id];

              return (
                <tr key={vehicle.id}>
                  <td>{customer?.name ?? "-"}</td>
                  <td>{customer?.phone ?? "-"}</td>
                  <td>{customer?.email ?? "-"}</td>
                  <td>{customer?.address ?? "-"}</td>

                  <td>{vehicle.registrationNumber}</td>
                  <td>{vehicle.brand}</td>
                  <td>{vehicle.model}</td>
                  <td>{vehicle.manufacturingYear}</td>
                </tr>
              );
            })
          ) : (
            <tr>
              <td colSpan="8" style={{ textAlign: "center" }}>
                No Data Available
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default CustomerVehicleTable;