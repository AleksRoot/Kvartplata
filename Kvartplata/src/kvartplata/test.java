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
        Scanner robot = new Scanner(System.in);
     double a = 5; 
     int b;
     System.out.println("a = " + a);
     
    
       do {
            System.out.println("Zminutu a?");
            System.out.println("1.Tak");
            System.out.println("2.Ni");
            
           
            b = robot.nextInt();
        } while (b != 1 && b != 2);
        switch (b) {
            case 1:
                System.out.println("Vvedit' nove a:");
                a = robot.nextInt();
                break;
            case 2:
            break;
        }
        System.out.println("a = " + a);
}
}
