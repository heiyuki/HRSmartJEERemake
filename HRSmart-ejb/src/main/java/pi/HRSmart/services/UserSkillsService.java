package pi.HRSmart.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pi.HRSmart.interfaces.UserSkillsServiceLocal;
import pi.HRSmart.persistence.UserSkill;

/**
 * @author yesmine
 *
 */
@Stateless


public class UserSkillsService implements UserSkillsServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "HRSmart-ejb")
	EntityManager em;
	
    public UserSkillsService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(UserSkill userSkill) {
		em.persist(userSkill);
		
	}

	@Override
	public void update(UserSkill userSkill) {
		em.merge(userSkill);
		
	}

	@Override
	public void remove(UserSkill userSkill) {
		em.remove(em.merge(userSkill));
		
	}

	@Override
	public UserSkill get(int id) {
		
		return em.find(UserSkill.class, id);
	}

	@Override
	public List<UserSkill> getAll() {
		Query query = em.createQuery("select us from userSkill us");
		return (List<UserSkill>) query.getResultList();
	}

	@Override
	public List<UserSkill> getByUser(int id) {
		Query query = em.createQuery("select us from userSkill us where us.user ="+id);
		return (List<UserSkill>) query.getResultList();
	}

}
