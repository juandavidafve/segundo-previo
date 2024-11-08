package co.edu.ufps.controller;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Employee;
import co.edu.ufps.services.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAll() {
		return employeeService.listAll();
	}
	
}
