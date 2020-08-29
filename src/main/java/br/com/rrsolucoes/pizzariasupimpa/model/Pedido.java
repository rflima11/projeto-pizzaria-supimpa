package br.com.rrsolucoes.pizzariasupimpa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_seq_pedido")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "CO_SEQ_CLIENTE")
	private Cliente cliente;
	
	@NotNull
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(
			name = "TB_PEDIDO_PIZZA",
			joinColumns = {@JoinColumn(name = "CO_SEQ_PEDIDO")},
			inverseJoinColumns = {@JoinColumn(name = "CO_SEQ_PIZZA")}
	)
	private List<Pizza> pizzas = new ArrayList<>();
	
	@Column(name = "DS_VALORTOTAL")
	private int valorTotal;
	
	
	@Column(name = "DT_HORA_INCLUSAO")
	private LocalDateTime dataInicio;


public Pedido() {

}

@PrePersist
public void definirHorarioInsercao() {
	this.dataInicio = LocalDateTime.now();
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

@PostLoad
public void setTotal() {
	for (Pizza pizza : pizzas) {
		this.valorTotal += pizza.getPreco();
	}
}

public int getValorTotal() {
	return valorTotal;
}


public void setValorTotal(int valorTotal) {
	
	this.valorTotal = valorTotal;
}




public Cliente getCliente() {
	return cliente;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


public LocalDateTime getDataInicio() {
	return dataInicio;
}


public void setDataInicio(LocalDateTime dataInicio) {
	this.dataInicio = dataInicio;
}


@Override
public String toString() {
	return "Pedido [id=" + id + ", pizzas=" + pizzas + ", valorTotal=" + valorTotal + ", cliente=" + cliente
			+ ", dataInicio=" + dataInicio + "]";
}







}
