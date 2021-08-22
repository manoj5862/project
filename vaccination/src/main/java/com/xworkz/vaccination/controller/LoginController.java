package com.xworkz.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.vaccination.service.RegisterService;
import com.xworkz.vaccination.service.VaccinationLoginService;
@Controller
public class LoginController {
	
	@Autowired
	private VaccinationLoginService loginService;
	
	public LoginController() {
		System.out.println("Created"+this.getClass().getSimpleName());
	}
	@RequestMapping("getLoginPage.do")
	public String jaonGetLoginPage() {
		
		return "Login";
	}
	
	
	@RequestMapping("/Login.do")
	public String onLogin(@RequestParam String email, @RequestParam String password , Model model) {
		System.out.println("Invoked Login method");
		boolean outcome = this.loginService.loginEmailAndPasswordValidate(email, password);
		if(outcome) {
			this.loginService.loginService(email, password, model);
		}else {
			model.addAttribute("LoginEmailAndPasswordEmptyValidateMessage", "Email or Password Cannot be empty");
			return "Login";
		}
		return null;
		
		

	}
}
