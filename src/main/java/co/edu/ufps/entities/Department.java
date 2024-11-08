package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "chief_id", nullable = true)
	private Employee chief;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	List<Employee> employees; 
	
	@ManyToMany
	@JoinTable(
	  name = "visit", 
	  joinColumns = @JoinColumn(name = "department_id"), 
	  inverseJoinColumns = @JoinColumn(name = "employee_id"))
	List<Employee> visits;
}

