package ua.fuego_2000.Dao;

import java.util.List;

import ua.fuego_2000.model.User;



public interface UserDao {
	
	User create(User user);
	User getById(int id);
	boolean delete(User user);
	User update(User user);
	List<User> getAll();
	User getByLogin(String login);
}
