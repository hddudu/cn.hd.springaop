package com.reflect.demo2;

import java.util.Properties;

public class Test {
	
	public static void main(String[] args) {
		try {
			Properties pro = Init.getProperties();
			System.out.println(pro);
			String className = pro.getProperty("apple");//全部限定名
			System.out.println(className);
			Fruit fruit = FruitFactory.getInstance(className);
			fruit.eat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		Fruit f = FruitFactory.getInstance("com.reflect.demo2.Apple");
//		f.eat();
//		Fruit f2 = FruitFactory.getInstance("com.reflect.demo2.Orange");
//		f2.eat();
		
//		Fruit f = FruitFactory.getInstance("Apple");
//		f.eat();
//		Fruit f2 = FruitFactory.getInstance("orange");
//		f2.eat();
	}
}
