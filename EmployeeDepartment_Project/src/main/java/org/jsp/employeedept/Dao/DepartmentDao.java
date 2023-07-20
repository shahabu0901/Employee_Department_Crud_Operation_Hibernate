package org.jsp.employeedept.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.employeedept.Dto.Department;

public class DepartmentDao {
	EntityManager manager = Persistence.createEntityManagerFactory("md").createEntityManager();

	public Department saveDepartment(Department d) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		return d;
	}

	public Department updateDepartment(Department d) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(d);
		transaction.begin();
		transaction.commit();
		return d;
	}
}
