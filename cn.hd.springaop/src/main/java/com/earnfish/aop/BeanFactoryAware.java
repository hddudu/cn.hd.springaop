package com.earnfish.aop;

import com.earnfish.factory.BeanFactory;

/**
 * 实现该接口则有操作beanFactory的能力
 * 
 * 容器的引用传入 Bean中去，这样，Bean将获取容器的引用，获取对容器操作的权限，也就允许了 编写扩展，
 * 扩展IOC容器的功能的Bean，
 * 		例如： 获取容器中的所有的切点对象，决定对哪些对象的哪些方法进行代理。
 * 	解决了 为哪些对象提供 AOP 的植入 的问题。
 * @author dudu
 *
 */
public interface BeanFactoryAware {
	/**
	 * 设置beanFactory后才能操作beanFactory，将设置实例和操作实例进行解耦
	 * @param beanFactory
	 * @throws Exception
	 */
	void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
