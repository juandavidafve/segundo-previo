package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.Project;

public interface ProjectAssignmentRepository extends JpaRepository<Project, Integer> {

}
