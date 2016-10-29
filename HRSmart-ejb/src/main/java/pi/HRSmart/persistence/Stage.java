package pi.HRSmart.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stage
 *
 * @author Khaled Romdhane
 *
 */

@Entity

public class Stage implements Serializable {

	   
	
	private int id;
	private String name;
	private Buisness buisness;
	private static final long serialVersionUID = 1L;
	
	public Stage() {
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
	public Buisness getBuisness() {
		return buisness;
	}
	public void setBuisness(Buisness buisness) {
		this.buisness = buisness;
	}
}
