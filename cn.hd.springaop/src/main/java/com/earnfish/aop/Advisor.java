package com.earnfish.aop;

/**
 * 通知器：
 * 	用于实现 具体的方法拦截，需要使用者编写，也就是对应了Spring中的 前置通知、 后置通知、 环切通知等
 * @author dudu
 *
 */
public interface Advisor {
	
	/**
	 * 获取通知器（方法拦截器： methodInterceptor + ClassFilter）
	 * 
	 * @return
	 */
	Advice getAdvice();
}
