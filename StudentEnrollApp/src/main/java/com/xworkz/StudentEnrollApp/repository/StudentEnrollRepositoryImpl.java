package com.xworkz.StudentEnrollApp.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.StudentEnrollApp.entity.StudentEnrollEntity;

@Repository
public class StudentEnrollRepositoryImpl implements StudentEnrollRepository {

	@Autowired
	private SessionFactory factory;

	public StudentEnrollRepositoryImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean SaveToDb(StudentEnrollEntity enrollEntity) {
		System.out.println("Invoked Repository save method");
		Session session = this.factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(enrollEntity);
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
	public StudentEnrollEntity getRecordByMailId(String email) {
		System.out.println("Invoked Repository Login Method");
		StudentEnrollEntity enrollEntity = null;
		Object session = null;
		try {
			session = this.factory.openSession();
			Query<StudentEnrollEntity> query = ((QueryProducer) session).createNamedQuery("GetRecordByMail");
			query.setParameter("em", email);
			enrollEntity = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an exception "+e.getMessage());
		} finally {
			if (session != null) {
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}

		return enrollEntity;
	}

}
