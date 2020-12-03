package ca.sheridancollege.hoodsi.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Student {

	private Long id;
	@NonNull
	private String name;
	private Boolean admin;
	
}
