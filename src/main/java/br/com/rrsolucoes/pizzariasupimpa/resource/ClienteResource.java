package br.com.rrsolucoes.pizzariasupimpa.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;
import br.com.rrsolucoes.pizzariasupimpa.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService servico;
	
	@PostMapping
	public ResponseEntity<?> salvarCliente(@RequestBody Cliente cliente){
		servico.salvarCliente(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				  buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarCliente(){
		List<Cliente> clientes = servico.listarClientes();
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> encontrarCliente(@PathVariable(value="id") Long id){
		Cliente cliente = servico.encontrarCliente(id).get();
		return ResponseEntity.ok().body(cliente);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable(value="id") Long id){
		servico.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
