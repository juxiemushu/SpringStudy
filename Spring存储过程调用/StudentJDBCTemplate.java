package com.hand.sf;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDao{

	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
		this.jdbcCall = new SimpleJdbcCall(ds).withProcedureName("getRecord");
		
	}

	@Override
	public void create(String name, Integer age) {
		String sql = "insert into Student (name,age) values(?,?)";
		jdbcTemplateObject.update(sql, name, age);
		System.out.println("Created Record Name="+name+" Age="+age);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
	//	String sql = "select * from Student where id = ?";
	//	Student student = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new StudentMapper());
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		Map<String,Object> out = jdbcCall.execute(in);
		Student student =new Student();
		student.setId(id);
		student.setName((String)out.get("out_name"));
		student.setAge((Integer)out.get("out_age"));
		return student;
	}

	@Override
	public List<Student> listStudents() {
		String sql = "select * from Student";
		List<Student> sl = jdbcTemplateObject.query(sql, new StudentMapper());
		return sl;
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from Student where id = ?";
		jdbcTemplateObject.update(sql,id);
		System.out.println("Delete Record with ID = "+id);
		return;
	}

	@Override
	public void update(String name, Integer id) {
		String sql = "update Student set name=? where id=?";
		jdbcTemplateObject.update(sql,name,id);
		System.out.println("Update Record with ID = "+id+" name = "+name);
		return;
		
	}

}
