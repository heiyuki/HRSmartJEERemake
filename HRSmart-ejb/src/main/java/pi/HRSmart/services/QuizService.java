package pi.HRSmart.services;

import pi.HRSmart.interfaces.IQuizServiceLocal;
import pi.HRSmart.persistence.Quiz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alaa on 19/10/16.
 */
@Stateless
public class QuizService implements IQuizServiceLocal{

    @PersistenceContext(unitName = "HRSmart-ejb")
    EntityManager em;

    @Override
    public void add(Quiz quiz) {
        em.persist(quiz);
    }

    @Override
    public void update(Quiz quiz) {
        em.merge(quiz);
    }

    @Override
    public void remove(Quiz quiz) {
        em.remove(em.merge(quiz));
    }

    @Override
    public Quiz get(int id) {
        return em.find(Quiz.class, id);
    }

    @Override
    public List<Quiz> all() {
        Query query = em.createQuery("select q from Quiz q");

        return (ArrayList<Quiz>)query.getResultList();
    }

}
