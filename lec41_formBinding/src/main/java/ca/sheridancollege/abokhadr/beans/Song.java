package ca.sheridancollege.abokhadr.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Song {
	
	private Long id;
	private String title;
	private String artist;
	private String genre;
	
	private final String[] genres = {"Spoken Word", "Electronic", "Country", "Classical", "Indie"};
	
}
