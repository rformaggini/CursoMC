package br.com.curso.domain.enums;

public enum SituacaoPagamento {
	
	PENDENTE(1, "PENDENTE DE PAGAMENTO"), 
	QUITADO(2, "PAGAMENTO REALIZADO"), 
	CANCELADO(3, "PAGAMENTO CANCELADO");

	private Integer id;
	private String descricao;

	private SituacaoPagamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public static SituacaoPagamento toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (SituacaoPagamento pg : SituacaoPagamento.values()) {
			if (id.equals(pg.getId())) {
				return pg;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);

	}

}
