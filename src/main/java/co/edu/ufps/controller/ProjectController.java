package co.edu.ufps.controller;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.dto.ErrorDTO;
import co.edu.ufps.dto.ProjectDTO;
import co.edu.ufps.services.ProjectService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping
	public Object getById(@RequestBody ProjectDTO projectDTO) {
		try {
			return projectService.create(projectDTO);
		} catch (Exception e) {
			return ErrorDTO.fromEntity(e);
		}
		
	}
	
}
