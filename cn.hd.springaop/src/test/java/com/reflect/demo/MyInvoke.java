package com.reflect.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dudu
 *
 */
public class MyInvoke implements InvocationHandler {

	private Object obj;//目标对象 《==被代理
	
	/**
	 * @param obj
	 * @return
	 */
	public Object bind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(
				obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), 
				this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object temp = method.invoke(this.obj, args);
		return temp;
	}

}

class tt {
	public static void main(String[] args) {
		MyInvoke mi = new MyInvoke();
		Subject sub = (Subject) mi.bind(new RealSubject());
		System.out.println(sub.say("dudua1", 24));
	}
}



