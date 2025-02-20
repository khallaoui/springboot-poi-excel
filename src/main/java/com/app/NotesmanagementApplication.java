package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NotesmanagementApplication {

	public static void main(String[] args) {
		ApplicationContext context =  
				SpringApplication.run(NotesmanagementApplication.class, args);
	}}
