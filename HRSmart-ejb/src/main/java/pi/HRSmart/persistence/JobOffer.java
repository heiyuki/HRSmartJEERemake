 package pi.HRSmart.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import pi.HRSmart.persistence.Buisness;

/**
 * Entity implementation class for Entity: JobOffer
 *
 * @author Khaled Romdhane
 *
 */

@Entity

public class JobOffer implements Serializable {

	   
	
	private int id;
	private String title;
	private String description;
	private int salary;
	private List<JobSkill> jobSkills;
	private List<Rewards> rewards;
	private Buisness buisness;
	private static final long serialVersionUID = 1L;

	public JobOffer() {
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
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@OneToMany(mappedBy="jobOffer")
	public List<JobSkill> getJobSkills() {
		return jobSkills;
	}
	public void setJobSkills(List<JobSkill> jobSkills) {
		this.jobSkills = jobSkills;
	}
	@OneToMany(mappedBy="jobOffer")
	public List<Rewards> getRewards() {
		return rewards;
	}
	public void setRewards(List<Rewards> rewards) {
		this.rewards = rewards;
	}
	@ManyToOne
	public Buisness getBuisness() {
		return buisness;
	}
	public void setBuisness(Buisness buisness) {
		this.buisness = buisness;
	}
	
	
	
   
}
