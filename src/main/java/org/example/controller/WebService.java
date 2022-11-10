package org.example.controller;


import org.eclipse.jetty.http.HttpStatus;
import org.example.WebServiceApplication;
import io.swagger.annotations.Api;
import org.example.dao.EmployeeDao;
import org.example.exception.DatabaseConnectionException;
import org.example.model.Employee;
import org.example.dao.EmployeesDB;
import org.example.service.EmployeeService;
import org.example.util.DatabaseConnector;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy Dropwizard API")
@Path("/api")
public class WebService {
    private static EmployeeService employeeService;
    public WebService() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        employeeService = new EmployeeService(new EmployeeDao(), databaseConnector);
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



//    @GET
//    @Path("/employees/{employee}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getMsg(@PathParam("employee") String employee) {
//        return "Hello from a RESTful Web service: " + employee;
//    }

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

}
