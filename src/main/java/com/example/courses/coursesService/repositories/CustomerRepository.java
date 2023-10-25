package com.example.courses.coursesService.repositories;

import com.example.courses.coursesService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long>{
    List<Customer> findByName(String name);

}
