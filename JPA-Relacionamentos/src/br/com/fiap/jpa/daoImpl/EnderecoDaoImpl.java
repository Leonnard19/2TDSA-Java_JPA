package br.com.fiap.jpa.daoImpl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.EnderecoDao;
import br.com.fiap.jpa.entity.Endereco;

public class EnderecoDaoImpl extends GenericDaoImpl<Endereco, Integer> implements EnderecoDao{

	public EnderecoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
