package com.martamarti.CrudPlantas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martamarti.CrudPlantas.model.Plantas;

public interface PlantasRepositorio extends JpaRepository<Plantas, Integer>{
	Iterable<Plantas> findByNombreContainingIgnoreCase(String keyword);
	Iterable<Plantas> findByAguaContainingIgnoreCase(String keyword);
	Iterable<Plantas> findByLuzContainingIgnoreCase(String keyword);
	Iterable<Plantas> findByPetfriendlyContainingIgnoreCase(String keyword);
	Iterable<Plantas> findByFlorContainingIgnoreCase(String keyword);
	

}