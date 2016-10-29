package pi.HRSmart.interfaces;

import pi.HRSmart.persistence.Notification;

import java.util.List;

import javax.ejb.Local;

/**
 * Created by hadhe on 10/17/2016.
 */
@Local
public interface INotificationLocal {

    void add(Notification notification);
    void update(Notification notification);
    void delete(Notification notification);
    Notification getNotification(int id);
    List<Notification> getAllNotifications();
}
