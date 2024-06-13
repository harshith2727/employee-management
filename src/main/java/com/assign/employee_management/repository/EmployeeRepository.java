package com.assign.employee_management.repository;

import com.assign.employee_management.models.EmployeeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeModel, String>,EmployeeCustomRepository {

    EmployeeModel findByUserId(String userId);

    void deleteByUserId(String userId);
}
