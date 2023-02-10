package com.certant.Consultorio.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.certant.Consultorio.entities.Turno;
import com.certant.Consultorio.helpers.Funciones;
import com.certant.Consultorio.helpers.ViewRouteHelper;
import com.certant.Consultorio.services.IEspecialistaService;
import com.certant.Consultorio.services.IPacienteService;
import com.certant.Consultorio.services.ITurnoService;

@Controller
@RequestMapping("/turno")
public class TurnoController {

	@Autowired
	@Qualifier("turnoService")
	private ITurnoService turnoService;
	
	@Autowired
	@Qualifier("pacienteService")
	private IPacienteService pacienteService;
	
	@Autowired
	@Qualifier("especialistaService")
	private IEspecialistaService especialistaService;
	
	@GetMapping("/")
	public String crear(Model model) {
		Turno turno = new Turno();
		model.addAttribute("titulo", "Formulario: Nuevo Turno");
		model.addAttribute("turno", turno);
		model.addAttribute("paciente", pacienteService.getAll());
		model.addAttribute("especialista", especialistaService.getAll());
		return ViewRouteHelper.TURNO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Turno turno,BindingResult result, Model model, RedirectAttributes attribute) {
		
		for (Turno t1 : turnoService.getAll()) {
			if((turno.getFecha().isEqual(t1.getFecha())&& turno.getHora().compareTo(t1.getHora())==0 && (turno.getEspecialista().getIdEspecialista()==t1.getEspecialista().getIdEspecialista()))) {
			FieldError error = new FieldError("turno", "hora", "Ya existe un turno asignado a esa hora");
			result.addError(error);
			}
		}
		
		for (Turno t2 : turnoService.getAll()) {
			if( (turno.getFecha().isEqual(t2.getFecha()) && turno.getHora().compareTo(t2.getHora())==0) && (turno.getPaciente().getIdPaciente()==t2.getPaciente().getIdPaciente()) ) {
				FieldError error = new FieldError("turno", "hora", "Ya tienes un turno ese dia y horario con otro especialista");
				result.addError(error);
			}
		}
		
		if(turno.getHora()==null) {
			FieldError error = new FieldError("turno", "hora", "Seleccione una hora por favor.");
			result.addError(error);
		}else {
		if(turno.getHora().isAfter(especialistaService.buscar(turno.getEspecialista().getIdEspecialista()).getHoraFin()) || turno.getHora().isBefore(especialistaService.buscar(turno.getEspecialista().getIdEspecialista()).getHoraInicio())) {
				FieldError error = new FieldError("turno", "hora", "el especialista no trabaja a esa hora");
				result.addError(error);
			}
		}
		
		if(turno.getFecha()==null) {
			FieldError error = new FieldError("turno", "fecha", "Seleccione una fecha por favor.");
			result.addError(error);
		}else {
			if(turno.getFecha().isBefore(LocalDate.now())) {
				FieldError error = new FieldError("turno", "fecha", "Debe seleccionar una fecha mayor al dia de hoy.");
				result.addError(error);
			}	
		}
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Turno");
			model.addAttribute("turno", turno);
			model.addAttribute("paciente", pacienteService.getAll());
			model.addAttribute("especialista", especialistaService.getAll());
			return ViewRouteHelper.TURNO_CREAR;
		}
		
		List<Turno> listaTurnos = turnoService.getAll();
		List<Turno> turnos = new ArrayList<Turno>();
		for (Turno t : listaTurnos) {
			if(t.isAsistencia()==false) {
				turnos.add(t);
			}
		}
		
		turno.setHoraFin(turno.getHora().plusMinutes(30));
		turno.setAsistencia(false);
		turnoService.save(turno);
		System.out.println("Turno guardado con exito!");
		attribute.addFlashAttribute("succes", "Turno agregado con exito");
		return ViewRouteHelper.TURNO_REDIRECT_LISTA;
	}
	
	@GetMapping("/lista")
	public String listarTurnos(Model model,@Param("palabraClave") String palabraClave) {
		List<Turno> listaTurnos = turnoService.getAll(palabraClave);
		List<Turno> turnos = new ArrayList<Turno>();
		for (Turno t : listaTurnos) {
			if(t.isAsistencia()==false) {
				turnos.add(t);
			}
		}
		model.addAttribute("titulo", "Lista de Turnos");
		model.addAttribute("lista", turnos);
		model.addAttribute("palabraClave", palabraClave);
		return ViewRouteHelper.TURNO_LISTA;
	}
	
	@GetMapping("lista/edit/{id}")
	public String eliminar(@PathVariable("id") long id,Model model) {
		Turno turno = turnoService.buscar(id);
		model.addAttribute("titulo", "Editar turno");
		model.addAttribute("turno", turno);
		model.addAttribute("paciente", pacienteService.getAll());
		model.addAttribute("especialista", especialistaService.getAll());
		return ViewRouteHelper.TURNO_CREAR;
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		turnoService.eliminar(id);
		System.out.println("eliminado con exito");
		attribute.addFlashAttribute("warning", "Turno eliminado con exito");
		return ViewRouteHelper.TURNO_REDIRECT_LISTA;		
	}
	
	
}
