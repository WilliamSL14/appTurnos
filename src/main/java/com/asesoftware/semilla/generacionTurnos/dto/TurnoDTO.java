package com.asesoftware.semilla.generacionTurnos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TurnoDTO {
	
	private Integer idTurno;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd")
	private Date fechaTurno;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss", timezone ="America/New_York")
	private Date horaInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss", timezone ="America/New_York")
	private Date horaFin;
	
	private String estado;
	
	private Integer idServicio;

	public TurnoDTO(Integer idTurno, Date fechaTurno, Date horaInicio, Date horaFin, String estado,
			Integer idServicio) {
		super();
		this.idTurno = idTurno;
		this.fechaTurno = fechaTurno;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.estado = estado;
		this.idServicio = idServicio;
	}

	
}
