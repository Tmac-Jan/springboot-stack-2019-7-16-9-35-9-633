package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping("/employees")
  public ResponseEntity getEmployees(@RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "1") Integer pageSize) {
    if (page > 0 && pageSize > 0) {
      return ResponseEntity.ok(employeeRepository.getEmployeeList()
          .subList(page - 1, page * pageSize - 1).stream().collect(Collectors.toList()));
    }
    return ResponseEntity.ok(employeeRepository.getEmployeeList());
  }
}