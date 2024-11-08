package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.ProjectAssignment;

public interface RoleRepository extends JpaRepository<ProjectAssignment, Integer> {

}
