package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.LocadoraDao;
import br.com.fiap.jpa.daoImpl.LocadoraDaoImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Locadora;
import br.com.fiap.jpa.entity.Plano;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		
		//Instanciar uma fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Intanciar um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um DAO
		LocadoraDao locadoraDao = new LocadoraDaoImpl(em);
		
		//cadastrar uma locadora com um endereço relacionados
		Endereco end = new Endereco("Av Lins de Vasconcelos, 1222", "Cambuci");
		Locadora loc = new Locadora(end, "Blockbuster", "(11)985654545", 3);
		
		//Adicionar filmes na locadora para serem cadastrados em cascata
		loc.addFilme(new Filme("Space Jam", new GregorianCalendar(1996, Calendar.JANUARY, 20),
				Genero.AVENTURA, 120));
		
		loc.addFilme(new Filme("007", new GregorianCalendar(2018, Calendar.AUGUST, 2),
				Genero.ACAO, 180));
		
		loc.addFilme(new Filme("Vingadores", Calendar.getInstance(),
				Genero.HEROI, 200));
		
		//adicionar os clientes relacionado com o filme
		Cliente leonardo = new Cliente("Leonardo", new GregorianCalendar(1995, Calendar.MAY, 19),
				Plano.PREMIUM, true, loc.getFilmes());
		
		Cliente carol = new Cliente("Carol", new GregorianCalendar(2000, Calendar.APRIL, 20),
						Plano.GOLD, false, loc.getFilmes());
		
		//Relacionar no filme a lista de clientes
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(leonardo);
		clientes.add(carol);
		
		for (Filme filme : loc.getFilmes()) { //adiciona todos os filmes nos clientes cadastrados
			filme.setCliente(clientes);
		}
				
		try {
			locadoraDao.cadastrar(loc);
			locadoraDao.commit();
			System.out.println("Locadora e Endereço cadastrados.");
		} catch (CommitException e) {
			System.out.println("Erro...");
		}
		
		//fechar as paradas
		em.close();
		fabrica.close();
		
	}

}
