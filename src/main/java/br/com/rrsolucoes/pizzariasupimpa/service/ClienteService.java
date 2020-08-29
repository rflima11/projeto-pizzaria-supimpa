package br.com.rrsolucoes.pizzariasupimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rrsolucoes.pizzariasupimpa.dao.ClienteDao;
import br.com.rrsolucoes.pizzariasupimpa.dto.AutoCompleteDto;
import br.com.rrsolucoes.pizzariasupimpa.dto.ClienteDto;
import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;
import br.com.rrsolucoes.pizzariasupimpa.parser.AutoCompleteParserDTO;
import br.com.rrsolucoes.pizzariasupimpa.parser.ClienteParserDTO;
import br.com.rrsolucoes.pizzariasupimpa.parser.ListaPedidosParserDTO;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao dao;
	
	@Autowired
	private ListaPedidosParserDTO parserPedidos;
	
	@Autowired
	private ClienteParserDTO parserClientes;
	
	@Autowired
	private AutoCompleteParserDTO parserAutoComplete;
	
	
	public void salvarCliente(Cliente cliente) {
		cliente.getEnderecos().forEach(endereco -> endereco.setCliente(cliente));
		if(cliente.getNome() != null) {
		cliente.setNome(cliente.getNome().toUpperCase());
		dao.save(cliente);
		} else 
		dao.save(cliente);
	}
	
	public List<ClienteDto> listarClientes(){
		List<Cliente> clientes = dao.findAll();
		List<ClienteDto> dtoList = parserClientes.toDTOList(clientes);
		return dtoList;
	}
	
	public Optional<ClienteDto> encontrarCliente(Long id) {
		ClienteDto dto = null;
		Optional<Cliente> cliente = dao.findById(id);
		if(cliente.isPresent()) {
		dto = parserClientes.toDTO(cliente.get());
		}
		return Optional.of(dto);
	}
	
	public void deletarCliente(Long id) {
		dao.deleteById(id);
	}
	
	public List<AutoCompleteDto> listarClientesPorNome(String nome){
		List<Cliente> listaClientes = dao.findByNomeContaining(nome);
		return parserAutoComplete.toDTOList(listaClientes);
	}
	
	
	
	
	
}
