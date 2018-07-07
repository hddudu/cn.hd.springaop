package com.creational.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 1： 封装Connection
 * 2： 提供基本的SQL查询功能
 * 3： 数据库连接池是做到连接的复用？
 * 4： 关闭连接是真的关闭连接吗？
 * @author dudu
 * 所谓数据库连接管道，就是对JDBC Connection进行封装而已，但是需要注意isBusy的这个标示。
 * 对管道的关闭，实际上只是标示的改变而已！
 *
 */
public class MyPooledConnection {

	private Connection connection;
	private boolean isBusy = false;
	
	public MyPooledConnection(Connection connection, boolean isBusy) {
		super();
		this.connection = connection;
		this.isBusy = isBusy;
	}
	
	public void close() {
		this.isBusy = false;
	}
	
	//getter setter
	
	
	public ResultSet query(String sql) {
		ResultSet resultSet = null;
		Statement statement;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	
	
}
