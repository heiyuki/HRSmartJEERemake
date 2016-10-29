package pi.HRSmart.services;

import pi.HRSmart.interfaces.IQuestionServiceLocal;
import pi.HRSmart.persistence.Question;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alaa on 20/10/16.
 */
public class QuestionService implements IQuestionServiceLocal{

    @PersistenceContext(unitName = "HRSmart-ejb")
    EntityManager em;

    @Override
    public void add(Question question) {
        em.persist(question);
    }

    @Override
    public void update(Question question) {
        em.merge(question);
    }

    @Override
    public void remove(Question question) {
        em.remove(em.merge(question));
    }

    @Override
    public Question get(int id) {
        return em.find(Question.class, id);
    }

    @Override
    public List<Question> all() {
        Query query = em.createQuery("select q from Question q");

        return (List<Question>)query.getResultList();
    }
}
