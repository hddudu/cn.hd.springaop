package com.creational.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 
 * @author dudu
 * 连接池
 * 需要加载外部配置（就是需要依赖外部配置）
 *
 */
public class MyDefaultPool implements IMyPool {

	private Vector<MyPooledConnection> myPooledConnectionVector = new Vector<MyPooledConnection>();
	private static String JDBCURL;
	private static String JDBCUSERNAME;
	private static String JDBCPASSWORD;
	private static int initCount;
	private static int step;
	private static int maxCount;
	
	/**
	 * 初始化:
	 */
	public MyDefaultPool() {
		//加载数据库连接配置
		init();
		//加载数据库连接驱动
		try {
			Class.forName(DBConfigXML.JDBCDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//初始化数据库连接池管道
		createMyPooledConnection(initCount);
	}
	
	/**
	 * 数据库连接池需要根据外部配置文件完成数据库驱动加载
	 * 以及初始化管道的建立
	 */
	private void init() {
		JDBCURL = DBConfigXML.JDBCURL;
		JDBCUSERNAME = DBConfigXML.JDBCUSERNAME;
		JDBCPASSWORD = DBConfigXML.JDBCPASSWORD;
		initCount = DBConfigXML.initCount;
		step = DBConfigXML.step;
		maxCount = DBConfigXML.maxCount;
	}

	/* 这里需要注意的是：如果得不到操作管道，需要去创建管道！
	 * @see com.creational.pool.IMyPool#getMyPooledConnection()
	 */
	public MyPooledConnection getMyPooledConnection() throws SQLException {
		if(myPooledConnectionVector.size() < 1) {
			throw new RuntimeException("连接池初始化错误!");
		}
		MyPooledConnection myPooledConnection = null;
		myPooledConnection = getRealConnectionFromPool();
		while(myPooledConnection == null) {
			createMyPooledConnection(step);//相当于扩容
			myPooledConnection = getRealConnectionFromPool();
			return myPooledConnection;
		}
		return myPooledConnection;
	}

	/**
	 * @return
	 * @throws SQLException
 第一，这里使用了synchronized，就是为了避免多线程下产生问题。

第二，要知道Connection是有超时机制的，如果我们得到的管道的Connection已经超时了怎么办呢？

第三，得到管道后，一定注意isBusy的设置。
	 */
	private synchronized MyPooledConnection getRealConnectionFromPool() throws SQLException {
		for(MyPooledConnection myPooledConnection : myPooledConnectionVector) {
			if(!myPooledConnection.isBusy()) {//没有在忙 没有在连接 等待连接
				if(myPooledConnection.getConnection().isValid(3000)) {
					myPooledConnection.setBusy(true);
					return myPooledConnection;
				}
			} else {
				Connection connection = DriverManager.getConnection(JDBCURL, JDBCUSERNAME, JDBCPASSWORD);
				myPooledConnection.setConnection(connection);
				myPooledConnection.setBusy(true);
				return myPooledConnection;
			}
		}
		return null;
	}

	/* 创建连接池
	 * @see com.creational.pool.IMyPool#createMyPooledConnection(int)
	 */
	public void createMyPooledConnection(int count) {
		if(myPooledConnectionVector.size() > maxCount ||
				myPooledConnectionVector.size() + count > maxCount) {
			throw new RuntimeException("connection pool is full!");
		}
		for(int i = 0; i < count; i++) {
			try {
				Connection connection = DriverManager.getConnection(JDBCURL, JDBCUSERNAME, JDBCPASSWORD);
				MyPooledConnection myPooledConnection = new MyPooledConnection(connection, false);
				myPooledConnectionVector.add(myPooledConnection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
