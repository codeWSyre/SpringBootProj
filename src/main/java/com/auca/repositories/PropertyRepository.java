package com.auca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.models.Property;

public interface PropertyRepository extends JpaRepository<Property, Long>{

}
