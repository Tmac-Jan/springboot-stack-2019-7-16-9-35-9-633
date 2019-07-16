package com.tw.apistackbase.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.repository.CompanyRepository;
import com.tw.apistackbase.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private CompanyController companyController;
  private CompanyRepository mockCompanyRepository;

  @Test
  public void shoule_return_List_of_companies_when_call_all_companies_api() throws Exception {
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company> mockCompanies = new ArrayList<Company>() {{
      add(new Company(0, "alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(1, "baidu", 2000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(2, "sina", 3000
          , new EmployeeRepository().getEmployeeList()));
    }};
    Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);
//    ReflectionTestUtils.setField(companyController,"companyRepository",mockCompanyRepository);
    mockMvc.perform(get("/companies"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[\n"
            + "    {\n"
            + "        \"companyName\": \"alibaba\",\n"
            + "        \"employeeNumber\": 1000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"companyName\": \"baidu\",\n"
            + "        \"employeeNumber\": 2000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 1\n"
            + "    },\n"
            + "    {\n"
            + "        \"companyName\": \"sina\",\n"
            + "        \"employeeNumber\": 3000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 2\n"
            + "    }\n"
            + "]"));
  }

  @Test
  public void shoule_return_List_of_companies_when_call_all_companies_api_by_Id() throws Exception {
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company> mockCompanies = new ArrayList<Company>() {{
      add(new Company(1, "baidu", 2000
          , new EmployeeRepository().getEmployeeList()));
    }};
    Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);
    mockMvc.perform(get("/companies/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[\n"
            + "    {\n"
            + "        \"companyName\": \"baidu\",\n"
            + "        \"employeeNumber\": 2000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 1\n"
            + "    }\n"
            + "]"));
  }

  @Test
  public void shoule_return_List_of_employees_when_call_all_employees_of_company_api_by_Id()
      throws Exception {
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company> mockCompanies = new ArrayList<Company>() {{
      add(new Company("alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
    }};
    Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);
    mockMvc.perform(get("/companies/1/employees"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[\n"
            + "    {\n"
            + "        \"id\": 0,\n"
            + "        \"name\": \"gio\",\n"
            + "        \"age\": 20,\n"
            + "        \"gender\": \"male\",\n"
            + "        \"salary\": 18888\n"
            + "    },\n"
            + "    {\n"
            + "        \"id\": 1,\n"
            + "        \"name\": \"sala\",\n"
            + "        \"age\": 21,\n"
            + "        \"gender\": \"female\",\n"
            + "        \"salary\": 17777\n"
            + "    },\n"
            + "    {\n"
            + "        \"id\": 2,\n"
            + "        \"name\": \"nini\",\n"
            + "        \"age\": 22,\n"
            + "        \"gender\": \"female\",\n"
            + "        \"salary\": 9999\n"
            + "    },\n"
            + "    {\n"
            + "        \"id\": 3,\n"
            + "        \"name\": \"yuyi\",\n"
            + "        \"age\": 23,\n"
            + "        \"gender\": \"male\",\n"
            + "        \"salary\": 8888\n"
            + "    }\n"
            + "]"));
  }

  @Test
  public void shoule_return_List_of_employees_when_call_all_employees_of_company_api_by_page_and_pageSize()
      throws Exception {
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company> mockCompanies = new ArrayList<Company>() {{
      add(new Company(0, "alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(1, "baidu", 2000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(2, "sina", 3000
          , new EmployeeRepository().getEmployeeList()));
    }};
    Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);
    mockMvc.perform(get("/companies?page=1&pageSize=3"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[\n"
            + "    {\n"
            + "        \"companyName\": \"alibaba\",\n"
            + "        \"employeeNumber\": 1000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"companyName\": \"baidu\",\n"
            + "        \"employeeNumber\": 2000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 1\n"
            + "    }\n"
            + "]"));
  }

  @Test
  public void shoule_return_company_when_call_create_company_api()
      throws Exception {
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company> mockCompanies = new ArrayList<Company>() {{
      add(new Company("alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
    }};
    Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);
    mockMvc.perform(post("/companies")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\n"
            + "\t\"companyName\":\"360\",\n"
            + "\t\"employeeNumber\":1000\n"
            + "}")
    )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("{\n"
            + "    \"companyName\": \"360\",\n"
            + "    \"employeeNumber\": 1000,\n"
            + "    \"employees\": null,\n"
            + "    \"id\": 3\n"
            + "}"));
  }

  @Test
  public void shoule_return_company_when_call_modifiy_company_api()
      throws Exception {
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company> mockCompanies = new ArrayList<Company>() {{
      add(new Company(0, "alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(1, "baidu", 2000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(2, "sina", 3000
          , new EmployeeRepository().getEmployeeList()));
    }};
    Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);
    mockMvc.perform(put("/companies/1")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\n"
            + "\t\"id\":\"1\",\n"
            + "\t\"companyName\":\"baidu1\",\n"
            + "\t\"employeeNumber\":1000\n"
            + "}")
    )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("{\n"
            + "    \"companyName\": \"baidu1\",\n"
            + "    \"employeeNumber\": 1000,\n"
            + "    \"employees\": null,\n"
            + "    \"id\": 1\n"
            + "}"));
  }

  @Test
  public void shoule_return_list_of_company_when_call_delete_company_api()
      throws Exception {
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company> mockCompanies = new ArrayList<Company>() {{
      add(new Company(0, "alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(1, "baidu", 2000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company(2, "sina", 3000
          , new EmployeeRepository().getEmployeeList()));
    }};
    Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);
    mockMvc.perform(delete("/companies/1")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[\n"
            + "    {\n"
            + "        \"companyName\": \"alibaba\",\n"
            + "        \"employeeNumber\": 1000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"companyName\": \"sina\",\n"
            + "        \"employeeNumber\": 3000,\n"
            + "        \"employees\": [\n"
            + "            {\n"
            + "                \"id\": 0,\n"
            + "                \"name\": \"gio\",\n"
            + "                \"age\": 20,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 18888\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 1,\n"
            + "                \"name\": \"sala\",\n"
            + "                \"age\": 21,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 17777\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 2,\n"
            + "                \"name\": \"nini\",\n"
            + "                \"age\": 22,\n"
            + "                \"gender\": \"female\",\n"
            + "                \"salary\": 9999\n"
            + "            },\n"
            + "            {\n"
            + "                \"id\": 3,\n"
            + "                \"name\": \"yuyi\",\n"
            + "                \"age\": 23,\n"
            + "                \"gender\": \"male\",\n"
            + "                \"salary\": 8888\n"
            + "            }\n"
            + "        ],\n"
            + "        \"id\": 2\n"
            + "    }\n"
            + "]"));
  }
}