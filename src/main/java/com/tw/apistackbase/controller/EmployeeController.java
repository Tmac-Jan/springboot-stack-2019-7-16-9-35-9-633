package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping("/employees")
  public ResponseEntity getEmployees(@RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "0") Integer pageSize, @RequestParam(required = false) String gender) {
    if (page > 0 && pageSize > 0) {
      return ResponseEntity.ok(employeeRepository.getEmployeeList()
          .subList(page - 1, page * pageSize).stream().collect(Collectors.toList()));
    } else if (!StringUtils.isEmpty(gender)) {
      return ResponseEntity.ok(employeeRepository.getEmployeeList()
          .stream().filter(e -> e.getGender().equals(gender)));
    } else {
      return ResponseEntity.ok(employeeRepository.getEmployeeList());
    }
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity getEmployeesById(@PathVariable Integer id) {

    Employee employee = employeeRepository.getEmployeeList()
        .stream()
        .filter(e -> e.getId().equals(id))
        .findFirst().orElse(null);
    if (employee != null) {
      return ResponseEntity.ok(employee);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/employees")
  public ResponseEntity createEmployee(@RequestBody Employee employee) {
    Employee willCreatedEmployee = new Employee();
      if (employee.getId()==null){
        BeanUtils.copyProperties(employee,willCreatedEmployee);
        willCreatedEmployee.setId(employeeRepository.getEmployeeList().size());
        return ResponseEntity.ok(willCreatedEmployee);
      }else{
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
      }

  }

  @PutMapping("/employees/{Id}")
  public ResponseEntity updateEmployee(@PathVariable(name = "Id") Integer Id, @RequestBody Employee employee) {
    Employee willMofiyiedEmployee = employeeRepository.getEmployeeList().stream().filter(e -> e.getId() == Id).findFirst().orElse(null);
    if (willMofiyiedEmployee != null) {
      BeanUtils.copyProperties(employee, willMofiyiedEmployee);
      willMofiyiedEmployee.setId(Id);
      return ResponseEntity.ok(willMofiyiedEmployee);
    }
    return ResponseEntity.notFound().build();
  }
  @DeleteMapping("/employees/{Id}")
  public ResponseEntity deleteEmployee(@PathVariable(name = "Id") Integer Id) {
      return ResponseEntity.ok(employeeRepository
          .getEmployeeList()
          .stream()
          .filter(e->!e.getId().equals(Id))
          .collect(Collectors.toList()));
  }
}
