package ca.sheridancollege.abokhadr.database;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.abokhadr.beans.Appointment;
import ca.sheridancollege.abokhadr.beans.User;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DatabaseAccess {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public User findUserAccount(String email) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user where email = :email";
		parameters.addValue("email", email);
		
		ArrayList<User> userList = (ArrayList<User>) jdbc.query(query, parameters, new
		BeanPropertyRowMapper<User>(User.class));
		if (userList.size() > 0) return userList.get(0);
		else return null;
	}
	
	public List<String> getRolesById(Long userId) {
		
		ArrayList<String> roleList = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT user_role.userId, sec_role.roleName "
		+ "FROM user_role, sec_role "
		+ "WHERE user_role.roleId = sec_role.roleId "
		+ "AND userId = :userId";	
		
		parameters.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
		roleList.add((String)row.get("roleName"));
		}
		return roleList;
	}
	
	public void addUser(String email, String password) {
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO sec_user "
		+ "(email, encryptedPassword, enabled)"
		+ " VALUES (:email, :encryptedPassword, 1)";
		parameters.addValue("email", email);
		parameters.addValue("encryptedPassword", passwordEncoder.encode(password));
		jdbc.update(query, parameters);
	}
	
	public void addRole(Long userId, Long roleId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO user_role (userId, roleId)"
		+ " VALUES (:userId, :roleId)";
		parameters.addValue("userId", userId);
		parameters.addValue("roleId", roleId);
		jdbc.update(query, parameters);
		}
	
	public void insertAppointment(Appointment appointment) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO appointment(firstName, email, appointmentDate, appointmentTime)"
				+ "VALUES (:firstName, :email, :appointmentDate, :appointmentTime)";
		namedParameters.addValue("firstName", appointment.getFirstName());
		namedParameters.addValue("email", appointment.getEmail());
		namedParameters.addValue("appointmentDate", appointment.getAppointmentDate().now());
		namedParameters.addValue("appointmentTime", appointment.getAppointmentTime().now());
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
