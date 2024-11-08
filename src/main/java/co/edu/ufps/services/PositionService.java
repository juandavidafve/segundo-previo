package co.edu.ufps.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.dto.PositionDTO;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Position;
import co.edu.ufps.repositories.EmployeeRepository;
import co.edu.ufps.repositories.PositionRepository;


@Service
public class PositionService {
	@Autowired
	PositionRepository positionRepository;
	
	public PositionDTO findById(Integer id){
		
		Optional<Position> position = positionRepository.findById(id);
		
		if(position.isEmpty()) {
			throw new RuntimeException("Position not found");
		}
		
		return PositionDTO.fromEntity(position.get());
	}
}
