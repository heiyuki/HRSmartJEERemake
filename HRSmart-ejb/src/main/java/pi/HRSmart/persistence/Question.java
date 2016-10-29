package pi.HRSmart.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alaa on 17/10/16.
 */

@Entity
public class Question implements Serializable{

    private int id;
    private String body;
    private Skill skill;
    private List<Choice> choices = new ArrayList<>();
    private List<Quiz> quizs = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @ManyToOne
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @OneToMany(mappedBy = "question")
    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @ManyToMany(mappedBy = "questions")
    @Column(name = "quiz_id")
    public List<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(List<Quiz> quizs) {
        this.quizs = quizs;
    }
}
