package com.zzt.Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zzt.pro.cartItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gsonUtils {

    //将javabean对象转化为字符串
    public static <T> String beanToString( T t) {
        Gson gson=new Gson();
        String s = gson.toJson(t);
        return  s;
    }
    //将字符串转化为gson对象
    public static <T> T  stringToGson(String  s,Class<T> type){

         Gson gson=new Gson();
         return gson.fromJson(s, type);
    }
    //将list对象转化为字符串
    public static <T> String listToString(List<T>list){
        Gson gson=new Gson();
        String s = gson.toJson(list);
        return  s;
    }
    //将字符串转化为list对象
    public static <T>List<T>  listToGson(String  s){
        Gson gson=new Gson();
        return gson.fromJson(s,  new TypeToken<List<T>>() {}.getType());
    }
    //将map对象转化为字符串
    public static <T> String  mapToString(Map<Integer, cartItem> map){
        Gson gson=new Gson();
        String s = gson.toJson(map);
        return  s;

    }
    //将字符串转化为map对象
    public static   Map<Integer, cartItem> StringToMap(String  s){
        Gson gson=new Gson();
     return     gson.fromJson(s,new TypeToken<HashMap<Integer, cartItem>>() {}.getType());
    }
}
