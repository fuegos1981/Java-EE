package ua.fuego_2000.dao;

import java.util.List;

import ua.fuego_2000.model.Person;

public interface PersonDao {
	void addPerson(Person person);

	Person findPerson(String name);

	List<Person> getAll();

}
