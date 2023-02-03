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

import com.certant.Consultorio.entities.Especialidad;
import com.certant.Consultorio.helpers.ViewRouteHelper;
import com.certant.Consultorio.services.IEspecialidadService;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {
	
	@Autowired
	@Qualifier("especialidadService")
	private IEspecialidadService especialidadService;
	
	@GetMapping("/")
	public String crear(Model model) {
		Especialidad especialidad = new Especialidad();
		model.addAttribute("titulo", "Nueva Especialidad");
		model.addAttribute("especialidad", especialidad);
		return ViewRouteHelper.ESPECIALIDAD_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Especialidad especialidad,BindingResult result,Model model,RedirectAttributes attribute) {
		especialidadService.save(especialidad);
		System.out.println("especialidad guardada con exito!");
		attribute.addFlashAttribute("success", "Especialidad agregada con exito");
		return ViewRouteHelper.ESPECIALIDAD_REDIRECT_LISTA;
	}
	
	@GetMapping("/lista")
	public String listarEspecialidades(Model model) {
		model.addAttribute("titulo", "Lista de Especialidades");
		model.addAttribute("lista", especialidadService.getAll());
		return ViewRouteHelper.ESPECIALIDAD_LISTA;
	}
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id,Model model) {
		Especialidad especialidad = especialidadService.buscar(id);
		model.addAttribute("titulo", "editar especialidad");
		model.addAttribute("especialidad", especialidad);
		return ViewRouteHelper.ESPECIALIDAD_CREAR;
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id")long id,RedirectAttributes attribute)
	{
		especialidadService.eliminar(id);
		System.out.println("eliminado con exito");
		attribute.addFlashAttribute("warning", "Especialidad eliminada con exito");
		return ViewRouteHelper.ESPECIALIDAD_REDIRECT_LISTA;
	}
}
