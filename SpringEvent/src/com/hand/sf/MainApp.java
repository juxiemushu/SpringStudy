package com.hand.sf;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentJDBCTemplate studentJdbcTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		System.out.println("-----------record creation------------");
		studentJdbcTemplate.create("Œﬁ∫∂", 18);
		System.out.println("-----------record list------------");
		List<Student> ls = studentJdbcTemplate.listStudents();
		for(Student s:ls){
			System.out.print(s.getId());
			System.out.print(s.getName());
			System.out.println(s.getAge());
		}
		System.out.println("-----------record update id=2------------");
		studentJdbcTemplate.update("±≥¿Î", 2001);
		System.out.println("-----------record delete id=6------------");
		studentJdbcTemplate.delete(6);
		System.out.println("-----------record list------------");
		List<Student> sl = studentJdbcTemplate.listStudents();
		for(Student s:sl){
			System.out.print(s.getId());
			System.out.print(s.getName());
			System.out.println(s.getAge());
		}
	}
}
