package com.asesoftware.semilla.generacionTurnos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.semilla.generacionTurnos.dto.ServicioDTO;
import com.asesoftware.semilla.generacionTurnos.entity.ServicioEntity;

@Mapper(componentModel = "spring")
public interface IServicioMapper {

	public ServicioDTO entityToDto(ServicioEntity servicioEntity);
	
	public ServicioEntity dtoToEntity(ServicioDTO servicioDTO);
	
	public List<ServicioDTO> listEntityToDto(List<ServicioEntity> servicioEntity);
	
	public List<ServicioEntity> listDtoToEntity(List<ServicioDTO> servicioDTO);
	
}
