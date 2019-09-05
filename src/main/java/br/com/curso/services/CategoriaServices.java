package br.com.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.domain.Categoria;
import br.com.curso.repository.CategoriaRepository;
import br.com.curso.services.exception.ObjectNotFoundException;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer idCategoria) {
		
		Optional<Categoria> obj = repository.findById(idCategoria);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " +
																 " Id: " + idCategoria +
																 " Tipo: " + Categoria.class.getName(), null ));
		
		
				
	}
}
