package com.asesoftware.semilla.generacionTurnos.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ServicioDTO {
	
	private Integer idServicio;
	
	private String nombreServicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd HH:mm:ss", timezone ="America/New_York")
	private Date horaApertura;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd HH:mm:ss", timezone ="America/New_York")
	private Date horaCierre;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss", timezone ="America/New_York")
	private Date duracion;
	
	private Integer idComercio;
	
	private List<TurnoDTO> turnos;
	
}
