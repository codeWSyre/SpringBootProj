package com.auca.services;

import java.util.List;
import java.util.Optional;
import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.models.Admin;
import com.auca.models.Property;
import com.auca.models.PropertyBooking;
import com.auca.models.Users;
import com.auca.repositories.AdminRepository;
import com.auca.repositories.BookingRepository;

import com.auca.repositories.PropertyRepository;
import com.auca.repositories.UserRepository;

@Service
public class PropertyServiceImpl implements PropertyService{
	@Autowired
	public PropertyRepository propRepo;
	@Autowired
	public AdminRepository adminRepo;
	@Autowired
	public UserRepository userRepo;
	@Autowired
	public BookingRepository bookRepo;
	
	
	
	@Override
	public List<Property> getAllProperties() {
		// TODO Auto-generated method stub
		return propRepo.findAll();
	}

	@Override
	public void saveProperty(Property property) {
		// TODO Auto-generated method stub
	//while(property != null) {	
		this.propRepo.save(property);
	//	Notifications notification = new Notifications();
      //  notification.setMessage("New property added: " + property.getName());
     //   notification.set("jesus@example.com"); // Set the recipient
        
    //    notificationService.createNotification(notification);
//	}
		
	}

	@Override
	public void saveUsers(Users users) {
		// TODO Auto-generated method stub
		this.userRepo.save(users);
		
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void deletePropertyById(Long id) {
		
		this.propRepo.deleteById(id);
		
	}
	
	@Override
	public void deleteUserById(Long id) {
		this.userRepo.deleteById(id);
	}

	/* @Override
	public List<Property> findByLocation(String address) {
		// TODO Auto-generated method stub
		return propRepo;
		
	}          */

	
	@Override
	public void deleteAdminById(Long id) {
		// TODO Auto-generated method 
  this.adminRepo.deleteById(id);
		
	}

	
	@Override
	public Property findPropertyById(Long id) {
		Optional<Property> optional=propRepo.findById(id);
		Property property =null;
		if(optional.isPresent())
		{
			property =optional.get();
			
		}else { 
			throw new RuntimeErrorException(null, "student not not found for id ::"+ id);
					}
		return (Property) property;
	}




	
	

	@Override
	public Admin findAdminById(Long id) {
		Optional<Admin> optional=adminRepo.findById(id);
		Admin admin =null;
		if(optional.isPresent())
		{
			admin =optional.get();
			
		}else { 
			throw new RuntimeErrorException(null, "admin not not found for id ::"+ id);
					}
		return admin;
	}





	@Override
	public void saveAdminUsers(Admin admin) {
		// TODO Auto-generated method stub
		this.adminRepo.save(admin);
		
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	

	@Override
	public void saveBookedProperty(PropertyBooking propertyBooking) {
		// TODO Auto-generated method stub\
		this.bookRepo.save(propertyBooking);
		
	}

	@Override
	public List<PropertyBooking> getAllBookingProperties() {
		// TODO Auto-generated method stub
	return bookRepo.findAll();
	}

	

	@Override
	public Users loginUser(String email, String password) {
		   Users user = userRepo.findByEmail(email);
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        } else {
	            return null;
	        }
	    }

	@Override
	public Admin loginAdmin(String email, String password) {
		  Admin admin = adminRepo.findByEmail(email);
	        if (admin != null && admin.getPassword().equals(password)) {
	            return admin;
	        } else {
	            return null;
	        }
	}

	@Override
	public Users getUsersById(Long id) {
		// TODO Auto-generated method stub
		Optional<Users> optional=userRepo.findById(id);
		Users users=null;
		if(optional.isPresent())
		{
			users =optional.get();
			
		}else { 
			throw new RuntimeErrorException(null, "student not not found for id ::"+ id);
					}
		return users;
	}

	@Override
	public List<Property> searchByLocation(String location) {
		// TODO Auto-generated method stub
		return propRepo.findByLocation(location);
	}

	@Override
	public long countUsers(Users user) {
		// TODO Auto-generated method stub
		return userRepo.count();
	}




	
	
	

	

	
}
