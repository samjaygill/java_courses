package com.example.courses.coursesService.controllers;

import com.example.courses.coursesService.models.Booking;
import com.example.courses.coursesService.models.Course;
import com.example.courses.coursesService.models.Customer;
import com.example.courses.coursesService.repositories.BookingRepository;
import com.example.courses.coursesService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(name = "stars", required = false) String name){

        if (name != null){
            return new ResponseEntity(customerRepository.findByName(name), HttpStatus.OK);
        }

        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
