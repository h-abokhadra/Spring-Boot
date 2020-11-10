package ca.sheridancollege.abokhadr.database;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.sheridancollege.abokhadr.beans.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class TestDatabaseAccess {

	@Autowired
	private DatabaseAccess da;
	
	@Test
	public void goodInsertStudent_getStudents() {
		
		// setup
		Student student = new Student();
		student.setName("Jaspreet");
		// when
		da.insertStudent(student);
		// then (the actual test!)
		Assert.assertTrue(da.getStudentList().size() > 0);
	}
	
	@Test
	public void badInsertStudent_getStudents() {
		
		// setup
		Student student = new Student();
		student.setName(null);
		// when
		da.insertStudent(student);
		// then (the actual test!)
		Assert.assertFalse(da.getStudentList().size() > 5);
	}
}
