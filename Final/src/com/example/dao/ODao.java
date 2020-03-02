package com.example.dao;

import com.example.DBManager;
import com.example.dto.CDto;
import com.example.dto.ODto;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ODao {
    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement2;

    public ODao(DBManager DBm){
        connection = DBm.getConnection();
    }

    public List<ODto> list(){
        List<ODto> oDtoL = new ArrayList<ODto>();
        String query="select o.*, c.name FROM Orders AS o JOIN Customer AS c ON o.custid = c.custid";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int     _orderid    =rs.getInt("orderid");
                int     _custid     =rs.getInt("custid");
                String  _name       =rs.getString("name");
                int     _bookid     =rs.getInt("bookid");
                int     _saleprice  =rs.getInt("saleprice");
                String  _orderdate  =rs.getString("orderdate");
                oDtoL.add(new ODto(_orderid,_custid,_name,_bookid,_saleprice,_orderdate));
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
        return oDtoL;
    }


    public ODto getBookPrice(int custid,int bookid){
        ODto oDto = null;
        String query ="select b.bookid, b.bookname, b.price, c.name, c.point FROM Book AS b JOIN Customer AS c WHERE c.custid=? AND b.bookid=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, custid);
            preparedStatement.setInt(2, bookid);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int     _bookid    =rs.getInt("bookid");
                String  _bookname  =rs.getString("bookname");
                int     _price     =rs.getInt("price");
                String  _name      =rs.getString("name");
                int     _point     =rs.getInt("point");
                oDto = new ODto(_bookid, _bookname,_price,_name, _point);
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
        return oDto;
    }

    public void order(int custid, int bookid, int saleprice ) throws SQLException {

        String query="insert into Orders (custid, bookid, saleprice, orderdate) values (?, ?, ?, ?)";
        String query2="update Book set stock=stock-1 where bookid=?";
        try {
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, custid);
            preparedStatement.setInt(2, bookid);
            preparedStatement.setInt(3, saleprice);
            preparedStatement.setDate(4, Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, bookid);
            preparedStatement2.executeUpdate();
            preparedStatement2.close();

            connection.commit();
        }
        catch(Exception e){
                connection.rollback();
            if(e instanceof SQLException&& ((SQLException) e).getErrorCode()==1690){
                System.out.println("해당 도서의 재고가 없습니다.");
            }
        } finally{
            try{
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                if(preparedStatement != null) preparedStatement.close();
//                if(connection != null) connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        }
    }

}
