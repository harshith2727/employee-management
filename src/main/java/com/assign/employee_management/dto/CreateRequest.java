package com.assign.employee_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateRequest {
    private String name;
    private String email;
    private String department;
    private String designation;
    private String joinDate;
}
