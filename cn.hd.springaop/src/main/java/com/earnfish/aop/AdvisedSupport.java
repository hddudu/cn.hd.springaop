package com.earnfish.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 支持对象进行通知的的封装类!!!! ===>接下来的操作进行代理工厂进行代理对象的实现了
 * 		代理的方式有 JDK 和 CGLIB 代理
 * 
 * AdvisedSupport封装了TargetSource、MethodInterceptor和MethodMathor
 * 因为Spring的aop只支持方法级别的调用，所以其实在AopProxy里，我们只要将
 * 	MethodInterceptor放入对象的方法调用
 * @author dudu
 *
 */
public class AdvisedSupport {
	
	//要拦截的对象
	private TargetSource targetSource;
	
	private MethodInterceptor methodInterceptor;//方法拦截器 : 拦截是大范围拦截
	
	private MethodMatcher methodMatcher;//方法匹配器 ： 匹配是小范围精确匹配

	public TargetSource getTargetSource() {
		return targetSource;
	}

	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}

	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}

	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}

	public MethodMatcher getMethodMatcher() {
		return methodMatcher;
	}

	public void setMethodMatcher(MethodMatcher methodMatcher) {
		this.methodMatcher = methodMatcher;
	}
}
