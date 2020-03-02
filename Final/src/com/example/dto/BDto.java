package com.example.dto;

public class BDto {
    int     _bookid;
    String  _bookname;
    String  _publisher;
    int     _price;
    int     _stock;

    public BDto(int _bookid, String _bookname, String _publisher, int _price, int _stock){
        this._bookid=_bookid;
        this._bookname=_bookname;
        this._publisher=_publisher;
        this._price=_price;
        this._stock=_stock;
    }
    public BDto(String _bookname, String _publisher, int _price){
        this._bookname=_bookname;
        this._publisher=_publisher;
        this._price=_price;
    }
    public BDto(int _bookid, int _stock){
        this._bookid=_bookid;
        this._stock=_stock;
    }
    public int get_bookid() {
        return _bookid;
    }

    public String get_bookname() {
        return _bookname;
    }

    public String get_publisher() {
        return _publisher;
    }

    public int get_price() {
        return _price;
    }

    public int get_stock() {
        return _stock;
    }
}
