package com.earnfish.aop;

/**
 * 封装被代理的对象的类的相关信息：
 *  代理对象和原对象必须要实现相同的接口
 * @author dudu
 *
 */
public class TargetSource {
	//原对象
	private Object target;
	
	//目标类
	private Class<?> targetClass;
	
	private Class<?>[] interfaces;//实现的接口的类对象数组

	public TargetSource(Object target, Class<?> targetClass,
			Class<?>...interfaces) {//设置为可变参数,可以实现多个接口,也可以一个
		this.target = target;
		this.targetClass = targetClass;
		this.interfaces = interfaces;
	}

	public Object getTarget() {
		return target;
	}

	public Class<?> getTargetClass() {
		return targetClass;
	}

	public Class<?>[] getInterfaces() {
		return interfaces;
	}
}
