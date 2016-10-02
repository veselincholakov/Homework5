package com.example.veski.homework5;

/**
 * Created by veski on 2.10.2016 г..
 */

public class ListItem {
    private int _id;
    private String _some_name;
    private String _some_info;
    public static int currentId = 0;

    public ListItem(){
        this._id = currentId;
        this._some_name = "some name";
        this._some_info = "some_info";
        currentId++;
    }

    public ListItem(int id, String name, String info){
        _some_info = info;
        _id = id;
        _some_name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_some_name() {
        return _some_name;
    }

    public void set_some_name(String _some_name) {
        this._some_name = _some_name;
    }

    public String get_some_info() {
        return _some_info;
    }

    public void set_some_info(String _some_info) {
        this._some_info = _some_info;
    }
}
