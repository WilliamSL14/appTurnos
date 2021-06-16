package com.asesoftware.semilla.generacionTurnos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.semilla.generacionTurnos.dto.TurnoDTO;
import com.asesoftware.semilla.generacionTurnos.entity.TurnoEntity;

@Mapper(componentModel = "spring")
public interface ITurnoMapper {
	
	public TurnoDTO entityToDto(TurnoEntity turnoEntity);
	public TurnoEntity dtoToEntity(TurnoDTO turnoDto);
	public List<TurnoDTO> listEntityToDto(List<TurnoEntity> listTurnoEntity);
	public List<TurnoEntity> listDtoToEntity(List<TurnoDTO> listTurnoDto);

}
