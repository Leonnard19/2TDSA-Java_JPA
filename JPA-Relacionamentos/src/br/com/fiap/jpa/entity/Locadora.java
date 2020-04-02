package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCADORA")
@SequenceGenerator(name = "locadora", sequenceName = "SQ_TB_LOCADORA", allocationSize = 1)
public class Locadora {

	@Id
	@Column(name = "cd_locadora")
	@GeneratedValue(generator = "locadora", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	// relation 1 to 1
	// cascade -> realiza as operações configuradas em cascata
	// Fetch   -> determina quando o relacionamento é carregado em uma pesquisa
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_endereco", nullable = false)
	private Endereco endereco;
	
	public Locadora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Locadora(Endereco endereco, String nome, String telefone, int quantidadeFuncionarios) {
		super();
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	//garante que qndo for cadastrar o filme, exista a locadora pertencente ao filme
	//mapeamento bi direcional ( MappedBy -> nome do atributo )
	@OneToMany(mappedBy = "locadora", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Filme> filmes = new ArrayList<Filme>(); //inicializar a lista

	@Column(name = "nm_locadora", nullable = false, length = 50)
	private String nome;

	@Column(name = "nr_telefone", length = 15)
	private String telefone;

	@Column(name = "nr_funcionario")
	private int quantidadeFuncionarios;
	
	
	//metodo para adicionar filmes
	public void addFilme(Filme filme) {
		filme.setLocadora(this); // adiciona a locadora no atributo que mapeia a FK
		getFilmes().add(filme); // adiciona o filme na lista
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

}
