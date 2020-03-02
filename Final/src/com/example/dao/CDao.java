package com.example.dao;

import com.example.DBManager;
import com.example.dto.BDto;
import com.example.dto.CDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CDao {
    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement2;

    public CDao(DBManager DBm){
        connection = DBm.getConnection();
    }

    public List<CDto> list(){
        List<CDto> cDtoL = new ArrayList<CDto>();
        String query="select * from Customer";
        try {

            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int     _custid       =rs.getInt(   "custid");
                String  _name         =rs.getString("name");
                String  _address      =rs.getString("address");
                String  _phone        =rs.getString("phone");
                int     _point        =rs.getInt(   "point");
                cDtoL.add(new CDto(_custid,_name,_address,_phone,_point));
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
        return cDtoL;
    }

    public void add(CDto cDto){
        String query="insert into Customer (name, address, phone) values ( ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cDto.get_name());
            preparedStatement.setString(2, cDto.get_address());
            preparedStatement.setString(3, cDto.get_phone());
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
    public void update(CDto cDto){

        String query="update Customer SET address=?, phone=? WHERE custid=?" ;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cDto.get_address());
            preparedStatement.setString(2, cDto.get_phone());
            preparedStatement.setInt(3, cDto.get_custid());
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
