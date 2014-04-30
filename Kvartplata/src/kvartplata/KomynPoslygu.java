/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvartplata;

/**
 *
 * @author Саша
 */
public class KomynPoslygu extends Object {

    public int Id;
    public String Name;
    public double LichKinc;
    public double LichPoch;
    public double Taruf;
//UPDATE SASHA.KOMYNPOSLYGU SET Сума = (ЛІЧИЛЬНИККІНЦЕВИЙ - ЛІЧИЛЬНИКПОЧАТКОВИЙ)*ТАРИФ;
//select * from SASHA.KOMYNPOSLYGU;

    @Override
    public String toString() {
        return Name;
    }

}
