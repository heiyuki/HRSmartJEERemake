package pi.HRSmart.services;

import javax.crypto.ExemptionMechanismException;
import javax.ejb.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pi.HRSmart.interfaces.UserBuisnessServiceLocal;
import pi.HRSmart.interfaces.UserServiceLocal;
import pi.HRSmart.interfaces.UserSkillsServiceLocal;
import pi.HRSmart.persistence.User;
import pi.HRSmart.utilities.getMD5Hash;

/**
 * Session Bean implementation class UserService
 */
@Stateless

public class UserService implements UserServiceLocal {

	@PersistenceContext(unitName = "HRSmart-ejb")
	EntityManager em;
	@EJB(beanName = "UserSkillsService")
	UserSkillsServiceLocal userSkillServiceLocal;

	@EJB(beanName = "UserBuisnessService")
	UserBuisnessServiceLocal userBuisnessServiceLocal;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User get(int id) {

		return em.find(User.class, id);
	}

	@Override
	public User getFull(int id) {
		User user = em.find(User.class, id);
		user.setUserSkills(userSkillServiceLocal.getByUser(id));
		user.setUserBuisness(userBuisnessServiceLocal.getByUser(user));
		return user;
	}

	@Override
	public boolean update(User user) {
		return false;
	}

	@Override
	public boolean delete(User user) {

		return false;
	}

	@Override
	public User authenticate(String Login, String password) {
		try {
			TypedQuery<User> query =
					em.createQuery("select e from User e where e.login=:login and e.password=:password", User.class);

			query.setParameter("login", "login");
			query.setParameter("password", "password");
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean checkConnectedUser(User userToVerify) {


		return false;
	}

	@Override
	public User getUserByEmail(String login) {
		try {
			TypedQuery<User> Myquery =
					em.createQuery("select e from User e where e.login=:login", User.class);

			Myquery.setParameter("login", "login");
			return Myquery.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String addUser(User user) {
		try {
			String beforeHash =  user.getPassword();
			user.setPassword(getMD5Hash.getMD5Hash(beforeHash));
			em.persist(user);

			return "adddone";
		}
		catch(Exception e) {
			return "userexists";
		}
	}

	//public void inviteUser (User userEmailToAdd,)




}


