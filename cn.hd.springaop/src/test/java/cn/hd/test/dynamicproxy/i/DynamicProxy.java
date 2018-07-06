package cn.hd.test.dynamicproxy.i;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK1.5提供，利用反射，实现InvocationHandler接口
 * 接口已经定义、然后就是代理类和真实类都实现这个接口
 * 再简化一点： 直接将 业务接口、真实类、代理类参数化就ok
 * @author dudu
 *
 */
public class DynamicProxy implements InvocationHandler {

	private Object target;/**需要代理的目标类**/
	
	/**
	 * 写法固定，aop专用:绑定委托对象并返回一个代理类
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				this);//这个this可以直接实现L： 就是new一个InvocationHandler的匿名类就行
	}
	
	
	
	/**
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		//切面执行之前
		System.out.println("切面执行之前!!!");
		result = method.invoke(target, args);
		//切面执行之后
		System.out.println("切面执行之后!!!");
		return result;
	}

}
