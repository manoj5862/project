package com.xworkz.vaccination.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccination.entity.AddMemberEntity;
import com.xworkz.vaccination.entity.RegisterEntity;
@Repository
public class AddMemberDAOImpl implements AddMemberDAO {

	@Autowired
	private SessionFactory factory;
	
	public AddMemberDAOImpl() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	@Override
	public boolean AddMemberDTOSave(AddMemberEntity addMemberEntity) {
		System.out.println("Invoked AddMemberDTOSave");
		Session session = this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(addMemberEntity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			Transaction transaction = session.getTransaction();
			transaction.rollback();
			return false;
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		
	}

	@Override
	public List<AddMemberEntity> FetchAllEntities() {
		System.out.println("Invoked FetchAllEntities");
		List<AddMemberEntity> listOfEnrollEntities = null;
		Session session = null;
		try {
			session = this.factory.openSession();
			String hql = "from AddMemberEntity";
			Query<AddMemberEntity> query = session.createQuery(hql);
			listOfEnrollEntities = query.list();
			return listOfEnrollEntities;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception " + e.getMessage());
			return null;
		} finally {
			if (session != null) {
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		
	}

}
