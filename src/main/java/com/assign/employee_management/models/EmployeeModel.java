package com.assign.employee_management.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeModel {
    private String userId;
    private String name;
    private String email;
    private String department;
    private String designation;
    private String joinDate;
    private double experience;
}
