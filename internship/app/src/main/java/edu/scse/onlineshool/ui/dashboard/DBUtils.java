package edu.scse.onlineshool.ui.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://39.102.38.93:3306/DzDw?useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";
    private static String password = "123456";
    public static Connection getConn(){
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
