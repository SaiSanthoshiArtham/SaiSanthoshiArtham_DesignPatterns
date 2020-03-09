package com.epam.DesignPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Notification 
{ 

	String notification; 

	public Notification(String notification) 
	{ 
		this.notification = notification; 
	} 
	public String getNotification() 
	{ 
		return notification; 
	} 
} 


interface Collection 
{ 
	public Iterator createIterator(); 
} 


class NotificationCollection implements Collection 
{ 
	static final int MAX_ITEMS = 6; 
	int numberOfItems = 0; 
	Notification[] notificationList; 

	public NotificationCollection() 
	{ 
		notificationList = new Notification[MAX_ITEMS]; 


		addItem("Notification 1"); 
		addItem("Notification 2"); 
		addItem("Notification 3"); 
	} 

	public void addItem(String str) 
	{ 
		final Logger logger =  LogManager.getLogger();
		Notification notification = new Notification(str); 
		if (numberOfItems >= MAX_ITEMS) 
			logger.info("Full"); 
		else
		{ 
			notificationList[numberOfItems] = notification; 
			numberOfItems = numberOfItems + 1; 
		} 
	} 

	public Iterator createIterator() 
	{ 
		return new NotificationIterator(notificationList); 
	} 
} 


interface Iterator 
{ 

	boolean hasNext(); 


	Object next(); 
} 

class NotificationIterator implements Iterator 
{ 
	Notification[] notificationList; 


	int pos = 0; 


	public NotificationIterator (Notification[] notificationList) 
	{ 
		this.notificationList = notificationList; 
	} 

	public Object next() 
	{ 

		Notification notification = notificationList[pos]; 
		pos += 1; 
		return notification; 
	} 

	public boolean hasNext() 
	{ 
		if (pos >= notificationList.length || 
				notificationList[pos] == null) 
			return false; 
		else
			return true; 
	} 
} 


class NotificationBar 
{ 
	public static final Logger logger =  LogManager.getLogger();
	NotificationCollection notifications; 

	public NotificationBar(NotificationCollection notifications) 
	{ 
		this.notifications = notifications; 
	} 

	public void printNotifications() 
	{ 
		Iterator iterator = notifications.createIterator(); 
		logger.info("-------NOTIFICATION BAR------------"); 
		while (iterator.hasNext()) 
		{ 
			Notification n = (Notification)iterator.next(); 
			logger.info(n.getNotification()); 
		} 
	} 
} 


class iteratorDesign
{ 
	public static void main(String args[]) 
	{ 
		NotificationCollection nc = new NotificationCollection(); 
		NotificationBar nb = new NotificationBar(nc); 
		nb.printNotifications(); 
	} 
} 
