package com.codewithshabaz.employeeratingsystem.controller;
import com.codewithshabaz.employeeratingsystem.model.Employee;
import com.codewithshabaz.employeeratingsystem.repository.EmployeeRepository;
import com.codewithshabaz.employeeratingsystem.service.EmployeeServices;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employees")
    public List<Employee> getEmployeesList(){
        return employeeServices.fetchAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeServices.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Map<String, Boolean> updateEmployee(@PathVariable Long id, @RequestBody JsonNode body){
        Boolean response = employeeServices.updateEmployee(id, body);
        return Map.of("update status",response);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeServices.deleteEmployee(id);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeServices.fetchEmployeeById(id);
    }


}
