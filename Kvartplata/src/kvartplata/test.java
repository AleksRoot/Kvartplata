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
import java.util.*;

/**
 *
 * @author Саша
 */
public class test {
   
    public static void main(String[] args) {
      
     double a = 5.123232313; 
     String b = "%.2f";
     b = String.format(Locale.ENGLISH,b, a);
    a= Double.parseDouble(b);
     System.out.println("a = " + a);
     
    
    }
}
