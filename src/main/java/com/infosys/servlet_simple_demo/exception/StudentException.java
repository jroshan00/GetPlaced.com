package com.infosys.servlet_simple_demo.exception;

public class StudentException extends Exception{

	/**
	 * @author Roshan Pandey
	 * @implNote All Exception build here are designated to provide proper flow of 
	 * the program without any failures.
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentException(){}
	public StudentException(String msg){
		super(msg);
	}
	

}
