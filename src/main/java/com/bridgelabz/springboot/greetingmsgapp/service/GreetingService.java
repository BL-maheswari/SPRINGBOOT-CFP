package com.bridgelabz.springboot.greetingmsgapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.springboot.greetingmsgapp.entity.Greeting;
import com.bridgelabz.springboot.greetingmsgapp.entity.User;
@Service
public interface GreetingService {
	
	String getGreetingMessage(User user);
    Greeting saveGreeting(User user);
    Greeting getGreetingById(int id);
    List<Greeting> getAllGreetings();
    Greeting editGreeting(int id, User user);
    void deleteGreeting(int id);

}
