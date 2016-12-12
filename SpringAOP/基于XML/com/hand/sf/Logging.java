package com.hand.sf;

public class Logging {

	public void beforeAdvice(){
		System.out.println("--------------Before Advice------------");
	}
	
	public void afterAdvice(){
		System.out.println("--------------After Advice------------");
	}
	
	public void afterReturningAdvice(Object retVal){
		System.out.println("--------------After Returning Advice------------"+retVal.toString());
	}
	
	public void afterThrowingAdvice(IllegalArgumentException ex){
		System.out.println("--------------After Throwing Advice------------"+ex.toString());
	}
}
