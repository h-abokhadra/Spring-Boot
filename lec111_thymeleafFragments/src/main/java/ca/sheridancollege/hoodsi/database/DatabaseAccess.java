package ca.sheridancollege.hoodsi.database;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.hoodsi.beans.Student;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DatabaseAccess {

	private NamedParameterJdbcTemplate jdbc;
	
	public void insertStudent(Student student) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	
		String query = "INSERT INTO student(name) VALUES (:name)";
		namedParameters.addValue("name", student.getName());
		
		jdbc.update(query, namedParameters);
	}
	public List<Student> getStudentList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "SELECT * FROM student";
		
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	
}
