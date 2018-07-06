package com.earnfish.aop;

/**
 * 类匹配器
 * @author dudu
 *
 */
@SuppressWarnings("rawtypes")
public interface ClassFilter {
	/**
	 * 用于匹配targetClass是否要拦截的类
	 * @param targetClass
	 * @return
	 */
	boolean matches(Class targetClass);
}
