package com.hbspring.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.hbspring.model.Employee;

@Repository
public class EmployeeRepo {
    
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public boolean saveEmployee(Employee emp)
	{
		Session ssn=sf.openSession();
		Transaction ts=ssn.beginTransaction();
		ssn.save(emp);
		
       ts.commit();
		return true;
		
	}
	@Transactional
	public Employee getEmployee(int empId)
	{
		Session ssn=sf.openSession();
		return ssn.get(Employee.class, empId);
	}
	
	@Transactional
	public List<Employee> getAllEmployee()
	{
		Session ssn=sf.openSession();
		Criteria cr=ssn.createCriteria(Employee.class);
		return(cr.list());
	}
	
	@Transactional
	public boolean deleteEmployee(Employee emp)
	{
		Session ssn=sf.openSession();
		ssn.beginTransaction();
		Query q=ssn.createQuery("delete from Employee where empId=:empId");
		q.setParameter("empId",emp.getEmpId());
	    q.executeUpdate();
	    ssn.getTransaction().commit();
		//ssn.delete(emp);
		return true;
	}
	@Transactional
	public boolean update(Employee emp)
	{
		Session ssn=sf.openSession();
		ssn.beginTransaction();
		Query q=ssn.createQuery("update Employee set age=:age where empId=:empId");
		q.setParameter("empId", emp.getEmpId());
		q.setParameter("age",emp.getAge());
		q.executeUpdate();
		ssn.getTransaction().commit();
		return true;
	}
}
