package pi.HRSmart.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Skill
 *
 * @author Khaled Romdhane
 *
 */

@Entity

public class Skill implements Serializable {

	   
	
	private int id;
	private String name;
	private List<JobSkill> jobSkills;
	private static final long serialVersionUID = 1L;
	private List<Certificat> certificats;
	private List<UserSkill> userSkills;
	private List<Question> questions ;

	public Skill() {
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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="skill")
	public List<JobSkill> getJobSkills() {
		return jobSkills;
	}
	public void setJobSkills(List<JobSkill> jobSkills) {
		this.jobSkills = jobSkills;
	}
	
	
	@OneToMany(mappedBy="skill")
	public List<Certificat> getCertificats() {
		return certificats;
	}
	public void setCertificats(List<Certificat> certificats) {
		this.certificats = certificats;
	}
	@OneToMany(mappedBy="id.skill")
	public List<UserSkill> getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}


	@OneToMany(mappedBy = "skill")
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
