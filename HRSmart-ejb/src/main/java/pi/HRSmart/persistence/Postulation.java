package pi.HRSmart.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Created by BoB on 10/18/2016.
 */

@Entity

public class Postulation  implements Serializable{

    private Integer idPostulation;
    private Date datePostulation;
    private User Postulant;
    private Rewards Reward;
    private List<Assessment> assessments;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    public Integer getIdPostulation() {
        return idPostulation;
    }

    public void setIdPostulation(Integer idPostulation) {
        this.idPostulation = idPostulation;
    }

    public Date getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(Date datePostulation) {
        this.datePostulation = datePostulation;
    }

    @ManyToOne
    public User getPostulant() {
        return Postulant;
    }

    public void setPostulant(User postulant) {
        Postulant = postulant;
    }

    @ManyToOne
    public Rewards getReward() {
        return Reward;
    }

    public void setReward(Rewards reward) {
        Reward = reward;
    }

    @Override
    public String toString() {
        return "Postulation{" +
                "idPostulation=" + idPostulation +
                ", datePostulation=" + datePostulation +
                ", Postulant=" + Postulant.getId()+
                ", Reward=" + Reward.getId() +
                '}';
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.postulation",orphanRemoval = true, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    })
    
    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }
}
