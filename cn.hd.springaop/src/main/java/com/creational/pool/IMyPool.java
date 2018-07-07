package com.creational.pool;

import java.sql.SQLException;

/**
 * @author dudu
 * IMyPool是一个接口，
 * 对外提供数据库连接池的基本服务，比如得到一个数据库操作管道
 * MyDefaultPool是IMyPool的实现。
 * MyPooledConnection代表数据库操作管道，它可以执行SQL，关闭管道等。
 * MyPoolFactory是一个工厂，单例模式，用于得到IMyPool实现。
 * DBConfigXML代表外部配置文件。
 * Test用于测试。
 */
/*
 * 对数据库连接池的一个基本管理API接口
 * 要可以得到数据库操作的管道
 * 还要可以创建数据库管道
 */
public interface IMyPool {

	public MyPooledConnection getMyPooledConnection() throws SQLException;
	
	public void createMyPooledConnection(int count);
	
}
