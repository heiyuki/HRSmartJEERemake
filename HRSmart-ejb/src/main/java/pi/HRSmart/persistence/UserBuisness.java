package pi.HRSmart.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * @author yesmine
 *
 */
@Entity
@Table(name ="UserBuisness")
@AssociationOverrides({
        @AssociationOverride(name ="id.user",
                joinColumns = @JoinColumn(name ="user_id",
                insertable = false, updatable = false
                )),
        @AssociationOverride(name ="id.buisness",
                joinColumns = @JoinColumn(name ="buisness_id",
                        insertable = false, updatable = false
                ))
})
public class UserBuisness implements Serializable {

	
	private UserBuisnessPK id;
	private String role;
	private int salary;
	private Date hireDate;

	private static final long serialVersionUID = 1L;

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Transient
	public Buisness getBuisness() {
		return this.getId().getBuisness();
	}

	public void setBuisness(Buisness buisness) {
		this.getId().setBuisness(buisness);
	}
	@Transient
	public User getUser() {
		return this.getId().getUser();
	}

	public void setUser(User user) {
		this.getId().setUser(user);
	}
	@EmbeddedId
	public UserBuisnessPK getId() {
		return id;
	}

	public void setId(UserBuisnessPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + salary;
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
		UserBuisness other = (UserBuisness) obj;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	
}
