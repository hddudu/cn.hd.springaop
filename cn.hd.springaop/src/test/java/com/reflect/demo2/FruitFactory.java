package com.reflect.demo2;

public class FruitFactory {
	
	/**
	 * 根据水果名来吃水果
	 * @param fruitName
	 * @return
	 */
	public static Fruit getInstance(String fruitName) {
		Fruit f = null;
//		if("apple".equalsIgnoreCase(fruitName)) {
//			f = new Apple();
//		}
//		if("orange".equalsIgnoreCase(fruitName)) {
//			f = new Orange();
//		}
		//通过反射来实现
		try {
			//fruitName是全限定名
			f = (Fruit) Class.forName(fruitName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
