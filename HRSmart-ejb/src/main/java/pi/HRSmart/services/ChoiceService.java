package pi.HRSmart.services;

import pi.HRSmart.interfaces.IChoiceServiceLocal;
import pi.HRSmart.persistence.Choice;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alaa on 20/10/16.
 */
@Stateless
public class ChoiceService implements IChoiceServiceLocal{

    @PersistenceContext(unitName = "HRSmart-ejb")
    EntityManager em;


    @Override
    public void add(Choice choice) {
        em.persist(choice);
    }

    @Override
    public void update(Choice choice) {
        em.merge(choice);
    }

    @Override
    public void remove(Choice choice) {
        em.remove(em.merge(choice));
    }

    @Override
    public Choice get(int id) {
        return em.find(Choice.class, id);
    }

    @Override
    public List<Choice> all() {
        Query query = em.createQuery("select c from Choice c");
        return (List<Choice>) query.getResultList();
    }
}
