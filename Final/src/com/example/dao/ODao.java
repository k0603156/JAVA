package com.example.dao;

import com.example.DBManager;

import java.sql.*;

public class ODao {
    Connection connection;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement2;

    public ODao(DBManager DBm){
        connection = DBm.getConnection();
    }


    public void getBookPrice(int custid,int bookid){


        String query ="select b.bookid, b.bookname, b.price, c.name, c.point FROM Book AS b JOIN Customer AS c WHERE c.custid=? AND b.bookid=?";
//        String query="select * from Book where bookid=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, custid);
            preparedStatement.setInt(2, bookid);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String _point       =rs.getString("point");
                String _bookid     =rs.getString("bookid");
                String _bookname    =rs.getString("bookname");
                String _price        =rs.getString("price");
                String _name        =rs.getString("name");
                System.out.println(_name
                        +"님의 포인트는 "
                        +_point
                        +"Point 이며 "
                        +_bookid
                        +"번 "
                        +_bookname
                        +"의 가격은 "
                        +_price
                        +"원 입니다."  );
                System.out.println("포인트 차감시 "+ (Integer.parseInt(_price) - Integer.parseInt((_point))+"원으로 구매 가능합니다."));
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

    public void order(int custid, int bookid, int saleprice ){

        String query="insert into Orders (custid, bookid, saleprice, orderdate) values (?, ?, ?, ?)";
        String query2="update Book set count=count-1 where bookid=?";
        try {
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, custid);
            preparedStatement.setInt(2, bookid);
            preparedStatement.setInt(3, saleprice);
            preparedStatement.setDate(4, Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.executeUpdate();

            preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, bookid);
            preparedStatement2.executeUpdate();


            connection.commit();
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
