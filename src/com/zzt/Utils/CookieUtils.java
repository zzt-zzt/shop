package com.zzt.Utils;

import org.junit.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CookieUtils {
    public static void addCookie(String cookieKey, String name, String password, int time, HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie=returnCookie(request,cookieKey);
  /*      String code=name+"#"+password;*/
        try {
            String encode1 = URLEncoder.encode(name+"#"+password, "utf-8");
            //判断Cookie是否存在 存在的话就在原来的基础上修改values值，不存在就新建一份cookie
            if(cookie!=null){
                cookie.setValue(encode1);
            }else{
                cookie=new Cookie(cookieKey,encode1);
            }
            //设置最长存活时长
            cookie.setMaxAge(time);
            //设置作用的范围
            cookie.setPath(request.getContextPath());
            //通过响应发送到浏览器
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void addCookie1(String cookieKey, String values,  int time, HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie=returnCookie(request,cookieKey);
        /*      String code=name+"#"+password;*/
        try {
            String encode1 = URLEncoder.encode(values, "utf-8");
            //判断Cookie是否存在 存在的话就在原来的基础上修改values值，不存在就新建一份cookie
            if(cookie!=null){
                cookie.setValue(encode1);
            }else{
                cookie=new Cookie(cookieKey,encode1);
            }
            //设置最长存活时长
            cookie.setMaxAge(time);
            //设置作用的范围
            cookie.setPath(request.getContextPath());
            //通过响应发送到浏览器
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Cookie returnCookie(HttpServletRequest request, String cookieKey) {
        //先获取浏览器的cookie值，判断是否已经存在存放密码和用户名的cookieKey,;
        Cookie[] cookies = request.getCookies();
        //遍历数组
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(cookieKey)){
                    //如果Cookie中本来就有name值，则返回cookie
                    return  cookie;
                }
            }
        }
        return  null;
    }
    public static Cookie returnCookie(HttpServletRequest request, int cookieKey) {
        //先获取浏览器的cookie值，判断是否已经存在存放密码和用户名的cookieKey,;
        Cookie[] cookies = request.getCookies();
        //遍历数组
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(cookieKey)){
                    //如果Cookie中本来就有name值，则返回cookie
                    return  cookie;
                }
            }
        }
        return  null;
    }



}
