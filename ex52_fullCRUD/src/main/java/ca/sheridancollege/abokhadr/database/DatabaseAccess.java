package ca.sheridancollege.abokhadr.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.abokhadr.beans.Appointment;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertAppointment() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO appointment(firstName, email,  appointmentDate, appointmentTime)"
				+ " VALUES ('Hoda', 'hoda.abokhadra90@gmail.com ', '2020-02-19', '02:19')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted Appointment into database.");
	}

	public void insertAppointment(Appointment appointment) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO appointment(firstName, email, appointmentDate, appointmentTime)"
				+ "VALUES (:firstName, :email, :appointmentDate, :appointmentTime)";
		namedParameters.addValue("firstName", appointment.getFirstName());
		namedParameters.addValue("email", appointment.getEmail());
		namedParameters.addValue("appointmentDate", appointment.getAppointmentDate());
		namedParameters.addValue("appointmentTime", appointment.getAppointmentTime());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted Appointment into database.");
	}

	public List<Appointment> getAppointmentList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM appointment";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Appointment>(Appointment.class));
	}

	public void deleteAppointmentById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM appointment WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Deleted appointment " + id + " from database");
	}

	public void editAppointmentById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "UPDATE appointment WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("appointment updated " + id + " from database");
	}

	public List<Appointment> getAppointmentListById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM appointment WHERE id = :id";
		namedParameters.addValue("id", id);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Appointment>(Appointment.class));
	}

}
