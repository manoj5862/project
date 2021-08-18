package com.xworkz.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.vaccination.service.RegisterService;
@Controller
public class LoginController {
	
	@Autowired
	private RegisterService registerService;
	
	public LoginController() {
		System.out.println("Created"+this.getClass().getSimpleName());
	}
	@RequestMapping("/Login.do")
	public String onLogin(@RequestParam String email, @RequestParam String password , Model model) {
		System.out.println("Invoked Login method");
		try {
		boolean outcome = this.registerService.loginService(email, password);
		if(outcome) {
			model.addAttribute("LoginSuccessMessage", "Login Successfull");
			System.out.println("Successfully Logged In");
			return "LoginSuccess";
		}else {
			model.addAttribute("LoginSuccessMessage", "Login Failed");
			System.out.println("Login Failed");
			return "LoginSuccess";
		}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception " + e.getMessage());
			return "";
		}

	}
}
