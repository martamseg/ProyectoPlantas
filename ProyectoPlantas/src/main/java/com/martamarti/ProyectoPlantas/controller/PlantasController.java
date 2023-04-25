package com.martamarti.ProyectoPlantas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martamarti.ProyectoPlantas.model.Plantas;
import com.martamarti.ProyectoPlantas.repository.PlantasRepositorio;
	

	@CrossOrigin
	@RestController
	@RequestMapping("/api")
	public class PlantasController {
		
		@Autowired
		PlantasRepositorio plantasRepositorio;
		
		@GetMapping("/plantas")
		public ResponseEntity<List<Plantas>> getAll () {
			try {
				List<Plantas>plantas=plantasRepositorio.findAll();
				
				if (plantas.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(plantas, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/plantas/{plant_id}")
		public ResponseEntity<Plantas> getById(@PathVariable("plant_id") int plant_id) {
			Optional<Plantas> plantas = plantasRepositorio.findById(plant_id);

			if (plantas.isPresent()) {
				return new ResponseEntity<>(plantas.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		@PostMapping("/plantas")
		
		public ResponseEntity<Plantas> create(@RequestBody Plantas plantas) {
			try {
				Plantas newPlantas = new Plantas(0, plantas.getNombre(),plantas.getAgua(),plantas.getLuz(),plantas.getFamilia(),plantas.getColor(),plantas.getDificultad(),plantas.getFlor(),plantas.getPetfriendly(), plantas.getTemperatura(),plantas.getFotos());
				newPlantas = plantasRepositorio.save(newPlantas);
				return new ResponseEntity<>(newPlantas, HttpStatus.OK);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		@PutMapping("plantas/{plant_id}")
		public ResponseEntity<Plantas> update(@PathVariable("plant_id") int plant_id, @RequestBody Plantas plantas) {
			try {
				Optional<Plantas> newPlantas = plantasRepositorio.findById(plant_id);
				if (newPlantas.isPresent()) {
					Plantas updPlantas = newPlantas.get();
					updPlantas.setNombre(plantas.getNombre());
					updPlantas.setAgua(plantas.getAgua());
					updPlantas.setLuz(plantas.getLuz());
					updPlantas.setFamilia(plantas.getFamilia());
					updPlantas.setColor(plantas.getColor());
					updPlantas.setDificultad(plantas.getDificultad());
					updPlantas.setFlor(plantas.getFlor());
					updPlantas.setPetfriendly(plantas.getPetfriendly());
					updPlantas.setTemperatura(plantas.getTemperatura());
					updPlantas.setFotos(plantas.getFotos());
					updPlantas = plantasRepositorio.save(updPlantas);
					
					return new ResponseEntity<>(updPlantas, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@DeleteMapping("/plantas/{plant_id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("plant_id") int plant_id){
			try {
				plantasRepositorio.deleteById(plant_id);
				return ResponseEntity.ok(null);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}	
		}
		
		@GetMapping("/Plantas/search/{keyword}")
		public ResponseEntity<List<Plantas>> search(@PathVariable String keyword) {
			System.out.println(keyword);
			try {
				List<Plantas> plantas = new ArrayList<Plantas>();

				if (keyword == null) {
					plantasRepositorio.findAll().forEach(plantas::add);
				} else {
					System.out.println("busqueda");
					plantasRepositorio.findByNombreContainingIgnoreCase(keyword).forEach(plantas::add);
					plantasRepositorio.findByAguaContainingIgnoreCase(keyword).forEach(plantas::add);
					plantasRepositorio.findByLuzContainingIgnoreCase(keyword).forEach(plantas::add);
					plantasRepositorio.findByFlorContainingIgnoreCase(keyword).forEach(plantas::add);
					plantasRepositorio.findByPetfriendlyContainingIgnoreCase(keyword).forEach(plantas::add);
				}

				if (plantas.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(plantas, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}


		}

}
