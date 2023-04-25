package com.martamarti.CrudPlantas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plantas")
public class Plantas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "plant_id")
	private int plant_id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "agua", nullable = false)
	private String agua;
	
	@Column(name = "luz", nullable = false)
	private String luz;
	
	@Column(name = "dificultad de cuidado")
	private int dificultad;

	@Column(name = "flor", nullable = false)
	private String flor;
	
	@Column(name = "petfriendly", nullable = false)
	private String petfriendly;
	
	@Column(name = "temperatura", nullable = false)
	private String temperatura;
	
	@Column(name = "fotos", nullable = false)
	private String fotos;
	

	public Plantas() {
	}

	public Plantas(int plant_id, String nombre, String agua, String luz, int dificultad, String flor, String petfriendly, String temperatura, String fotos) {
		this.plant_id = plant_id;
		this.nombre = nombre;
		this.agua = agua;
		this.luz = luz;
		this.dificultad = dificultad;
		this.flor = flor;
		this.petfriendly = petfriendly;
		this.temperatura = temperatura;
		this.fotos = fotos;
	}

	public int getPlant_id() {
		return plant_id;
	}

	public void setPlant_id(int plant_id) {
		this.plant_id = plant_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAgua() {
		return agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}

	public String getLuz() {
		return luz;
	}

	public void setLuz(String luz) {
		this.luz = luz;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public String getFlor() {
		return flor;
	}

	public void setFlor(String flor) {
		this.flor = flor;
	}

	public String getPetfriendly() {
		return petfriendly;
	}

	public void setPetfriendly(String petfriendly) {
		this.petfriendly = petfriendly;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}

	@Override
	public String toString() {
		return "Plantas [plant_id=" + plant_id + ", nombre=" + nombre + ", agua=" + agua + ", luz=" + luz
				+ ", dificultad=" + dificultad + ", flor=" + flor + ", petfriendly=" + petfriendly + ", temperatura="
				+ temperatura + ", fotos=" + fotos + "]";
	}

}
