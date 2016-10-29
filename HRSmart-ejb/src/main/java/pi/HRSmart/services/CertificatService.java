package pi.HRSmart.services;

import java.security.AllPermission;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pi.HRSmart.interfaces.CertificatServiceLocal;
import pi.HRSmart.persistence.Certificat;
import pi.HRSmart.persistence.Skill;


/**
 * Session Bean implementation class CertificatService
 */
@Stateless

public class CertificatService implements CertificatServiceLocal {

	/**
	 * @author yesmine
	 *
	 */

	@PersistenceContext(unitName = "HRSmart-ejb")
	EntityManager em;

	public CertificatService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Certificat certificat) {
		em.persist(certificat);
	}

	@Override
	public void update(Certificat certificat) {
		em.merge(certificat);

	}

	@Override
	public void remove(Certificat certificat) {
		em.remove(em.merge(certificat));

	}

	@Override
	public Certificat get(int id) {

		return em.find(Certificat.class, id);
	}

	@Override
	public List<Certificat> getAll() {

		Query query = em.createQuery("SELECT c FROM Certificat c");
	    return (List<Certificat>) query.getResultList();
	}

}
