package co.edu.ufps.dto;

import java.util.Date;

import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Position;
import lombok.Data;

@Data
public class EmployeeDTO {
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private Date entryDate;
	
	private Integer position;
	
	private Integer department;
	
	public static EmployeeDTO fromEntity(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setId(employee.getId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setBirthDate(employee.getBirthDate());
		employeeDTO.setEntryDate(employee.getEntryDate());

		if (employee.getPosition() != null) {
			employeeDTO.setPosition(employee.getPosition().getId());
		}
		
		if (employee.getDepartment() != null) {
			employeeDTO.setDepartment(employee.getDepartment().getId());
		}
		
		return employeeDTO;
	}
	
	public Employee toEntity() {
		Employee employee = new Employee();
		employee.setId(this.id);
		employee.setFirstName(this.firstName);
		employee.setLastName(this.lastName);
		employee.setLastName(this.lastName);
		employee.setEntryDate(this.entryDate);

		if (this.position != null) {
			Position position = new Position();
			position.setId(this.position);
			employee.setPosition(position);
		}
		
		if (this.department != null) {
			Department department = new Department();
			department.setId(this.department);
			employee.setDepartment(department);
		}
		
		return employee;
	}
}
