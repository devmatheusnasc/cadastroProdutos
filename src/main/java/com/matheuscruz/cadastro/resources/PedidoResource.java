package com.matheuscruz.cadastro.resources;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheuscruz.cadastro.domain.Pedidos;

@RestController
@RequestMapping(value = "/api/orders/")
public class PedidoResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Pedidos> listar() {

		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);

		Pedidos p1 = new Pedidos(null, 25, timestamp, 15, 35);
		Pedidos p2 = new Pedidos(null, 18, timestamp, 17, 39);
		
		List<Pedidos> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		return lista;
	}

}
