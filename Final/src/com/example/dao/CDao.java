package com.example.dao;

import com.example.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CDao {
    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement2;

    public CDao(DBManager DBm){
        connection = DBm.getConnection();
    }


    public void add(String bookname, String publisher, int price){

    }



}
