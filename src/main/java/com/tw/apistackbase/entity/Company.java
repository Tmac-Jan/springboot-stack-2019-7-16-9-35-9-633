package com.tw.apistackbase.entity;

import java.util.List;

public class Company {

  private Integer Id;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public Company(Integer id, String companyName, Integer employeeNumber,
      List<Employee> employees) {
    Id = id;
    this.companyName = companyName;
    this.employeeNumber = employeeNumber;
    this.employees = employees;
  }

  private String companyName;
  private Integer employeeNumber;
  private List<Employee> employees ;

  public Company() {
  }

  public Company(String companyName, Integer employeeNumber,
      List<Employee> employees) {
    this.companyName = companyName;
    this.employeeNumber = employeeNumber;
    this.employees = employees;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
}
