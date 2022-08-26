package com.matheuscruz.cadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.ItensPedidos;
import com.matheuscruz.cadastro.dto.ItensPedidosDTO;
import com.matheuscruz.cadastro.repositories.ItensPedidosRepository;
import com.matheuscruz.cadastro.services.exceptions.DataIntegrityException;
import com.matheuscruz.cadastro.services.exceptions.ObjectNotFoundException;

@Service
public class ItensPedidosService {
	
	@Autowired
	private ItensPedidosRepository pedidosRepository;
	
	public ItensPedidos find(UUID id) {
		Optional<ItensPedidos> obj = pedidosRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! " + "Tipo: " + ItensPedidos.class.getName());
		}
		
		return obj.orElse(null);
	}
	
	public ItensPedidos insert(ItensPedidos obj) {
		obj.setId(null);
		return pedidosRepository.save(obj);
	}
	
	public ItensPedidos update(ItensPedidos obj ) {
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
	
	public List<ItensPedidos> findAll() {
		return pedidosRepository.findAll();
	}
	
	public ItensPedidos fromDTO(ItensPedidosDTO objDto) {
		return new  ItensPedidos(objDto.getId(), objDto.getOrder(), objDto.getItemId(), objDto.getQuantity(), objDto.getTotalValue());
	}
	

}
