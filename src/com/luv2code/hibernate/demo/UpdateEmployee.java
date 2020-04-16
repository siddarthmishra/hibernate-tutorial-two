package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			int employeeId = 8;
			Employee employee = session.get(Employee.class, employeeId);
			employee.setCompany("Sri Maruti Foods Private Limited");
			transaction.commit();

			System.out.println("Done!!!");
		} catch (Exception e) {

		} finally {
			session.close();
		}
	}

}
