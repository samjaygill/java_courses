package com.example.courses.coursesService.controllers;

import com.example.courses.coursesService.models.Booking;
import com.example.courses.coursesService.models.Course;
import com.example.courses.coursesService.repositories.BookingRepository;
import com.example.courses.coursesService.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(name = "date", required = false) String date){

        if (date != null){
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity(booking, HttpStatus.OK);
    }
}

