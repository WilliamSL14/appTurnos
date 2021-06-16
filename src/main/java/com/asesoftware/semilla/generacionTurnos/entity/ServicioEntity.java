package com.asesoftware.semilla.generacionTurnos.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class ServicioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servicio")
	private Integer idServicio;
	
	@Column(name = "nom_servicio")
	private String nombreServicio;
	
	@Column(name = "hora_apertura")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaApertura;
	
	@Column(name = "hora_cierre")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaCierre;
	
	@Column(name = "duracion")
	@Temporal(TemporalType.TIME)
	private Date duracion;
	
	@Column(name = "id_comercio")
	private Integer idComercio;
	
	@OneToMany(mappedBy = "idServicio")
	private List<TurnoEntity> turnos;

}
