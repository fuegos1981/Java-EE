package ua.fuego_2000.Dao;

import java.util.List;

import ua.fuego_2000.DTO.TaskChoice;
import ua.fuego_2000.model.Task;
import ua.fuego_2000.model.User;

public interface TaskDao {

	Task create(Task task);
	Task getById(int id);
	boolean delete(Task task);
	Task update(Task task);
	List<Task> getAll();
	List<Task> getSelTasks(User user,  String status);
	List<Task> findTasks(TaskChoice taskChoice);
}
