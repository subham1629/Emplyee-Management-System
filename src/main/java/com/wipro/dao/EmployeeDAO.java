package com.wipro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.wipro.model.Employee;



public class EmployeeDAO {
	SessionFactory sf;
	public EmployeeDAO() {
		Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
	    ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
	    sf=con.buildSessionFactory(reg);
	}
	
	public void saveEmployee(Employee emp) {
		Transaction tx = null;
		try (Session session=sf.openSession()) {
	        tx = session.beginTransaction();
	        session.save(emp);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee emp) {
		Transaction tx = null;
		try (Session session=sf.openSession()) {
	        tx = session.beginTransaction();
	        session.update(emp);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {
		Transaction tx = null;
		try (Session session=sf.openSession()) {
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, id);
			if (emp != null) {
				session.delete(emp);
				System.out.println("user is deleted");
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public Employee getEmployee(int id) {
		Transaction tx = null;
		Employee emp = null;
		try (Session session=sf.openSession()) {
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return emp;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		Transaction tx = null;
		List<Employee> listOfEmployee = null;
		try (Session session=sf.openSession()) {
			tx = session.beginTransaction();
			listOfEmployee = session.createQuery("from Employee").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return listOfEmployee;
	}
}
