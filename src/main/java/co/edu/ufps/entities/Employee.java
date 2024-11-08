package co.edu.ufps.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "entry_date")
	private Date entryDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pos_id")
	private Position position;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "dep_id")
	private Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy = "chief", cascade = CascadeType.ALL)
	List<Department> chiefs; 
	
	@JsonIgnore
	@ManyToMany(mappedBy = "visits")
	List<Department> visits;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	List<ProjectAssignment> assignments; 
	
	public void addDepartment(Department department) {
		this.visits.add(department);
	}
}
