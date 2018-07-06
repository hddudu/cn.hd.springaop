package com.aop.test;

import org.junit.Test;

import com.earnfish.aop.AdvisedSupport;
import com.earnfish.aop.Cglib2AopProxy;
import com.earnfish.aop.JdkDynamicAopProxy;
import com.earnfish.aop.TargetSource;
import com.earnfish.context.ApplicationContext;
import com.earnfish.context.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	
	@Test
	public void testPostBeanProcessor() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc-postbeanprocessor.xml");
		HelloService helloService = (HelloService) applicationContext.getBean("helloService");
		helloService.helloworld();
	}
	
	@Test
	public void testInterceptor() throws Exception {
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloService helloWorldService = (HelloService) applicationContext.getBean("helloService");
//		helloWorldService.helloworld();
		// --------- helloWorldService with AOP
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloServiceImpl.class, HelloService.class);
		advisedSupport.setTargetSource(targetSource);
		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);
		
		// 3. 创建代理(Proxy)
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
		HelloService helloWorldServiceProxy = (HelloService) jdkDynamicAopProxy.getProxy();
		
		// 4. 基于AOP的调用
		helloWorldServiceProxy.helloworld();
	}
	
	@Test
	public void testInterceptor2() throws Exception {
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloService helloWorldService = (HelloService) applicationContext.getBean("helloService");
		helloWorldService.helloworld();

		// --------- helloWorldService with AOP
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloServiceImpl.class,
				HelloService.class);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		// 补：没有设置MethodMatcher，所以拦截该类的所有方法
		// 3. 创建代理(Proxy)
		Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
		HelloService helloWorldServiceProxy = (HelloService) cglib2AopProxy.getProxy();

		// 4. 基于AOP的调用
		helloWorldServiceProxy.helloworld();

	}
	
}
