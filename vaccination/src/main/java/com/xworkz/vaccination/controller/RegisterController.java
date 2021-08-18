package com.xworkz.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccination.dto.RegisterDTO;
import com.xworkz.vaccination.service.RegisterService;
import com.xworkz.vaccination.util.MailTrigger;
import com.xworkz.vaccination.util.RandomNumberGenerator;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@Autowired
	private MailTrigger mailTrigger;

	public RegisterController() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	Integer randomNumber;

	@RequestMapping("/GetOtp.do")
	public String getOtp(@RequestParam String email, Model model) {
		randomNumber = RandomNumberGenerator.randomNumberGenerator(1000, 9999);
		this.mailTrigger.mailTrigger(email, "Vaccination OTP", "Hello!! Your OTP for Vaccination is " + randomNumber);
		model.addAttribute("OtpSuccessMessage", "Your Otp sent to mail id");
		System.out.println("OTP is generated");
		return "Register";
	}

	@RequestMapping("/Register.do")
	public String onRegister(@ModelAttribute RegisterDTO dto, Model model) {

		System.out.println("Invoked onRegister Method");
		try {
			Integer dto1 = dto.getOtp();
			if (randomNumber.equals(dto1)) {
				this.registerService.serviceSave(dto);
				model.addAttribute("RegisterSuccessMessage", "Registeration Successfull !! Login here");
				System.out.println("Successfully Registerd");
				return "Login";

			} else {
				model.addAttribute("RegisterSuccessMessage", "Registeration Failed");
				System.out.println("Successfully Failed");
				return "Login";

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception " + e.getMessage());
			return "Exception";
		}

	}

}
