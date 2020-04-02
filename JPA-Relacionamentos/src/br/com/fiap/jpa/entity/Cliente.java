package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
@Table(name = "TB_CLIENTE")
public class Cliente {

	public Cliente() {
		super();
	}

	public Cliente(String nome, Calendar dataNascimento, Plano plano, boolean status, List<Filme> filmes) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.plano = plano;
		this.status = status;
		this.filmes = filmes;
	}

	@Id
	@Column(name = "cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private Integer codigo;

	@Column(name = "nm_cliente", length = 80, nullable = false)
	private String nome;

	@Column
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "ds_plano")
	@Enumerated(EnumType.STRING)
	private Plano plano;

	@Column(name = "st_ativo")
	private boolean status;

	// Mapeamento da tabela assossiativa // mapeamento pode ser feito em qualquer
	// tabela da rela��o
	// atributo do tipo loca��o (lista)
	// j� que mapeia uma tabela (assossiativa loca��o), � joinTable
	@ManyToMany
	@JoinTable(name = "TB_LOCACAO",
	joinColumns = @JoinColumn(name="cd_cliente"),
	inverseJoinColumns = @JoinColumn(name="cd_filme"))
	private List<Filme> filmes;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

}
