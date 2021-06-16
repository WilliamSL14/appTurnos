package com.asesoftware.semilla.generacionTurnos.dto;


import java.util.List;

import lombok.Data;

@Data
public class ComercioDTO {

	private Integer idComercio;
	
	private String nombreComercio;
	
	private Integer aforoMax;
	
	private List<ServicioDTO> servicios;
}
