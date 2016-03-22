package ua.fuego_2000.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MyUserDetails {

	private String login;
	private String password;
	private List<GrantedAuthority> list;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<GrantedAuthority> getList() {
		return list;
	}

	public void setList(List<GrantedAuthority> list) {
		this.list = list;
	}

	public MyUserDetails(String login, String password, List<GrantedAuthority> list) {
		super();
		this.login = login;
		this.password = password;
		this.list = list;
	}

}
