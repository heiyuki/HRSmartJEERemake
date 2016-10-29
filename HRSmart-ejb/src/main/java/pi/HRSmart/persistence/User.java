package pi.HRSmart.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {


	private int Id;
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private List<UserBuisness> userBuisness;
	private String login; /*email*/
	private String password;
	private String adresse;
	private String numTel;
	private int age;
	private List <UserSkill> userSkills;
	private List<Notification> userNotifications;


	public User() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@OneToMany(mappedBy="id.user")
	public List<UserSkill> getUserSkills() {
		return userSkills;
	}
	
	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}
	@OneToMany(mappedBy="id.user")
	public List<UserBuisness> getUserBuisness() {
		return userBuisness;
	}
	public void setUserBuisness(List<UserBuisness> userBuisness) {
		this.userBuisness = userBuisness;
	}

	@OneToMany(mappedBy="user")
	public List<Notification> getUserNotifications() {
		return userNotifications;
	}

	public void setUserNotifications(List<Notification> userNotifications) {
		this.userNotifications = userNotifications;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
