package com.matheuscruz.cadastro.resources;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheuscruz.cadastro.domain.Cadastro;
import com.matheuscruz.cadastro.services.CadastroService;

@RestController
@RequestMapping(value = "/api/orders/")
public class CadastroResource {

	@Autowired
	private CadastroService cadastroService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cadastro> find( @PathVariable UUID id) {
		
		Cadastro obj = cadastroService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cadastro obj) {
		obj = cadastroService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cadastro obj, @PathVariable UUID id) {
		obj.setId(id);
		obj = cadastroService.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete( @PathVariable UUID id) {
		cadastroService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
