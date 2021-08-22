package com.xworkz.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccination.entity.RegisterEntity;
import com.xworkz.vaccination.repository.VaccinationLoginDAO;
import com.xworkz.vaccination.util.PasswordEncryptorAndDecryptor;

@Service
public class VaccinationLoginServiceImpl implements VaccinationLoginService {

	@Autowired
	VaccinationLoginDAO vaccinationLoginDAO;

	@Autowired
	private PasswordEncryptorAndDecryptor encryptDecrypt;

	public VaccinationLoginServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public String loginService(String email, String Password, Model model) {
		System.out.println("Invoked Login Service Method");
		try {
			RegisterEntity entity = this.vaccinationLoginDAO.getEmailByEntity(email);
			int loginAttempts = entity.getNoOfLoginAttempts();
			if (loginAttempts < 3) {
				String decryptedPassword = this.encryptDecrypt.decrypt(entity.getPassword());
				if (entity != null && !entity.getEmail().isEmpty() && entity.getEmail() != null
						&& !entity.getPassword().isEmpty() && entity.getPassword() != null
						&& Password.equals(decryptedPassword)) {
					model.addAttribute("LoginSuccessMessage", "Login Successfull");
					System.out.println("Successfully Logged In");
					return "LoginSuccess";
				} else {
					loginAttempts++;
					this.vaccinationLoginDAO.updateAttempt(loginAttempts, email);
					model.addAttribute("LoginSuccessMessage", "Incorrect Login Details Entered");
					System.out.println("Incorrect Login Details Entered");
					return "LoginSuccess";
				}
			} else {
				model.addAttribute("LoginBlockMessage", "User is blocked exceeded no of login attempts");
				System.out.println("User is blocked exceeded no of login attempts");
				return "Login";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an Exception " + e.getMessage());
			return "Something Went Wrong in Login Details";
		}

	}

	@Override
	public boolean loginEmailAndPasswordValidate(String email, String Password) {
		if(!email.isEmpty() && email !=null && Password != null && !Password.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
}
