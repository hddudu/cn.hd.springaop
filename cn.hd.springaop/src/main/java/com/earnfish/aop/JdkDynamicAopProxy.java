package com.earnfish.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 一个基于JDK的动态代理
 * 只能针对实现了接口的类生成代理，于是我们就有了基本的织入功能
 * 注意： 实现了 InvocationHandler 接口，可以通过重写invoke方法进行控制访问
 * @author dudu
 *
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler{

	public JdkDynamicAopProxy(AdvisedSupport advised) {
		super(advised);//实例化封装的类： 通知的类 + 拦截器
	}

	/**
	 * 获取代理对象
	 */
	public Object getProxy() throws Exception {
		return Proxy.newProxyInstance(getClass().getClassLoader(),
						advised.getTargetSource().getInterfaces(), 
						this);
	}
	
	/**
	 * 控制访问
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 从AdvisedSupport里获取方法拦截器
		MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
		//如果方法匹配器存在，且匹配该对象的该方法匹配成功,则调用用户提供的方法拦截器的invoke方法
		//就是匹配了就进行调用
		if(advised.getMethodMatcher() != null
				&& advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
			return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
		}
		//调用原来对象的方法
		return method.invoke(advised.getTargetSource().getTarget(), args);
	}
	
}
