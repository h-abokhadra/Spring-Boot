package ca.sheridancollege.abokhadr.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.abokhadr.beans.Contact;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DatabaseAccess {

	@Autowired
	NamedParameterJdbcTemplate jdbc;

	public List<Contact> getContactList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "SELECT * FROM contact";

		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	public void insertContact(Contact contact) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO contact (firstName, lastName, phoneNumber, birthday)"
				+ "VALUES (:firstName, :lastName, :phoneNumber, :birthday )";
		namedParameters.addValue("firstName", contact.getFirstName());
		namedParameters.addValue("lastName", contact.getLastName());
		namedParameters.addValue("phoneNumber", contact.getPhoneNumber());
		namedParameters.addValue("birthday", contact.getBirthday());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted Contact into database.");
	}
	

	public void deleteContactById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM contact WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Deleted Contact " + id + " from database");
	}

	public void editContactById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "UPDATE contact WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Contact updated " + id + " from database");
	}

	public List<Contact> getContactListById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM contact WHERE id = :id";
		namedParameters.addValue("id", id);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

}
