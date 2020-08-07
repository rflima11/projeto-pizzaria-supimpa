package br.com.rrsolucoes.pizzariasupimpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_SEQ_PEDIDO")
	private Long id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CO_SEQ_PIZZA")
	private List<Pizza> pizzas = new ArrayList<>();
	
	@Column(name = "DS_VALORTOTAL")
	private Float valorTotal;


public Pedido() {
	
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public List<Pizza> getPizzas() {
	return pizzas;
}


public void setPizzas(List<Pizza> pizzas) {
	this.pizzas = pizzas;
}


public Float getValorTotal() {
	this.pizzas.parallelStream().map(pizza -> pizza.getPreco() + this.valorTotal);
	return valorTotal;
}


public void setValorTotal(Float valorTotal) {
	this.valorTotal = valorTotal;
}



}
