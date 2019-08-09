package br.com.curso.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.domain.Categoria;


//Resources sao controladores REST


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		
		List<Categoria> listaCategoria = new ArrayList<>();
		
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		listaCategoria.add(cat1);
		listaCategoria.add(cat2);
		
		return listaCategoria;
	}
	
}
