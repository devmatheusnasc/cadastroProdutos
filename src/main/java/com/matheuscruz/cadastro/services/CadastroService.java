package com.matheuscruz.cadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.Cadastro;
import com.matheuscruz.cadastro.dto.CadastroDTO;
import com.matheuscruz.cadastro.repositories.CadastroRepository;
import com.matheuscruz.cadastro.services.exceptions.DataIntegrityException;
import com.matheuscruz.cadastro.services.exceptions.ObjectNotFoundException;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	public Cadastro find(UUID id) {
		Optional<Cadastro> obj = cadastroRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! " + "Tipo: " + Cadastro.class.getName());
		}
		
		return obj.orElse(null);
	}
	public Cadastro insert(Cadastro obj) {
		obj.setId(null);
		return cadastroRepository.save(obj);
	}
	
	public Cadastro update(Cadastro obj ) {
		find(obj.getId());
		return cadastroRepository.save(obj);
	}
	
	public void delete(UUID id) {
		
		find(id);
		
		try {
			cadastroRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possível excluir !!");
		}
	}
	
	public List<Cadastro> findAll() {
		return cadastroRepository.findAll();
	}
	
	public Cadastro fromDTO(CadastroDTO objDto) {
		return new  Cadastro(objDto.getId(), objDto.getDescription(),objDto.getValue(),objDto.getType());
	}

}
