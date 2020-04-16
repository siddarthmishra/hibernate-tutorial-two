package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			System.out.println("Delete an object by primary key");
			int employeeId = 4;
			int count = session.createQuery("delete from Employee where id = " + employeeId).executeUpdate();
			System.out.println(count + " row deleted");
			transaction.commit();

			System.out.println("Done!!!");
		} catch (Exception e) {

		} finally {
			session.close();
		}
	}

}
