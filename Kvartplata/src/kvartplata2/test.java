/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvartplata2;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author Саша
 */
public class test {

    public static void main(String args[]) {
         
         String date1 = "20.12.2014";
         String date2 = "19.12.2014";
         String date3 = "20.12.2014";
         String date4 = "01.01.2015";
         
         
     
System.out.println(date1.compareTo(date2));
System.out.println(date1.compareTo(date3));
System.out.println(date1.compareTo(date4));
}}
