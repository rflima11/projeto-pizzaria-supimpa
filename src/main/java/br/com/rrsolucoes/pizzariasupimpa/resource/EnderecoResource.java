package br.com.rrsolucoes.pizzariasupimpa.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rrsolucoes.pizzariasupimpa.model.Endereco;
import br.com.rrsolucoes.pizzariasupimpa.service.CepService;
import br.com.rrsolucoes.pizzariasupimpa.service.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {

	
	@Autowired
	private EnderecoService servico;
	
	@Autowired
	private CepService cepServico;
	
	@PostMapping
	public ResponseEntity<?> salvarEndereco(@RequestBody Endereco endereco){
		servico.salvarEndereco(cepServico.converterCep(endereco));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(endereco);
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> listaEnderecos(){
		List<Endereco> enderecos = servico.listarEnderecos();
		return ResponseEntity.ok().body(enderecos);	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> encontraUmEnderecoPorId(@PathVariable Long id){
		return ResponseEntity.ok().body(servico.encontrarEndereco(id));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarEnderecoPorId(@PathVariable Long id){
		servico.deletarEndereco(id);
		return ResponseEntity.noContent().build();
	}
	
}
