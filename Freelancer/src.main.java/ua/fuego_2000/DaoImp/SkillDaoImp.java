package ua.fuego_2000.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.fuego_2000.Dao.SkillDao;
import ua.fuego_2000.model.Skill;

@Repository
public class SkillDaoImp implements SkillDao {

	public static final String queryStrAllSkill = "from Skill";
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Skill create(Skill skill) {
		Session session = sessionFactory.getCurrentSession();
		session.save(skill);
		return skill;
	}

	@Override
	public Skill getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Skill skill = (Skill) session.get(Skill.class, id);
		return skill;
	}

	@Override
	public boolean delete(Skill skill) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(skill);
		return true;
	}

	@Override
	public Skill update(Skill skill) {
		Session session = sessionFactory.getCurrentSession();
		session.update(skill);
		return skill;
	}

	@Override
	public List<Skill> getAll() {
		List<Skill> skillList = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(queryStrAllSkill);
		skillList = (List<Skill>) q.list();
		return skillList;
	}
}
