package com.hand.sf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student st = (Student)context.getBean("student");
		st.getName();
		st.getAge();
		st.printThrowException();
	}
}
