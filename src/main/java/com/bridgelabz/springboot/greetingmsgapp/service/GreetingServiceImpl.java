package com.bridgelabz.springboot.greetingmsgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springboot.greetingmsgapp.entity.Greeting;
import com.bridgelabz.springboot.greetingmsgapp.entity.User;
import com.bridgelabz.springboot.greetingmsgapp.repository.GreetingRepository;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	private GreetingRepository repository;

	@Override
	public String getGreetingMessage(User user) {
		if (user.getFirstName() != null && user.getLastName() != null)
			return "Hello " + user.getFirstName() + " " + user.getLastName();
		else if (user.getFirstName() != null)
			return "Hello " + user.getFirstName();
		else if (user.getLastName() != null)
			return "Hello " + user.getLastName();
		else
			return "Hello World";
	}

	@Override
	public Greeting saveGreeting(User user) {
		String message = getGreetingMessage(user);
		Greeting greeting = new Greeting(message);
		return repository.save(greeting);
	}

	@Override
	public Greeting getGreetingById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Greeting> getAllGreetings() {
		return repository.findAll();
	}

	@Override
	public Greeting editGreeting(int id, User user) {
		Greeting existing = getGreetingById(id);
		if (existing != null) {
			existing.setMessage(getGreetingMessage(user));
			return repository.save(existing);
		}
		return null;
	}

	@Override
	public void deleteGreeting(int id) {
		repository.deleteById(id);
	}
}
