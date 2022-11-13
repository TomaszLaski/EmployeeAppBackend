package org.example.controller;


import org.eclipse.jetty.http.HttpStatus;
import io.swagger.annotations.Api;
import org.example.dao.EmployeeDao;
import org.example.dao.SalesEmployeeDao;
import org.example.exception.DatabaseConnectionException;
import org.example.model.Employee;
import org.example.model.SalesEmployee;
import org.example.service.EmployeeService;
import org.example.service.SalesEmployeeService;
import org.example.util.DatabaseConnector;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy Dropwizard API")
@Path("/api")
public class WebService {
    private static EmployeeService employeeService;
    private static SalesEmployeeService salesEmployeeService;

    public WebService() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        employeeService = new EmployeeService(new EmployeeDao(), databaseConnector);
        salesEmployeeService = new SalesEmployeeService(new SalesEmployeeDao(), databaseConnector);

    }

    @GET
    @Path("/employees/{department}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByDepartment(@PathParam("department") String department) {
        try {
            return Response.ok(employeeService.getEmployeesByDepartment(department)).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
    
    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        try {
            return Response.ok(employeeService.getEmployees()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
    @POST
    @Path("/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) throws DatabaseConnectionException {
            try {
                int id = employeeService.insertEmployee(employee);
                return Response.status(HttpStatus.CREATED_201).entity(id).build();
            } catch (Exception e) {
                System.out.println(e);
                return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
            }

    }

    @POST
    @Path("/salesemployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployee salesEmployee) {
        try {
            salesEmployeeService.insertSalesEmployee(salesEmployee);
            return Response.status(HttpStatus.CREATED_201).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @GET
    @Path("/salesEmployee/topsales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTopSalesEmployee(){
        try {
            return Response.status(HttpStatus.OK_200).entity(salesEmployeeService.getHighestSaleValueSalesEmployee()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }


}



