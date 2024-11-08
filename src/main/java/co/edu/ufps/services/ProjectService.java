package co.edu.ufps.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.dto.PositionDTO;
import co.edu.ufps.dto.ProjectDTO;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Position;
import co.edu.ufps.entities.Project;
import co.edu.ufps.repositories.EmployeeRepository;
import co.edu.ufps.repositories.PositionRepository;
import co.edu.ufps.repositories.ProjectRepository;


@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public ProjectDTO create(ProjectDTO projectDTO){
		Project project = projectDTO.toEntity();
		
		project = projectRepository.save(project);
		
		return ProjectDTO.fromEntity(project);
	}
}
