package com.earnfish.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.earnfish.factory.BeanFactory;

/**
 * 环绕通知
 * 	  用AspectJ表达式匹配 :通知对象==》beanFactory
 * 			匹配方法==》Method
 * 				匹配名字==》String
 * @author dudu
 *
 */
public class AspectJAroundAdvice implements Advice, MethodInterceptor {
	
	private BeanFactory beanFactory;
	
	private Method aspectJAdviceMethod;
	
	private String aspectJInstanceName;
	
	/**
	 * 
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		return aspectJAdviceMethod.invoke(beanFactory.getBean(aspectJInstanceName), invocation);
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public Method getAspectJAdviceMethod() {
		return aspectJAdviceMethod;
	}

	public void setAspectJAdviceMethod(Method aspectJAdviceMethod) {
		this.aspectJAdviceMethod = aspectJAdviceMethod;
	}

	public String getAspectJInstanceName() {
		return aspectJInstanceName;
	}

	public void setAspectJInstanceName(String aspectJInstanceName) {
		this.aspectJInstanceName = aspectJInstanceName;
	}
}
