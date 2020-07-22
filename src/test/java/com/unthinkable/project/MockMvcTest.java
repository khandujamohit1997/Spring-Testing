package com.unthinkable.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unthinkable.project.model.Employee;
import com.unthinkable.project.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class MockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void add() {
        Employee employee = new Employee("Mohit", "22");
        employeeRepository.save(employee);
    }

    @Test
    public void getAllEmployees() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/employee/all")
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void createEmployeeAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
            .post("/employee/add")
            .content(asJsonString(new Employee("Mohit Khanduja", "22")))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
             .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
