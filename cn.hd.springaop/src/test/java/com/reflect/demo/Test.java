package com.reflect.demo;

public class Test {
	public static void main(String[] args) {
		hello h = new hello();
		System.out.println("类加载器: " + h.getClass().getClassLoader().getClass().getName());
		//类加载器: sun.misc.Launcher$AppClassLoader
		MyInvoke mi = new MyInvoke();
		Subject sub = (Subject) mi.bind(new RealSubject());
		System.out.println(sub.say("dudua1", 24));
	}
}
/*
1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。

2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类

3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器
 */
class hello {
	
}
