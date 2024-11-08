package co.edu.ufps.dto;

import co.edu.ufps.entities.Position;
import lombok.Data;

@Data
public class PositionDTO {
	private Integer id;
	
	private String name;
	
	private Integer salary;
	
	public static PositionDTO fromEntity(Position position) {
		PositionDTO positionDTO = new PositionDTO();
		positionDTO.setId(position.getId());
		positionDTO.setName(position.getName());
		positionDTO.setSalary(position.getSalary());
		
		return positionDTO;
	}
}
