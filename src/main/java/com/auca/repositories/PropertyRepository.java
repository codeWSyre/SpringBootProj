package com.auca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.models.Property;

public interface PropertyRepository extends JpaRepository<Property, Long>{
	//List<Property> findPropByLocation(String location); 
    List<Property> findByLocation(String location);

}
