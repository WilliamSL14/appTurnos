package com.asesoftware.semilla.generacionTurnos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.dto.ServicioDTO;
import com.asesoftware.semilla.generacionTurnos.service.ServicioService;

@RestController
@RequestMapping(path = "/api/v1/servicio")
public class ServiciosController {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll() {
			
		return servicioService.getAll();
			
	}
	
	// listar uno
	@GetMapping(path = "/servicio/{id}")
	public ResponseDTO getServiceById(@PathVariable Integer id) {
			
		return servicioService.getServiceById(id);
	}

	@GetMapping(path = "/servicio")
	public ResponseDTO getServiceParametroById(@RequestParam Integer id) {
		
		return servicioService.getServiceById(id);
	}
	
	// crear
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseDTO createCommerce(@RequestBody ServicioDTO servicioDTO) {
		
		return servicioService.createService(servicioDTO);
	}
	
	// editar
	
	@PostMapping(path = "/edit", consumes = "application/json", produces = "application/json")
	public ResponseDTO editCommerce(@RequestBody ServicioDTO servicioDTO) {
		
		return servicioService.updateService(servicioDTO);
	}
	
	// eliminar
	
	@GetMapping(path = "/delete/{id}")
	public ResponseDTO deleteService(@PathVariable Integer id) {
		
		return servicioService.deleteService(id);
	}

}
