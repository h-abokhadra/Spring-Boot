package ca.sheridancollege.abokhadr.beans;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class VideoGame {
	
	private Long id;
	private String title;
	private String publisher;
	private String platform;
	String[] platforms = {"Xbox", "Playstation", "Nintendo"};
	private BigDecimal price;

	

}
