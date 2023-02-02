package com.certant.Consultorio.controllers;

import java.util.List;

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

import com.certant.Consultorio.entities.Departamento;
import com.certant.Consultorio.helpers.ViewRouteHelper;
import com.certant.Consultorio.services.IDepartamentoService;


@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	@Qualifier("departamentoService")
	private IDepartamentoService departamentoService;
	
	@GetMapping("/")
	public String crear(Model model) {
		Departamento departamento = new Departamento();
		model.addAttribute("titulo", "Formulario: Nuevo Departamento");
		model.addAttribute("departamento", departamento);

		return ViewRouteHelper.DEPARTAMENTO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Departamento departamento,BindingResult result,Model model,RedirectAttributes attribute) {
		if(validaRepetidos(departamento)) {
			System.out.println("Ya existe un departamento con esas caracteristicas.");
			attribute.addFlashAttribute("error","Ya existe un departamento con esas caracteristicas.");
			return ViewRouteHelper.DEPARTAMENTO_REDIRECT_LISTA;
		}
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Departamento");
			model.addAttribute("departamento", departamento);
			System.out.println("Se encontraron Errores en el formulario!");
			return ViewRouteHelper.DEPARTAMENTO_CREAR;
			}
		departamentoService.save(departamento);
		System.out.println("Departamento guardado con exito!");
		attribute.addFlashAttribute("success","Departamento agregado con exito");
		return ViewRouteHelper.DEPARTAMENTO_REDIRECT_LISTA;	
	}
	
	@GetMapping("/lista")
	public String listarDepartamentos(Model model) {
		List<Departamento> listado = departamentoService.getAll();
	    model.addAttribute("titulo", "Lista de Departamentos");
		model.addAttribute("lista", listado);
		return ViewRouteHelper.DEPARTAMENTO_LISTA;
	}
	
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id, Model model) {
		Departamento departamento = departamentoService.buscar(id); 
		model.addAttribute("titulo", "Editar departamento");
		model.addAttribute("departamento", departamento);
		return ViewRouteHelper.DEPARTAMENTO_CREAR;
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		departamentoService.eliminar(id);
		System.out.println("Departamento eliminado con exito");
		System.out.println("Perfil eliminado con exito");
		attribute.addFlashAttribute("warning","Departamento eliminado con exito");
		return ViewRouteHelper.DEPARTAMENTO_REDIRECT_LISTA;
	}
	
	public boolean validaRepetidos(Departamento departamento) {
		boolean repetido = false;
		List<Departamento> listado = departamentoService.getAll();
		for (Departamento d : listado) {
			if(departamento.equals(d)) {
				repetido = true;
			}
		}
		return repetido;
	}
	
}
