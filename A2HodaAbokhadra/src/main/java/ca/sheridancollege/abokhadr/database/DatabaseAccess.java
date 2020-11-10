package ca.sheridancollege.abokhadr.database;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.abokhadr.beans.Review;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertReview() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO review(name, rating, reviewDateTime, reviewSubject)"
				+ " VALUES ('Emma',  4, '2020-02-19 12:25', 'Gorgeous details combined with a funnier-than-expected screenplay and a wonderful ensemble make this one of the best Jane Austen adaptations in many years.')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted review into database.");
	}

	public void insertReview(Review review) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO review(name, rating, reviewDateTime , reviewSubject)"
				+ "VALUES (:name, :rating, :reviewDateTime, :reviewSubject)";
		namedParameters.addValue("name", review.getName());
		namedParameters.addValue("rating", review.getRating());
		namedParameters.addValue("reviewDateTime", review.getReviewDateTime());
		namedParameters.addValue("reviewSubject", review.getReviewSubject());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted review into database.");
	}

	public List<Review> getReviewList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM review";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Review>(Review.class));
	}

}
