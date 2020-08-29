package br.com.rrsolucoes.pizzariasupimpa.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String telefone;
	private List<ListaPedidosDto> pedidos = new ArrayList<>();
	private Set<EnderecoDto> enderecos = new HashSet<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public Set<EnderecoDto> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}
	public List<ListaPedidosDto> getPedidoDto() {
		return pedidos;
	}
	public void setPedidoDto(List<ListaPedidosDto> pedidoDto) {
		this.pedidos = pedidoDto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
