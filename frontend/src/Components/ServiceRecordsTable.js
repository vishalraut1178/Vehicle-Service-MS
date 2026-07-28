import React from "react";

const ServiceRecordsTable = ({ serviceRecords }) => {
  return (
    <div className="table-container">
      <table className="customer-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Vehicle Number</th>
            <th>Service Description</th>
            <th>Service Cost</th>
            <th>Service Status</th>
          </tr>
        </thead>

        <tbody>
          {serviceRecords.length > 0 ? (
            serviceRecords.map((record) => (
              <tr key={record.id}>
                <td>{record.vehicle?.owner?.name ?? "-"}</td>
                <td>{record.vehicle?.registrationNumber ?? "-"}</td>
                <td>{record.description}</td>
                <td>{record.serviceCost}</td>
                <td>{record.status}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" style={{ textAlign: "center" }}>
                No Service Records Found
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ServiceRecordsTable;