package org.example.dao;

import org.example.model.Employee;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
    public int insertEmployee(Employee emp1, Connection c) throws SQLException {
        String insertEmployeeQuery = "INSERT INTO Employee (name, address, nationalInsuranceNo, bankAccountIBANorBic, startingSalary, employeeNumber )"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(insertEmployeeQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, emp1.getName());
        preparedStmt.setString(2, emp1.getAddress());
        preparedStmt.setString(3, emp1.getNationalInsuranceNo());
        preparedStmt.setString(4, emp1.getBankAccountIBANorBic());
        preparedStmt.setInt(5, emp1.getStartingSalary());
        preparedStmt.setInt(6, emp1.getEmployeeNumber());

        int affectedRows = preparedStmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        int empNo = 0;

        try (ResultSet rs = preparedStmt.getGeneratedKeys()) {
            if (rs.next()) {
                empNo = rs.getInt(1);
            }
        }

        return empNo;
    }
    public List<Employee> getEmployees(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * "
                        + "FROM Employee;");

        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("nationalInsuranceNo"),
                    rs.getString("bankAccountIBANorBic"),
                    rs.getInt("startingSalary"),
                    rs.getInt("employeeNumber")
            );
            employees.add(employee);
        }
        return employees;
    }
}