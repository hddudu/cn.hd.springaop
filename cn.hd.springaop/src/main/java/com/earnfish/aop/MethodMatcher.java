package com.earnfish.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配器 :
 * @author dudu
 *
 */

@SuppressWarnings("rawtypes")
public interface MethodMatcher {
	/**
	 * 匹配该方法是否是要拦截的方法
	 * @param method 方法
	 * @param targetClass 类
	 * @return
	 */
	boolean matches(Method method, Class targetClass);
}
