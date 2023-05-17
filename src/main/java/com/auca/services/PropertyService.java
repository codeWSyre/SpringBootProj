package com.auca.services;

import java.util.List;

import org.apache.catalina.User;

import com.auca.models.Admin;
import com.auca.models.Property;
import com.auca.models.Users;

public interface PropertyService {

	List<Property> getAllProperties();
	 void saveProperty(Property property);
	 
	 void saveUsers(Users users);
	 List<Users> getAllUsers();
	 
	 void deletePropertyById(Long id);
	  Property findPropertyById(Long id);
	  
	  User getUsersById(Long id);
	  boolean authenticateUser(Long id, String password);
	  
	 
	  void deleteUserById(Long id);
	  
	   // List<Property> findByLocation(String address);
	//    public Property getBookingById(Long id);
	  //  List<Property> getAllAdmin(Long id);
	    
	    void deleteAdminById(Long id);
	 ///  User findUserByEmail(String email);
	    
	    void saveAdminUsers(Admin admin);
	    Admin findAdminById(Long id);
	    boolean authenticateAdmin(Long id, String password);
	    List<Admin> getAllAdmins();
	  //  public Users authenticate(String email, String password);
	

}
