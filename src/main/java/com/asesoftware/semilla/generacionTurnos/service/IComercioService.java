package com.asesoftware.semilla.generacionTurnos.service;

import java.util.List;

import com.asesoftware.semilla.generacionTurnos.dto.ComercioDTO;
import com.asesoftware.semilla.generacionTurnos.dto.ResponseDTO;
import com.asesoftware.semilla.generacionTurnos.entity.ComercioEntity;

public interface IComercioService {
	
	public ResponseDTO getAll();
	
	public ResponseDTO getCommerceById(Integer id);
	
	public ResponseDTO createCommerce(ComercioDTO comercioDTO);
	
	public ResponseDTO updateCommerce(ComercioDTO comercioDTO);
	
	public ResponseDTO deleteCommerce(Integer id);
	

}
