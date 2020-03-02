package com.example.dto;

public class BDto {
    int     _bookid;
    String  _bookname;
    String  _publisher;
    int     _price;
    int     _count;

    public BDto(int _bookid, String _bookname, String _publisher, int _price, int _count){
        this._bookid=_bookid;
        this._bookname=_bookname;
        this._publisher=_publisher;
        this._price=_price;
        this._count=_count;
    }
    public BDto(String _bookname, String _publisher, int _price){
        this._bookname=_bookname;
        this._publisher=_publisher;
        this._price=_price;
    }
    public BDto(int _bookid, int _count){
        this._bookid=_bookid;
        this._count=_count;
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

    public int get_count() {
        return _count;
    }
}
