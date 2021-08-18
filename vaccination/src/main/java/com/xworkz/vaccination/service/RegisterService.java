package com.xworkz.vaccination.service;

import com.xworkz.vaccination.dto.RegisterDTO;

public interface RegisterService {
	public boolean serviceSave(RegisterDTO dto);
	public boolean loginService(String email , String Password);
}
