package ca.sheridancollege.abokhadr.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.abokhadr.beans.Event;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public List<Event> findAll() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM event";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Event>(Event.class));
	}

	public Event findById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM event WHERE id = :id";
		namedParameters.addValue("id", id);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Event>(Event.class)).get(0);
	}

	public Long save(Event event) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		String query = "INSERT INTO event (title, guests, description, eventDate, eventTime) VALUES(:title, :guests, :description, :eventDate, :eventTime)";
		namedParameters.addValue("title", event.getTitle());
		namedParameters.addValue("guests", event.getGuests());
		namedParameters.addValue("description", event.getDescription());
		namedParameters.addValue("eventDate", event.getEventDate());
		namedParameters.addValue("eventTime", event.getEventTime());
		jdbc.update(query, namedParameters, generatedKeyHolder);
		return (Long) generatedKeyHolder.getKey();
	}

	public void deleteAll() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM event";
		jdbc.update(query, namedParameters);
	}

	public Long count() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT count(*) FROM event";
		return jdbc.queryForObject(query, namedParameters, Long.TYPE);
	}

	public void saveAll(List<Event> eventList) {
		for (Event ev : eventList) {
			save(ev);
		}
	}
	
	public void deleteById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM event WHERE id = :id";
		namedParameters.addValue("id", id);
		jdbc.update(query, namedParameters);
	}
	
	public Long saveById(Event event) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		String query = "INSERT INTO event (title, guests, description, eventDate, eventTime) VALUES(:title, :guests, :description, :eventDate, :eventTime)";
		namedParameters.addValue("title", event.getTitle());
		namedParameters.addValue("guests", event.getGuests());
		namedParameters.addValue("description", event.getDescription());
		namedParameters.addValue("eventDate", event.getEventDate());
		namedParameters.addValue("eventTime", event.getEventTime());
		jdbc.update(query, namedParameters, generatedKeyHolder);
		return (Long) generatedKeyHolder.getKey();
	}
	
}
