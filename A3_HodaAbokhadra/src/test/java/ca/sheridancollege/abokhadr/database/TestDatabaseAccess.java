package ca.sheridancollege.abokhadr.database;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.sheridancollege.abokhadr.beans.Comment;
import ca.sheridancollege.abokhadr.beans.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase

public class TestDatabaseAccess {

	@Autowired
	private DatabaseAccess da;

	@Test
	public void whenInsertComment_getComments() {

		Comment comment = new Comment();
		comment.setUserName("Yehia");
		comment.setSubject("Cool Topic");
		comment.setCommentDateTime(comment.getCommentDateTime());
		comment.setThreadId(1L);
		da.insertComment(comment);
		Assert.assertTrue(da.getCommentListByThreadId(comment.getThreadId()).size() > 0);

	}

	@Test
	public void TestGetThreadList() {

		Assert.assertTrue(da.getThreadList().size() > 0);

	}

	@Test
	public void TestGetThreadListById() {

		Assert.assertFalse(da.getThreadList().size() < 0);

	}

}
