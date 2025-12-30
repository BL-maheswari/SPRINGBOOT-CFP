package com.bridgelabz.springboot.greetingmsgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springboot.greetingmsgapp.entity.Greeting;
import com.bridgelabz.springboot.greetingmsgapp.entity.User;
import com.bridgelabz.springboot.greetingmsgapp.service.GreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
	
	

	    @Autowired
	    private GreetingService service;

	    @GetMapping("/hello")
	    public String hello() {
	        return "{\"message\":\"Hello from Greeting App\"}";
	    }

	    @GetMapping("/message")
	    public String getMessage(@RequestParam(required = false) String firstName,
	                             @RequestParam(required = false) String lastName) {

	        User user = new User(firstName, lastName);
	        return service.getGreetingMessage(user);
	    }

	    @PostMapping("/save")
	    public Greeting save(@RequestBody User user) {
	        return service.saveGreeting(user);
	    }

	    @GetMapping("/{id}")
	    public Greeting getById(@PathVariable int id) {
	        return service.getGreetingById(id);
	    }

	    @GetMapping
	    public List<Greeting> listAll() {
	        return service.getAllGreetings();
	    }

	    @PutMapping("/edit/{id}")
	    public Greeting edit(@PathVariable int id, @RequestBody User user) {
	        return service.editGreeting(id, user);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String delete(@PathVariable int id) {
	        service.deleteGreeting(id);
	        return "Greeting Message Deleted Successfully!";
	    }
	}



