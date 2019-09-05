package br.com.curso.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer id;
	private String descricao;

	private TipoCliente(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (TipoCliente cli : TipoCliente.values()) {
			if (id.equals(cli.getId())) {
				return cli;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);

	}

}
