package com.xworkz.vaccination.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.util.PasswordEncryptorAndDecryptor;
import com.xworkz.vaccination.dto.RegisterDTO;
import com.xworkz.vaccination.entity.RegisterEntity;
import com.xworkz.vaccination.repository.RegisterDAO;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDAO dao;

	@Autowired
	private PasswordEncryptorAndDecryptor encryptDecrypt;

	public RegisterServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean serviceSave(RegisterDTO dto) {
		System.out.println("Invoked Service Save Mrthod");
		try {
			RegisterEntity entity = new RegisterEntity();
			BeanUtils.copyProperties(dto, entity);
			String encryptedPassword = this.encryptDecrypt.encrypt(dto.getPassword());
			entity.setPassword(encryptedPassword);
			boolean outcome = this.dao.regsiterDao(entity);
			if (outcome) {
				System.out.println("Saved the deatils into db");
				return true;
			} else {
				System.out.println("Details are not saved into db");
				return false;

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an Exception " + e.getMessage());
		}
		return false;
	}

}
