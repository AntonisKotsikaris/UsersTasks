package com.example.springbamigos.Task;

import java.sql.*;



public class InserData {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("http://localhost:8080/User/allusers", "root", "As400eer2003!");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();


            String query1 = "INSERT INTO ToDO " + "VALUES (1, 'John', 34)";
            stmt.executeUpdate(query1);

            System.out.println("Record is inserted in the table successfully..................");
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");
    }
}

