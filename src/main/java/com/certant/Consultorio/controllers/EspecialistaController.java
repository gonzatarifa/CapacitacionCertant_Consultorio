package com.certant.Consultorio.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.certant.Consultorio.entities.Especialidad;
import com.certant.Consultorio.entities.Especialista;
import com.certant.Consultorio.helpers.ViewRouteHelper;
import com.certant.Consultorio.services.IEspecialidadService;
import com.certant.Consultorio.services.IEspecialistaService;

@Controller
@RequestMapping("/especialista")
public class EspecialistaController {
	
	@Autowired
	@Qualifier("especialistaService")
	private IEspecialistaService especialistaService;
	
	@Autowired
	@Qualifier("especialidadService")
	private IEspecialidadService especialidadService;
	
	@GetMapping("/")
	public String crear(Model model) {
		Especialista especialista = new Especialista();
		model.addAttribute("titulo", "Formulario: Nuevo Especialista");
		model.addAttribute("especialista", especialista);
		model.addAttribute("especialidad", especialidadService.getAll());
		return ViewRouteHelper.ESPECIALISTA_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Especialista especialista,BindingResult result, Model model, RedirectAttributes attribute) {
		List<Especialidad> listaEspecialidad = especialidadService.getAll();
		List<Especialidad> especialidad = new ArrayList<Especialidad>();
		for (Especialidad es : listaEspecialidad) {
			especialidad.add(es);
		}
		
		if(especialistaService.getByDni(especialista.getDni())!=null && especialistaService.getByDni(especialista.getDni()).getIdEspecialista()!=especialista.getIdEspecialista()) {
			FieldError error = new FieldError("especialista", "dni", "Ya existe un especialista con ese dni");
			result.addError(error);
		}
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Especialista");
			model.addAttribute("especialista", especialista);
			model.addAttribute("especialidad", especialidadService.getAll());
			System.out.println("Se encontraron Errores en el formulario!");
			return ViewRouteHelper.ESPECIALISTA_CREAR;
			}
		
		especialistaService.save(especialista);
		System.out.println("Especialista guardado con exito!");
		attribute.addFlashAttribute("success", "Especialista agregado con exito");
		return ViewRouteHelper.ESPECIALISTA_REDIRECT_LISTA;
	}
	
	@GetMapping("/lista")
	public String listarEspecialistas(Model model) {
		model.addAttribute("titulo", "Lista de Especialistas");
		model.addAttribute("lista", especialistaService.getAll());
		return ViewRouteHelper.ESPECIALISTA_LISTA;
	}
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id,Model model) {	
		Especialista especialista = especialistaService.buscar(id);
		model.addAttribute("titulo", "Editar especialista");
		model.addAttribute("especialista", especialista);
		model.addAttribute("especialidad", especialidadService.getAll());
		return ViewRouteHelper.ESPECIALISTA_CREAR;
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id")long id,RedirectAttributes attribute) {
		especialistaService.eliminar(id);
		System.out.println("eliminado con exito");
		attribute.addFlashAttribute("warning", "Especialista eliminado con exito");
		return ViewRouteHelper.ESPECIALISTA_REDIRECT_LISTA;
	}
	
}
