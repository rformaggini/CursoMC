package br.com.curso.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.com.curso.domain.enums.SituacaoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date dataPagamento;
	private Date dataVencimento;


	public PagamentoComBoleto() {

	}


	public PagamentoComBoleto(Integer id, SituacaoPagamento situacaoPagamento, Pedido pedido,Date dataPagamento,Date dataVencimento ) {
		super(id, situacaoPagamento, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	public Date getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	

}
