package com.asesoftware.semilla.generacionTurnos.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDTO {
	
	private Object data;
	private boolean succes;
	private String message;
	private HttpStatus status;
	
	public ResponseDTO(Object data, boolean succes, String message, HttpStatus status) {
		this.data = data;
		this.succes = succes;
		this.message = message;
		this.status = status;
	}
	

}
