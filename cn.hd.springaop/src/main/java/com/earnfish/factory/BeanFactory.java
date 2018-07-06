package com.earnfish.factory;

import com.earnfish.BeanDefinition;

public interface BeanFactory {
	
	Object getBean(String name) throws Exception;
	
	void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
