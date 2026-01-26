package com.java.api.console.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmpController {

    List<Employee> employees = new ArrayList<>();

    // @GetMapping("employees")
    // public List<Employee> getEmployee() {
    //     // this.employees.add();
    //     return employees; 
    // }

    @GetMapping("/employee")
    public Map<String, Object> getEmployeeById(@RequestBody Employee employee) {
        employees.add(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("data", employees);
        response.put("message", "Employee added successfully");

        return response;
    }

    @PostMapping("employee")
    public String postMethodName(@RequestBody Employee employee) {
        //TODO: process POST request
        employees.add(employee);
        System.out.println("Employee added: " + employee);      
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee added successfully");
        response.put("status", 200);
        System.out.println(response);
        // Return the employee object as a string for demonstration purposes
        // In a real application, you might return a more structured response
        // or redirect to another endpoint.

        
        return "Saved Successfully";
    }
    
    
}
