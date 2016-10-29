package pi.HRSmart.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pi.HRSmart.interfaces.BuisnessServiceLocal;
import pi.HRSmart.persistence.Buisness;

@Stateless
public class BuisnessService implements BuisnessServiceLocal {
	
	@PersistenceContext(unitName = "HRSmart-ejb")
	EntityManager em;

	@Override
	public void add(Buisness Buisness) {
		em.persist(Buisness);
		
	}

	@Override
	public void update(Buisness Buisness) {
		em.merge(Buisness);
		
	}

	@Override
	public void remove(Buisness Buisness) {
		em.remove(em.merge(Buisness));
		
	}

	@Override
	public Buisness get(int id) {
		return em.find(Buisness.class, id);
	}

	@Override
	public List<Buisness> getAll() {
		Query query = em.createQuery("select b from Buisness b");
		return (List<Buisness>) query.getResultList();
	}

}
