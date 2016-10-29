package pi.HRSmart.interfaces;

import pi.HRSmart.persistence.Choice;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by alaa on 20/10/16.
 */
@Local
public interface IChoiceServiceLocal {

    void add(Choice choice);
    void update(Choice choice);
    void remove(Choice choice);
    Choice get(int id);
    List<Choice> all();
}
