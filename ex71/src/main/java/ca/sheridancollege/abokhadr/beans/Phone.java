package ca.sheridancollege.abokhadr.beans;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Phone {
	
	private Long id;
	private String model;
	private BigDecimal price;
	

}
