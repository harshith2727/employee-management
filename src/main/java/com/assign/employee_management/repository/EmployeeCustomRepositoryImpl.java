package com.assign.employee_management.repository;

import com.assign.employee_management.dto.AvgExperienceResponse;
import com.assign.employee_management.models.EmployeeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository{

    private final MongoTemplate mongoTemplate;
    @Override
    public void saveEmployees(List<EmployeeModel> employees) {

            mongoTemplate.insertAll(employees);
    }

    public double avgExp(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group().avg("yearsOfExperience").as("averageExperience")
        );

        AggregationResults<AvgExperienceResponse> results = mongoTemplate.aggregate(aggregation, "employees", AverageExperienceResult.class);
        AvgExperienceResponse result = results.getUniqueMappedResult();

        return result != null ? result.avgExp() : 0.0;
    }
    }
}
