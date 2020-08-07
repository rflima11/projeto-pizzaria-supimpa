package br.com.rrsolucoes.pizzariasupimpa.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;
import br.com.rrsolucoes.pizzariasupimpa.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService servico;
	
	@PostMapping
	public ResponseEntity<?> salvarPedido(@RequestBody Pedido pedido){
		servico.save(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(pedido);
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listarPizzas(){
		List<Pedido> pizzas = servico.listarPizzas();
		return ResponseEntity.ok().body(pizzas);	
	}
}
