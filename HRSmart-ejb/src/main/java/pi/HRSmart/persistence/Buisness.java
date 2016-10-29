package pi.HRSmart.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Buisness
 *
 *
 * @author Khaled Romdhane
 *
 */

@Entity

public class Buisness implements Serializable {

	private int id;
	private String name;
	private List<JobOffer> jobOffers;
	private List<UserBuisness> userBuisness;
	private List<Stage> stages;
	private static final long serialVersionUID = 1L;

	public Buisness() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(mappedBy = "id.buisness")
	public List<UserBuisness> getUserBuisness() {
		return userBuisness;
	}

	public void setUserBuisness(List<UserBuisness> userBuisness) {
		this.userBuisness = userBuisness;
	}

	@OneToMany(mappedBy = "buisness")
	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

	@OneToMany(mappedBy = "buisness")
	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}
}
