package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.model.Dog;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("컨텍스트 리스너 소멸!");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext sc = event.getServletContext();
		String dogBreed = sc.getInitParameter("breed");
		String dogName = "초코";
		
		Dog d = new Dog(dogBreed, dogName);
		sc.setAttribute("dog", d);
	}

	
}
