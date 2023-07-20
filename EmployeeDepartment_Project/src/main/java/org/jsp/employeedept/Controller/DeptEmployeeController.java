package org.jsp.employeedept.Controller;
import java.util.List;
import java.util.Scanner;

import org.jsp.employeedept.Dao.DepartmentDao;
import org.jsp.employeedept.Dao.EmployeeDao;
import org.jsp.employeedept.Dto.Department;
import org.jsp.employeedept.Dto.Employee;

public class DeptEmployeeController {
	static DepartmentDao deptDao = new DepartmentDao();
	static EmployeeDao empDao = new EmployeeDao();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("1.Save the Department");
		System.out.println("2.Update the Department");
		System.out.println("3.Add the Employee");
		System.out.println("4.Verify Employee By Phone and password");
		System.out.println("5.Verify Employee By id and password");
		System.out.println("6.Find Employees By Department Id");
		System.out.println("7.Find Employees By Department name");
		int choice = s.nextInt();
		switch (choice) {
		case 1: {
			saveDept();
			break;
		}
		case 2: {
			updateDept();
			break;
		}
		case 3: {
			addEmployee();
			break;
		}
		case 4: {
			verifyEmpByPhone();
			break;
		}
		case 5: {
			verifyEmpById();
			break;
		}
		case 6: {
			findEmployeeBydeptId();
			break;
		}
		case 7: {
			findEmployeeBydeptName();
			break;
		  }
		}
	}

	public static void saveDept() {
		System.out.println("Enter the department name and location");
		String name = s.next();
		String location = s.next();
		Department d = new Department();
		d.setName(name);
		d.setLocation(location);
		d = deptDao.saveDepartment(d);
		System.out.println("department Saved with Id:" + d.getId());
	}

	public static void updateDept() {
		System.out.println("Enter The department id to update");
		int id = s.nextInt();
		System.out.println("Enter the department name and location");
		String name = s.next();
		String location = s.next();
		Department d = new Department();
		d.setId(id);
		d.setName(name);
		d.setLocation(location);
		d = deptDao.updateDepartment(d);
		System.out.println("department updated");
	}

	public static void addEmployee() {
		System.out.println("Enter the department id to add Employee");
		int dept_id = s.nextInt();
		System.out.println("Enter name,desg,salary,phone and password to add the Employee");
		String name = s.next();
		String desg = s.next();
		double salary = s.nextDouble();
		long phone = s.nextLong();
		String password = s.next();
		Employee e = new Employee();
		e.setName(name);
		e.setDesg(desg);
		e.setPassword(password);
		e.setPhone(phone);
		e.setSalary(salary);
		e = empDao.saveEmployee(e, dept_id);
		if (e != null)
			System.out.println("Employee saved with id:" + e.getId());
		else
			System.err.println("Invalid department id");
	}

	public static void verifyEmpByPhone() {
		System.out.println("Enter the employee phone and password to verify");
		long phone = s.nextLong();
		String password = s.next();
		Employee e = empDao.verifyEmployee(phone, password);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("Invalid Phone or Password");
		}
	}
	public static void verifyEmpById() {
		System.out.println("Enter the employee id and password to verify");
		int id = s.nextInt();
		String password = s.next();
		Employee e = empDao.verifyEmployee(id, password);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Phone Number:" + e.getPhone());

		} else {
			System.err.println("Invalid id or Password");
		}
	}

	public static void findEmployeeBydeptId() {
		System.out.println("Enter the department id to fetch Employees");
		int id = s.nextInt();
		List<Employee> emps = empDao.findEmployees(id);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id:" + e.getId());
				System.out.println("Employee Name:" + e.getName());
				System.out.println("Salary:" + e.getSalary());
				System.out.println("Designation:" + e.getDesg());
				System.out.println("Phone Number:" + e.getPhone());
				System.out.println("---------------------------------------");
			}
		} else {
			System.err.println("You have entered an Invalid department id");
		}
	}

	public static void findEmployeeBydeptName() {
		System.out.println("Enter the department name to fetch Employees");
		String name = s.next();
		List<Employee> emps = empDao.findEmployees(name);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id:" + e.getId());
				System.out.println("Employee Name:" + e.getName());
				System.out.println("Salary:" + e.getSalary());
				System.out.println("Designation:" + e.getDesg());
				System.out.println("Phone Number:" + e.getPhone());
				System.out.println("---------------------------------------");
			}
		} else {
			System.err.println("You have entered an Invalid department name");
		}
	}
}
