package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_FILME")
@SequenceGenerator(name = "filme", sequenceName = "SQ_TB_FILME", allocationSize = 1)
public class Filme {

	public Filme() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Filme(String nome, Calendar dataLancamento, Genero genero, int duracao) {
		super();
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.genero = genero;
		this.duracao = duracao;
	}

	@Id
	@Column(name = "cd_filme")
	@GeneratedValue(generator = "filme", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	//Relacionamento bidirecional com os clientes
	@ManyToMany(mappedBy = "filmes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Cliente> cliente;
	
	// Mapeamento da relação da classe que está para classe da referencia
	@ManyToOne
	@JoinColumn(name = "cd_locadora", nullable = false)
	private Locadora locadora; 

	@Column(name = "nm_filme", nullable = false, length = 100)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_lancamento")
	private Calendar dataLancamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero")
	private Genero genero;

	@Column(name = "ds_duracao")
	private int duracao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

}
