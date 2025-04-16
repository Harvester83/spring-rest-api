package com.rs.spring_rest_api.services;

import com.rs.spring_rest_api.model.Employee;
import com.rs.spring_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> getAllEmployeeList() {
    return employeeRepository.getAllEmployeeList();
  }

  public Employee getEmployeeById(String id) {
    return employeeRepository.getEmployeeById(id);
  }

  public List<Employee> getEmployeesByParams(String firstName, String lastName) {
    return employeeRepository.getEmployeesByParams(firstName, lastName);
  }

  public Employee saveEmployee(Employee employee) {
    return employeeRepository.saveEmployee(employee);
  }

  public boolean deleteEmployee(String id) {
    return employeeRepository.deleteEmployee(id);
  }
}
