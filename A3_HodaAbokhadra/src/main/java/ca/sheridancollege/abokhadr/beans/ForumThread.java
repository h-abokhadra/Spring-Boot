package ca.sheridancollege.abokhadr.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForumThread {
	
	private Long threadId;
	private String title;
	private String body;

}
