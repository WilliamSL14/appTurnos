package com.asesoftware.semilla.generacionTurnos.service;

import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;

public interface ITurnoService {
	
	public ResponseDTO getAll();
	
	public ResponseDTO consultarTodosServicio (String nombreServicio);
	
	public ResponseDTO consultarTodosComercio (String nombreComercio);

}
