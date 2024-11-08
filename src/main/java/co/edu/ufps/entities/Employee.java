package co.edu.ufps.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String first_name;
	
	private String last_name;
	
	private Date birth_date;
	
	private Date entry_date;

	@ManyToOne
	@JoinColumn(name = "pos_id")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Department department;
	
	@OneToMany(mappedBy = "chief", cascade = CascadeType.ALL)
	List<Department> chiefs; 
	
	@ManyToMany(mappedBy = "visits")
	List<Department> visits;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	List<ProjectAssignment> assignments; 
}
