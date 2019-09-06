package br.com.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.domain.Pedido;
import br.com.curso.repository.PedidoRepository;
import br.com.curso.services.exception.ObjectNotFoundException;

@Service
public class PedidoServices {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido buscar(Integer idPedido) {
		
		Optional<Pedido> obj = repository.findById(idPedido);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " +
																 " Id: " + idPedido +
																 " Tipo: " + Pedido.class.getName(), null ));
		
		
				
	}
}
