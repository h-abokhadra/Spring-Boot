package ca.sheridancollege.abokhadr.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Appointment {

	private Long id;
	private String firstName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate = LocalDate.now();
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime appointmentTime = LocalTime.now();
}
