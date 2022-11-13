package org.example.dao;

import org.example.model.Employee;
import org.example.model.SalesEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesEmployeeDao {
    public void insertSalesEmployee(SalesEmployee sEmp1, Connection c) throws SQLException {
        String insertSalesEmployeeQuery = "insert into Sales_Employees (employee_id_fk, commission_rate, total_sales_value)"
                + " values (?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(insertSalesEmployeeQuery);
        preparedStmt.setInt(1, sEmp1.getEmployeeNumber());
        preparedStmt.setFloat(2, sEmp1.getCommissionRate());
        preparedStmt.setFloat(3, sEmp1.getTotalSalesValue());
        preparedStmt.executeUpdate();
    }

    public Employee getHighestSaleValueSalesEmployee(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT *, MAX(total_sales_value) FROM Employee join Sales_Employees on Employee.employeeNumber = Sales_Employees.employee_id_fk ;");


        Employee employee = null;
        while (rs.next()) {
            employee = new Employee(
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("nationalInsuranceNo"),
                    rs.getString("bankAccountIBANorBic"),
                    rs.getInt("startingSalary"),
                    rs.getInt("employeeNumber")
            );
        }

        return employee;
    }
}