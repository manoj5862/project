package com.xworkz.vaccination.repository;

import java.util.List;

import com.xworkz.vaccination.entity.AddMemberEntity;

public interface AddMemberDAO {

	boolean AddMemberDTOSave(AddMemberEntity addMemberEntity);
	List<AddMemberEntity> FetchAllEntities();	
}
