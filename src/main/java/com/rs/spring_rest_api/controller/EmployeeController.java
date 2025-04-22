package com.rs.spring_rest_api.controller;

import com.rs.spring_rest_api.model.Employee;
import com.rs.spring_rest_api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping(path = "/get-list")
  public List<Employee> getAllEmployeeList() {

    // Test
    System.out.println(1);
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Audi");
    cars.add("BMW");
    cars.add("Nissan");

    cars.add(0, "Honda");

    System.out.println(cars);


    return employeeService.getAllEmployeeList();
  }

  @GetMapping(path = "/{id}")
  public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) {
    return employeeService.getEmployeeById(id);
  }

  @GetMapping(path = "/by-params")
  public List<Employee> getEmployeesByParams(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {

    System.out.println(firstName + " " + lastName);
    return employeeService.getEmployeesByParams(firstName, lastName);
  }

  @PostMapping(path = "/save")
  public Employee saveEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
  }

  @DeleteMapping(path = "/delete/{id}")
  public boolean deleteEmployee(@PathVariable(name = "id", required = true) String id) {
    return employeeService.deleteEmployee(id);
  }

  @PutMapping(path = "/update/{id}")
  public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
      return employeeService.updateEmployeeId(id, employee);
  }

}
