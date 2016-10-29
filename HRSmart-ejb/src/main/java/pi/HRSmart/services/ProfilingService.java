package pi.HRSmart.services;

import pi.HRSmart.interfaces.*;
import pi.HRSmart.persistence.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by BoB on 10/18/2016.
 */
@Stateless

public class ProfilingService implements ProfilingServiceLocal {

    @PersistenceContext(unitName="HRSmart-ejb")
    EntityManager em;

    @EJB(beanName = "RewardService")
    RewardServiceLocal rewardServiceLocal;
    @EJB(beanName = "UserService")
    UserServiceLocal userServiceLocal;




    @Override
    public void Profile(JobOffer jobOffer) {

        List<JobSkill> jobSkills = jobOffer.getJobSkills();
        List<Skill> skillSet = jobSkills.stream().map(e -> e.getSkill()).collect(Collectors.toList());
        List<Postulation> ps = rewardServiceLocal.getCVStage(jobOffer.getId()).getPostulations();
        List<User> postulants = ps.stream().map(e->
            userServiceLocal.getFull(e.getPostulant().getId())).collect(Collectors.toList());

        Map<User,Integer> scoredList = new HashMap<>();
        postulants.forEach(e->scoredList.put(e,0));



    }

    @Override
    public Map<User, Integer> Score(Map<User, Integer> scored) {




        return null;
    }
}
