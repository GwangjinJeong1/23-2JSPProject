package com.example.jspproject.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mariadb://walab.handong.edu:3306/p233_21900651?user=p233_21900651", "p233_21900651", "eeSh7E");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 오류!");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("DB연결 오류!");
            throw new RuntimeException(e);
        }
        return conn;
    }

//    public static void main(String arg[]) {
//        System.out.println("DB 연결");
//        Connection conn = MariaDBConnection.getConnection();
//        if (conn == null) {
//            System.out.println("DB연결오류");
//        } else {
//            System.out.println("DB 연결!!");
//        }
//    }
}
