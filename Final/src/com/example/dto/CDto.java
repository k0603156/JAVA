package com.example.dto;

public class CDto {
    int     _custid;
    String  _name;
    String  _address;
    String  _phone;
    int     _point;

    public CDto(int _custid, String _name, String _address, String _phone, int _point){
        this._custid=_custid;
        this._name=_name;
        this._address=_address;
        this._phone=_phone;
        this._point=_point;
    }

    public CDto(int _custid, String _address, String _phone){
        this._custid=_custid;
        this._name=_name;
        this._address=_address;
        this._phone=_phone;
        this._point=_point;
    }

    public CDto(String _name, String _address, String _phone){
        this._custid=_custid;
        this._name=_name;
        this._address=_address;
        this._phone=_phone;
        this._point=_point;
    }

    public int get_custid() {
        return _custid;
    }

    public String get_name() {
        return _name;
    }

    public String get_address() {
        return _address;
    }

    public String get_phone() {
        return _phone;
    }

    public int get_point() {
        return _point;
    }

}
