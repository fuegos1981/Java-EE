package oracle.academy;

import java.util.List;

import oracle.academy.model.User;

public interface UserDao {

	User create(User user);
	User getById(Long id);
	boolean delete(User user);
	User update(User user);
	List<User> getAll();

}
