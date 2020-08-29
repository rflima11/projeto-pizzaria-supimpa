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

import br.com.rrsolucoes.pizzariasupimpa.dto.PedidoDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;
import br.com.rrsolucoes.pizzariasupimpa.parser.ClienteParserDTO;
import br.com.rrsolucoes.pizzariasupimpa.parser.PedidoParserDTO;
import br.com.rrsolucoes.pizzariasupimpa.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService servico;
	
	@Autowired
	private PedidoParserDTO parser;
	
	@Autowired
	private ClienteParserDTO parserCliente;
	
	@PostMapping
	public ResponseEntity<PedidoDto> salvarPedido(@RequestBody Pedido pedido){
		servico.save(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(parser.toDTO(pedido));
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> listarPedidos(){
		List<PedidoDto> pedidos = servico.listarPedidos();
		return ResponseEntity.ok().body(pedidos);	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PedidoDto> encontrarUmPedidoPorId(@PathVariable Long id){
		System.out.println(servico.encontrarPedido(id).get().getCliente().getNome());
		return ResponseEntity.ok().body(parser.toDTO(servico.encontrarPedido(id).get()));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletarEnderecoPorId(@PathVariable Long id){
		servico.deletarPedido(id);
		return ResponseEntity.noContent().build();
	}
	

}
