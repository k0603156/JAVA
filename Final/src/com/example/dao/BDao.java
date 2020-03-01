package com.example.dao;

import com.example.DBManager;

import java.sql.*;

public class BDao {
    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement2;

    public BDao(DBManager DBm){
        connection = DBm.getConnection();
    }

    public void list(){
        String query="select * from Book";
        try {

            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String bookid       =rs.getString("bookid");
                String bookname     =rs.getString("bookname");
                String publisher    =rs.getString("publisher");
                String price        =rs.getString("price");
                String count        =rs.getString("count");
                System.out.println(
                        String.format("%-4s",     bookid)
                                + String.format("%-20s",    bookname)
                                + String.format("%-15s",    publisher)
                                + String.format("%-10s",    price)
                                + String.format("%4s",      count) );
            }
            if(rs !=null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if(preparedStatement != null) preparedStatement.close();
//                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void add(String bookname, String publisher, int price){
        String query="insert into Book (bookname, publisher, price) values ( ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookname);
            preparedStatement.setString(2, publisher);
            preparedStatement.setInt(3, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
//                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int bookId){
        String query="delete from Book WHERE bookid=?" ;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
//                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void receiving(int bookId, int count){
        String query="update Book set count=? where bookid=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);
            preparedStatement.setInt(2, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
//                if(connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
