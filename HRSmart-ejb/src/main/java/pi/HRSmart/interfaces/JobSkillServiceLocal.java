package pi.HRSmart.interfaces;

import java.util.List;

import javax.ejb.Local;

import pi.HRSmart.persistence.JobOffer;
import pi.HRSmart.persistence.JobSkill;
import pi.HRSmart.persistence.Skill;

/**
 * @author Khaled Romdhane
 *
 */

@Local
public interface JobSkillServiceLocal {
	
	 void add(JobSkill jobSkill);
	 void update(JobSkill jobSkill);
	 void remove(JobSkill jobSkill);
	 JobSkill get(int id);
	 List<JobSkill> getAll();
	List<JobSkill> getByJob(JobOffer jobOffer);


}
