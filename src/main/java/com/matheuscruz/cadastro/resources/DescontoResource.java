package com.matheuscruz.cadastro.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheuscruz.cadastro.domain.Desconto;
import com.matheuscruz.cadastro.dto.DescontoDTO;
import com.matheuscruz.cadastro.services.DescontoService;

@RestController
@RequestMapping(value = "/api/orders/close")
public class DescontoResource {
	
		@Autowired
		private DescontoService descontoService;
		
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<DescontoDTO>> findAll() {
			
			List<Desconto> list = descontoService.findAll();
			List<DescontoDTO> listDto = list.stream().map(obj -> new DescontoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}
}
