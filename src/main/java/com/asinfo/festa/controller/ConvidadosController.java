package com.asinfo.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asinfo.festa.model.Convidado;
import com.asinfo.festa.model.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados; 

	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView model = new ModelAndView("ListaConvidados");
		model.addObject("convidados", convidados.findAll());
		model.addObject(new Convidado());
		return model;
	}
	
	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
}
