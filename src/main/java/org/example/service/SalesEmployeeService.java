package org.example.service;

import org.example.dao.SalesEmployeeDao;
import org.example.exception.DatabaseConnectionException;
import org.example.model.SalesEmployee;
import org.example.util.DatabaseConnector;

import java.sql.SQLException;

public class SalesEmployeeService {
    public SalesEmployeeDao salesEmployeeDao;
    public DatabaseConnector databaseConnector;

    public SalesEmployeeService(SalesEmployeeDao salesEmployeeDao, DatabaseConnector databaseConnector) {
        this.salesEmployeeDao = salesEmployeeDao;
        this.databaseConnector = databaseConnector;
    }

    public void insertSalesEmployee(SalesEmployee sEmp1) throws DatabaseConnectionException, SQLException {
        salesEmployeeDao.insertSalesEmployee(sEmp1, databaseConnector.getConnection());
    }

    public SalesEmployee getSalesEmployee(int employeeId) throws DatabaseConnectionException, SQLException {
        return salesEmployeeDao.getSalesEmployee(employeeId, databaseConnector.getConnection());
    }
}