package pi.HRSmart.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pi.HRSmart.interfaces.StageServiceLocal;
import pi.HRSmart.persistence.Stage;

@Stateless
public class StageService implements StageServiceLocal{

	@PersistenceContext(unitName = "HRSmart-ejb")
	EntityManager em;
	@Override
	public void add(Stage Stage) {
		em.persist(Stage);
		
	}

	@Override
	public void update(Stage Stage) {
		em.merge(Stage);
		
	}

	@Override
	public void remove(Stage Stage) {
		em.remove(em.merge(Stage));
		
	}

	@Override
	public Stage get(int id) {
		return em.find(Stage.class, id);
	}

	@Override
	public List<Stage> getAll() {
		Query query = em.createQuery("select s from Stage s");
		return (List<Stage>) query.getResultList();
	}

}
