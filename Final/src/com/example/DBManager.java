package com.example;

import java.sql.*;

public class DBManager {
    private final String JDBC   = "com.mysql.cj.jdbc.Driver";
    private final String URL    = "jdbc:mysql://localhost/madang?&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private final String USER   = "dev";
    private final String PASS   = "";
    private Connection conn = null;

    public DBManager(){
        try{
            Class.forName(JDBC);
            conn = DriverManager.getConnection(URL,USER,PASS);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void closeConnection() {
        try {
            if(this.conn!=null)this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
