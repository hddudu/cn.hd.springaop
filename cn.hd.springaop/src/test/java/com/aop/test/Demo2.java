package com.aop.test;

import java.util.Map;

import com.earnfish.BeanDefinition;
import com.earnfish.factory.AutoWireCapableBeanFactory;
import com.earnfish.factory.BeanFactory;
import com.earnfish.io.ResourceLoader;
import com.earnfish.xml.XmlBeanDefinitionReader;


public class Demo2 {
	
	public static void main(String[] args) throws Exception {
		//读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		//初始化beanFactory并注册bean
		BeanFactory beanFactory = new AutoWireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
		//获取bean :根据tinyioc.xml的name配置
		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		OutputService outputService = (OutputService) beanFactory.getBean("outputService");
//		System.out.println(helloService);
		System.out.println(outputService);
		System.out.println("说明了是bean之间依赖的关系问题");
		outputService.output("output怎么可以用呢");
		
//		helloService.helloworld();
		
	}
}
