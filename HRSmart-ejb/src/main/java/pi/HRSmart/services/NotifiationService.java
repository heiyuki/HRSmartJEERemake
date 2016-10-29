package pi.HRSmart.services;

import pi.HRSmart.interfaces.INotificationLocal;
import pi.HRSmart.persistence.Notification;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by hadhe on 10/21/2016.
 */
public class NotifiationService implements INotificationLocal {

    EntityManager em;

    @Override
    public void add(Notification notification) {
        em.persist(notification);
    }

    @Override
    public void update(Notification notification) {

    }

    @Override
    public void delete(Notification notification) {

    }

    @Override
    public Notification getNotification(int id) {
        return null;
    }

    @Override
    public List<Notification> getAllNotifications() {
        return null;
    }

}
