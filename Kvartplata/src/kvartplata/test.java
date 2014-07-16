/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvartplata;

import java.util.ArrayList;
import java.util.Locale;
/**
 *
 * @author Саша
 */
public class test {
    public static void main(String[] args) {
        
        Datas data = new Datas();
        ArrayList AL = new ArrayList();
        
        data.id = 1;
        data.text = "Газ";
        data.previous_counter = 10.2;
        data.new_counter = data.previous_counter + 5;
        data.rate = data.previous_counter / 10;
       
       //AL.add(data);
       AL.add(data.id); AL.add(data.text); AL.add(data.previous_counter); AL.add(data.new_counter); AL.add(data.rate); 
      for (int i=0;i<AL.size();i++){
       System.out.println(AL.get(i));
       }
        


//String update;
       // String updation = "Rezult = %d.%s: %f, %f, %f";
      
 //for (int number = 0; number< al.size(); number++) {
         //      update = String.format(Locale.ENGLISH, updation, al.get(number),  al.get(number+1) , al.get(number+2), al.get(number+3), al.get(number+4));
              //  System.out.println(update);
          // }
       
       
       
        
        
        
        
        
    }
}
