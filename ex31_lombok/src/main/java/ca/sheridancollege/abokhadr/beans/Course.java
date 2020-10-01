package ca.sheridancollege.abokhadr.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data

@Builder

public class Course {

	@NonNull
	private Long id;
	private String prefix;
	private int code;
	private String name;

}