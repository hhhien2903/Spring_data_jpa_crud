package com.example.spring_data_pja_pr;

import com.example.spring_data_pja_pr.entity.Employee;
import com.example.spring_data_pja_pr.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataPjaPrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataPjaPrApplication.class, args);
    }

    private CommandLineRunner run(EmployeeRepository employeeRepository){
        return args -> {
            insertEmployee(employeeRepository);
        };
    }
    private void insertEmployee(EmployeeRepository employeeRepository){
        Employee employee = Employee.builder()
                .firstName("Van")
                .lastName("Hung")
                .email("hungvan@gmail.com")
                .build();
        employeeRepository.save(employee);

    }



}
