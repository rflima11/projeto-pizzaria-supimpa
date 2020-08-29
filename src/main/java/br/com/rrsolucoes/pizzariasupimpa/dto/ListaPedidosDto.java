package br.com.rrsolucoes.pizzariasupimpa.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.rrsolucoes.pizzariasupimpa.model.Pizza;

public class ListaPedidosDto {

	private Long id;
	private int valorTotal;
	private List<Pizza> pizzas = new ArrayList<>();
	private int quantidadePizzas;
	private LocalDateTime horaInsercao;
	
	
	
	
	
	
	public LocalDateTime getHoraInsercao() {
		return horaInsercao;
	}
	public void setHoraInsercao(LocalDateTime horaInsercao) {
		this.horaInsercao = horaInsercao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getQuantidadePizzas() {
		return quantidadePizzas;
	}
	public void setQuantidadePizzas(int quantidadePizzas) {
		this.quantidadePizzas = quantidadePizzas;
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
