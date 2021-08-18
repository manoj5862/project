package com.xworkz.vaccination.repository;

import com.xworkz.vaccination.entity.RegisterEntity;

public interface RegisterDAO {

	boolean regsiterDao(RegisterEntity entity);
	RegisterEntity getEmailByEntity(String email);
}
