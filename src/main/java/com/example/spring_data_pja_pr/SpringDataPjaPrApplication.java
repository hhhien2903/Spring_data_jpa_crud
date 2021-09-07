package com.example.spring_data_pja_pr;

import com.example.spring_data_pja_pr.entity.Employee;
import com.example.spring_data_pja_pr.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataPjaPrApplication implements CommandLineRunner {
	@Autowired 
	private EmployeeRepository employeeRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(SpringDataPjaPrApplication.class, args);
    }

    @Override
	public void run(String... args) throws Exception {
    	Employee employee = Employee.builder()
                .firstName("Hien")
                .lastName("Hoang")
                .email("test@test.com")
                .build();
    	System.out.println("Initial Employee: " + employee.toString());
		insertEmployee(employee);
	}
    
    private void insertEmployee(Employee employee){
        System.out.println("Added new Employee: " + this.employeeRepository.save(employee));
    }



}
