package com.asesoftware.semilla.generacionTurnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.semilla.generacionTurnos.entity.ComercioEntity;

public interface IComercioRepository extends JpaRepository<ComercioEntity, Integer>{

}
