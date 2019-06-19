package br.com.rest.util;

import javax.persistence.EntityManager;

public class JPAUtil {
	
	private static final String PERSISTENCE_UNIT = "jdbcDB3";
	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory entityManagerFactory;
	
	private JPAUtil() {
	}
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			
		}
		EntityManager entityManager = threadEntityManager.get();
		
		if(entityManager == null) || !entityManager.isManager.isOpen()){
			entityManager = entityManagerFactory.cretaeEntityManager();
			JPAUtil.threadEntityManager.set(entityManager);
		}
		return entityManager;
	}
	
	public static void closetEntityManager() {
		EntityManager em = threadEntityManager.get();
		if(em != null) {
			EntityTransaction transaction = em.getTransaction();
			if(transaction.isActive()) {
				transaction.commit();
			}
			em.close();
			threadEntityManager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}

}
