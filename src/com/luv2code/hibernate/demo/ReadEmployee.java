package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			Employee employee = new Employee("Gayatri", "Mishra", "Sri Maruti Foods");
			session.save(employee);
			transaction.commit();
			session.close();

			session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			System.out.println("\nRetrieve Employee by primary key");
			int employeeId = employee.getId();
			Employee e = session.get(Employee.class, employeeId);
			System.out.println(e);
			transaction.commit();

			session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			System.out.println("\nQuery objects to find employees for a given company");
			List<Employee> listEmployee = session.createQuery("from Employee where company = 'OFSS'").getResultList();
			listEmployee.forEach(System.out::println);
			transaction.commit();

			System.out.println("\nDone!!!");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
	}

}
