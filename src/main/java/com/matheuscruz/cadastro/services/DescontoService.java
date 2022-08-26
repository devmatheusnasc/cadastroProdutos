package com.matheuscruz.cadastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.Cadastro;
import com.matheuscruz.cadastro.domain.Desconto;
import com.matheuscruz.cadastro.dto.CadastroDTO;
import com.matheuscruz.cadastro.repositories.DescontoRepository;

@Service
public class DescontoService {
	
	@Autowired
	private DescontoRepository descontoRepository;
	
	public List<Desconto> findAll() {
		return descontoRepository.findAll();
	}
	
	public Cadastro fromDTO(CadastroDTO objDto) {
		return new  Cadastro(objDto.getId(), objDto.getDescription(),objDto.getValue(),objDto.getType());
	}

}
