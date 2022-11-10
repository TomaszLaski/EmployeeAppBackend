package org.example.dao;

import org.example.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDB {
    public static List<Employee> getEmployees(Connection c, String department) throws SQLException {

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                String.format("SELECT * from Employee e join %s d" +
                        " on e.id = d.employee_id_fk ", department));
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getString("first_name")
            );
            employees.add(employee);
        }
        return employees;
    }

    public static String getReport(List<Employee> employees) {
        StringBuilder info = new StringBuilder();
        for(Employee e: employees) {
            info.append(e.getName()).append(", ");
        }
        return info.toString();
    }
}
