package ca.sheridancollege.abokhadr.beans;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {
	
	private Long id;
	private String userName;
	private String subject;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime commentDateTime;
	private Long threadId;
	

}
