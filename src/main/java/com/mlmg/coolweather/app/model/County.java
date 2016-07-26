package com.mlmg.coolweather.app.model;

/**
 * Created by mlmg on 2016/7/26.
 */
public class County {

    private int id;

    private String county_name;

    private String county_code;

    private int city_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public String getCounty_code() {
        return county_code;
    }

    public void setCounty_code(String county_code) {
        this.county_code = county_code;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
}
