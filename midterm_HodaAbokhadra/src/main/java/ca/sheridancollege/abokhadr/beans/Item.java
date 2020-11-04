package ca.sheridancollege.abokhadr.beans;

import java.math.BigDecimal;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

	private Long id;
	private String name;
	private String link;
	private String description;
	private BigDecimal price;

}
