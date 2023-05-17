package com.auca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.models.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {

}
