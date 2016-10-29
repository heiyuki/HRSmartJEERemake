package pi.HRSmart.interfaces;

import pi.HRSmart.persistence.Quiz;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by alaa on 19/10/16.
 */
@Local
public interface IQuizServiceLocal {
    void add(Quiz quiz);
    void update(Quiz quiz);
    void remove(Quiz quiz);
    Quiz get(int id);
    List<Quiz> all();

}
