package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.exception.DatabaseConnectionException;
import org.example.model.Employee;
import org.example.util.DatabaseConnector;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    public EmployeeDao employeeDao;
    public DatabaseConnector databaseConnector;

    public EmployeeService(EmployeeDao employeeDao, DatabaseConnector databaseConnector) {
        this.employeeDao = employeeDao;
        this.databaseConnector = databaseConnector;
    }

    public int insertEmployee(Employee employee) throws DatabaseConnectionException, SQLException {
        return employeeDao.insertEmployee(employee, databaseConnector.getConnection());
    }

    public List<Employee> getEmployees() throws DatabaseConnectionException, SQLException {
        return employeeDao.getEmployees(databaseConnector.getConnection());
    }
}

