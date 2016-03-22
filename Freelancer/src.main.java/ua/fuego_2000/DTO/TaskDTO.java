package ua.fuego_2000.DTO;

import ua.fuego_2000.model.Status;

public class TaskDTO {
	private int id;
	private String tema;
	private String description;
	private String price;
	private Status status;
	private String autorName;
	private String perfomerName;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getAutorName() {
		return autorName;
	}
	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}
	public String getPerfomerName() {
		return perfomerName;
	}
	public void setPerfomerName(String perfomerName) {
		this.perfomerName = perfomerName;
	}
	
	

}
