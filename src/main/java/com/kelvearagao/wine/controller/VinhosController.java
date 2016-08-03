package com.kelvearagao.wine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kelvearagao.wine.model.Vinho;
import com.kelvearagao.wine.repository.Vinhos;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;
	
	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("/vinho/ListagemVinhos");
		List<Vinho> todosVinhos = vinhos.findAll();
		
		return mv.addObject("vinhos", todosVinhos);
	}
	
	@RequestMapping("/novo")
	public String pesquisa() {
		return "/produto/PesquisaProdutos";
	}
	
}
