package com.matheuscruz.cadastro.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.Pedidos;
import com.matheuscruz.cadastro.repositories.PedidosRepository;
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
	

}
