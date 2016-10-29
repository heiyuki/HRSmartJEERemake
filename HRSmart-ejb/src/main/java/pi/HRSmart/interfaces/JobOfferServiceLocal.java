package pi.HRSmart.interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import pi.HRSmart.persistence.JobOffer;

/**
 * @author Khaled Romdhane
 *
 */

@Remote
public interface JobOfferServiceLocal {
	 void add(JobOffer jobOffer);
	  void update(JobOffer jobOffer);
	  void remove(JobOffer jobOffer);
	  JobOffer get(int id);
	  JobOffer getFull(int id);
	  List<JobOffer> getAll();
}
