package com.zzt.DAO;

import com.zzt.Utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDAo {
    QueryRunner queryRunner=new QueryRunner();
    //考虑事务的增删改
    public  void   upDateOne(String sql,Object...args){
        //获取链接
        Connection co= JdbcUtils.getConnection();

        try {
            co.setAutoCommit(false);
            int update = queryRunner.update(co, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                co.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                co.commit();
                JdbcUtils.close(co);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //考虑事务的查询一条记录
    public  <T> T queryOneList(Class<T>type,String sql,Object...args) {
        //获取链接
        Connection co = JdbcUtils.getConnection();
        //取消自动提交
        try {
            co.setAutoCommit(false);
            T query = queryRunner.query(co, sql, new BeanHandler<T>(type), args);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                co.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                co.commit();
                JdbcUtils.close(co);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }
    //考虑事务查询多条记录
    public <T> List<T> queryAll( Class<T>type,String sql,Object...args){
        Connection co=JdbcUtils.getConnection();
        try {
            co.setAutoCommit(false);
            return  queryRunner.query(co,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                co.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                co.commit();
                JdbcUtils.close(co);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }
    //查询一个记录
    public Object queryForOne(String sql,Object...args){
         Connection co=JdbcUtils.getConnection();
        try {
            co.setAutoCommit(false);
            return  queryRunner.query(co,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                co.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                co.commit();
                JdbcUtils.close(co);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }

    public <T> T queryObject(Class<T> type,  String sql, Object... args) {
        Connection co= JdbcUtils.getConnection();
        try {
            return  queryRunner.query(co, sql, new BeanHandler<T>(type), args);
        }  catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }}
}
