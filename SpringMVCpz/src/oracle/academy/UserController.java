package oracle.academy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import oracle.academy.model.Role;
import oracle.academy.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String gotoMAinPAge(){
		return "addUser";
	}
	
	@RequestMapping(value="/UpdateUser", method= RequestMethod.POST)
	public String gotoUpdatePAge(@RequestParam("id") String id,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") String age,
			@RequestParam("email") String email,
			@RequestParam("role") String role, Model model){
		User user = new User();
		user = userDao.getById(Long.parseLong(id));
		System.out.println("ghhg = "+firstName);
		user.setFirstName(firstName);
		user.setAge(Integer.parseInt(age));
		user.setLastName(lastName);
		user.setRole(getRoleFromString(role));
		user.setEmail(email);
		userDao.update(user);
		List<User> list = (List<User>) userDao.getAll();
		model.addAttribute("list",list);
		return "userList";
	}
	@RequestMapping(value="/DeleteUser", method= RequestMethod.GET)
	public String gotoDeletePage(@RequestParam("id") long id, Model model){
		User user = new User();
		user = userDao.getById(id);
		userDao.delete(user);
		List<User> list = (List<User>) userDao.getAll();
		model.addAttribute("list",list);
		return "userList";
	}
	
		@RequestMapping(value="/addUser", method= RequestMethod.POST)
		public String gotoaddUser(@RequestParam("firstName") String firstName,
				@RequestParam("lastName") String lastName,
				@RequestParam("email") String email,
				@RequestParam("age") int age,
				@RequestParam("role") String role, Model model){
			User  user= new User();
			user.setFirstName(firstName);
			System.out.println(user.getFirstName());
			user.setLastName(lastName);
			user.setAge(age);
			user.setEmail(email);
			user.setRole(getRoleFromString(role));
		
			userDao.create(user);
			List<User> list = (List<User>) userDao.getAll();
			model.addAttribute("list",list);
			return "userList";

}
	public static Role getRoleFromString(String  roleString) {
		if (roleString == "user"){
			return Role.USER;
		}
		else if (roleString == "admin"){
			return Role.ADMIN;
		}
		else if (roleString == "Super admin"){
			return Role.SUPER_ADMIN;
		}
		return Role.USER;
				
	}	
		

}