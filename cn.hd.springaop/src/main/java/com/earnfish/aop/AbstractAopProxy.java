package com.earnfish.aop;

/**
 * 抽象aop代理： 
 * 	有获取代理对象的能力
 * @author dudu
 *
 */
public abstract class AbstractAopProxy implements AopProxy {
	
	protected AdvisedSupport advised;//使用这个有获取代理的能力

	/**
	 * 实例化AdvisedSupport对象,那么就拥有了获取获取代理的能力
	 * 	拦截一个对象(类)是为了找到更合适的对象进行匹配使用
	 * @param advised
	 */
	public AbstractAopProxy(AdvisedSupport advised) {
		this.advised = advised;
	}
}
