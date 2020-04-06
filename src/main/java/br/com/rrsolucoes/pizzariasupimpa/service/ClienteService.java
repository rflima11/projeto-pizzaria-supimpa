package br.com.rrsolucoes.pizzariasupimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rrsolucoes.pizzariasupimpa.dao.ClienteDao;
import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao dao;
	
	
	public void salvarCliente(Cliente cliente) {
		dao.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return dao.findAll();
	}
	
	public Optional<Cliente> encontrarCliente(Long id) {
		return dao.findById(id);
	}
	
	public void deletarCliente(Long id) {
		dao.deleteById(id);
	}
	
	public void atualizarCliente() {
	}
	
}
