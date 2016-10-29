package pi.HRSmart.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pi.HRSmart.interfaces.SkillServiceLocal;
import pi.HRSmart.persistence.JobSkill;
import pi.HRSmart.persistence.Skill;

/**
 * Session Bean implementation class SkillService
 *
 * @author Khaled Romdhane
 *
 */

@Stateless
public class SkillService implements SkillServiceLocal {

	@PersistenceContext(unitName="HRSmart-ejb")
	EntityManager em;

	public SkillService() {

	}

	@Override
	public void add(Skill skill) {
		em.persist(skill); 
	}

	@Override
	public void update(Skill skill) {
		em.merge(skill);
	}

	@Override
	public void remove(Skill skill) {
		em.remove(em.merge(skill));
	}

	@Override
	public Skill get(int id) {
		return em.find(Skill.class, id);
	}

	@Override
	public List<Skill> getAll() {
		Query query = em.createQuery("SELECT s FROM Skill s");
	    return (List<Skill>) query.getResultList();
	}



}
