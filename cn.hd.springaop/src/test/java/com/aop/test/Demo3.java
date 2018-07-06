package com.aop.test;

import java.util.Map;

import com.earnfish.BeanDefinition;
import com.earnfish.factory.AbstractBeanFactory;
import com.earnfish.factory.AutoWireCapableBeanFactory;
import com.earnfish.io.ResourceLoader;
import com.earnfish.xml.XmlBeanDefinitionReader;

/**
 * 为bean注入bean:
 * 我们无法处理bean之间的依赖，无法将bean注入到bean中，所以它无法称之为完整的IoC容器！
 * 比如HelloServiceImpl中的outputService就没法注入到bean：HelloServiceImpl中!
 * 解决办法：
 * 	①我们定义一个BeanReference，来表示这个属性是对另一个bean的引用。
 * 		这个在读取xml的时候初始化，并在初始化bean的时候，进行解析和真实bean的注入
 * @author dudu
 *
 */
public class Demo3 {
	
	public static void main(String[] args) throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader  = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		
		AbstractBeanFactory beanFactory = new AutoWireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
//		System.out.println(beanFactory.getBeanDefinitionMap());
		//初始化bean
		beanFactory.preInstantiateSingletons();
		
		//
		HelloService hs = (HelloService) beanFactory.getBean("helloService");
		System.out.println("hs: "+hs);
		hs.helloworld();
	}
}
