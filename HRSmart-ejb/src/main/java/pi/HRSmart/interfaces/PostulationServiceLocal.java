package pi.HRSmart.interfaces;


import javafx.geometry.Pos;
import pi.HRSmart.persistence.Postulation;
import pi.HRSmart.persistence.*;

import java.util.List;

/**
 * Created by BoB on 10/18/2016.
 */
public interface PostulationServiceLocal {

    void add(Postulation postulation);
    void update(Postulation postulation);
    void delete(Postulation postulation);
    Postulation getPostulation(int id);
    List<Postulation> getAllPostulations();
    List<Postulation> filterPostulationsByQuizResult(int threshold, Skill sk);


}
