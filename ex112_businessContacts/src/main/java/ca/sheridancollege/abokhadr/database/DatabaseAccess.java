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

	public List<Contact> getStudentList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "SELECT * FROM student";

		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	public void insertStudent(Contact student) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "INSERT INTO student(name) VALUES(:name)";
		namedParameters.addValue("name", student.getName());

		jdbc.update(query, namedParameters);
	}

}
