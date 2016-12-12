package com.hand.sf;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMarksMapper implements RowMapper<StudentMarks>{

	@Override
	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentMarks sm = new StudentMarks();
		sm.setId(rs.getInt(1));
		sm.setName(rs.getString(2));
		sm.setAge(rs.getInt(3));
		sm.setSid(rs.getInt(4));
		sm.setMarks(rs.getInt(5));
		sm.setYear(rs.getInt(6));
		return sm;
	}

}
