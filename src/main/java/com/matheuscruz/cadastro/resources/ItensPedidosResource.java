package com.matheuscruz.cadastro.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheuscruz.cadastro.domain.ItensPedidos;
import com.matheuscruz.cadastro.dto.ItensPedidosDTO;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ItensPedidosDTO objDto) {
		ItensPedidos obj = pedidosService.fromDTO(objDto);
		obj = pedidosService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ItensPedidosDTO objDto, @PathVariable UUID id) {
		ItensPedidos obj = pedidosService.fromDTO(objDto);
		obj.setId(id);
		obj = pedidosService.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete( @PathVariable UUID id) {
		pedidosService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItensPedidosDTO>> findAll() {
		
		List<ItensPedidos> list = pedidosService.findAll();
		List<ItensPedidosDTO> listDto = list.stream().map(obj -> new ItensPedidosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
