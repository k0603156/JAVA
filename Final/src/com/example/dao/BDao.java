package com.example.dao;

import com.example.DBManager;
import com.example.dto.BDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDao {
    Connection connection;
    PreparedStatement preparedStatement;

    public BDao(DBManager DBm){
        connection = DBm.getConnection();
    }

    public List<BDto> list(){
        List<BDto> bDtoL = new ArrayList<BDto>();
        String query="select * from Book";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int     _bookId      =rs.getInt("bookid");
                String  _bookName    =rs.getString("bookname");
                String  _publisher   =rs.getString("publisher");
                int     _price       =rs.getInt("price");
                int     _stock       =rs.getInt("stock");
                bDtoL.add( new BDto(_bookId, _bookName, _publisher, _price, _stock));
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
        return bDtoL;
    }

    public void add(BDto bDto){
        String query="insert into Book (bookname, publisher, price) values ( ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bDto.get_bookname());
            preparedStatement.setString(2, bDto.get_publisher());
            preparedStatement.setInt(3, bDto.get_price());
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


    public void receiving(BDto bDto){
        String query="update Book set stock=? where bookid=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bDto.get_stock());
            preparedStatement.setInt(2, bDto.get_bookid());
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
