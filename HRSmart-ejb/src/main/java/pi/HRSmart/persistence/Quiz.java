package pi.HRSmart.persistence;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alaa on 18/10/16.
 */
@Entity
public class Quiz {

    private int id;
    private int duration;
    private float result;
    private String descrption;

    private List<Assessment> assessments = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.quiz",orphanRemoval = true, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    })
    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }


    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    @ManyToMany

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
