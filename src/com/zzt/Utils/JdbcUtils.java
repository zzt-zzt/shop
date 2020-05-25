package com.zzt.Utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource dataSource;
    static{

        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
              Connection co=null;
        try {
            co=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  co;
    }
    public  static  void  close(Connection co){
         if(co!=null){
             try {
                 co.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
    }
}
