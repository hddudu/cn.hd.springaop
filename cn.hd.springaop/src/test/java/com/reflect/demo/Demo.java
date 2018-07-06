package com.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		Class ec1 = ExampleObject.class;
		System.out.println(ec1);//class com.reflect.demo.ExampleObject
		
		try {
			Class ec2 = Class.forName("com.reflect.demo.ExampleObject");
			System.out.println(ec2);//class com.reflect.demo.ExampleObject
/*
 * 此方法需要有2个条件，第一，forName中的字符串必须是全限定名，
 * 第二，这个Class类必须在classpath的路径下面，因为该方法会抛出ClassNotFoundException的异常。
 */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String fullClassName = ec1.getName();
		String simpleClassName = ec1.getSimpleName();
		//com.reflect.demo.ExampleObject : ExampleObject(就是简单类名字)
		System.out.println(fullClassName + " : " + simpleClassName);
		
		//得到包信息
		Package aPackage = ec1.getPackage();
		System.out.println(aPackage);//package com.reflect.demo
		
		//得到父类
		Class superClass = ec1.getSuperclass();
		System.out.println(superClass.getSimpleName());//FatherObject
		
		System.out.println("父类是不是抽象类： " + Modifier.isAbstract(superClass.getModifiers()));
		//
//		getModifiers可以得到类的修饰符，从而得到类的修饰符，当然，这个getModifiers不仅仅Class对象可以调用，Method对象可以调用
		
//		Modifier.isAbstract(int modifiers);
		
		//得到接口
		Class[] classes = superClass.getInterfaces();//父类的接口: interface java.lang.Runnable
		System.out.println("父类的接口: " + classes[0]);
		System.out.println(classes.length);//1
		
		Constructor[] constructors = ec1.getConstructors();
		for(Constructor constructor : constructors) {
			System.out.println(constructor.toString());
		}
		/*
public com.reflect.demo.ExampleObject(java.lang.String)
public com.reflect.demo.ExampleObject(int,java.lang.Integer)
public com.reflect.demo.ExampleObject()
		 */
		try {
			Constructor constructor = ec1.getConstructor(String.class);
			System.out.println(constructor.toString());
			//public com.reflect.demo.ExampleObject(java.lang.String)
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		try {
//			Constructor constructor2 = ec1.getConstructor(Integer.class, String.class);
			//上面的不对,与上面
			Constructor constructor2 = ec1.getConstructor(int.class, Integer.class);
			System.out.println(constructor2.toString());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println(".................................................");
		Constructor[] constructor3 = ec1.getConstructors();
		for(Constructor constructor : constructor3) {
			System.out.println("构造参数如下==============");
			Class[] parameterTypes = constructor.getParameterTypes();
			System.out.println(parameterTypes.length == 0 ? 0 : parameterTypes.length + " : " + parameterTypes[0]);
			for(Class clz : parameterTypes) {
				System.out.println("参数类型: " + clz.toString());
			}
			//参数类型: class java.lang.String
			
			//参数类型: int
			//参数类型: class java.lang.Integer
			System.out.println("==================================================================");
			if(parameterTypes.length < 1) {
//				Object object = constructor.newInstance(1,100);
//				System.out.println(object.toString());
			}
			System.out.println("==================================================================");
		}
		
		System.out.println("分割符号---------------------------------------------------");
		Field[] fields = ec1.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("变量为: " + field.toString());
			/*
			 * private java.lang.Integer com.reflect.demo.ExampleObject.socre
			 * public java.lang.String com.reflect.demo.ExampleObject.name
			 * public int com.reflect.demo.ExampleObject.age
			 */
		}
		
		Constructor c1 = ec1.getConstructor(String.class);
		ExampleObject eo1 = (ExampleObject) c1.newInstance("hongdu");
		Field field = ec1.getField("age");
		System.out.println("原先的age是: "+eo1.getAge());
		field.set(eo1, 20);//实例设置对应字段的值
		System.out.println("更改后的age是: "+eo1.getAge());
		
		
		
	}
}
