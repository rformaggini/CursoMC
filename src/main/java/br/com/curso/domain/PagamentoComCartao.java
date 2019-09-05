package br.com.curso.domain;

import javax.persistence.Entity;

import br.com.curso.domain.enums.SituacaoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	
	private Integer numeroParcelas;

	public PagamentoComCartao() {
		// TODO Auto-generated constructor stub
	}

	public PagamentoComCartao(Integer id, SituacaoPagamento situacaoPagamento, Pedido pedido, Integer numeroParcelas) {
		super(id, situacaoPagamento, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
