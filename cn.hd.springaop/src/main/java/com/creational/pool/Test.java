package com.creational.pool;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 数据库连接池：
 * 1： 通过外部配置xml完成初始化及扩容处理
 * 2： 应用系统发出操作数据库的请求(增删改查)
 * 3： 然后是一个mysql数据库被操作
 * 4： 中间抽象出数据库连接池(接口),用来缓解连接数据库的资源消耗;
 * 5： 抽象： 数据库连接池 :==> 数据库操作管道 :==> DataSource
 * 涉及问题:
 * 1: 数据库连接池的初始化存放,还需要管理
 * 2： 外部配置文件去初始化
 * 3: 多线程并发下,管道的分配问题 ： 就是两个线程同时请求一个数据库connection;虽然设置了连接的标识,
 * 		但是在多线程环境下,这个标识是会混乱的!
 * 4: 设置标识是为了做到管道复用
 */
public class Test {

	public static IMyPool myPool = MyPoolFactory.getInstance();
	public static void main(String[] args) throws SQLException {
		for(int i = 0; i < 100; i++) {
			MyPooledConnection myPooledConnection = myPool.getMyPooledConnection();
			ResultSet query = myPooledConnection.query("select * from gy_user");
			while(query.next()) {
				System.out.println(query.getString("login_name") + "," +
						query.getString("password") + ",使用管道:" + 
						myPooledConnection.getConnection());
			}
			myPooledConnection.close();
		}
	}
}
