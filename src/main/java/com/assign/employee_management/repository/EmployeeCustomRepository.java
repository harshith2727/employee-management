package com.assign.employee_management.repository;

import com.assign.employee_management.models.EmployeeModel;

import java.util.List;

public interface EmployeeCustomRepository {
    void saveEmployees(List<EmployeeModel> employees);

    int avgExp();
}
