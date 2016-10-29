/**
 * 
 */
package pi.HRSmart.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author yesmine
 *
 */
@Embeddable
public class UserSkillPk implements Serializable {
	private Skill skill;
	private User user;

	@ManyToOne
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSkillPk other = (UserSkillPk) obj;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
