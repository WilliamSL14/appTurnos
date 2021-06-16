package com.asesoftware.semilla.generacionTurnos.service;

import java.util.List;

import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.dto.ServicioDTO;
import com.asesoftware.semilla.generacionTurnos.entity.ServicioEntity;

public interface IServicioService {
	
	public ResponseDTO getAll();
	
	public ResponseDTO getServiceById(Integer id);
	
	public ResponseDTO createService(ServicioDTO servicioDTO);
	
	public ResponseDTO updateService(ServicioDTO servicioDTO);
	
	public ResponseDTO deleteService(Integer id);

}
