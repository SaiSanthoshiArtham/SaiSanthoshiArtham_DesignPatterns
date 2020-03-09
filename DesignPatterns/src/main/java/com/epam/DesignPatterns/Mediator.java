package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ATCMediator implements IATCMediator {
	public static final Logger log =  LogManager.getLogger();
	private Flight flight; 
	private Runway runway; 
	public boolean land; 

	public void registerRunway(Runway runway) 
	{ 
		this.runway = runway; 
	} 

	public void registerFlight(Flight flight) 
	{ 
		this.flight = flight; 
	} 

	public boolean isLandingOk() 
	{ 
		return land; 
	} 

	public void setLandingStatus(boolean status) 
	{ 
		land = status; 
	} 
} 

interface Command 
{ 
	void land(); 
} 

interface IATCMediator 
{ 

	public void registerRunway(Runway runway); 

	public void registerFlight(Flight flight); 

	public boolean isLandingOk(); 

	public void setLandingStatus(boolean status); 
} 

class Flight implements Command 
{ 
	private IATCMediator atcMediator; 

	public Flight(IATCMediator atcMediator) 
	{ 
		this.atcMediator = atcMediator; 
	} 

	public void land() {
		final Logger logger =  LogManager.getLogger();
		if (atcMediator.isLandingOk()) { 
			logger.info("Successfully Landed."); 
			atcMediator.setLandingStatus(true); 
		} 
		else
			logger.info("Waiting for landing."); 
	} 

	public void getReady() { 
		final Logger logger =  LogManager.getLogger();
		logger.info("Ready for landing."); 
	} 

} 

class Runway implements Command 
{ 
	private IATCMediator atcMediator; 

	public Runway(IATCMediator atcMediator) { 
		this.atcMediator = atcMediator; 
		atcMediator.setLandingStatus(true); 
	} 

	public void land() { 
		final Logger logger =  LogManager.getLogger();
		logger.info("Landing permission granted."); 
		atcMediator.setLandingStatus(true); 
	} 

} 

class Mediator{ 
	public static void main(String args[]) 
	{ 

		IATCMediator atcMediator = new ATCMediator(); 
		Flight sparrow101 = new Flight(atcMediator); 
		Runway mainRunway = new Runway(atcMediator); 
		atcMediator.registerFlight(sparrow101); 
		atcMediator.registerRunway(mainRunway); 
		sparrow101.getReady(); 
		mainRunway.land(); 
		sparrow101.land(); 
		
	} 
} 
