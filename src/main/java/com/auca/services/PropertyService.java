package com.auca.services;

import java.util.List;
import com.auca.models.Admin;
import com.auca.models.Property;
import com.auca.models.PropertyBooking;
import com.auca.models.Users;


public interface PropertyService {

	List<Property> getAllProperties();
	 void saveProperty(Property property);
	 
		List<PropertyBooking> getAllBookingProperties();
		 void saveBookedProperty(PropertyBooking propertyBooking);

		    public long countUsers(Users user);
	 void saveUsers(Users users);
	 List<Users> getAllUsers();
	 
	 void deletePropertyById(Long id);
	  Property findPropertyById(Long id);
	 
	  List<Property> searchByLocation(String location);
	  
	  Users getUsersById(Long id);

	   // public long countUsers(Users user); 
	  void deleteUserById(Long id);
	  
	    void deleteAdminById(Long id);
	    
	    void saveAdminUsers(Admin admin);
	    Admin findAdminById(Long id);
	   
	    List<Admin> getAllAdmins();
	
	    Users loginUser(String email, String password);
	    Admin loginAdmin(String email, String password);
	

}
