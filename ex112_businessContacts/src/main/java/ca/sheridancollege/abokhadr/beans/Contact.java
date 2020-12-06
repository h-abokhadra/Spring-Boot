package ca.sheridancollege.abokhadr.beans;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {

	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private LocalDate birthday;
	
	
	
	
}
