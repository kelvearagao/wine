package com.kelvearagao.wine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvearagao.wine.model.Vinho;
import com.kelvearagao.wine.repository.Vinhos;

@Service
public class CadastroVinhoService {
	
	@Autowired
	private Vinhos vinhos;
	
	public void salvar(Vinho vinho) {
		this.vinhos.save(vinho);
	}
	
}
