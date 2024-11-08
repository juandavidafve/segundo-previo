package co.edu.ufps.dto;

import java.util.Date;

import co.edu.ufps.entities.Project;
import lombok.Data;

@Data
public class ProjectDTO {
	private Integer id;
	
	private String name;
	
	private String description;
	
	private Date startDate;
	
	private Date endDate;
	
	public static ProjectDTO fromEntity(Project project) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(project.getId());
		projectDTO.setName(project.getName());
		projectDTO.setDescription(project.getDescription());
		projectDTO.setStartDate(project.getStartDate());
		projectDTO.setEndDate(project.getEndDate());
		
		return projectDTO;
	}
	
	public Project toEntity() {
		Project project = new Project();
		project.setId(this.id);
		project.setName(this.name);
		project.setDescription(this.description);
		project.setStartDate(this.getStartDate());
		project.setEndDate(this.getEndDate());
		
		return project;
	}
}
