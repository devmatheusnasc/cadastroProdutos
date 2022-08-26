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

import com.matheuscruz.cadastro.domain.Cadastro;
import com.matheuscruz.cadastro.dto.CadastroDTO;
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
	public ResponseEntity<Void> insert(@Valid @RequestBody CadastroDTO objDto) {
		Cadastro obj = cadastroService.fromDTO(objDto);
		obj = cadastroService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CadastroDTO objDto, @PathVariable UUID id) {
		Cadastro obj = cadastroService.fromDTO(objDto);
		obj.setId(id);
		obj = cadastroService.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete( @PathVariable UUID id) {
		cadastroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CadastroDTO>> findAll() {
		
		List<Cadastro> list = cadastroService.findAll();
		List<CadastroDTO> listDto = list.stream().map(obj -> new CadastroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
