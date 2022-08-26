package com.matheuscruz.cadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.ItemsPedidos;
import com.matheuscruz.cadastro.dto.ItensPedidosDTO;
import com.matheuscruz.cadastro.repositories.ItemsPedidosRepository;
import com.matheuscruz.cadastro.services.exceptions.DataIntegrityException;
import com.matheuscruz.cadastro.services.exceptions.ObjectNotFoundException;

@Service
public class ItemsPedidosService {
	
	@Autowired
	private ItemsPedidosRepository itemsPedidosRepository;
	
	public ItemsPedidos find(UUID id) {
		Optional<ItemsPedidos> obj = itemsPedidosRepository.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! " + "Tipo: " + ItemsPedidos.class.getName());
		}
		
		return obj.orElse(null);
	}
	
	public ItemsPedidos insert(ItemsPedidos obj) {
		obj.setId(null);
		return itemsPedidosRepository.save(obj);
	}
	
	public ItemsPedidos update(ItemsPedidos obj ) {
		find(obj.getId());
		return itemsPedidosRepository.save(obj);
	}
	
	public void delete(UUID id) {
		
		find(id);
		
		try {
			itemsPedidosRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possível excluir !!");
		}
	}
	
	public List<ItemsPedidos> findAll() {
		return itemsPedidosRepository.findAll();
	}
	
	public ItemsPedidos fromDTO(ItensPedidosDTO objDto) {
		return new  ItemsPedidos(objDto.getId(), objDto.getOrder(), objDto.getItemId(), objDto.getQuantity(), objDto.getTotalValue());
	}
	

}
