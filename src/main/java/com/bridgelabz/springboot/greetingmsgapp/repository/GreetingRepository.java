package com.bridgelabz.springboot.greetingmsgapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.springboot.greetingmsgapp.entity.Greeting;
@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Integer>{
	

}
