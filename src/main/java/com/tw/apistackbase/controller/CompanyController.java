package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

  @Autowired
  private CompanyRepository companyRepository;

  @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
  public ResponseEntity<List<Company>> getAllCompaniesByEmployeeNumber(
      @PathVariable  Integer id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(companyRepository.getCompanies()
          .stream().filter(e -> e.getId().equals(id))
          .collect(Collectors.toList()));
    }
  }

  @RequestMapping(value = "/companies", method = RequestMethod.GET)
  public ResponseEntity<List<Company>> getAllCompanies() {

      return ResponseEntity.ok(companyRepository.getCompanies());

  }

  @RequestMapping(value = "/companies/{id}/employees", method = RequestMethod.GET)
  public ResponseEntity<List<Employee>> getAllEmployeesOfCompany(
      @PathVariable Integer id) {

    Company company = companyRepository.getCompanies()
        .stream().filter(e -> e.getId().equals(id))
        .findFirst().orElse(null);
    if (company != null) {
      return ResponseEntity.ok(company.getEmployees());
    }
    return ResponseEntity.notFound().build();

  }
}
