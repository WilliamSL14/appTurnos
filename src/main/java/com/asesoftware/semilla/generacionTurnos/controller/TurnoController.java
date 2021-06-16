package com.asesoftware.semilla.generacionTurnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.service.ITurnoService;

@RestController
@RequestMapping(path = "/api/v1/turno")
public class TurnoController {
	
	@Autowired
	private ITurnoService turnoService;
	
	@GetMapping(path = "/todos")
	public ResponseDTO getAll() {
		
		return turnoService.getAll();
	}
	
	@GetMapping(path = "/servicio")
	public ResponseDTO consultarTodosServicio(@RequestParam String nombreServicio) {
		
		return turnoService.consultarTodosServicio(nombreServicio);
	}
	
	@GetMapping(path = "/comercio")
	public ResponseDTO consultarTodosComercio(@RequestParam String nombreComercio) {
		
		return turnoService.consultarTodosComercio(nombreComercio);
	}

}
