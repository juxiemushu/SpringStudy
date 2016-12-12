package com.hand.sf;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentJDBCTemplate studentJdbcTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		System.out.println("-----------record creation------------");
		studentJdbcTemplate.create("’≈∫≤", 11, 98, 2010);
		studentJdbcTemplate.create("¡÷Ÿª", 12, 88, 2010);
		System.out.println("-----------list record ------------");
		List<StudentMarks> sml = studentJdbcTemplate.listStudents();
		for(StudentMarks sm:sml){
			System.out.print(sm.getId());
			System.out.print(sm.getName());
			System.out.print(sm.getAge());
			System.out.print(sm.getMarks());
			System.out.println(sm.getYear());
		}
	}
}
