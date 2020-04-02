package br.com.fiap.jpa.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao{

	public ClienteDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
}
