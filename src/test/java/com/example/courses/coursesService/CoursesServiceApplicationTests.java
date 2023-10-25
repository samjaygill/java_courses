package com.example.courses.coursesService;

import com.example.courses.coursesService.models.Booking;
import com.example.courses.coursesService.models.Course;
import com.example.courses.coursesService.models.Customer;
import com.example.courses.coursesService.repositories.BookingRepository;
import com.example.courses.coursesService.repositories.CourseRepository;
import com.example.courses.coursesService.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
class CoursesServiceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByRating(){
		List<Course> foundCourses = courseRepository.findByRating(5);
		assertEquals("Python", foundCourses.get(0).getName());
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> foundBookings = bookingRepository.findByDate("20-06-2023");
		assertEquals("Java", foundBookings.get(0).getCourseName());
	}

	@Test
	public void canFindCustomerByTheirName(){
		List<Customer> foundCustomer = customerRepository.findByName("Samantha");
		assertEquals("Samantha", foundCustomer.get(0).getName());
	}

}
