/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvartplata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Саша
 */
public class test {
   
    public static void main(String[] args) {
        double counter_difference = 250;
        double rate2 = 1.0;
       double rate = 2.0;
       String total2;
        String total3;
 total2 = "(%f-150)*%f + 150 * %f)";
 total3 = String.format(total2, counter_difference, rate2, rate);
     
      System.out.println(total3);
       
  
      
}
}
