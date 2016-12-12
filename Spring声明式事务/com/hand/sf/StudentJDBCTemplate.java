package com.hand.sf;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mysql.jdbc.StringUtils;

public class StudentJDBCTemplate implements StudentDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);

	}
	
	@Override
	public void create(String name, Integer age, Integer marks, Integer year) { 
		try{
			String sql1 = "insert into Student(name,age) values (?,?)";
			jdbcTemplateObject.update(sql1, name, age);
			String sql2 = "select max(id) from Student";
			Object o = jdbcTemplateObject.queryForList(sql2).get(0);
			System.out.println("o:" +o.toString().substring(9, 11));
			Integer sid = Integer.parseInt(o.toString().substring(9, 11));
			String sql3 = "insert into Marks (sid, marks, year) values (?,?,?)";
			jdbcTemplateObject.update(sql3, sid, marks, year);
			System.out.println("Created Name = "+name+", Age = "+age);
			
		//	throw new RuntimeException("simulate Error condition");
		}catch(DataAccessException e){
			System.out.println("Error during creating record");
			throw e;
		}
		
	}

	@Override
	public List<StudentMarks> listStudents() {
		String sql = "select * from Student,Marks where Student.id = Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplateObject.query(sql, new StudentMarksMapper());
		return studentMarks;
	}

	

}
