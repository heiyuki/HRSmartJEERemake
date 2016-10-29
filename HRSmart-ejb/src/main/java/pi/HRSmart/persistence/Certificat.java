package pi.HRSmart.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
/**
 * @author yesmine
 *
 *
 */

@Entity

public class Certificat implements Serializable {

	   
	
	private int id;
	private String name;
	private static final long serialVersionUID = 1L;
	private Skill skill;
	private List<UserSkill> userSkills;
	public Certificat() {
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
	@ManyToOne
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@ManyToMany
	public List<UserSkill> getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}
	
   
}
