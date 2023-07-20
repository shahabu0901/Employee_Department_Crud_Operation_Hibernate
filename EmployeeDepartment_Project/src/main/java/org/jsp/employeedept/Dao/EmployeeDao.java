package org.jsp.employeedept.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.employeedept.Dto.Department;
import org.jsp.employeedept.Dto.Employee;

public class EmployeeDao {
	EntityManager manager = Persistence.createEntityManagerFactory("md").createEntityManager();

	public Employee saveEmployee(Employee e, int dept_id) {
		Department d = manager.find(Department.class, dept_id);
		if (d != null) {
			e.setDept(d);// assigning department for Employee
			d.getEmps().add(e);// Adding employee for Department
			EntityTransaction transaction = manager.getTransaction();
			manager.persist(e);
			transaction.begin();
			transaction.commit();
			return e;
		}
		return null;
	}
	public Employee updateEmployee(Employee e, int dept_id) {
		Department d = manager.find(Department.class, dept_id);
		if (d != null) {
			e.setDept(d);// assigning department for Employee
			d.getEmps().add(e);// Adding employee for Department
			EntityTransaction transaction = manager.getTransaction();
			manager.merge(e);
			transaction.begin();
			transaction.commit();
			return e;
		}
		return null;
	}
	public Employee verifyEmployee(long phone, String password) {
		String qry = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public Employee verifyEmployee(int id, String password) {
		String qry = "select e from Employee e where e.id=?1 and e.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public List<Employee> findEmployees(int dept_id) {
		String qry = "select d.emps from Department d where d.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, dept_id);
		return q.getResultList();
	}
	public List<Employee> findEmployees(String dept_name) {
		String qry = "select d.emps from Department d where d.name=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, dept_name);
		return q.getResultList();
	}
}
