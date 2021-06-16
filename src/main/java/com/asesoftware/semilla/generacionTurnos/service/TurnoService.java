package com.asesoftware.semilla.generacionTurnos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.dto.TurnoDTO;
import com.asesoftware.semilla.generacionTurnos.entity.TurnoEntity;
import com.asesoftware.semilla.generacionTurnos.mapper.ITurnoMapper;
import com.asesoftware.semilla.generacionTurnos.repository.ITurnoRepository;

@Service
public class TurnoService implements ITurnoService{
	
	private static final Logger logger = LoggerFactory.getLogger(TurnoService.class);
			
	@Autowired
	private ITurnoRepository turnoRepository;
	
	@Autowired
	private ITurnoMapper mapperTurno;
	
	@Override
	public ResponseDTO getAll() {
		
		try {
			
			List<TurnoEntity> listTurnoEntity = turnoRepository.findAll();
			logger.info("Se consultaron todos los turnos");
			return new ResponseDTO(mapperTurno.listEntityToDto(listTurnoEntity), true, "Consulta por realizada con éxito", HttpStatus.OK);
		
		}catch (Exception e) {
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, true, "Error en la consulta", HttpStatus.OK);
		}
		
		
	}

	@Override
	public ResponseDTO consultarTodosServicio(String nombreServicio) {
		// TODO Auto-generated method stub
		
		try {
			
			List<TurnoDTO> listTurnoDtos = mapperTurno.listEntityToDto(turnoRepository.queryServicio(nombreServicio));
			logger.info("Se consultaón los turnos del servicio {}", nombreServicio);
			return new ResponseDTO(listTurnoDtos, true, "Consulta por servicios realizada con éxito", HttpStatus.OK);
			
		}catch (Exception e) {
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, true, "Error en la consulta", HttpStatus.OK);
		}			
	}

	@Override
	public ResponseDTO consultarTodosComercio(String nombreComercio) {
		// TODO Auto-generated method stub
		
		try {
			
			List<TurnoDTO> listTurnoDto = mapperTurno.listEntityToDto(turnoRepository.queryComercio(nombreComercio));
			logger.info("Se consultaón los turnos del comercio {}", nombreComercio);
			return new ResponseDTO(listTurnoDto, true, "Consulta por comercios realizada con éxito", HttpStatus.OK);
			
		}catch (Exception e) {
			
			logger.info("Error {}", e.getMessage());
			return new ResponseDTO(null, true, "Error en la consulta", HttpStatus.OK);
		}
		
	}

}
