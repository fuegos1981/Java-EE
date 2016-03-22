package ua.fuego_2000.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.fuego_2000.DTO.TaskChoice;
import ua.fuego_2000.Dao.TaskDao;
import ua.fuego_2000.model.Status;
import ua.fuego_2000.model.Task;
import ua.fuego_2000.model.User;

@Service
public class TaskService {
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserService userService;

	@Transactional
	public Task create(Task task) {
		task.setTime_create(new Date(System.currentTimeMillis()));
		task.setStatus(Status.OPEN);
		taskDao.create(task);
		return task;
	}

	@Transactional(readOnly = true)
	public List<Task> getAll() {
		return taskDao.getAll();
	}

	@Transactional(readOnly = true)
	public List<Task> getSelTasks(boolean withUser, String status) {
		User user = null;
		if (withUser) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			user = userService.getByLogin(auth.getName());
		}

		return taskDao.getSelTasks(user, status);
	}
	
	@Transactional(readOnly = true)
	public List<Task> findTasks(TaskChoice taskChoice) {
		

		return taskDao.findTasks(taskChoice);
	}

	@Transactional(readOnly = true)
	public Task getById(int id) {
		return taskDao.getById(id);
	}

	@Transactional
	public void delete(int id) {

		taskDao.delete(taskDao.getById(id));
	}

	@Transactional
	public Task update(Task task) {
		return taskDao.update(task);
	}
}
