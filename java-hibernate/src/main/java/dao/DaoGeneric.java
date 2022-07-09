package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.geEntityManager();

	// CRIAR NOVO USUÁRIO
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	// ATUALIZAR USUÁRIO 
	public E updateMerge(E entidade) { 
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();

		return entidadeSalva;
	}
	
	// PESQUISAR USUÁRIO
	public E pesquisar(E entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);

		E e = (E) entityManager.find(entidade.getClass(), id);

		return e;

	}
	
	// PESQUISAR POR ID
	public E pesquisar(Long id, Class<E> entidade) {
		E e = (E) entityManager.find(entidade, id);
		return e;

	}

	// DELETAR POR ID 
	public void deletarPoId(E entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager
				.createNativeQuery(
						"delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id =" + id)
				.executeUpdate(); 
		transaction.commit();

	}
	
	// CONSULTAR TODOS OS USUÁRIOS 
	public List<E> listar(Class<E> entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();

		transaction.commit();

		return lista;
	}
}