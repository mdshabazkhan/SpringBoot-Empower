package com.codewithshabaz.employeeratingsystem.service;

import com.codewithshabaz.employeeratingsystem.model.Employee;
import com.codewithshabaz.employeeratingsystem.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List <Employee> fetchAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee fetchEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Boolean updateEmployee(Long id, JsonNode body){
        Employee item = employeeRepository.findById(id).orElse(null);
        if(item != null){
            if (body.get("department") != null) item.setDepartment(body.get("department").asText());
            if (body.get("name") != null) item.setName(body.get("name").asText());
            if (body.get("increment") != null) item.setScore(item.getScore() + 1);
            if (body.get("decrement") != null) item.setScore(item.getScore() - 1);
            if (body.get("score") != null) item.setScore(body.get("score").asInt());
            employeeRepository.save(item);
            return true;
        }

        return false;
    }


    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
