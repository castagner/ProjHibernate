package br.com.rest.dados;

import java.util.List;
import javax.persistence.EntityManager;
import Javax.persistence.Query;
import br.com.rest.entidade.Ferramenta;

import br.com.rest.util.JPAUtil;

public class FerramentaDB {
	
	private static FerramentaDB instance;
	EntityManager entityManager;
	
	private FerramentaDB() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	public static FerramentaDB getInstance() {
		if(instance == null)
		   instance = new FerramentaDB();
		return instance;
	}
	
	public boolean inserir (Object t) {
	
		boolean status = false;
	try {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		status = true;
	}catch (Exception e) {
		e.printStackTrace();
		entityManager.getTransaction().rollback;
	}
	return status;

}
	
	@SuppressWarnings("unchecked")
	public List<Ferramenta> getListaFerramenta (String q){
		entityManager.getTransaction().begin();
		Query query = entityManager.createNameQuery(q);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}
}