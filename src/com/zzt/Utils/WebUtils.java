package com.zzt.Utils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(  T bean ,Map value){
        try {
            System.out.println(" 注入之前：" + bean);

            BeanUtils.populate(bean, value);
            System.out.println(" 注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String strInt,int defaultValue) {
        try {
           /* return Integer.parseInt(strInt);*/
            if(strInt !=null){
                 return Integer.parseInt(strInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
    public static String pareString(String sth,String defaultValue){
        if(sth!=null){
            return  sth;
        }else{
            return  defaultValue;
        }
    }
    public static double parseDouble(String strdouble,double defaultValue) {
        try {
            /* return Integer.parseInt(strInt);*/
            if(strdouble !=null&&strdouble!=""){
                return Double.parseDouble(strdouble);
            }
            else{
                return defaultValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
    @Test
    public void aa(){
        double v = parseDouble("1.1", 0);
        System.out.println(v);
    }


}
