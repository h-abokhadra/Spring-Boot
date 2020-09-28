package ca.sheridancollege.abokhadr.repositories;

import java.util.List;

import ca.sheridancollege.abokhadr.beans.Course;

public interface CourseList {
	
	public List<Course> getCourseList();
	
	public void setCourseList(List<Course> courseList);
	
	public void emptyList();
	
	
	

}
