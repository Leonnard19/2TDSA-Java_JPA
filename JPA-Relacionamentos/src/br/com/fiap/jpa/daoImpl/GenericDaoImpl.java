package br.com.fiap.jpa.daoImpl;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

//@SuppressWarnings("hiding")
public abstract class GenericDaoImpl<Table, Key> implements GenericDao<Table, Key> {

	private EntityManager em;

	private Class<Table> clazz;

	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<Table>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(Table entity) {
		em.persist(entity);
	}

	@Override
	public void atualizar(Table entity) {
		em.merge(entity);
	}

	@Override
	public Table pesquisar(Key key) {
		return em.find(clazz, key);

	}

	@Override
	public void remover(Key key) throws KeyNotFoundException {
		Table entity = pesquisar(key);
		if (key == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

	public Class<Table> getClazz() {
		return clazz;
	}

	public void setClazz(Class<Table> clazz) {
		this.clazz = clazz;
	}

}
