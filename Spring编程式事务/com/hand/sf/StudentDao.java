package com.hand.sf;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDao {

	public void setDataSource(DataSource ds);
	
	public void create(String name,Integer age, Integer marks, Integer year);
	
	public List<StudentMarks> listStudents();
	
}
