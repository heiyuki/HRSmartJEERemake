package pi.HRSmart.persistence;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author yesmine
 * 
 */
@Embeddable
public class UserBuisnessPK implements Serializable {

	private Buisness buisness;
	private User user;

	@ManyToOne
	public Buisness getBuisness() {
		return buisness;
	}

	public void setBuisness(Buisness buisness) {
		this.buisness = buisness;
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
		result = prime * result + ((buisness == null) ? 0 : buisness.hashCode());
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
		UserBuisnessPK other = (UserBuisnessPK) obj;
		if (buisness == null) {
			if (other.buisness != null)
				return false;
		} else if (!buisness.equals(other.buisness))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
