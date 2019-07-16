package com.tw.apistackbase.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tw.apistackbase.entity.Employee;
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
public class EmployeeControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private EmployeeRepository mockEmployeeRepository;
  @Autowired
  private EmployeeController employeeController;

  @Test
  public void should_return_List_of_employees_when_call_all_employees_api() throws Exception {
    mockEmployeeRepository = Mockito.mock(EmployeeRepository.class);
    List<Employee> mockEmployee = new ArrayList<Employee>() {{
      add(new Employee(0, "gio", 20, "male", 18888));
      add(new Employee(1, "sala", 21, "female", 17777));
      add(new Employee(2, "nini", 22, "female", 9999));
      add(new Employee(3, "yuyi", 23, "male", 8888));
    }};
    Mockito.when(mockEmployeeRepository.getEmployeeList()).thenReturn(mockEmployee);
    mockMvc.perform(get("/employees"))
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
  public void should_return_List_of_employees_when_call_employees_api_by_page_and_pageSize() throws Exception {
    mockEmployeeRepository = Mockito.mock(EmployeeRepository.class);
    List<Employee> mockEmployees = new ArrayList<Employee>() {{
      add(new Employee(0, "gio", 20, "male", 18888));
      add(new Employee(1, "sala", 21, "female", 17777));
      add(new Employee(2, "nini", 22, "female", 9999));
      add(new Employee(3, "yuyi", 23, "male", 8888));
    }};
    Mockito.when(mockEmployeeRepository.getEmployeeList()).thenReturn(mockEmployees);
    mockMvc.perform(get("/employees?page=1&pageSize=2"))
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
            + "    }\n"
            + "]"));
  }
  @Test
  public void should_return_List_of_employees_when_call_employee_api_by_id() throws Exception {
    mockEmployeeRepository = Mockito.mock(EmployeeRepository.class);
    List<Employee> mockEmployee = new ArrayList<Employee>() {{
      add(new Employee(0, "gio", 20, "male", 18888));
      add(new Employee(1, "sala", 21, "female", 17777));
      add(new Employee(2, "nini", 22, "female", 9999));
      add(new Employee(3, "yuyi", 23, "male", 8888));
    }};
    Mockito.when(mockEmployeeRepository.getEmployeeList()).thenReturn(mockEmployee);
    mockMvc.perform(get("/employees/0"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("{\n"
            + "    \"id\": 0,\n"
            + "    \"name\": \"gio\",\n"
            + "    \"age\": 20,\n"
            + "    \"gender\": \"male\",\n"
            + "    \"salary\": 18888\n"
            + "}"));
  }
}