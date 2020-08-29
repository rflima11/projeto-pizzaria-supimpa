package br.com.rrsolucoes.pizzariasupimpa.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;
import br.com.rrsolucoes.pizzariasupimpa.model.Pizza;

public class PedidoDto {
	
	private Long id;
	private ClienteDto clienteDto;
	private int valorTotal;
	private List<Pizza> pizzas = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClienteDto getCliente() {
		return clienteDto;
	}
	public void setCliente(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	
}
