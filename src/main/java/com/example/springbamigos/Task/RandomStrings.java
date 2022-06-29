package com.example.springbamigos.Task;

import org.apache.tomcat.jni.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.sql.*;

import static org.hibernate.type.descriptor.java.JdbcDateTypeDescriptor.DATE_FORMAT;


public class RandomStrings {

    public static void main(String[] args) {
        int i = 1;
        int limit = 1000000;
        int ID = 0;

        while (i <= limit && ID <= limit) {
            ID++;

            // create a string of all characters
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-";

            // create random string builder
            StringBuilder sb = new StringBuilder();

            // create an object of Random class
            Random random = new Random();

            // specify length of random string
            int length = 10;

            for (int j = 0; j < length; j++) {

                // generate random index number
                int index = random.nextInt(alphabet.length());

                // get character specified by index
                // from the string
                char randomChar = alphabet.charAt(index);
                // append the character to string builder
                sb.append(randomChar);
            }

            String randomString = sb.toString();
            i++;

            int[] catID = {1, 4, 7, 9, 10, 11, 12, 13, 14};
            Random Category = new Random();
            int category = Category.nextInt(0, 8);


            int[] UserID = {1, 2, 3, 4, 5, 6};

            Random user = new Random();
            int User = user.nextInt(0, 5);

            GregorianCalendar gc = new GregorianCalendar();

            int year = randBetween(2022, 2050);

            gc.set(gc.YEAR, year);

            int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

            gc.set(gc.DAY_OF_YEAR, dayOfYear);

            // System.out.println("Id: " + ID + " Task Name: " + randomString + " Category: " + cat [category] + " User Name: " + UserName[User] +" Date: " + (gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)) );

            Connection conn = null;
            Statement stmt = null;
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (Exception e) {
                    System.out.println(e);
                }
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDO", "root", "As400eer2003!");
                System.out.println("Connection is created successfully:");
                stmt = (Statement) conn.createStatement();


                String query1 = "INSERT INTO Tasks (Title,CategoryID,UserID,complDate) VALUES ( '" + randomString + "', " + catID[category] + ", " + UserID[User] + ",'" + (gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH)) + "')";

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
                } catch (SQLException se) {
                }
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                //
            }
            System.out.println("Please check it in the MySQL Table......... ……..");
        }
    }


    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }


}

