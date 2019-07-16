package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
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
  public ResponseEntity<List<Company>> getAllCompaniesByEmployeeNumber(@PathVariable("id") Integer employeeNumber){
         if (employeeNumber==null){
           return  ResponseEntity.notFound().build();
         }else{
//           System.out.println("Not null!");
          return  ResponseEntity.ok(companyRepository.getCompanies()
              .stream().filter(e->e.getEmployeeNumber().equals(employeeNumber))
              .collect(Collectors.toList()));
         }
  }
  @RequestMapping(value = "/companies", method = RequestMethod.GET)
  public ResponseEntity<List<Company>> getAllCompanies(@PathVariable (required = false)Integer employeeNumber){
    if (employeeNumber==null){
      return ResponseEntity.ok(companyRepository.getCompanies());
    }else{
//           System.out.println("Not null!");
      return  ResponseEntity.ok(companyRepository.getCompanies()
          .stream().filter(e->e.getEmployeeNumber().equals(employeeNumber))
          .collect(Collectors.toList()));
    }
  }
}
