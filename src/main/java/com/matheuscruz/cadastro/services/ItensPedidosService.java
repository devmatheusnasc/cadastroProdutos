package com.matheuscruz.cadastro.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.ItensPedidos;
import com.matheuscruz.cadastro.repositories.ItensPedidosRepository;
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
	

}
