package com.asesoftware.semilla.generacionTurnos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.semilla.generacionTurnos.dto.ComercioDTO;
import com.asesoftware.semilla.generacionTurnos.entity.ComercioEntity;

@Mapper(componentModel = "spring")
public interface IComercioMapper {
	
	public ComercioDTO entityToDto(ComercioEntity comercioEntity);
	
	public ComercioEntity dtoToEntity(ComercioDTO comercioDTO);
	
	public List<ComercioDTO> listEntityToDto(List<ComercioEntity> comercioEntity);
	
	public List<ComercioEntity> listDtoToEntity(List<ComercioDTO> comercioDTO);
	
}
