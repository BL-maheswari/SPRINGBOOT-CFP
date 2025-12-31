package com.bridgelabz.springboot.helloworlddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
