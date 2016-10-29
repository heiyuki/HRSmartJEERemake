package pi.HRSmart.persistence;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alaa on 17/10/16.
 */
@Entity
public class Choice implements Serializable{

    private int id;
    private String body;
    private boolean isCorrect;
    private int mark;
    private Question question;

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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @ManyToOne
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


}
