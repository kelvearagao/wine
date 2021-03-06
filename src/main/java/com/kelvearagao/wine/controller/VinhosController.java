package com.kelvearagao.wine.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kelvearagao.wine.model.TipoVinho;
import com.kelvearagao.wine.model.Vinho;
import com.kelvearagao.wine.repository.Vinhos;
import com.kelvearagao.wine.service.CadastroVinhoService;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;
	
	@Autowired
	private CadastroVinhoService cadastroVinhoService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/vinho/ListagemVinhos");
		List<Vinho> todosVinhos = vinhos.findAll();
		
		return mv.addObject("vinhos", todosVinhos);
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("/vinho/CadastroVinho");
		
		mv.addObject("tipos", TipoVinho.values());
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result, RedirectAttributes attributes)
	{
		if (result.hasErrors()) {
			return novo(vinho);
		}
		
		cadastroVinhoService.salvar(vinho);
		attributes.addFlashAttribute("message", "Vinho salvo com sucesso!");
		
		return new ModelAndView("redirect:/vinhos/novo");
	}
	
}
