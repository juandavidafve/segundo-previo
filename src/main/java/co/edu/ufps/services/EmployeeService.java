package co.edu.ufps.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.ufps.dto.EmployeeDTO;
import co.edu.ufps.dto.ErrorDTO;
import co.edu.ufps.dto.ProjectDTO;
import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Project;
import co.edu.ufps.repositories.DepartmentRepository;
import co.edu.ufps.repositories.EmployeeRepository;


@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	DepartmentRepository positionRepository;
	
	public List<EmployeeDTO> listAll(){
		ArrayList<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		List<Employee> employees = employeeRepository.findAll();
		
		for(Employee employee : employees) {
			employeeDTOs.add(EmployeeDTO.fromEntity(employee));
		}
		
		return employeeDTOs;
	}
	
	
	public EmployeeDTO update(EmployeeDTO employeeDTO){
		Employee employee = employeeDTO.toEntity();
		
		if(!employeeRepository.existsById(employee.getId())) {
			throw new RuntimeException("Employee not found");
		}
		
		if(employee.getDepartment() == null || !departmentRepository.existsById(employee.getDepartment().getId())) {
			throw new RuntimeException("Department not found");
		}
		
		if(employee.getPosition() == null || !positionRepository.existsById(employee.getPosition().getId())) {
			throw new RuntimeException("Position not found");
		}
		
		employee = employeeRepository.save(employee);
		
		return EmployeeDTO.fromEntity(employee);
	}
	
	public EmployeeDTO addDepartment(Integer employeeId, Integer departmentId){
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		if(employee.isEmpty()) {
			throw new RuntimeException("Employee not found");
		}
		
		Optional<Department> department = departmentRepository.findById(departmentId);
		
		if(department.isEmpty()) {
			throw new RuntimeException("Department not found");
		}
		
		Employee employeeEntity = employee.get();
		employeeEntity.addDepartment(department.get());
		
		employeeRepository.save(employeeEntity);

		return EmployeeDTO.fromEntity(employeeEntity);
	}
	
}
