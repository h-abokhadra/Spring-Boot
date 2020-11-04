package ca.sheridancollege.abokhadr.database;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.abokhadr.beans.Item;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertItem() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO item(name, link, description, price)"
				+ " VALUES ('Vitamex Blender', 'https://www.amazon.ca/Vitamix-Blender-Professional-Grade-Container-Black/dp/B008H4SLV6 ', 'Vitamix 001372 Blender Professional-Grade Container, Self-Cleaning 64 oz', '559.85')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted Item into database.");
	}

	public void insertItem(Item item) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO item(name, link, description, price)"
				+ "VALUES (:name, :link,:description, :price )";
		namedParameters.addValue("name", item.getName());
		namedParameters.addValue("link", item.getLink());
		namedParameters.addValue("description", item.getDescription());
		namedParameters.addValue("price", item.getPrice());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted Item into database.");
	}

	public List<Item> getItemList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM item";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Item>(Item.class));
	}

	public void deleteItemById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM item WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Deleted item " + id + " from database");
	}

	public void editItemById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "UPDATE item WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("item updated " + id + " from database");
	}

	public List<Item> getItemListById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM item WHERE id = :id";
		namedParameters.addValue("id", id);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Item>(Item.class));
	}

}
