package com.example.model;

public class Dog {
	private String breed;
	private String name;
	
	public Dog(){
		
	}
	public Dog(String breed, String name){
		this.breed=breed;
		this.name=name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [breed=" + breed + ", name=" + name + "]";
	}
	
}
