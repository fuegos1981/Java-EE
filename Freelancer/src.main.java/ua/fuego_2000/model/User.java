package ua.fuego_2000.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "login", length = 20)
	private String login;
	@Column(name = "password", length = 10)
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "timeCreate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeCreate;
	@ManyToMany
	@JoinTable(name = "user_skill", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SKILL_ID") })
	private Set<Skill> skills;
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY/*
															 * ,cascade =
															 * javax.persistence
															 * .CascadeType.
															 * MERGE
															 */)
	private Set<Task> taskAutors;

	@OneToMany(mappedBy = "perfomer", fetch = FetchType.LAZY/*
															 * ,cascade =
															 * javax.persistence
															 * .CascadeType.
															 * MERGE
															 */)
	private Set<Task> taskPerfomers;

	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY/*
															 * ,cascade =
															 * javax.persistence
															 * .CascadeType.
															 * MERGE
															 */)
	private Set<Correspondence> correspondences;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public Set<Task> getTaskAutors() {
		return taskAutors;
	}

	public void setTaskAutors(Set<Task> taskAutors) {
		this.taskAutors = taskAutors;
	}

	public Set<Task> getTaskPerfomers() {
		return taskPerfomers;
	}

	public void setTaskPerfomers(Set<Task> taskPerfomers) {
		this.taskPerfomers = taskPerfomers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Correspondence> getCorrespondences() {
		return correspondences;
	}

	public void setCorrespondences(Set<Correspondence> correspondences) {
		this.correspondences = correspondences;
	}

	public User() {
		super();
	}

}
