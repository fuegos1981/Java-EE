package oracle.academy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import oracle.academy.model.Role;
import oracle.academy.model.User;

@Controller
public class UserController {

		@SuppressWarnings("resource")
		@RequestMapping(value="/addUser", method= RequestMethod.POST)
		public String gotoaddUser(@RequestParam("firstName") String firstName,
				@RequestParam("lastName") String lastName,
				@RequestParam("age") int age,
				@RequestParam("role") String role, Model model){
			User  user= new User();
			user.setFirstName(firstName);
			System.out.println(user.getFirstName());
			user.setLastName(lastName);
			user.setAge(age);
			if (role == "user"){
				user.setRole(Role.USER);
			}
			else if (role == "admin"){
				user.setRole(Role.ADMIN);
			}
			else if (role == "Super admin"){
				user.setRole(Role.SUPER_ADMIN);
			}
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("webContext.xml");
			UserDaoImp userDaoImp = (UserDaoImp) applicationContext.getBean("UserDaoImp");
			userDaoImp.create(user);
			List<User> list = (List<User>) userDaoImp.userMap.values();
			model.addAttribute("list",list);
			return "userList";

}

}