package com.bridgelabz.springboot.helloworlddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springboot.helloworlddemo.model.User;

//@Controller
@RestController
public class HelloworldController {

//	@GetMapping("/web")
//	public String hello() {
//		return "hello";
//		
//	}
//	
//	@GetMapping("/web/message")
//	public String message(Model model) {
//		
//		model.addAttribute("message","this is a custom message");
//		return "message";
//		
//	}
	@RequestMapping("/")
	public String hello() {
		return "hello";
	}

	@GetMapping
	public String sayHello() {
		return "Hello from BridgeLabz";
	}

	@GetMapping("/query")
	public String sayHelloQuery(@RequestParam String name) {
		return "Hello " + name + " from BridgeLabz";
	}

	@GetMapping("/param/{name}")
	public String sayHelloPath(@PathVariable String name) {
		return "Hello " + name + " from BridgeLabz";
	}

	@PostMapping("/post")
	public String sayHelloPost(@RequestBody User user) {
		return "Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz";
	}

	@PutMapping("/put/{firstName}")
	public String sayHelloPut(@PathVariable String firstName, @RequestParam String lastName) {
		return "Hello " + firstName + " " + lastName + " from BridgeLabz";
	}

}
