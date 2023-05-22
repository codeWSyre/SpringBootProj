package com.auca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.models.PropertyBooking;

public interface BookingRepository extends JpaRepository<PropertyBooking, Long>{

}
