package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Company;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CompanyRepository {

  private List<Company> companies;

  public CompanyRepository() {
    companies = new ArrayList<Company>() {{
      add(new Company(0,"alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(1,"baidu", 2000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(2,"sina", 3000
          , new EmployeeRepository().getEmployeeList()));
    }};
  }

  public List<Company> getCompanies() {
    return companies;
  }
}
