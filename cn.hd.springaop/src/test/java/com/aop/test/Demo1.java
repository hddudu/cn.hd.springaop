package com.aop.test;

import com.earnfish.BeanDefinition;
import com.earnfish.PropertyValue;
import com.earnfish.PropertyValues;
import com.earnfish.factory.AutoWireCapableBeanFactory;
import com.earnfish.factory.BeanFactory;

public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		//初始化beanFactory
		BeanFactory beanFactory = new AutoWireCapableBeanFactory();
		
		//注入bean
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("com.aop.test.HelloService");
		//第一个问题：未注入： beanDefinition属性为空
		//设置属性
		PropertyValues propertyValues  = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "HelloWorld"));//属性名和属性值成为一对
		beanDefinition.setPropertyValues(propertyValues);
		
		//4.生成bean
//		beanFactory.registerBeanDefinition("helloService2", beanDefinition);
		
		beanFactory.registerBeanDefinition("helloService", beanDefinition);//注入 ： 取出一样
		//获取bean
		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
//		HelloService helloService = (HelloService) beanFactory.getBean("helloService2");
		helloService.helloworld();
	}
}
