package com.earnfish.aop;

/**
 * 切点通知器 ： 切点 继承 前置等通知器
 * 	切点通知器 ： 切入点 + 前置等通知 ==》 已经完成了切面==》AOP接口
 * @author dudu
 *
 */
public interface PointcutAdvisor extends Advisor {
	/**
	 * 找到了切点: 然后又具有了前置、后置等通知器==》已经完成了切面接口
	 * @return
	 */
	Pointcut getPointcut();
}
