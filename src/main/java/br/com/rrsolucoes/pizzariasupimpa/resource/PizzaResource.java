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

import br.com.rrsolucoes.pizzariasupimpa.model.Pizza;
import br.com.rrsolucoes.pizzariasupimpa.service.PizzaService;

@RestController
@RequestMapping(value="/pizzas")
public class PizzaResource {

	@Autowired
	private PizzaService servico;
	
	@PostMapping
	public ResponseEntity<?> salvarPedido(@RequestBody Pizza pizza){
		servico.save(pizza);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pizza.getId()).toUri();
		return ResponseEntity.created(uri).body(pizza);
	}
	
	@GetMapping
	public ResponseEntity<List<Pizza>> listarPizzas(){
		List<Pizza> pizzas = servico.listarPizzas();
		return ResponseEntity.ok().body(pizzas);	
	}
}

