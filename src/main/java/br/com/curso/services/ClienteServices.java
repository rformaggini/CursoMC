package br.com.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.domain.Cliente;
import br.com.curso.repository.ClienteRepository;
import br.com.curso.services.exception.ObjectNotFoundException;

@Service
public class ClienteServices {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente buscar(Integer idCliente) {
		
		Optional<Cliente> obj = repository.findById(idCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " +
																 " Id: " + idCliente +
																 " Tipo: " + Cliente.class.getName(), null ));
		
		
				
	}
}
