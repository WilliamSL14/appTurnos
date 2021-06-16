package com.asesoftware.semilla.generacionTurnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.semilla.generacionTurnos.entity.TurnoEntity;

public interface ITurnoRepository extends JpaRepository<TurnoEntity, Integer>{

	@Query("SELECT t FROM TurnoEntity t, ServicioEntity u WHERE t.idServicio = u.idServicio AND u.nombreServicio like %?1%")
	List<TurnoEntity> queryServicio(String nombreServicio);
	
	@Query("SELECT t FROM TurnoEntity t, ServicioEntity u, ComercioEntity w WHERE t.idServicio = u.idServicio AND u.idComercio = w.idComercio AND w.nombreComercio like %?1%")
	List<TurnoEntity> queryComercio(String nombreComercio);
	
}
