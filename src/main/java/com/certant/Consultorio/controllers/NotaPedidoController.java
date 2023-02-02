package com.certant.Consultorio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certant.Consultorio.entities.NotaPedido;
import com.certant.Consultorio.helpers.ViewRouteHelper;
import com.certant.Consultorio.services.INotaPedidoService;

@Controller
@RequestMapping("/nota-pedido")
public class NotaPedidoController {

	@Autowired
	private INotaPedidoService notaPedidoServices;

	@GetMapping("/manage")
	public String create(Model model) {

		return ViewRouteHelper.NOTA_PEDIDO_ADMINISTRAR;
	}

	@GetMapping("")
	public String index(Model model) {

		List<NotaPedido> notas = notaPedidoServices.getAll();

		model.addAttribute("notas", notas);

		return ViewRouteHelper.NOTA_PEDIDO_LISTA;
	}

}
