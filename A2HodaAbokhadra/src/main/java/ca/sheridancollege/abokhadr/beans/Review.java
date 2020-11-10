package ca.sheridancollege.abokhadr.beans;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Review {

	private Long id;
	private String name;
	private Double rating;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime reviewDateTime;
	private String reviewSubject;

}
