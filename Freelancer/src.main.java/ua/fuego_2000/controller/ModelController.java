package ua.fuego_2000.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.fuego_2000.DTO.TaskChoice;
import ua.fuego_2000.DTO.TaskDTO;
import ua.fuego_2000.model.Role;
import ua.fuego_2000.model.Skill;
import ua.fuego_2000.model.Status;
import ua.fuego_2000.model.Task;
import ua.fuego_2000.service.SkillService;
import ua.fuego_2000.service.TaskService;
import ua.fuego_2000.model.User;
import ua.fuego_2000.service.UserService;

@Controller
public class ModelController<Request> {
	@Autowired
	private SkillService skillService;
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	public ModelController() {
		super();
	}

	/*
	 * @RequestMapping(value="/enter/j_spring_security_check", method=
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody public String gotoEnter(@RequestParam("j_username") String
	 * j_username,
	 * 
	 * @RequestParam("j_password") String j_password){ User user
	 * =userService.getByLogin(j_username); System.out.println(user); if (user
	 * != null){ if(user.getPassword().equals(j_password)){ return j_username; }
	 * } return "";
	 * 
	 * }
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String gotoEnter(Model model) {
		List<Skill> listSkill = skillService.getAll();
		System.out.println(listSkill.size());
		model.addAttribute("listSkill", listSkill);
		return "Registration";
	}

	@RequestMapping(value = "/myRoom", method = RequestMethod.GET)
	public String gotoMyRoom(Model model, SecurityContextHolderAwareRequestWrapper request) {
		List<Task> taskSkill = taskService.getSelTasks(true, "ALL");
		System.out.println(taskSkill.size());
		model.addAttribute("listTask", taskSkill);
		return "MyRoom";
	}

	@RequestMapping(value = "/findTask", method = RequestMethod.GET)
	public String gotoFind(Model model) {

		return "FindTask";

	}

	@RequestMapping(value = "/find/task", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public List<Task> processAjaxRequestGetJSON(@RequestBody TaskChoice taskChoice) {
		List<Task> selListTask = taskService.findTasks(taskChoice);
		return selListTask;

	}

	@RequestMapping(value = "/taskClose", method = RequestMethod.GET)
	@ResponseBody
	public List<TaskDTO> selCloseTable(@RequestParam("status") String statusText) {
		List<TaskDTO> listTaskDto =  new ArrayList<TaskDTO>();
		List<Task> listTask = taskService.getSelTasks(true, statusText);
		for (Task task : listTask) {
			TaskDTO taskDto = new TaskDTO();
			taskDto.setId(task.getId());
			taskDto.setTema(task.getTema()==null?"":task.getTema());
			taskDto.setDescription(task.getDescription());
			taskDto.setPrice(task.getPrice());
			taskDto.setStatus(task.getStatus());
			taskDto.setAutorName(task.getAutor().getName());
			if (task.getPerfomer() ==null){
				taskDto.setPerfomerName("");
			}
			else
			{
				taskDto.setPerfomerName(task.getPerfomer().getName());
			}
			listTaskDto.add(taskDto);
		}
		return listTaskDto;

	}

	@RequestMapping(value = "/allTask", method = RequestMethod.GET)
	public String getAllTasks(Model model) {
		List<Task> listTask = taskService.getAll();
		model.addAttribute("listTask", listTask);
		return "Index";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoMainPage(Model model) {
		List<Task> listTask = taskService.getSelTasks(false, "OPEN");
		model.addAttribute("listTask", listTask);
		return "Index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String gotoMainPage1(Model model) {
		List<Task> listTask = taskService.getSelTasks(false, "OPEN");
		model.addAttribute("listTask", listTask);
		return "Index";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String gotoAddUser(@RequestParam("login") String login, @RequestParam("pas") String pas,
			@RequestParam("personName") String name, @RequestParam("email") String email,
			@RequestParam("type") String type, @RequestParam("checkSkill") List<String> checkSkill, Model model) {
		User user = new User();
		user.setLogin(login);
		user.setName(name);
		user.setPassword(pas);
		user.setEmail(email);
		user.setRole(Role.valueOf(type));
		List<Skill> listSkill = skillService.getAll();
		Set<Skill> userSkill = new HashSet<Skill>();
		for (String nameSkill : checkSkill) {
			boolean isSkill = false;
			for (Skill skill : listSkill) {
				if (nameSkill.equals(skill.getName())) {
					userSkill.add(skill);
					isSkill = true;
					continue;
				}

			}
			if (isSkill == false) {
				Skill newSkill = new Skill();
				newSkill.setName(nameSkill);
				skillService.create(newSkill);
				userSkill.add(newSkill);
			}
		}
		user.setSkills(userSkill);
		userService.create(user);
		model.addAttribute("selLogin", user.getLogin());
		return "Index";
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.GET)
	public String gotoNewTask(Model model) {
		return "AddTask";
	}

	@RequestMapping(value = "/addNewTask", method = RequestMethod.POST)
	public String gotoAddTask(@RequestParam("tema") String tema, @RequestParam("description") String description,
			@RequestParam("id") String id, @RequestParam("status") String status,
			@RequestParam("perfomer") String perfomer, @RequestParam("price") String price, Model model) {

		Task task = new Task();
		task.setStatus(Status.valueOf(status));
		if (!perfomer.equals("")) {
			task.setPerfomer(userService.getByLogin(perfomer));
		}
		task.setTema(tema);
		task.setDescription(description);
		task.setPrice(price);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getByLogin(auth.getName());
		task.setAutor(user);
		if (!id.equals("")) {
			task.setId(Integer.parseInt(id));
			taskService.update(task);
		} else {
			taskService.create(task);
		}
		List<Task> listTask = taskService.getSelTasks(true, "OPEN");
		model.addAttribute("listTask", listTask);
		return "MyRoom";
	}

	@RequestMapping(value = "/UpdateTask", method = RequestMethod.GET)
	public String gotoChangeTask(@RequestParam("id") int id, Model model) {
		Task task = taskService.getById(id);
		model.addAttribute("task", task);
		return "AddTask";
	}
}
