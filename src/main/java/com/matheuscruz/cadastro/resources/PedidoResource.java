package com.matheuscruz.cadastro.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/orders/")
public class PedidoResource {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST esta pegando";
	}
	

}
