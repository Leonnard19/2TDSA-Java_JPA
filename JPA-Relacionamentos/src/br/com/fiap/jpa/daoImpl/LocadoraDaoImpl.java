package br.com.fiap.jpa.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.LocadoraDao;
import br.com.fiap.jpa.entity.Locadora;

public class LocadoraDaoImpl extends GenericDaoImpl<Locadora, Integer> implements LocadoraDao{

	public LocadoraDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
