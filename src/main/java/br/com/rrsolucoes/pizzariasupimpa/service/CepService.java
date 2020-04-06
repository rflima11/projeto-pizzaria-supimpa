package br.com.rrsolucoes.pizzariasupimpa.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

import br.com.rrsolucoes.pizzariasupimpa.model.Endereco;

@Service
public class CepService {

	public Endereco converterCep(Endereco endereco) {
		ViaCEPClient client = new ViaCEPClient();
		try {
			ViaCEPEndereco enderecoCep = client.getEndereco(endereco.getCep());
			endereco.setBairro(enderecoCep.getBairro());
			endereco.setComplemento(enderecoCep.getComplemento());
			endereco.setLocalidade(enderecoCep.getLocalidade());
			endereco.setUf(enderecoCep.getUf());
			endereco.setLogradouro(enderecoCep.getLogradouro());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return endereco;
	}
	
	public Endereco retornarEnderecoPorCep(String cep) {
		ViaCEPClient client = new ViaCEPClient();
		Endereco endereco = new Endereco();
		try {
			ViaCEPEndereco enderecoCep = client.getEndereco(cep);
			endereco.setBairro(enderecoCep.getBairro());
			endereco.setComplemento(enderecoCep.getComplemento());
			endereco.setLocalidade(enderecoCep.getLocalidade());
			endereco.setUf(enderecoCep.getUf());
			endereco.setLogradouro(enderecoCep.getLogradouro());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return endereco;
	}
}
