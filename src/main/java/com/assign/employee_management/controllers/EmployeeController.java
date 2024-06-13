package com.assign.employee_management.controllers;

import com.assign.employee_management.dto.*;
import com.assign.employee_management.models.EmployeeModel;
import com.assign.employee_management.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @PostMapping(path = "/api/employees")
    public CreateResponse createEmployee(@RequestBody CreateRequest employee, @RequestHeader("user-id") String userId)
    {
        return employeeService.createEmployee(employee,userId);
    }
    @GetMapping(path = "/api/employees/{userId}")
    public EmployeeModel getEmployeeById(@PathVariable String userId)
    {
        return employeeService.getEmployeeById(userId);
    }
    @GetMapping(path = "GET/api/employees/average-experience")
    public double avgExperience()
    {
        return employeeService.avgExperience();
    }
    @PutMapping(path = "PUT/api/employees/{userId}")
    public UpdateResponse updateEmployee(@PathVariable String userId, @RequestBody UpdateRequest updateRequest)
    {
        return employeeService.updateEmployee(userId,updateRequest);
    }
    @PutMapping(path="DELETE/api/employees/{userId}")
    public DeleteResponse deleteEmployee(@PathVariable String userId)
    {
        return employeeService.deleteEmployee(userId);
    }

}
