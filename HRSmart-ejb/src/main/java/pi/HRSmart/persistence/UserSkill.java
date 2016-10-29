package pi.HRSmart.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import pi.HRSmart.persistence.Certificat;
import pi.HRSmart.persistence.Skill;
import pi.HRSmart.persistence.User;

/**
 * @author yesmine
 *
 */
@Entity
@Table(name ="UserSkill")
@AssociationOverrides({
    @AssociationOverride(name ="id.user",
            joinColumns = @JoinColumn(name ="user_id",
            insertable = false, updatable = false
            )),
    @AssociationOverride(name ="id.skill",
            joinColumns = @JoinColumn(name ="skill_id",
                    insertable = false, updatable = false
            ))
})
public class UserSkill implements Serializable {

	private int level;

	private UserSkillPk id;
	private static final long serialVersionUID = 1L;
	private User user;
	private List<Certificat> certificats;
	private Skill skill;

	public UserSkill() {
		super();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	@EmbeddedId
	public UserSkillPk getId() {
		return id;
	}

	public void setId(UserSkillPk id) {
		this.id = id;
	}

	@Transient
	public User getUser() {
		return getId().getUser();
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToMany(mappedBy = "userSkills")
	public List<Certificat> getCertificats() {
		return certificats;
	}
	public void setCertificats(List<Certificat> certificats) {
		this.certificats = certificats;
	}

	@Transient
	public Skill getSkill() {
		return getId().getSkill();
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certificats == null) ? 0 : certificats.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + level;
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
		UserSkill other = (UserSkill) obj;
		if (certificats == null) {
			if (other.certificats != null)
				return false;
		} else if (!certificats.equals(other.certificats))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level != other.level)
			return false;
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
