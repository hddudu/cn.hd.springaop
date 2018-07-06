package com.aop.test;

import com.earnfish.BeanPostProcessor;


/**
 * 实例化bean后,初始化时会调用该方法
 * @author dudu
 *
 */
public class BeanInitializeLogger implements BeanPostProcessor {


	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws Exception {
		System.out.println("Initialize bean " + beanName + " start!");
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws Exception {
		System.out.println("Initialize bean " + beanName + " end!");
		return bean;
	}


}
