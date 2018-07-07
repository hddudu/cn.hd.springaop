package com.creational.pool;

/**
 * @author dudu
 * 单例模式
 * 数据库连接池工厂
 * static表示只能初始化一次=>可以改变,因为是初始化一次可以修改
 * final表示只能加载一次=>不变
 */
public class MyPoolFactory {

	private static class createPool {
		public static IMyPool myPool = new MyDefaultPool();
	}
	
	public static IMyPool getInstance() {
		return createPool.myPool;
	}
}
