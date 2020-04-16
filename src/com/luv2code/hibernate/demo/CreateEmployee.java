package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getCurrentSession();
			transaction = session.beginTransaction();

			Employee e1 = new Employee("Nikhita", "Sharma", "SANSB");
			Employee e2 = new Employee("Siddarth", "Mishra", "OFSS");
			Employee e3 = new Employee("Kapil", "Mishra", "Granules India Limited");
			Employee e4 = new Employee("John", "Deo", "XYZ PVT LTD");
			Employee e5 = new Employee("Anil Kumar", "Mishra", "SMB");
			Employee e6 = new Employee("Sid", "Niks", "OFSS");
			Employee e7 = new Employee("Indrajeet", "Sharma", "ICICI");

			session.save(e1);
			session.save(e2);
			session.save(e3);
			session.save(e4);
			session.save(e5);
			session.save(e6);
			session.save(e7);

			transaction.commit();
			System.out.println("Done!!!");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

}
