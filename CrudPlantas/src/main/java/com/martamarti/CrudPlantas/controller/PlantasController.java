package com.martamarti.CrudPlantas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.martamarti.CrudPlantas.model.Plantas;
import com.martamarti.CrudPlantas.repository.PlantasRepositorio;

@Controller
public class PlantasController {
	@Autowired
	private PlantasRepositorio plantasRepositorio;

	@GetMapping("/plantas")
	public String getAll(Model model, @Param("keyword") String keyword) {

		try {
			List<Plantas> plantas = new ArrayList<Plantas>();

			if (keyword == null) {
				plantasRepositorio.findAll().forEach(plantas::add);
			} else {
				plantasRepositorio.findByNombreContainingIgnoreCase(keyword).forEach(plantas::add);
				model.addAttribute("keyword", keyword);
				plantasRepositorio.findByAguaContainingIgnoreCase(keyword).forEach(plantas::add);
				model.addAttribute("keyword", keyword);
				plantasRepositorio.findByLuzContainingIgnoreCase(keyword).forEach(plantas::add);
				model.addAttribute("keyword", keyword);
				plantasRepositorio.findByPetfriendlyContainingIgnoreCase(keyword).forEach(plantas::add);
				model.addAttribute("keyword", keyword);
				plantasRepositorio.findByFlorContainingIgnoreCase(keyword).forEach(plantas::add);
				model.addAttribute("keyword", keyword);
			}
			model.addAttribute("plantas", plantas);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "plantas";
	}

	@GetMapping("/plantas/new")
	public String add(Model model) {
		Plantas plantas = new Plantas();
		model.addAttribute("plantas", plantas);
		model.addAttribute("pageTitle", "Crear planta");

		return "plantas_form";
	}

	@PostMapping("/plantas/save")
	public String save(Plantas plantas, RedirectAttributes redirectAttributes) {
		try {
			plantasRepositorio.save(plantas);
			redirectAttributes.addFlashAttribute("message", "Planta guardada");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/plantas";
	}

	@GetMapping("/plantas/{plant_id}")
	public String editTutorial(@PathVariable("plant_id") Integer plant_id, Model model,
			RedirectAttributes redirectAttributes) {
		try {
			Plantas plantas = plantasRepositorio.findById(plant_id).get();

			model.addAttribute("plantas", plantas);
			model.addAttribute("pageTitle", "Editar Plantas (ID: " + plant_id + ")");

			return "plantas_form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "plantas_form";
	}

	@GetMapping("/plantas/delete/{plant_id}")
	public String delete(@PathVariable("plant_id") Integer plant_id, Model model,
			RedirectAttributes redirectAttributes) {

		try {
			plantasRepositorio.deleteById(plant_id);

			redirectAttributes.addFlashAttribute("message", "Plantas con id=" + plant_id + " eliminado");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/plantas";
	}

}