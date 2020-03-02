package com.example.dto;

public class ODto {
    int     _orderid;
    int     _custid;
    int     _bookid;

    int     _saleprice;
    int     _price;
    int     _point;

    String  _name;
    String  _bookname;

    String  _orderdate;



    public ODto(int _orderid, int _custid, String _name, int _bookid, int _saleprice, String _orderdate){
        this._orderid   =   _orderid;
        this._custid    =   _custid;
        this._name      =   _name;
        this._bookid    =   _bookid;
        this._saleprice =   _saleprice;
        this._orderdate =   _orderdate;
    }
    public ODto(int _bookid, String _bookname, int _price, String _name, int _point){
        this._bookid    =   _bookid;
        this._bookname  =   _bookname;
        this._price     =   _price;
        this._name      =   _name;
        this._point     =   _point;
    }

    public int get_orderid() {
        return _orderid;
    }

    public int get_custid() {
        return _custid;
    }

    public int get_bookid() {
        return _bookid;
    }

    public int get_saleprice() {
        return _saleprice;
    }

    public int get_price() {
        return _price;
    }

    public int get_point() {
        return _point;
    }

    public String get_name() {
        return _name;
    }

    public String get_bookname() {
        return _bookname;
    }

    public String get_orderdate() {
        return _orderdate;
    }
}
