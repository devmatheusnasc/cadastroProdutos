package com.matheuscruz.cadastro;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheuscruz.cadastro.domain.Pedidos;
import com.matheuscruz.cadastro.repositories.PedidosRepository;

@SpringBootApplication
public class CadastroProdutosApplication implements CommandLineRunner {

	@Autowired
	PedidosRepository pedidosRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroProdutosApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {


		Long datetime = System.currentTimeMillis();
		Timestamp timeStamp = new Timestamp(datetime);
		
		Pedidos p1 = new Pedidos(null, 13, null, 5, 12);
		Pedidos p2 = new Pedidos(null, 14, null, 54, 12);
		
		pedidosRepository.saveAll(Arrays.asList(p1, p2));

	}

}
