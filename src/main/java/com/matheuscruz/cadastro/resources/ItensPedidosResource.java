package com.matheuscruz.cadastro.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheuscruz.cadastro.domain.ItensPedidos;
import com.matheuscruz.cadastro.services.ItensPedidosService;

@RestController
@RequestMapping(value = "/api/orders/")
public class ItensPedidosResource {

	@Autowired
	private ItensPedidosService pedidosService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ItensPedidos> find( @PathVariable UUID id) {
		
		ItensPedidos obj = pedidosService.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
