package com.matheuscruz.cadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.Cadastro;
import com.matheuscruz.cadastro.repositories.CadastroRepository;
import com.matheuscruz.cadastro.services.exceptions.DataIntegrityException;
import com.matheuscruz.cadastro.services.exceptions.ObjectNotFoundException;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository pedidosRepository;
	
	public Cadastro find(UUID id) {
		Optional<Cadastro> obj = pedidosRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! " + "Tipo: " + Cadastro.class.getName());
		}
		
		return obj.orElse(null);
	}
	public Cadastro insert(Cadastro obj) {
		obj.setId(null);
		return pedidosRepository.save(obj);
	}
	
	public Cadastro update(Cadastro obj ) {
		find(obj.getId());
		return pedidosRepository.save(obj);
	}
	
	public void delete(UUID id) {
		
		find(id);
		
		try {
		pedidosRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possível excluir !!");
		}
	}
	
	public List<Cadastro> findAll() {
		return pedidosRepository.findAll();
	}

}
