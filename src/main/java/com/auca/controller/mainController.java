package com.auca.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import com.auca.models.*;
import com.auca.services.PropertyService;

@Controller
public class mainController {
	
	@Autowired
	public PropertyService propServ;
	
	
	@GetMapping("/")
	public String showAdminFrom(Model model) {
		//model.addAttribute("listProps", propServ.getAllProperties());
		
		return "admin_portal";
}
	@GetMapping("/listProp")
	public String showPropList(Model model) {
		model.addAttribute("property", propServ.getAllProperties());
		
		return "PropertyList";
	}
	@GetMapping("/showPropReg")
	public String showPropertyForm(Model model){
		 Property prop=new Property();
		model.addAttribute("property" ,prop);
		return "new_property";
	
	}
	@GetMapping("/showSearchingPortal")
	public String showSearchForm(Model model){
		 Property prop=new Property();
		model.addAttribute("property" ,prop);
		return "searching";
	
	}
	@PostMapping("/saveProperty")
	public String saveProperty(@ModelAttribute("property") Property property,Model model) {
		propServ.saveProperty(property);
		 model.addAttribute("message", " Property Successfully saved!");
		return "new_property";		
	}

	@GetMapping("/adminPropList")
	public String showAdminPropList(Model model) {
		model.addAttribute("property", propServ.getAllProperties());
		
		return "user_portal";
	}
	
	@GetMapping("/showUserForm")
	public String showUserForm(Model model) {
		Users users=new Users();
		model.addAttribute("users",users);
		return "user_reg";

	}
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("users") Users users,Model model) {
	
		propServ.saveUsers(users);
		 model.addAttribute("message", "Guest Successfully saved!");
		return "user_reg";
		
		
	}
	@GetMapping("/showLoginForm")
	public String showLogin(Model model) {
		model.addAttribute("users", new Users());
		return "Login";
		
		
	}
	
   
	@GetMapping("/userList")
	public String showUserList(Model model) {
		model.addAttribute("users", propServ.getAllUsers());
		
		return "user_list";
		
	}
	@GetMapping("/showUserFormForUpdate/{id}")
	public String showUserFormForUpd(@PathVariable(value = "id") Long id, Model model) {
		
		//get student
		Users user=(Users) propServ.getUsersById(id);
		
		//set student as model attribute to prepoppulate the form
		model.addAttribute("user", user );
		return "UserUpdate";
}
	
	@GetMapping("/showPropForBook")
    public String showProp(Model model) {
		model.addAttribute("property", propServ.getAllProperties());
        return "user_portal";
    }
	
	
//==========================================delete property======================================================
	@GetMapping("/DeleteProperty/{id}")
	public String deleteStudent(@PathVariable(value = "id") Long id) {
		//call delete student method
		this.propServ.deletePropertyById(id);
		return "redirect:/listProp";
		
	}
	@GetMapping("/showPropFormForUpdate/{id}")
	public String showNewFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		
		//get student
		Property prop=propServ.findPropertyById(id);
		
		//set student as model attribute to prepoppulate the form
		model.addAttribute("property", prop );
		return "propUpdate";
}
	//===================================deleting user by id ==============================================================
	@GetMapping("/DeleteUser/{id}")
	public String deleteUser(@PathVariable(value = "id") Long id) {
		//call delete student method
		this.propServ.deleteUserById(id);
		return "redirect:/userList";
		
	}
	//======================================update user=====================================================

	  @GetMapping("/adminReg")
	 	public String showAdminForm(Model model) {
	 		Admin admin=new Admin();
	 		model.addAttribute("admin" ,admin);
	 		return "admin_reg";
	 	
	 	} 
	    
	     
	 	@PostMapping("/saveAdmin")
public String saveAdmin(@ModelAttribute("admin") Admin admin) {
	 	
	 		propServ.saveAdminUsers(admin);
	 		return "redirect:/adminLoginForm";
	 		
	 		
	 	}
	 	  @GetMapping("/adminLoginForm")
	      public String showLoginFormAdmin(Model model) {
	     	 model.addAttribute("admin", new Admin());
	          return "adminLogin";
	      }
	      @PostMapping("/adminLogin")
	      public String loginAdmin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	          Admin adminUser = propServ.loginAdmin(email, password);
	          if (adminUser != null) {
	              // Successful login
	              model.addAttribute("admin", adminUser);
	              return "admin_Dash";
	          } else {
	              // Failed login
	              model.addAttribute("error", "Invalid email or password");
	              return "adminLogin";
	          }
	      }
  
   	@GetMapping("/adminDashB")
   	public String adminDashBoard(Model model) {
   		//model.addAttribute("listProps", propServ.getAllProperties());
   		Admin admin =new Admin();
   	 model.addAttribute("admin", admin);
   		return "admin_Dash";
}
   	@GetMapping("/listAgents")
   	public String showAllAdmins(Model model) {
   		model.addAttribute("admins", propServ.getAllAdmins());
   		
   		return "adminList";
   		
   	}
   	//============================================booking================================================
   	@GetMapping("/showBookingPortal")
	public String showBookingForm(Model model){
		 PropertyBooking propB=new PropertyBooking();
		model.addAttribute("propertyBooking" ,propB);
	     return "booking";
	
	}
 	@PostMapping("/saveBooked")
public String saveBooked(@ModelAttribute("propertyBooking") PropertyBooking propertyBooking,Model model) {
 	
 		propServ.saveBookedProperty(propertyBooking);
 		 model.addAttribute("message", "Successfully Booked we'll get back to you!");
 		return "booking";
 		
 		
 	}
 	@GetMapping("/BookedList")
	public String showBookingList(Model model){
		 model.addAttribute("propertyBookingList", propServ.getAllBookingProperties());
	     return "bookedProp";
	
	}
 	@GetMapping("/searchPortal")
	public String showSearchedProp(Model model){
		 Property prop= new Property();
		 prop.getLocation();
		model.addAttribute("property" ,prop);
	     return "searchedProp";
	
	}
 	 @PostMapping("/searchPropByLocation")
     public String searchByLocation(@RequestParam("location") String location, Model model) {
 		 //Property prop= new Property();
 		// prop.getLocation();
 		// String myLoc=prop.getLocation();
 		 List<Property> properties = propServ.searchByLocation(location);
         model.addAttribute("properties", properties);
         return "searchedProp"; 
     }
 	 //==============================================login testt============================================

     @GetMapping("/loginForm")
     public String showLoginForm(Model model) {
    	 model.addAttribute("user", new Users());
         return "login";
     }
     @PostMapping("/login")
     public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
         Users user = propServ.loginUser(email, password);
         if (user != null) {
             // Successful login
             model.addAttribute("user", user);
             return "dashboard";
         } else {
             // Failed login
             model.addAttribute("error", "Invalid email or password");
             return "login";
         }
     }
     @GetMapping("/dashboard")
     public String dashboard(Model model) {
    	Users user=new Users();
    	
    	 model.addAttribute("user", user);
             return "dashboard";
       
     }

    
     
 	 
}