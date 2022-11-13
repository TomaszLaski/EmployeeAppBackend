package org.example.dao;

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

    public SalesEmployee getSalesEmployee(int employee_id_fk, Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * "
                        + "FROM salesEmployee "
                        + "WHERE employee_id_fk = " + employee_id_fk + ";");


        while (rs.next()) {
            return new SalesEmployee(
                    rs.getInt("commission_rate"),
                    rs.getFloat("total_sales_value"),
                    rs.getFloat("employee_id_fk"));
        }

        return null;
    }
}