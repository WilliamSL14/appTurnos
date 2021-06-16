package com.asesoftware.semilla.generacionTurnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.generacionTurnos.dto.ComercioDTO;
import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.service.IComercioService;


@RestController
@RequestMapping(path = "/api/v1/comercio")
public class ComerciosController {
	
	@Autowired
	private IComercioService comercioService;
	
	// listar todos
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll() {
			
		return comercioService.getAll();
			
	}
	
	// listar uno
	@GetMapping(path = "/comercio/{id}")
	public ResponseDTO getCommerceById(@PathVariable Integer id) {
			
		return comercioService.getCommerceById(id);
	}

	@GetMapping(path = "/comercio")
	public ResponseDTO getComercioParametroById(@RequestParam Integer id) {
		
		return comercioService.getCommerceById(id);
	}
	
	// crear
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseDTO createCommerce(@RequestBody ComercioDTO dto) {
		
		return comercioService.createCommerce(dto);
	}
	
	// editar
	
	@PostMapping(path = "/edit", consumes = "application/json", produces = "application/json")
	public ResponseDTO editCommerce(@RequestBody ComercioDTO dto) {
		
		return comercioService.updateCommerce(dto);
	}
	
	// eliminar
	
	@GetMapping(path = "/delete/{id}")
	public void deleteCommerce(@PathVariable Integer id) {
		
		comercioService.deleteCommerce(id);
	}
	
}
