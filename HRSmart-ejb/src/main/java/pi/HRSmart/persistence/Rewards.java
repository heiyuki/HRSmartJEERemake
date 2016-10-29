package pi.HRSmart.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import pi.HRSmart.persistence.JobOffer;
import pi.HRSmart.persistence.Stage;

/**
 * Entity implementation class for Entity: Rewards
 *
 * @author Khaled Romdhane
 *
 */

@Entity

public class Rewards implements Serializable {

	   

	private int id;
	private int value;
	private JobOffer jobOffer;
	private static final long serialVersionUID = 1L;

	private List<Postulation> postulations;

	public Rewards() {
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
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@ManyToOne
	public JobOffer getJobOffer() {
		return jobOffer;
	}
	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}

	@OneToMany(mappedBy = "reward")
	public List<Postulation> getPostulations() {
		return postulations;
	}

	public void setPostulations(List<Postulation> postulations) {
		this.postulations = postulations;
	}
}
