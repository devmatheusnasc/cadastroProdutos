package com.matheuscruz.cadastro.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheuscruz.cadastro.domain.Pedidos;
import com.matheuscruz.cadastro.services.PedidosService;

@RestController
@RequestMapping(value = "/api/orders/")
public class PedidosResource {

	@Autowired
	private PedidosService pedidosService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find( @PathVariable UUID id) {
		
		Pedidos obj = pedidosService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
