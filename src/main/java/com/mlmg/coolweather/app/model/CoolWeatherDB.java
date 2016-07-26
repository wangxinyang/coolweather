package com.mlmg.coolweather.app.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mlmg.coolweather.app.db.CoolWeatherOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlmg on 2016/7/26.
 */
public class CoolWeatherDB {

    /**
     * 数据库名
     */
    public static final String DB_NAME = "cool_weather";
    /**
     * 数据库版本
     */
    public static final int VERSION = 1;
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    private CoolWeatherDB (Context context) {
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public synchronized static CoolWeatherDB getInstance (Context context) {
        if (coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    /**
     * 保存省
     */
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvince_name());
            values.put("province_code", province.getProvince_code());
            db.insert("Province", null, values);
        }
    }

    /**
     * 从数据库读取全国所有的省份信息。
     */
    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvince_name(cursor.getString(cursor
                        .getColumnIndex("province_name")));
                province.setProvince_code(cursor.getString(cursor
                        .getColumnIndex("province_code")));
                list.add(province);
            } while (cursor.moveToNext());
        }
        return list;
    }

    /**
     * 保存市
     */
    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCity_name());
            values.put("city_code", city.getCity_code());
            values.put("province_id", city.getProvince_id());
            db.insert("City", null, values);
        }
    }

    /**
     * 从数据库读取市信息。
     */
    public List<City> loadCities() {
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCity_name(cursor.getString(cursor
                        .getColumnIndex("city_name")));
                city.setCity_code(cursor.getString(cursor
                        .getColumnIndex("city_code")));
                city.setProvince_id(cursor.getInt(cursor.getColumnIndex("province_id")));
                list.add(city);
            } while (cursor.moveToNext());
        }
        return list;
    }

    /**
     * 保存区
     */
    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCounty_name());
            values.put("county_code", county.getCounty_code());
            values.put("city_id", county.getCity_id());
            db.insert("County", null, values);
        }
    }

    /**
     * 从数据库读取区信息。
     */
    public List<County> loadCounties() {
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCounty_name(cursor.getString(cursor
                        .getColumnIndex("county_name")));
                county.setCounty_code(cursor.getString(cursor
                        .getColumnIndex("county_code")));
                county.setCity_id(cursor.getInt(cursor.getColumnIndex("city_id")));
                list.add(county);
            } while (cursor.moveToNext());
        }
        return list;
    }
}
