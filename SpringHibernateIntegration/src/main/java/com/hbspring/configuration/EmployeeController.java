package com.hbspring.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbspring.model.Employee;
import com.hbspring.service.Employeeservice;

@Controller
public class EmployeeController {
	
	@Autowired
	
	Employeeservice service;
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee emp, Model m) throws NullPointerException
	{
		String msg="Failed...";
		if(service.saveEmployee(emp))		
			msg="successful";
		m.addAttribute("msg",msg);
		return "view.jsp";
	}
	
	@GetMapping("/employee")
	public String getEmployee(@RequestParam("empId")int empId, Model m)
	{
		Employee emp=service.getEmployee(empId);
		m.addAttribute("emp",emp);
		System.out.println("emp");
		return "getemp.jsp";
			
	}
	
	@RequestMapping("/employees")
	public String getAllEmployees(Model m)
	{
	List<Employee> emplist=service.getAllEmployee();
	m.addAttribute("emplist", emplist);
	return "getall.jsp";
	}
	
	@PostMapping("/delete")
	public String deleteEmp(@RequestParam("empId")int empId, Model m) throws NullPointerException
	{
		String msg="Failed...";
		Employee emp=service.getEmployee(empId);
		if(service.deleteEmployee(emp))
		{
			msg="successful";}
		m.addAttribute("msg",msg);
		return "view.jsp";
	}

	@RequestMapping("/update")
	public String updateEmp(@ModelAttribute Employee emp, Model m) throws NullPointerException
	{
		String msg="Failed...";
		System.out.println(emp);
	    if(service.update(emp))
	    {
	    	msg="successful";
	    }
		m.addAttribute("msg",msg);
		return "view.jsp";
	   }
		
		
	}
