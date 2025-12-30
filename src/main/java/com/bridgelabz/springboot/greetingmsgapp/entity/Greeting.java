package com.bridgelabz.springboot.greetingmsgapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Greeting {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String message;
	    

	    public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Greeting() {}

	    public Greeting(String message) {
	        this.message = message;
	    }
}



