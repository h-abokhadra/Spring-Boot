package ca.sheridancollege.abokhadr.database;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.sheridancollege.abokhadr.beans.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase

public class TestDatabaseAccess {

	@Autowired
	private DatabaseAccess da;

	@Test
	public void TestGetEventsList() {

		Assert.assertTrue(da.findAll().size() > 0);

	}
	


	

}
