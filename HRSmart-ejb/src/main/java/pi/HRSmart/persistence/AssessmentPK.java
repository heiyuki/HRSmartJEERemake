package pi.HRSmart.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by alaa on 18/10/16.
 */
@Embeddable
public class AssessmentPK implements Serializable{

    private Quiz quiz;
    private Postulation postulation;


    @ManyToOne
    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @ManyToOne
    public Postulation getPostulation() {
        return postulation;
    }

    public void setPostulation(Postulation postulation) {
        this.postulation = postulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssessmentPK that = (AssessmentPK) o;

        if (quiz != null ? !quiz.equals(that.quiz) : that.quiz != null) return false;
        return postulation != null ? postulation.equals(that.postulation) : that.postulation == null;

    }

    @Override
    public int hashCode() {
        int result = quiz != null ? quiz.hashCode() : 0;
        result = 31 * result + (postulation != null ? postulation.hashCode() : 0);
        return result;
    }
}
