package com.xworkz.StudentEnrollApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.StudentEnrollApp.entity.StudentEnrollEntity;
import com.xworkz.StudentEnrollApp.service.StudentEnrollService;
import com.xworkz.StudentEnrollApp.service.StudentEnrollServiceImpl;

@Controller
public class StudentLoginController {
	@Autowired
	private StudentEnrollService enrollService;

	public StudentLoginController() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	@RequestMapping("/getLoginPage.do")
	public String getLoginPage() {
		System.out.println("Invoked getLoginPage method");
		return "Login";
	}

	@RequestMapping("/Login.do")
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
		System.out.println("Invoked Login method");
		try {
			boolean outcome = this.enrollService.getRecordByMailId(email, password);
			if (outcome) {
				model.addAttribute("SuccessMessage", "Successfully Logged In");
				System.out.println("Successfully logged In");
				return "Home";
			} else {
				model.addAttribute("SuccessMessage", "Login failed");
				System.out.println("Login failed");
				return "Home";
			}
		} catch (Exception e) {
			System.out.println("You have an exception " + e.getMessage());
			return "nothing";
		}

	}

}
