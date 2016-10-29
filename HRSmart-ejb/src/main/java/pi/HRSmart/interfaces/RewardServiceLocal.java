package pi.HRSmart.interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import pi.HRSmart.persistence.Rewards;
import pi.HRSmart.persistence.Skill;
/**
 * @author Khaled Romdhane
 *
 */

@Local
public interface RewardServiceLocal {
	
	 void add(Rewards reward);
	 void update(Rewards reward);
	 void remove(Rewards reward);
	 Rewards get(int id);
	 List<Rewards> getAll();

	 List<Rewards> getByJob(int jobId);
	Rewards getCVStage(int jobId);

}
