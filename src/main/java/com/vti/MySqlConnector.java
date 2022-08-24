package com.vti;

public class MySqlConnector extends DatabaseConnector {
   public void connect() {
	   System.out.println("Đã kết nối tới Mysql: " + getUrl());
   }
}
