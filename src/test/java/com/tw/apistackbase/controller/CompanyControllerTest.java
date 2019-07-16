package com.tw.apistackbase.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
  public void shoule_return_List_of_companies_when_call_all_companies_api() throws Exception{
    mockCompanyRepository = Mockito.mock(CompanyRepository.class);
    List<Company>  mockCompanies = new ArrayList<Company>(){{
      add(new Company("alibaba", 1000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company("baidu", 2000
          , new EmployeeRepository().getEmployeeList()));
      add(new Company("sina", 3000
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
            + "        ]\n"
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
            + "        ]\n"
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
            + "        ]\n"
            + "    }\n"
            + "]"));
  }
  

}