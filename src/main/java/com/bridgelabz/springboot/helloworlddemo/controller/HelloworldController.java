package com.bridgelabz.springboot.helloworlddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloworldController {
	
	@GetMapping("/web")
	public String hello() {
		return "hello";
		
	}
	
	@GetMapping("/web/message")
	public String message(Model model) {
		
		model.addAttribute("message","this is a custom message");
		return "message";
		
	}
	
	

}
