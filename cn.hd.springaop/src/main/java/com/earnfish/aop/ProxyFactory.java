package com.earnfish.aop;

/**
 * @author dudu
 *
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

	//获取代理对象
	public Object getProxy() throws Exception {
		return createAopProxy().getProxy();
	}

	protected final AopProxy createAopProxy() {
		return new Cglib2AopProxy(this);
	}
}
