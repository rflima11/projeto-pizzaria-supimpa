package br.com.rrsolucoes.pizzariasupimpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rrsolucoes.pizzariasupimpa.dao.PizzaDao;
import br.com.rrsolucoes.pizzariasupimpa.model.Pizza;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaDao dao;
	
	

	public void save(Pizza pizza) {
		dao.save(pizza);
	}
	
	public List<Pizza> listarPizzas(){
		return dao.findAll();
	}
	
	public Optional<Pizza> encontrarPizza(Long id) {
		return dao.findById(id);
	}
	
	public void deletarPizza(Long id) {
		dao.deleteById(id);
	}
	
	public void atualizarPizza() {
		
	}

}
