package com.matheuscruz.cadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.Pedidos;
import com.matheuscruz.cadastro.dto.PedidosDTO;
import com.matheuscruz.cadastro.repositories.PedidosRepository;
import com.matheuscruz.cadastro.services.exceptions.DataIntegrityException;
import com.matheuscruz.cadastro.services.exceptions.ObjectNotFoundException;

@Service
public class PedidosService {
	
	@Autowired
	private PedidosRepository pedidosRepository;
	
	public Pedidos find(UUID id) {
		Optional<Pedidos> obj = pedidosRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! " + "Tipo: " + Pedidos.class.getName());
		}
		
		return obj.orElse(null);
	}
	
	public Pedidos insert(Pedidos obj) {
		obj.setId(null);
		return pedidosRepository.save(obj);
	}
	
	public Pedidos update(Pedidos obj ) {
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
	
	public List<Pedidos> findAll() {
		return pedidosRepository.findAll();
	}
	
	public Pedidos fromDTO(PedidosDTO objDto) {
		return new  Pedidos(objDto.getId(), objDto.getNumber(), objDto.getDate(), objDto.getPercentualDiscount(), objDto.getTotalValue());
	
	}
	

}
