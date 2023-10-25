package com.example.courses.coursesService.repositories;

import com.example.courses.coursesService.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository <Booking, Long> {
    List<Booking> findByDate(String date);
}
