package br.com.rrsolucoes.pizzariasupimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rrsolucoes.pizzariasupimpa.dao.EnderecoDao;
import br.com.rrsolucoes.pizzariasupimpa.model.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoDao dao;
	
	public void salvarEndereco(Endereco endereco) {
		dao.save(endereco);
	}
	
	public List<Endereco> listarEnderecos(){
		return dao.findAll();
	}
	
	public Optional<Endereco> encontrarEndereco(Long id) {
		return dao.findById(id);
	}
	
	public void deletarEndereco(Long id) {
		dao.deleteById(id);
	}
	
	public void atualizarCliente() {
		
	}
}
