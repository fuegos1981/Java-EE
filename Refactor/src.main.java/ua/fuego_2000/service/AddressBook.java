package ua.fuego_2000.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ua.fuego_2000.dao.PersonDao;
import ua.fuego_2000.daoImp.PersonDb;
import ua.fuego_2000.model.Person;
import ua.fuego_2000.model.PhoneNumber;

public class AddressBook {

	static {
		new Thread().start();
	}

	/**
	 * Returns information that the person with the given name has mobile.
	 */
	public boolean hasMobile(String name) {
		PersonDao personDao = new PersonDb();
		Person person = personDao.findPerson(name);
		if (person != null) {
			if (person.getPhoneNumber().getNumber().startsWith("070")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns count in the book truncated to the given length.
	 */
	public int getSize() {
		PersonDao db = new PersonDb();
		List<Person> people = db.getAll();
		int count = -1;
		if (count < 0) {
			Iterator<Person> n = people.iterator();
			while (n.hasNext()) {
				++count;
			}
		}

		return count;

	}

	/**
	 * Gets the given user's mobile phone number, or null if he doesn't have
	 * one.
	 */
	public String getMobile(String name) {
		PersonDao db = new PersonDb();
		Person person = db.findPerson(name);
		PhoneNumber phone = person.getPhoneNumber();
		return phone.getNumber();
	}

	/**
	 * Returns all names in the book truncated to the given length.
	 */
	public List<String> getNames(int maxLength) {
		PersonDao db = new PersonDb();
		List<Person> people = db.getAll();
		List<String> names = new LinkedList<String>();
		for (Person person : people) {
			String name = person.getName();
			if (name.length() > maxLength) {
				name = name.substring(0, maxLength);
			}
			names.add(name);
		}
		return names;

	}

	/**
	 * Returns all people who have mobile phone numbers.
	 */
	public List<Person> getList() {
		PersonDb db = new PersonDb();
		List<Person> people = db.getAll();
		List<Person> linkedPeople = new LinkedList<Person>();
		for (Person person : people) {
			if (people != null) {
				if (person.getPhoneNumber().getNumber().startsWith("070")) {
					linkedPeople.add(person);
				}
			}
		}
		return linkedPeople;
	}

}
