package br.com.rrsolucoes.pizzariasupimpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.rrsolucoes.pizzariasupimpa.model.Cliente;
import br.com.rrsolucoes.pizzariasupimpa.model.Pedido;
import br.com.rrsolucoes.pizzariasupimpa.model.Pizza;
import br.com.rrsolucoes.pizzariasupimpa.service.ClienteService;
import br.com.rrsolucoes.pizzariasupimpa.service.PedidoService;
import br.com.rrsolucoes.pizzariasupimpa.service.PizzaService;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class PizzariaSupimpaApplication {
	
	@Autowired
	private static PizzaService servicePizza;
	@Autowired
	private static ClienteService serviceCliente;
	@Autowired
	private static PedidoService servicePedido;
	
	
	
	
	
	public static void incriptarPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode("123456");
		System.out.println("password: " + encode);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
				.allowCredentials(true);
			}
		};
	}

	

	

	public static void main(String[] args) {
		SpringApplication.run(PizzariaSupimpaApplication.class, args);
	}

}
   