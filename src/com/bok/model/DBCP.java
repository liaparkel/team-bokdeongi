package com.bok.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBCP {
	
	// static: 실행됐을 때 바로 메모리에 올라감
	private static DBCP dbcp; 
	private static DataSource dataSource; // context 정보를 얻어옴
	private static SqlSessionFactory sqlSessionFactory;
	
	private DBCP() {
		try{
			Context context = new InitialContext();
			dataSource =
			       (DataSource) context.lookup("java:comp/env/jdbc/myoracle"); // Datasource가 위 //한 작업을 해줌
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// sqlsession -> DB 연결
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream = null;

			try {
				String resource = "config/mybatis-Config.xml";
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
		}
		return sqlSessionFactory;
	}
}
