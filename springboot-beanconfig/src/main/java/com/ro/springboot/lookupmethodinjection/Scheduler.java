package com.ro.springboot.lookupmethodinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component("scheduler")
@Scope("prototype")
public class Scheduler {

	public static int counter;
	private static final int FIX_RATE = 2000;
	private String uuid;
	
	
	@Autowired
	private Repo repo;

	public Scheduler() {
		super();
		System.out.println("Creating Scheduler bean number "+counter++);
	}
	
	@Scheduled(fixedRate=FIX_RATE)
	public void startSchedule() {

		System.out.println(this.toString()+"--> scheduling uuid "+this.uuid + " to save every " + FIX_RATE + "ms");
		repo.save(this.uuid);
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
