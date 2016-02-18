package oracle.academy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.academy.model.User;



public class UserDaoImp implements UserDao {
	Map<Long, User> userMap = new HashMap<Long, User>();
	
	public UserDaoImp() {
		super();
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		Set<Long> setId = userMap.keySet();
		long maxId =(long) Collections.max(setId); 
		user.setId(maxId+1);
		userMap.put(user.getId(), user);
		return user;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> list = (List<User>) userMap.values();
		return list;
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return userMap.get(id);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		userMap.put(user.getId(), user);
		return user;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return userMap.remove(user.getId(), user);
	}

}