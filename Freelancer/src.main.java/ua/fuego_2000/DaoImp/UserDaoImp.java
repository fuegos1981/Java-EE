package ua.fuego_2000.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.fuego_2000.Dao.UserDao;
import ua.fuego_2000.model.User;

@Repository
public class UserDaoImp implements UserDao {
	public static final String queryStrAllUsers = "from User as user";
	public static final String queryStrUserByLogin = "from User as user where user.login =:login";
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User create(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	@Override
	public User getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Override
	public boolean delete(User user) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
		return true;
	}

	@Override
	public User update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		List<User> userList = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(queryStrAllUsers);
		userList = (List<User>) q.list();

		return userList;
	}

	@Override
	public User getByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(queryStrUserByLogin);
		q.setParameter("login", login);
		List<User> userList = (List<User>) q.list();
		if (userList.size() == 1) {
			return userList.get(0);
		}
		return null;
	}

}
