package br.com.fiap.jpa.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.FilmeDao;
import br.com.fiap.jpa.entity.Filme;

public class FilmeDaoImpl extends GenericDaoImpl<Filme, Integer> implements FilmeDao{

	public FilmeDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
