  
package ca.sheridancollege.abokhadr.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//POJO
public class Course {

	@NonNull
	private Long id;
	private String prefix;
	private String code;
	private String name;

}