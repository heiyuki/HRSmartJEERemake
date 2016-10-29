package pi.HRSmart.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pi.HRSmart.interfaces.RewardServiceLocal;
import pi.HRSmart.persistence.Certificat;
import pi.HRSmart.persistence.Rewards;

/**
 * Session Bean implementation class RewardService
 *
 * @author Khaled Romdhane
 *
 */

@Stateless
public class RewardService implements RewardServiceLocal {

	@PersistenceContext(unitName = "HRSmart-ejb")
	EntityManager em;

	public RewardService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Rewards reward) {
		em.persist(reward);

	}

	@Override
	public void update(Rewards reward) {
		em.merge(reward);

	}

	@Override
	public void remove(Rewards reward) {
		em.remove(em.merge(reward));

	}

	@Override
	public Rewards get(int id) {
		return em.find(Rewards.class, id);
	}

	@Override
	public List<Rewards> getAll() {
		Query query = em.createQuery("Select r from Rewards r");
		return (List<Rewards>) query.getResultList();
	}

	@Override
	public List<Rewards> getByJob(int jobId) {
		Query query = em.createQuery("Select r from Rewards r where r.jobOffer = " + jobId);
		return (List<Rewards>) query.getResultList();
	}

	@Override
	public Rewards getCVStage(int jobId) {
		Query query = em.createQuery("Select r from Rewards r where r.value=0 AND r.jobOffer = " + jobId);
		return (Rewards) query.getResultList();	}

}
