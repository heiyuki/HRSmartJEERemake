package pi.HRSmart.persistence;

import javax.persistence.*;

/**
 * Created by hadhe on 10/17/2016.
 */
@Entity
public class Notification {

    private int id;
    private User user;
    private String notificationText;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}
    
    
}
