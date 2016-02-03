package ua.fuego_2000;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name","price", "category", "description"})
public class Good {
	private String name;
	private double price;
	private String category;
	private String description;
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public Good(String name, double price, String category, String description, int id) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
		this.id = id;
	}
	public Good() {
		super();
	}
	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	@XmlElement
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Good [name=" + name + ", price=" + price + ", category=" + category + ", description=" + description
				+ ", id=" + id + "]";
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	private int id;
}
