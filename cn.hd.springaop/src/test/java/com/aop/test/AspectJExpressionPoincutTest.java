package com.aop.test;

import org.junit.Assert;
import org.junit.Test;

import com.earnfish.PropertyValues;
import com.earnfish.aop.AspectJExpressionPointcut;

public class AspectJExpressionPoincutTest {
	
	/**
	 * 这里是类过滤,基本上就没有过滤不成功的!
	 * @throws Exception
	 * 步骤：
	 *  1：获取切点，得到切入点，切入方法
	 *  2： 设置切点匹配表达式，就是方法匹配表达式
	 *  3： 进行匹配
	 */
	@Test
	public void testClassFilter() throws Exception {
		String expression = "execution(* com.test.*.*(..))";
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		System.out.println(aspectJExpressionPointcut.toString());
		System.out.println(aspectJExpressionPointcut.getClassFilter());
		System.out.println(aspectJExpressionPointcut.getMethodMatcher());
		/*
com.earnfish.aop.AspectJExpressionPointcut@5d22bbb7
com.earnfish.aop.AspectJExpressionPointcut@5d22bbb7
com.earnfish.aop.AspectJExpressionPointcut@5d22bbb7
		 */
		aspectJExpressionPointcut.setExpression(expression);
		boolean matches = aspectJExpressionPointcut.getClassFilter().matches(PropertyValues.class);//还是匹配
//		boolean matches = aspectJExpressionPointcut.getClassFilter().matches(OutputService.class);//匹配
//		boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloServiceImpl.class);//也匹配
		//因为都在同一个expression下面
		System.out.println(matches);
		Assert.assertTrue(matches);
	}
	
	@Test
	public void testMethodInterceptor() throws Exception {
		String expression = "execution(* com.aop.test.*.*(..))";
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		aspectJExpressionPointcut.setExpression(expression);
		boolean matches = aspectJExpressionPointcut.getMethodMatcher()
				.matches(HelloServiceImpl.class.getDeclaredMethod("helloworld"), HelloServiceImpl.class);
		System.out.println(matches);
//		Assert.assertTrue(matches);
	}
}
