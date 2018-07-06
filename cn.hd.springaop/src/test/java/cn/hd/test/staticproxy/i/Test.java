package cn.hd.test.staticproxy.i;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class Test {
	
	public static void main(String[] args) {
//		Sell sell = (Sell) new DynamicProxy().getProxyInstance(new Vendor());
//		sell.advise();
//		System.out.println("------");
//		sell.sell();
		//左边是接口：右边是实现
		Sell vendor = new Vendor();
		InvocationHandler ih = new DynamicProxy(vendor);//代理的对象的处理器
		Class<?> cls = vendor.getClass();
		Field[] fvendor = cls.getDeclaredFields();
		for(Field f : fvendor) {
			System.out.print(f.getName()+"-");  
			System.out.println(f.getModifiers()+", " );
		}
		System.out.println("-------------");
		//一下是生成代理的过程：
		Sell sell = (Sell) Proxy.newProxyInstance(
				cls.getClassLoader(),
				cls.getInterfaces(), 
				ih);
		//证明了sell是Proxy的一个实例，这个实例实现了Sell接口
		System.out.println(sell instanceof Proxy);//true
		//这里可以看出subject的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了Subject接口
		System.out.println(sell.getClass().toString());//class com.sun.proxy.$Proxy0
		
//		int modifiers = sell.getClass().getModifiers();
//		System.out.println(modifiers);
		System.out.println("sell中的属性有："); 
		Field[] fields = sell.getClass().getDeclaredFields();
		for(Field f:fields){  
//			if(f.getGenericType()  Method){
				System.out.print(f.getName()+"-");  
				System.out.println(f.getModifiers()+", " );
//			}
        }  //sell中的属性有：m1, m0, m3, m4, m2,
		//这几个属性其实都是Method的引用
		
		System.out.print("\n"+"sell中的方法有：");
		
		Method[] methods=sell.getClass().getDeclaredMethods();  
		for(Method m:methods){ // 
            System.out.print(m.getName()+", ");  
        }//sell中的方法有：equals, toString, hashCode, sell, advise, 
		
		System.out.println("\n"+"sell的父类是："+sell.getClass().getSuperclass());  
        
        System.out.print("\n"+"sell实现的接口是：");  
        Class<?>[] interfaces=sell.getClass().getInterfaces();  
        
        for(Class<?> i:interfaces){  
            System.out.print(i.getName()+", ");  
        }  
  
        System.out.println("\n\n"+"运行结果为：");  
        sell.sell();  
	}
}
