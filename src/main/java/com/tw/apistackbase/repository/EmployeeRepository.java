package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {

  private List<Employee> employeeList;

  public EmployeeRepository() {
    employeeList = new ArrayList<Employee>() {{
      add(new Employee(0, "gio", 20, "male", 18888));
      add(new Employee(1, "sala", 21, "female", 17777));
      add(new Employee(2, "nini", 22, "female", 9999));
      add(new Employee(3, "yuyi", 23, "male", 8888));
    }};
  }

  public List<Employee> getEmployeeList() {
    return employeeList;
  }
}
