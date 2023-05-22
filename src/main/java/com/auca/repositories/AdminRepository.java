package com.auca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.models.Admin;
import com.auca.models.Users;


public interface AdminRepository extends JpaRepository<Admin, Long> {
	 Admin findByEmail(String email);
}
