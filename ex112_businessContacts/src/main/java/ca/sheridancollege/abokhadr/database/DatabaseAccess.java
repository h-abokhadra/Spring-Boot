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
	private NamedParameterJdbcTemplate jdbc;

	public List<Contact> getContactList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "SELECT * FROM contact";

		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	public void insertContact(Contact contact) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "INSERT INTO contact(firstName) VALUES(:firstName)";
		namedParameters.addValue("name", contact.getFirstName());

		jdbc.update(query, namedParameters);
	}

}
