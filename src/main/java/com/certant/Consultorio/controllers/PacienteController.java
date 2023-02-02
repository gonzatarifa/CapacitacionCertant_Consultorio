package com.certant.Consultorio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.certant.Consultorio.entities.Paciente;
import com.certant.Consultorio.entities.Perfiles;
import com.certant.Consultorio.helpers.ViewRouteHelper;
import com.certant.Consultorio.services.IPacienteService;


@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	@Qualifier("pacienteService")
	private IPacienteService pacienteService;
	
	@GetMapping("/")
	public String crear(Model model) {
		Paciente paciente = new Paciente();
		model.addAttribute("titulo", "Nuevo Paciente");
		model.addAttribute("paciente", paciente);
		return ViewRouteHelper.PACIENTE_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Paciente paciente,BindingResult result,Model model,RedirectAttributes attribute) {
		pacienteService.save(paciente);
		System.out.println("paciente guardado con exito!");
		attribute.addFlashAttribute("success", "Paciente agregado con exito");
		return ViewRouteHelper.PACIENTE_REDIRECT_LISTA;
	}
	
	@GetMapping("/lista")
	public String listarPacientes(Model model) {
		model.addAttribute("titulo", "Lista de Pacientes");
		model.addAttribute("lista", pacienteService.getAll());
		return ViewRouteHelper.PACIENTE_LISTA;
	}
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id, Model model) {
		Paciente paciente = pacienteService.buscar(id);
		model.addAttribute("titulo", "Editar paciente");
		model.addAttribute("paciente", paciente);
		return ViewRouteHelper.PACIENTE_CREAR;
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		pacienteService.eliminar(id);
		System.out.println("eliminado con exito");
		attribute.addFlashAttribute("warning", "Paciente eliminado con exito");
		return ViewRouteHelper.PACIENTE_REDIRECT_LISTA;
	}
	

}
