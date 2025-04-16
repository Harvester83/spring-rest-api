package com.rs.spring_rest_api.config;


import com.rs.spring_rest_api.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

  @Bean
  public List<Employee> getEmployeeList() {

    List<Employee> employeeList = new ArrayList<>();

    employeeList.add(new Employee("1", "Henk", "Ho", "Ataturk 41"));
    employeeList.add(new Employee("2", "Sem", "Ro", "Block Street 3"));
    employeeList.add(new Employee("3", "Lion", "Ro", "Avenue 12"));
    employeeList.add(new Employee("4", "Henk", "Li","Street 456"));

    return employeeList;
  }
}
