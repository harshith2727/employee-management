package com.assign.employee_management.services;

import com.assign.employee_management.dto.*;
import com.assign.employee_management.models.EmployeeModel;
import com.assign.employee_management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public CreateResponse createEmployee(CreateRequest employee, String userId) {
        EmployeeModel employeeModel = EmployeeModel.builder()
                .userId(userId)
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .designation(employee.getDesignation())
                .joinDate(employee.getJoinDate()).
                build();

        employeeRepository.save(employeeModel);
        return CreateResponse.builder()
                .userId(employeeModel.getUserId())
                .message("Employee created successfully")
                .build();
    }

    public EmployeeModel getEmployeeById(String userId) {

        return employeeRepository.findByUserId(userId);

    }

    public UpdateResponse updateEmployee(String userId, UpdateRequest updateRequest) {

        if (!Objects.isNull(employeeRepository.findByUserId(userId))) {

            EmployeeModel employeeModel = EmployeeModel.builder()
                    .userId(userId)
                    .name(updateRequest.getName())
                    .email(updateRequest.getEmail())
                    .department(updateRequest.getDepartment())
                    .designation(updateRequest.getDesignation())
                    .joinDate(employeeRepository.findByUserId(userId).getJoinDate()).
                    build();
            employeeRepository.deleteByUserId(userId);
            employeeRepository.save(employeeModel);
        }
        else{
            throw new RuntimeException("Employee not found");
        }

        return UpdateResponse.builder()
                .message("Employee updated successfully")
                .build();

    }

    public DeleteResponse deleteEmployee(String userId) {

        employeeRepository.deleteByUserId(userId);
        return  DeleteResponse.builder()
                .message("Employee deleted successfully")
                .build();
    }

    public double avgExperience() {

         return employeeRepository.avgExp();
    }
}
