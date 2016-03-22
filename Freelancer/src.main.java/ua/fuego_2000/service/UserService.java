package ua.fuego_2000.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.fuego_2000.Dao.UserDao;
import ua.fuego_2000.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public User create(User user) {
		user.setTimeCreate(new Date(System.currentTimeMillis()));
		userDao.create(user);
		return user;
	}

	@Transactional(readOnly = true)
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Transactional(readOnly = true)
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Transactional
	public void delete(int id) {

		userDao.delete(userDao.getById(id));
	}

	@Transactional
	public User update(User user) {
		return userDao.update(user);
	}

	@Transactional(readOnly = true)
	public User getByLogin(String login) {
		return userDao.getByLogin(login);
	}

}
