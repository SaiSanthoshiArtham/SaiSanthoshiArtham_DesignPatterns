package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



interface Bird {
	public static final Logger logger =  LogManager.getLogger();
	
	public void fly(); 
	public void makeSound(); 
} 

class Sparrow implements Bird { 
	public void fly() 	{ 
		logger.info("Flying"); 
	} 
	public void makeSound()	{ 
		logger.info("Chirp Chirp"); 
	} 
} 

interface ToyDuck { 
	public void squeak(); 
} 

class PlasticToyDuck implements ToyDuck { 
	public static final Logger logger =  LogManager.getLogger();
	public void squeak() { 
		logger.info("Squeak"); 
	} 
} 

class BirdAdapter implements ToyDuck { 
	Bird bird; 
	public BirdAdapter(Bird bird) {
		this.bird = bird; 
	} 

	public void squeak() {  
		bird.makeSound(); 
	} 
} 

class adapter { 
	public static final Logger logger =  LogManager.getLogger();
	public static void main(String args[]) { 
		Sparrow sparrow = new Sparrow(); 
		ToyDuck toyDuck = new PlasticToyDuck(); 

		
		ToyDuck birdAdapter = new BirdAdapter(sparrow); 

		logger.info("Sparrow..."); 
		sparrow.fly(); 
		sparrow.makeSound(); 

		logger.info("ToyDuck..."); 
		toyDuck.squeak(); 

		
		logger.info("BirdAdapter..."); 
		birdAdapter.squeak(); 
	} 
} 

