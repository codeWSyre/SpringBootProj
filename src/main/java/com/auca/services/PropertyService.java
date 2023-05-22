package com.auca.services;

import java.util.List;

import org.apache.catalina.User;

import com.auca.models.Admin;
import com.auca.models.Property;
import com.auca.models.PropertyBooking;
import com.auca.models.Users;

public interface PropertyService {

	List<Property> getAllProperties();
	 void saveProperty(Property property);
	 
		List<PropertyBooking> getAllBookingProperties();
		 void saveBookedProperty(PropertyBooking propertyBooking);
	 
	 void saveUsers(Users users);
	 List<Users> getAllUsers();
	 
	 void deletePropertyById(Long id);
	  Property findPropertyById(Long id);
	  Property findPropertyByLocation(String location);
	  
	  Users getUsersById(Long id);
	 
	  void deleteUserById(Long id);
	  
	   // List<Property> findByLocation(String address);
	//    public Property getBookingById(Long id);
	  //  List<Property> getAllAdmin(Long id);
	    
	    void deleteAdminById(Long id);
	 ///  User findUserByEmail(String email);
	    
	    void saveAdminUsers(Admin admin);
	    Admin findAdminById(Long id);
	   
	    List<Admin> getAllAdmins();
	  //  public Users authenticate(String email, String password);
	    Users loginUser(String email, String password);
	    Admin loginAdmin(String email, String password);
	

}
