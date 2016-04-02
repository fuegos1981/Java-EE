package ua.fuego_2000.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ua.fuego_2000.dao.PersonDao;
import ua.fuego_2000.model.Person;
import ua.fuego_2000.model.PhoneNumber;

public class PersonDb implements PersonDao {
	private static final String url = "jdbc:oracle:thin:@prod";
	private static final String user = "admin";
	private static final String password = "beefhead";
	private static final String SQl_Insert = "insert into AddressEntry values (?, ?, ?)";
	private static final String SQl_Select = "select * from AddressEntry where name =?";

	public PersonDb() {
		try {
			Class.forName("oracle.jdbc.ThinDriver");
		} catch (ClassNotFoundException e) {
		}

		new Thread().start();
	}

	/**
	 * Add person in database.
	 */
	@Override
	public void addPerson(Person person) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.prepareStatement(SQl_Insert);
			statement.setLong(1, System.currentTimeMillis());
			statement.setString(2, person.getName());
			statement.setString(3, person.getPhoneNumber().getNumber());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException err) {
					throw new RuntimeException(err);
				}
			}
		}
	}

	/**
	 * Looks up the given person, null if not found.
	 */
	@Override
	public Person findPerson(String name) {
		Connection connection = null;
		try {
			ResultSet result;
			PreparedStatement statement;
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.prepareStatement(SQl_Select);
			statement.setString(1, name);
			result = statement.executeQuery();
			if (result.next()) {
				String foundName = result.getString("name");
				PhoneNumber phoneNumber = new PhoneNumber(result.getString("phoneNumber"));
				Person person = new Person(foundName, phoneNumber);
				return person;
			} else {
				return new Person("", null);
			}
		} catch (SQLException e) {
			return null;
		} catch (IllegalArgumentException x) {
			throw x;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException err) {
					throw new RuntimeException(err);
				}
			}
		}
	}

	/**
	 * Get all people from Database.
	 */
	@Override
	public List<Person> getAll() {
		Connection connection = null;
		try {
			ResultSet result;
			PreparedStatement statement;
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.prepareStatement("select * from AddressEntry");

			result = statement.executeQuery();
			List<Person> entries = new LinkedList<Person>();
			while (result.next()) {
				String name = result.getString("name");
				PhoneNumber phoneNumber = new PhoneNumber(result.getString("phoneNumber"));
				Person person = new Person(name, phoneNumber);
				entries.add(person);
			}
			result.close();
			statement.close();
			connection.close();
			return entries;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException err) {
					throw new RuntimeException(err);
				}
			}
		}
	}

}
