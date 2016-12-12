package com.hand.sf;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {
	
	@Pointcut("execution(* com.hand.sf.*.*(..))")
	public void selectAll(){};

	@Before("selectAll()")
	public void beforeAdvice(){
		System.out.println("--------------Before Advice------------");
	}
	
	@After("selectAll()")
	public void afterAdvice(){
		System.out.println("--------------After Advice------------");
	}
	
	@AfterReturning(pointcut="selectAll()",returning="retVal")
	public void afterReturningAdvice(Object retVal){
		System.out.println("--------------After Returning Advice------------"+retVal.toString());
	}
	
	@AfterThrowing(pointcut="selectAll()",throwing="ex")
	public void afterThrowingAdvice(IllegalArgumentException ex){
		System.out.println("--------------After Throwing Advice------------"+ex.toString());
	}
}
