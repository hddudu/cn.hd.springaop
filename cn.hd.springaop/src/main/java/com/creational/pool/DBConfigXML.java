package com.creational.pool;

/**
 * @author dudu
 * 很多数据库都需要XML OR properties进行配置
 * 这里为了简化解析过程，直接这样提供常量
 *
 */
public class DBConfigXML {
	
	public static final String JDBCDRIVER = "com.mysql.jdbc.Driver";
	public static final String JDBCURL = "jdbc:mysql://127.0.0.1:3306/test";
	public static final String JDBCUSERNAME = "root";
	public static final String JDBCPASSWORD = "123456";
	
	//数据库连接池的初始化大小==》如果能自动调节 + 弹性扩容就好了
	//这个该怎么处理呢?
	public static final int initCount = 10;
	//连接池不足的时候增长的步进值
	//占用资源且消耗资源的扩容需限制大小
	public static final int step = 2;
	//连接池的最大数量
	public static final int maxCount = 50;
	
}
