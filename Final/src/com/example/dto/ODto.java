package com.example.dto;

public class ODto {
    int _bookid;
    String _bookname;
    int _price;

    String _name;
    int _point;

    public ODto( int _bookid, String _bookname, int _price, String _name, int _point){
        this._bookid=_bookid;
        this._bookname=_bookname;
        this._price=_price;
        this._name=_name;
        this._point=_point;
    }

    public int get_bookid() {
        return _bookid;
    }

    public String get_bookname() {
        return _bookname;
    }

    public int get_price() {
        return _price;
    }

    public String get_name() {
        return _name;
    }

    public int get_point() {
        return _point;
    }

}
