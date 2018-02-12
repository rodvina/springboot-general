package com.ro.springboot.lookupmethodinjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Service {
	
	public static int counter;

	public Service() {
		super();
		System.out.println("Creating Service bean number "+counter++);
	}
	
	@Lookup("scheduler")
	protected Scheduler createScheduler() {
		//container will return lookup result
		return null;
	}
	
	public void processTransaction(String uuid) {
		Scheduler scheduler = this.createScheduler();
		scheduler.setUuid(uuid);
		scheduler.startSchedule();
	}
	
}
