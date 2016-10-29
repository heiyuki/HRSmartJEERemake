package pi.HRSmart.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pi.HRSmart.interfaces.UserBuisnessServiceLocal;
import pi.HRSmart.persistence.Buisness;
import pi.HRSmart.persistence.User;
import pi.HRSmart.persistence.UserBuisness;
/**
 * @author yesmine
 *
 */
@Stateless

public class UserBuisnessService implements UserBuisnessServiceLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext(unitName = "HRSmart-ejb")
	EntityManager em;

	public UserBuisnessService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(UserBuisness userBuisness) {
		em.persist(userBuisness);

	}

	@Override
	public void update(UserBuisness userBuisness) {
		em.merge(userBuisness);

	}

	@Override
	public void remove(UserBuisness userBuisness) {
		em.remove(em.merge(userBuisness));

	}

	@Override
	public UserBuisness get(int id) {

		return em.find(UserBuisness.class, id);
	}

	@Override
	public List<UserBuisness> getAll() {
		Query query = em.createQuery("select ub from UserBuisness ub");
		return (List<UserBuisness>) query.getResultList();
	}

	@Override
	public List<UserBuisness> getByUser(User user) {
		Query query = em.createQuery("select ub from Userbuisness ub where ub.user=" + user.getId());
		return (List<UserBuisness>) query.getResultList();
	}

	@Override
	public List<UserBuisness> getByBuisness(Buisness buisness) {
		Query query = em.createQuery("select ub from Userbuisness ub where ub.buisness=" + buisness.getId());
		return (List<UserBuisness>) query.getResultList();

	}

}
