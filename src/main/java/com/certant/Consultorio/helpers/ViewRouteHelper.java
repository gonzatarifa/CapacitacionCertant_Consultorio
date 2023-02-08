package com.certant.Consultorio.helpers;

public class ViewRouteHelper {

	// Vista de la pagina principal
	public final static String INDEX = "home/index";

	// Redirects
	public final static String ROUTE_INDEX = "/index";
	public final static String ROUTE_REDIRECT = "redirect:/usuarios/lista";
	public final static String USUARIO_REDIRECT = "redirect:/usuarios/";
	public final static String PERFIL_REDIRECT = "redirect:/perfiles/";
	public final static String PERFIL_REDIRECT_LISTA = "redirect:/perfiles/lista";
	public final static String USUARIO_REDIRECT_LISTA = "redirect:/usuarios/lista/";
	public final static String USUARIO_ROOT = "/usuarios/";
	public final static String ROUTE = "/index";

	public final static String USUARIO_LISTA = "usuario/lista";
	public final static String USUARIO_FORM = "usuario/form";
	public final static String USUARIO_INDEX = "usuario/index";
	public final static String PERFIL_LISTA = "perfil/lista";
	public final static String PERFIL_CREAR = "perfil/crear";	
	
	public final static String PACIENTE_LISTA = "paciente/lista";
	public final static String PACIENTE_CREAR = "paciente/crear";	
	public final static String PACIENTE_REDIRECT_LISTA = "redirect:/paciente/lista";	
	
	public final static String ESPECIALIDAD_LISTA = "especialidad/lista";
	public final static String ESPECIALIDAD_CREAR = "especialidad/crear";
	public final static String ESPECIALIDAD_REDIRECT_LISTA = "redirect:/especialidad/lista";
	
	public final static String ESPECIALISTA_LISTA = "especialista/lista";
	public final static String ESPECIALISTA_CREAR = "especialista/crear";
	public final static String ESPECIALISTA_REDIRECT_LISTA = "redirect:/especialista/lista";
	
	public final static String TURNO_LISTA = "turno/lista";
	public final static String TURNO_CREAR = "turno/crear";
	public final static String TURNO_REDIRECT_LISTA = "redirect:/turno/lista";
}