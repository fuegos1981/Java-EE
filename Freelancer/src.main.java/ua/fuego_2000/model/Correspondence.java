package ua.fuego_2000.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CORRESPONDENCE")
public class Correspondence {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "TASK_ID")
	private Task task;
	@Column(name = "message", length = 300)
	private String message;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date time_create;

	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	private User autor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime_create() {
		return time_create;
	}

	public void setTime_create(Date time_create) {
		this.time_create = time_create;
	}

	public User getAutor() {
		return autor;
	}

	public void setAutor(User autor) {
		this.autor = autor;
	}

	public Correspondence() {
		super();
	}

}
