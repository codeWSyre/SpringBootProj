package com.auca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import  org.springframework.validation.*;


import com.auca.models.*;
import com.auca.services.PropertyService;

import jakarta.servlet.http.HttpSession;

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
	@PostMapping("/saveProperty")
	public String saveProperty(@ModelAttribute("property") Property property) {
		propServ.saveProperty(property);
		
		return "redirect:/listProp";		
	}
	@GetMapping("/showUserForm")
	public String showUserForm(Model model) {
		Users users=new Users();
		model.addAttribute("users",users);
		return "user_reg";

	}
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("users") Users users) {
	
		propServ.saveUsers(users);
		return "redirect:/showLoginForm";
		
		
	}
	@GetMapping("/showLoginForm")
	public String showLogin(Model model) {
		model.addAttribute("users", new Users());
		return "login";
		
		
	}
	
    @PostMapping("/authenticateUser")
    public String login(@ModelAttribute("users") Users users, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "login";
        }

        if (propServ.authenticateUser(users.getId(),users.getPassword())) {
            session.setAttribute("userId", users.getId());
            return "redirect:/showPropForBook";
        } else {
        	
            result.rejectValue("password", "error.users", "Invalid username or password");
            return "login";
        }
}
	@GetMapping("/userList")
	public String showUserList(Model model) {
		model.addAttribute("users", propServ.getAllUsers());
		
		return "user_list";
		
	}
	
	@GetMapping("/showPropForBook")
    public String showProp(Model model) {
		model.addAttribute("listProps", propServ.getAllProperties());
        return "user_dashb";
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
	@GetMapping("/showUserFormForUpdate/{id}")
	public String showUserFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		
		//get student
	Users users=(Users) propServ.getUsersById(id);
		
		//set student as model attribute to prepoppulate the form
		model.addAttribute("users", users );
		return "UserUpdate";
}
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
	    public String adminLogin(Model model) {
	         model.addAttribute("admin", new Admin());
	         return "adminLogin";
	     }
		
	//===================implement validation==============================
		
	;    @PostMapping("/authenticateAdmin")
	    public String AdminloginAuth(@ModelAttribute("admin") Admin admin, BindingResult result, HttpSession session) {
	        if (result.hasErrors()) {
	            return "adminLogin";
	        }

	        if (propServ.authenticateAdmin(admin.getId(),admin.getPassword())) {
	            session.setAttribute("adminId", admin.getId());
	            return "redirect:/adminDashB";
	        } else {
	        	
	            result.rejectValue("password", "error.users", "Invalid username or password");
	            return " adminLogin";
	        }
	        }
  
   	@GetMapping("/adminDashB")
   	public String adminDashBoard(Model model) {
   		//model.addAttribute("listProps", propServ.getAllProperties());
   		
   		return "admin_Dash";
}
   	@GetMapping("/listAgents")
   	public String showAllAdmins(Model model) {
   		model.addAttribute("listAdmins", propServ.getAllAdmins());
   		
   		return "adminList";
   		
   	}
}