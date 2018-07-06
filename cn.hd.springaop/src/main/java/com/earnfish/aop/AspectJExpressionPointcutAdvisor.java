package com.earnfish.aop;

/**
 * PointcutAdvisor ：完成了切点通知的接口设计
 * 然后我们通过设计AspectJ表达式来进行简单、方便、高效的通知（切入切点处理程序）
 * @author dudu
 *
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
	
	/**
	 *  AspectJ表达式切点匹配器
	 *  AspectJ表达式匹配的切点，默认有初始化。也默认有了MethodMatcher(AspectJExpressionPointcut实现了MethodMatcher接口)
	 */
	private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	
	/**
	 * 通知器被内含在切点通知中 ， 它是被依赖的接口
	 */
	private Advice advice;

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	
	/**
	 * 获取通知器： 前置处理等程序
	 */
	public Advice getAdvice() {
		return advice;
	}
	
	public void setExpression(String expression) {
		this.pointcut.setExpression(expression);
	}

	/**
	 * 获取切点，就是拦截后可以准确匹配的方法==》AspectJExpressionPointcut 这个类完成了切点方法的识别
	 */
	public Pointcut getPointcut() {
		return pointcut;
	}

}
