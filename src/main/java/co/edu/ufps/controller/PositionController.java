package co.edu.ufps.controller;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.dto.EmployeeDTO;
import co.edu.ufps.dto.ErrorDTO;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Position;
import co.edu.ufps.services.EmployeeService;
import co.edu.ufps.services.PositionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	PositionService positionService;
	
	@GetMapping("/{id}")
	public Object getById(@PathVariable Integer id) {
		try {
			return positionService.findById(id);
		} catch (Exception e) {
			return ErrorDTO.fromEntity(e);
		}
		
	}
	
}
