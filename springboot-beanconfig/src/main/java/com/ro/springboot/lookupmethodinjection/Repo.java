package com.ro.springboot.lookupmethodinjection;

import org.springframework.stereotype.Component;

@Component
public class Repo {
	public static int counter;
	
	public Repo() {
		super();
		System.out.println("Creating Repo bean number "+counter++);
	}

	public void save(String uuid) {
		System.out.println("Saving uuid " + uuid);
	}
}
