package ua.fuego_2000.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.fuego_2000.model.Role;
import ua.fuego_2000.model.Skill;
import ua.fuego_2000.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testContext.xml")
public class TestHibernate {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void testCreate() {
		User user = new User();
		user.setLogin("Vasya");
		user.setName("Petrov");
		user.setRole(Role.AUTOR);
		Set<Skill> skills = new HashSet<Skill>();
		Skill skill1 = new Skill();
		Skill skill2 = new Skill();
		skill1.setName("Oracle");
		skill2.setName("Java");
		skills.add(skill1);
		skills.add(skill2);
		user.setSkills(skills);

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		session.save(skill1);
		session.save(skill2);
		// session.save(user);

		transaction.commit();
		session.close(); /* �� ����������� */
	}
}
