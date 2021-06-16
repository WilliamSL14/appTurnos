package com.asesoftware.semilla.generacionTurnos.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.dto.ServicioDTO;
import com.asesoftware.semilla.generacionTurnos.entity.ServicioEntity;
import com.asesoftware.semilla.generacionTurnos.mapper.IServicioMapper;
import com.asesoftware.semilla.generacionTurnos.repository.IServicioRepository;

@Service
public class ServicioService implements IServicioService{
	
	private static final Logger logger = LoggerFactory.getLogger(ServicioService.class);
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private IServicioMapper mapperServicio;

	@Override
	public ResponseDTO getAll() {
		
		List<ServicioEntity> listServicioEntity = servicioRepository.findAll();
		logger.info("Se consultaron todos los servicios");
		return new ResponseDTO((mapperServicio.listEntityToDto(listServicioEntity)), true, "Consulta de servicio realizada con éxito", HttpStatus.OK);
	}


	@Override
	public ResponseDTO getServiceById(Integer id) {
		
		Optional<ServicioEntity> optional = servicioRepository.findById(id);
		
		if (optional.isPresent()) {
			logger.info("Se consultó el servicio {}", id);
			return new ResponseDTO(mapperServicio.entityToDto(optional.get()), true , "Consulta de servicio realizada con éxito", HttpStatus.OK);
		}
		else {
			logger.info("Error al consultar el servicio {}", id);
			return new ResponseDTO(null, true , "Servicio no encontrado", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO createService(ServicioDTO servicioDTO) {
		
		try { 
			
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDTO);
			logger.info("El servicio {} se creó", servicioDTO.getIdServicio());
			return new ResponseDTO(mapperServicio.entityToDto(servicioRepository.save(servicioEntity)), true, "Servicio creado correctamente", HttpStatus.OK);
			
		}catch (Exception e){
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, true, "Error al crear servicio", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO updateService(ServicioDTO servicioDTO) {
		
		try {
			
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDTO);
			logger.info("El servicio {} se actualizó", servicioDTO.getIdServicio());
			return new ResponseDTO(mapperServicio.entityToDto(servicioRepository.save(servicioEntity)), true, "Servicio actualizado correctamente", HttpStatus.OK);
			
		}catch (Exception e) {
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, true, "Error al actualizar servicio", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO deleteService(Integer id) {
		
		try {
			
			servicioRepository.deleteById(id);
			logger.info("El servicio {} se eliminó", id);
			return new ResponseDTO(null, true, "Servicio eliminado correctamente", HttpStatus.OK);
			
		}catch(Exception e) {
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, true, "Erro al eliminar servicio", HttpStatus.OK);
			
		}
		
	}
	
}
