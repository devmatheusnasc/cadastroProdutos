package com.matheuscruz.cadastro.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscruz.cadastro.domain.Pedidos;
import com.matheuscruz.cadastro.repositories.PedidosRepository;

@Service
public class PedidosService {
	
	@Autowired
	private PedidosRepository pedidosRepository;
	
	public Pedidos buscar(UUID id) {
		Optional<Pedidos> obj = pedidosRepository.findById(id);
		if(obj == null) {
			
		}
		return obj.orElse(null);
		
		
		
	}
	

}
