package co.edu.ufps.controller;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.dto.EmployeeDTO;
import co.edu.ufps.dto.ErrorDTO;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.services.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<EmployeeDTO> getAll() {
		return employeeService.listAll();
	}
	
	@PutMapping
	public Object update(@RequestBody EmployeeDTO employeeDTO) {
		try {
			return employeeService.update(employeeDTO);
		} catch (Exception e) {
			return ErrorDTO.fromEntity(e);
		}
		
	}
	
	@PostMapping("/{employeeId}/department/{departmentId}")
	public Object addDepartment(@PathVariable Integer employeeId, @PathVariable Integer departmentId) {
		try {
			return employeeService.addDepartment(employeeId, departmentId);
		} catch (Exception e) {
			return ErrorDTO.fromEntity(e);
		}
		
	}
}
