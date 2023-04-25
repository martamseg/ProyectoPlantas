package com.martamarti.ProyectoPlantas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martamarti.ProyectoPlantas.model.Plantas;


public interface PlantasRepositorio extends JpaRepository<Plantas, Integer>{
	List <Plantas> findByNombreContainingIgnoreCase(String nombre);
	List <Plantas> findByAguaContainingIgnoreCase(String agua);
	List <Plantas> findByLuzContainingIgnoreCase(String luz);
	List <Plantas> findByFlorContainingIgnoreCase(String flor);
	List <Plantas> findByPetfriendlyContainingIgnoreCase(String petfriendly);

}