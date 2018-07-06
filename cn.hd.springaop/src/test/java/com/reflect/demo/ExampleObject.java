package com.reflect.demo;

/**
 * @author dudu
 *
 */
public class ExampleObject extends FatherObject{
	
	public int age = 30;
	public String name = "byhing";
	private Integer socre = 60;
	
	public void printName() {
		System.out.println(name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return this.socre;
	}
	public void setScore(Integer score) {
		this.socre = score;
	}
	
	public ExampleObject() {}
	
	public ExampleObject(String name) {
		
	}
	public ExampleObject(int age, Integer score) {
		
	}
	@Override
	public void run() {
		System.out.println("run......");
	}
	
	@Override
	public void doSomething() {
		super.doSomething();
	}
}
