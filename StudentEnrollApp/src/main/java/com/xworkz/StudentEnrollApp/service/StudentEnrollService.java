package com.xworkz.StudentEnrollApp.service;

import com.xworkz.StudentEnrollApp.dto.StudentEnrollDTO;
import com.xworkz.StudentEnrollApp.entity.StudentEnrollEntity;

public interface StudentEnrollService {
	boolean saveStudentDetails(StudentEnrollDTO studentEnrollDTO);
	boolean getRecordByMailId(String Emaild , String password);
}
