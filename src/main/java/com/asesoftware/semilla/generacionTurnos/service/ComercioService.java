package com.asesoftware.semilla.generacionTurnos.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.generacionTurnos.dto.ComercioDTO;
import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.entity.ComercioEntity;
import com.asesoftware.semilla.generacionTurnos.mapper.IComercioMapper;
import com.asesoftware.semilla.generacionTurnos.repository.IComercioRepository;


@Service
public class ComercioService implements IComercioService{
	
	private static final Logger logger = LoggerFactory.getLogger(ComercioService.class);

	@Autowired
	private IComercioRepository comercioRepository;
	
	@Autowired
	private IComercioMapper mapperComercio;
	
	@Override
	public ResponseDTO getAll() {
		
		List<ComercioEntity> listComercioEntity = comercioRepository.findAll();
		logger.info("Se consultaron todos los comercios");
		return new ResponseDTO(mapperComercio.listEntityToDto(listComercioEntity), true, "Consulta de comercio realizada con éxito", HttpStatus.OK);
	}


	@Override
	public ResponseDTO getCommerceById(Integer id) {
		
		Optional<ComercioEntity> comercioEntity = comercioRepository.findById(id);
		
		if (comercioEntity.isPresent()) {
			logger.info("Se consultó el comercio {}", id);
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity.get()), true, "Consulta de comercio realizada con éxito",  HttpStatus.OK);
		}
		else {
			logger.info("Error al consultar el comercio {}", id);
			return new ResponseDTO(null, false, "Comercio no encontrado", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO createCommerce(ComercioDTO comercioDTO) {
		
		try {
			
			logger.info("El comercio {} se creó", comercioDTO.getIdComercio());
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			
			return new ResponseDTO(mapperComercio.entityToDto(comercioRepository.save(comercioEntity)), true, "Comercio Creado correctamente", HttpStatus.OK);
			
		}catch (Exception e){
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, false, "Error al crear comercio", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO updateCommerce(ComercioDTO comercioDTO) {
		
		try {
			
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			logger.info("El comercio {} se actualizó", comercioDTO.getIdComercio());
			return new ResponseDTO(mapperComercio.entityToDto(comercioRepository.save(comercioEntity)), true , "Datos de comercio actualizados", HttpStatus.OK);
			
		}catch (Exception e) {
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, false, "Error al actualizar comercio", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO deleteCommerce(Integer id) {
		
		try {			
			
			
			comercioRepository.deleteById(id);
			logger.info("El comercio {} se eliminó", id);
			return new ResponseDTO(null, true, "Comercio eliminado", HttpStatus.OK);
			
		}catch (Exception e){
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, false, "Error al eliminar comercio", HttpStatus.OK);
		}
		
	}
}
