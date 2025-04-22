package com.rs.spring_rest_api.repository;

import com.rs.spring_rest_api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeRepository {

  @Autowired
  private List<Employee> employeeList;

  public List<Employee> getAllEmployeeList() {
    return employeeList;
  }

  public Employee getEmployeeById(String id) {

    Employee findEmployee = null;

    for (Employee employee : employeeList) {
      if (id.equals(employee.getId())) {
        findEmployee = employee;
        break;
      }
    }

    return findEmployee;
  }

  public List<Employee> getEmployeesByParams(String firstName, String lastName) {

    List<Employee> employeeByParams = new ArrayList<>();

    if (firstName == null && lastName == null) {
      return employeeList;
    }

    for (Employee employee : employeeList) {
      if (firstName != null && lastName != null) {

        if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
          employeeByParams.add(employee);
        }
      }

      if (firstName != null && lastName == null) {
        if (employee.getFirstName().equalsIgnoreCase(firstName)) {
          employeeByParams.add(employee);
        }
      }

      if (lastName != null && firstName == null) {
        if (employee.getLastName().equalsIgnoreCase(lastName)) {
          employeeByParams.add(employee);
        }
      }
    }

    return employeeByParams;
  }

  public Employee saveEmployee(Employee employee) {
    employeeList.add(employee);

    return employee;
  }

  public boolean deleteEmployee(String id) {
    return employeeList.removeIf(employee -> employee.getId().equals(id));
  }

  public Employee updateEmployeeId(String id, Employee updatedEmployee) {
    for (int i = 0; i < employeeList.size(); i++) {
      Employee existingEmployee = employeeList.get(i);
      if (existingEmployee.getId().equals(id)) {
        // Обновляем нужные поля
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        // Добавь другие поля по мере необходимости

        return existingEmployee;
      }
    }
    return null; // Если не найден
  }

}
