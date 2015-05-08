package com.mtsmda.restSpring.javaCodeGeek.controller.service;

import com.mtsmda.restSpring.javaCodeGeek.xml.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmitriim on 5/8/2015.
 */
@Path("/sampleservice")
public class SampleService {
    private static Map<String, Employee> employeeMap = new HashMap<>();

    static {
        Employee employee = new Employee();
        employee.setEmployeeId("1");
        employee.setEmployeeName("Ivan");
        employee.setJob("Java");

        Employee employee1 = new Employee();
        employee1.setEmployeeId("2");
        employee1.setEmployeeName("Petr");
        employee1.setJob(".NET");

        employeeMap.put(employee.getEmployeeId(), employee);
        employeeMap.put(employee1.getEmployeeId(), employee1);
    }

    @GET
    @Path(value = "/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";
    }

    @GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message") String message){
        return "Message - " + message;
    }

    @GET
    @Path("employees")
    @Produces("application/xml")
    public List<Employee> listEmployees(){
        return new ArrayList<>(employeeMap.values());
    }

    @GET
    @Path("employees/{employeeId}")
    @Produces("application/xml")
    public Employee getEmployee(@PathParam("employeeId") String employeeId){
        return employeeMap.get(employeeId);
    }

    @GET
    @Path("json/employees")
    @Produces("application/json")
    public List<Employee> listEmployeeJSON(){
        return new ArrayList<>(employeeMap.values());
    }

    @GET
    @Path("json/employees/{employeeId}")
    @Produces("application/xml")
    public Employee getEmployeeJSON(@PathParam("employeeId") String employeeId){
        return employeeMap.get(employeeId);
    }
}
