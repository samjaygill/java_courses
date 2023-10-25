package com.example.courses.coursesService.components;

import com.example.courses.coursesService.models.Booking;
import com.example.courses.coursesService.models.Course;
import com.example.courses.coursesService.models.Customer;
import com.example.courses.coursesService.repositories.BookingRepository;
import com.example.courses.coursesService.repositories.CourseRepository;
import com.example.courses.coursesService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Python", "Glasgow",5);
        courseRepository.save(course1);

        Course course2 = new Course("Python", "Edinburgh",5);
        courseRepository.save(course2);

        Course course3 = new Course("JavaScript", "Edinburgh",4);
        courseRepository.save(course3);

        Course course4 = new Course("JavaScript", "Glasgow",4);
        courseRepository.save(course4);

        Course course5 = new Course("Java", "Glasgow",5);
        courseRepository.save(course5);

        Course course6 = new Course("Java", "Edinburgh",4);
        courseRepository.save(course6);

        Customer customer1 = new Customer("Bob", "Modena", 30);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jeff", "Novato", 41);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Jackie", "San Francisco", 40);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Eric", "Novato", 55);
        customerRepository.save(customer4);

        Customer customer5 = new Customer("Samantha", "Glasgow", 26);
        customerRepository.save(customer5);

        Customer customer6 = new Customer("James", "Edinburgh", 55);
        customerRepository.save(customer6);

        Booking booking1 = new Booking("24-12-2018", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("24-12-2018", customer2, course2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("17-11-2019", customer3, course2);
        bookingRepository.save(booking3);

        Booking booking4  = new Booking("24-12-2018", customer4, course2);
        bookingRepository.save(booking4);

        Booking booking5  = new Booking("24-06-2023", customer5, course5);
        bookingRepository.save(booking5);

        Booking booking6  = new Booking("20-06-2023", customer6, course6);
        bookingRepository.save(booking6);

    }
}
