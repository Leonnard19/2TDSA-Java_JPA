package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

public interface GenericDao<Table, Key> {

	void cadastrar(Table entity);
	
	void atualizar(Table entity);
	
	Table pesquisar(Key key);
	
	void remover(Key key) throws KeyNotFoundException;
	
	void commit() throws CommitException;
	
}
