package ca.sheridancollege.abokhadr.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.abokhadr.beans.Comment;
import ca.sheridancollege.abokhadr.beans.ForumThread;
import ca.sheridancollege.abokhadr.beans.User;

@Repository
public class DatabaseAccess {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public User findUserAccount(String email) {

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user where email = :email";
		parameters.addValue("email", email);

		ArrayList<User> userList = (ArrayList<User>) jdbc.query(query, parameters,
				new BeanPropertyRowMapper<User>(User.class));
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	public List<String> getRolesById(Long userId) {

		ArrayList<String> roleList = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT user_role.userId, sec_role.roleName " + "FROM user_role, sec_role "
				+ "WHERE user_role.roleId = sec_role.roleId " + "AND userId = :userId";

		parameters.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
			roleList.add((String) row.get("roleName"));
		}
		return roleList;
	}

	public void addUser(String email, String password) {

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO sec_user " + "(email, encryptedPassword, enabled)"
				+ " VALUES (:email, :encryptedPassword, 1)";
		parameters.addValue("email", email);
		parameters.addValue("encryptedPassword", passwordEncoder.encode(password));
		jdbc.update(query, parameters);
	}

	public void addRole(Long userId, Long roleId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO user_role (userId, roleId)" + " VALUES (:userId, :roleId)";
		parameters.addValue("userId", userId);
		parameters.addValue("roleId", roleId);
		jdbc.update(query, parameters);
	}

	public void insertComment(Comment comment) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO comment(userName, subject, commentDateTime, threadId)"
				+ "VALUES (:userName, :subject, :commentDateTime, :threadId)";
		namedParameters.addValue("userName", comment.getUserName());
		namedParameters.addValue("subject", comment.getSubject());
		namedParameters.addValue("commentDateTime", comment.getCommentDateTime());
		namedParameters.addValue("threadId", comment.getThreadId());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted Comment into database.");
	}

	public List<Comment> getCommentListByThreadId(Long threadId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM comment WHERE threadId = :threadId";
		namedParameters.addValue("threadId", threadId);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Comment>(Comment.class));
	}

	public List<ForumThread> getThreadListById(Long threadId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM thread WHERE threadId = :threadId";
		namedParameters.addValue("threadId", threadId);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<ForumThread>(ForumThread.class));
	}

	public List<ForumThread> getThreadList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM thread";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<ForumThread>(ForumThread.class));
	}

}
