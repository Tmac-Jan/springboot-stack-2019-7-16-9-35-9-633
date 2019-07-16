package com.tw.apistackbase.controller;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import java.util.List;
import java.util.stream.Collectors;
import jdk.net.SocketFlow.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

  @Autowired
  private CompanyRepository companyRepository;

  @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
  public ResponseEntity<List<Company>> getAllCompaniesByEmployeeNumber(
      @PathVariable Integer id) {
    if (id == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(companyRepository.getCompanies()
          .stream().filter(e -> e.getId().equals(id))
          .collect(Collectors.toList()));
    }
  }

//  @RequestMapping(value = "/companies", method = RequestMethod.GET)
//  public ResponseEntity<List<Company>> getAllCompanies() {
//
//    return ResponseEntity.ok(companyRepository.getCompanies());
//
//  }

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


  @RequestMapping(value = "/companies", method = RequestMethod.GET)
  public ResponseEntity<List<Company>> getAllCompaniesByPageAndPageSize(
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "3") Integer pageSize) {
    if (page > 0 && pageSize > 0) {
      return ResponseEntity.ok(companyRepository.getCompanies()
          .stream()
          .limit(page * pageSize).collect(Collectors.toList()));
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(value = "/companies")
  public ResponseEntity<Company> createCompany(@RequestBody Company company) {
    if (company.getId() == null) {
      Company willCreatedCompany = new Company();
      System.out.println(
          "company Id:" + company.getId() + "" + company.getCompanyName() + "" + company
              .getEmployeeNumber());
      BeanUtils.copyProperties(company, willCreatedCompany);
      System.out.println(
          "willCreatedCompany Id:" + willCreatedCompany.getId() + "" + willCreatedCompany
              .getCompanyName() + "" + willCreatedCompany.getEmployeeNumber());
      willCreatedCompany.setId(companyRepository.getCompanies().size());
      companyRepository.getCompanies().add(willCreatedCompany);
      return ResponseEntity.ok(willCreatedCompany);
    } else {
      return (ResponseEntity<Company>) ResponseEntity.badRequest();
    }
  }

  @PutMapping (value = "/companies/{id}")
  public ResponseEntity<Company> modifyCompany(@PathVariable Integer id,
      @RequestBody Company company) {
    if (id != null) {
      Company modifiedCompany = companyRepository.getCompanies().stream()
          .filter(e -> e.getId() == id)
          .findFirst()
          .orElse(null);
      if (modifiedCompany != null) {
        BeanUtils.copyProperties(company, modifiedCompany);
        modifiedCompany.setId(id);
        return ResponseEntity.ok(modifiedCompany);
      } else {
        return (ResponseEntity<Company>) ResponseEntity.badRequest();
      }
    } else {
      return (ResponseEntity<Company>) ResponseEntity.badRequest();
    }
  }
}
