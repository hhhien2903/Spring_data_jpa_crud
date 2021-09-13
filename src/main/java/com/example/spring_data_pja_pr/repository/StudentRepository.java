package com.example.spring_data_pja_pr.repository;

import com.example.spring_data_pja_pr.entity.Employee;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends CrudRepository<Employee, Long> {

}
