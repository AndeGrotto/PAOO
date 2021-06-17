package model;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Localizacao
 *
 */
@Entity

public class Localizacao implements Serializable {

	   
	@Id
	private Long id;
	private Date dataHora;
	private Float lat;
	private Float lon;
	@ManyToOne
	private Ronda ronda;
	
	
	private static final long serialVersionUID = 1L;
	
	public Localizacao() {
		super();
	}   

	public Localizacao(Long id, Date dataHora, Float lat, Float lon, Ronda ronda) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.lat = lat;
		this.lon = lon;
		this.ronda = ronda;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}   
	public Float getLat() {
		return this.lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}   
	public Float getLon() {
		return this.lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}
	public Ronda getRonda() {
		return this.ronda;
	}
	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}

}
