package com.codewithshabaz.employeeratingsystem.repository;

import com.codewithshabaz.employeeratingsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
