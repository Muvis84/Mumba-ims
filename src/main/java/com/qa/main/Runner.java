package com.qa.main;

import org.apache.log4j.Logger;

public class Runner {
	
	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) {
		
		Ims mysql = new Ims();
		System.out.println("rtyu");
		mysql.imsSystem();
	}

}
