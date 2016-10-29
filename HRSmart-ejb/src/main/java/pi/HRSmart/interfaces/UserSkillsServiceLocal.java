package pi.HRSmart.interfaces;

import java.util.List;

import javax.ejb.Local;

import pi.HRSmart.persistence.UserSkill;


@Local
public interface UserSkillsServiceLocal {
	public void add(UserSkill userSkill);
	 public void update(UserSkill userSkill);
	 public void remove(UserSkill userSkill);
	 public UserSkill get(int id);
	 public List<UserSkill> getAll();
	 public List<UserSkill> getByUser(int id);
}
