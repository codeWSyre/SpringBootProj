package com.auca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	//Optional<User> findByEmailAndPassword(String email, String password);
	 Users findByEmail(String email);

}
