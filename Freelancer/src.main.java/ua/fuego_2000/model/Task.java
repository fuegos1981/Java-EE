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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TASKS")
public class Task {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "tema", length = 100)
	private String tema;
	@Column(name = "description", length = 300)
	private String description;
	@Column(name = "price")
	private String price;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date time_create;

	@Column
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	private User autor;
	@ManyToOne
	@JoinColumn(name = "PERFOMER_ID")
	private User perfomer;
	@OneToMany(mappedBy = "task", fetch = FetchType.LAZY/*
														 * ,cascade =
														 * javax.persistence.
														 * CascadeType.MERGE
														 */)
	private Set<Correspondence> correspondences;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getTime_create() {
		return time_create;
	}

	public void setTime_create(Date time_create) {
		this.time_create = time_create;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getAutor() {
		return autor;
	}

	public void setAutor(User autor) {
		this.autor = autor;
	}

	public User getPerfomer() {
		return perfomer;
	}

	public void setPerfomer(User perfomer) {
		this.perfomer = perfomer;
	}

	public Set<Correspondence> getCorrespondences() {
		return correspondences;
	}

	public void setCorrespondences(Set<Correspondence> correspondences) {
		this.correspondences = correspondences;
	}

	public Task() {
		super();
	}

}
