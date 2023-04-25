package com.martamarti.ProyectoPlantas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="plantas")

public class Plantas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plant_id")
	private int plant_id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "agua")
	private String agua;
	
	@Column(name = "luz")
	private String luz;
	
	@Column(name = "familia")
	private String familia;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "dificultad de cuidado")
	private int dificultad;
	
	@Column(name = "flor")
	private String flor;
	
	@Column(name = "petfriendly")
	private String petfriendly;
	
	@Column(name = "temperatura")
	private String temperatura;
	
	@Column(name = "fotos")
	private String fotos;

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

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
		return "Plantas [plant_id=" + plant_id + ", nombre=" + nombre + ", agua=" + agua + ", luz=" + luz + ", familia="
				+ familia + ", color=" + color + ", dificultad=" + dificultad + ", flor=" + flor + ", petfriendly="
				+ petfriendly + ", temperatura=" + temperatura + ", fotos=" + fotos + "]";
	}

	public Plantas(int plant_id, String nombre, String agua, String luz, String familia, String color, int dificultad,
			String flor, String petfriendly, String temperatura, String fotos) {
		super();
		this.plant_id = plant_id;
		this.nombre = nombre;
		this.agua = agua;
		this.luz = luz;
		this.familia = familia;
		this.color = color;
		this.dificultad = dificultad;
		this.flor = flor;
		this.petfriendly = petfriendly;
		this.temperatura = temperatura;
		this.fotos = fotos;
	}

	public Plantas() {
		
	}
	
	

}
