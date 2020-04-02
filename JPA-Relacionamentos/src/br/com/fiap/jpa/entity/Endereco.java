package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {

	@Id
	@Column(name = "cd_endereco")
	@GeneratedValue(generator = "endereco", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	// mapeamento bidirecional one-to-one ( MappedBy )
	// Mappedby -> nao cria a chave estrangeira nessa tabela no BD
	// MappedBy -> atributo (endereco) que mapeia a chave estrangeira (na classe locadora)
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "endereco")
	private Locadora locadora;

	@Column(name = "ds_logradouro", length = 60, nullable = false)
	private String logradouro;

	@Column(name = "ds_bairro", length = 50)
	private String bairro;
	
	

	public Endereco(String logradouro, String bairro) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
	}

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
