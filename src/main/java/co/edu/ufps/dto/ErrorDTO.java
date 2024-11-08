package co.edu.ufps.dto;

import lombok.Data;

@Data
public class ErrorDTO {
	private Boolean error;
	private String msg;
	
	public static ErrorDTO fromEntity(Exception exception) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setError(true);
		errorDTO.setMsg(exception.getMessage());
		
		return errorDTO;
	}
}