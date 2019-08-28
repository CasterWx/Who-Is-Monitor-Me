package dao.impl;


import dao.IHttpDAO;
import domain.Http;

import java.sql.*;
import java.util.ArrayList;

public class HttpDAOImpl implements IHttpDAO {
    public static Connection connection = null ;

    public void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("连接成功");
        }catch (Exception e){
            System.out.println("连接失败");
        }
        try{
            connection = DriverManager.getConnection("jdbc:mysql://45.32.136.190:3306/httpdb","antz","antz!");
        }catch (Exception e){
        }
    }

    public void shutdownConnection(){
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
        }
    }
    @Override
    public void save(Http http) {
        setConnection();
        Statement statement = null ;
        try {
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "INSERT INTO t_http(id,hostname,ip,address,date) VALUES('"+http.getId()+"','"+http.getHostname()+"','"+http.getIp()+"',null ,'"+ http.getDate()+"');";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }
        }
        shutdownConnection();
    }

    @Override
    public ArrayList<Http> list() {
        ArrayList<Http> list  = new ArrayList<Http>() ;
        setConnection();
        Statement statement = null ;
        ResultSet resultSet = null ;
        Http http = null ;
        try {
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "SELECT * FROM t_http" ;
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                http = new Http() ;
                http.setId(resultSet.getLong("id"));
                http.setHostname(resultSet.getString("hostname"));
                http.setIp(resultSet.getString("ip"));
                http.setDate(resultSet.getString("date"));
                http.setAddress(resultSet.getString("address"));
                list.add(http) ;
            }
            return list ;
        }catch (Exception e){
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }finally {
                try{
                    if(resultSet!=null){
                        resultSet.close();
                    }
                }catch (Exception e){
                }
            }
        }
        shutdownConnection();
        return list;
    }

}
