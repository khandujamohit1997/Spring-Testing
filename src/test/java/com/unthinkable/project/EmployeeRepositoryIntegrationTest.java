package com.unthinkable.project;

import com.unthinkable.project.model.Employee;
import com.unthinkable.project.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee employee = new Employee("alex");
        entityManager.persist(employee);

        entityManager.flush();

        // when
        Employee employeeSearch = employeeRepository.findByName(employee.getName());

        // then
        assertThat(employeeSearch.getName())
            .isEqualTo(employee.getName());
    }
}
