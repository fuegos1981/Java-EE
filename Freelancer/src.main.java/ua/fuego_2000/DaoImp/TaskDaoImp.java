package ua.fuego_2000.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.fuego_2000.DTO.TaskChoice;
import ua.fuego_2000.Dao.TaskDao;
import ua.fuego_2000.model.Status;
import ua.fuego_2000.model.Task;
import ua.fuego_2000.model.User;
import ua.fuego_2000.utils.DopUtils;

@Repository
public class TaskDaoImp implements TaskDao {

	public static final String queryStrAllTask = "from Task";
	public static final String queryFindTasks = "from Task as task where task.autor like: selAutor and task.perfomer like :selPerfomer  and (task.description like: selDescription or task.tema like: selDescription)";
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Task create(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.save(task);
		return task;
	}

	@Override
	public Task getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Task task = (Task) session.get(Task.class, id);
		return task;
	}

	@Override
	public boolean delete(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(task);
		return true;
	}

	@Override
	public Task update(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.update(task);
		return task;
	}

	@Override
	public List<Task> getAll() {
		List<Task> taskList = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(queryStrAllTask);
		taskList = (List<Task>) q.list();
		return taskList;
	}

	@Override
	public List<Task> getSelTasks(User user, String status) {
		List<Task> taskList = null;
		String role = "All";
		if (user != null) {
			role = user.getRole().toString();
		}
		Session session = sessionFactory.getCurrentSession();

		String myQueryText = "from Task as task where ";
		String addPeople = "";
		String addStatus = "";
		String addJoin = " and ";
		if (role.equals("AUTOR")) {
			addPeople = " task.autor =:selPeople";
		} else if (role.equals("PERFOMER")) {
			addPeople = " task.perfomer =:selPeople";
		} else {
			addPeople = "";
		}
		if (status.equals("ALL")) {
			addStatus = "";
		} else {
			addStatus = " task.status =:selStatus";
		}
		if (addPeople.equals("") || addStatus.equals("")) {
			addJoin = "";
		}
		String res = myQueryText + addPeople + addJoin + addStatus;
		System.out.println(res);
		Query q = session.createQuery(res);
		if (!addPeople.equals("")) {
			q.setParameter("selPeople", user);
		}
		if (!addStatus.equals("")) {
			q.setParameter("selStatus", Status.valueOf(status));
		}
		taskList = (List<Task>) q.list();

		return taskList;
	}

	@Override
	public List<Task> findTasks(TaskChoice taskChoice) {
		List<Task> taskList = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(queryFindTasks);
		q.setParameter("selAutor", "%"+taskChoice.getAutor()+"%");
		q.setParameter("selPerfomer", "%"+taskChoice.getPerfomer()+"%");
		q.setParameter("selDescription", "%"+taskChoice.getTaskName()+"%");
		taskList = (List<Task>) q.list();
		return taskList;
	}

}
