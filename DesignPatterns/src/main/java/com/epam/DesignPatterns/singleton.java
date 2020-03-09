package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Java program implementing Singleton class 
//with getInstance() method 
class SingletonDesign 
{ 
	// static variable single_instance of type Singleton 
	private static SingletonDesign single_instance = null; 

	// variable of type String 
	public String s; 

	// private constructor restricted to this class itself 
	private SingletonDesign() 
	{ 
		s = "Hello I am a string part of Singleton class"; 
	} 

	// static method to create instance of Singleton class 
	public static SingletonDesign getInstance() 
	{ 
		if (single_instance == null) 
			single_instance = new SingletonDesign(); 

		return single_instance; 
	} 
} 

//Driver Class 
class singleton 
{ 
	public static final Logger logger =  LogManager.getLogger();

	public static void main(String args[]) 
	{ 
		// instantiating Singleton class with variable x 
		SingletonDesign x = SingletonDesign.getInstance(); 

		// instantiating Singleton class with variable y 
		SingletonDesign y = SingletonDesign.getInstance(); 

		// instantiating Singleton class with variable z 
		SingletonDesign z = SingletonDesign.getInstance(); 

		// changing variable of instance x 
		x.s = (x.s).toUpperCase(); 

		logger.info("String from x is " );
		logger.info( x.s); 
		logger.info("String from y is " );
		logger.info( y.s); 
		logger.info("String from z is " );
		logger.info( z.s); 
		logger.info("\n"); 

		// changing variable of instance z 
		z.s = (z.s).toLowerCase(); 

		logger.info("String from x is " );
		logger.info( x.s); 
		logger.info("String from y is " );
		logger.info( y.s); 
		logger.info("String from z is " );
		logger.info( z.s); 
	} 
} 
