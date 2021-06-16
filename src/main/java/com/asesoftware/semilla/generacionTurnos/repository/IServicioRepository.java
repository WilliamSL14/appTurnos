package com.asesoftware.semilla.generacionTurnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.semilla.generacionTurnos.entity.ServicioEntity;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer>{

}
