package pi.HRSmart.persistence;

import java.io.Serializable;
import javax.persistence.*;

import pi.HRSmart.persistence.JobOffer;
import pi.HRSmart.persistence.Skill;

/**
 * Entity implementation class for Entity: JobSkill
 *
 * @author Khaled Romdhane
 *
 */

@Entity

public class JobSkill implements Serializable {

	   
	
	private int id;
	private boolean hasQuiz;
	private int level;
	private JobOffer jobOffer;
	private Skill skill;
	private static final long serialVersionUID = 1L;

	public JobSkill() {
		super();
	}  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}   
	public boolean getHasQuiz() {
		return this.hasQuiz;
	}

	public void setHasQuiz(boolean hasQuiz) {
		this.hasQuiz = hasQuiz;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@ManyToOne
	public JobOffer getJobOffer() {
		return jobOffer;
	}
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}
	@ManyToOne
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
   
}
