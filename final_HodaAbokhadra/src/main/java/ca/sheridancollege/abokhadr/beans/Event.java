package ca.sheridancollege.abokhadr.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Event {

	private Long id;
	private String title;
	private String guests;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate eventDate;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime eventTime;
	

	
	
}
