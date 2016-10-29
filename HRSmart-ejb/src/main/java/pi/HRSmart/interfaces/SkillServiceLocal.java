package pi.HRSmart.interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import pi.HRSmart.persistence.JobSkill;
import pi.HRSmart.persistence.Skill;
/**
 * @author Khaled Romdhane
 *
 */

@Local
public interface SkillServiceLocal {
	
	 void add(Skill skill);
	 void update(Skill skill);
	 void remove(Skill skill);
	 Skill get(int id);
	 List<Skill> getAll();

}
