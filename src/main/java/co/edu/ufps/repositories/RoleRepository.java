package co.edu.ufps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
