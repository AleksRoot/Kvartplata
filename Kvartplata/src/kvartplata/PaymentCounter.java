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
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Саша
 */
public class PaymentCounter extends javax.swing.JFrame {

    
    public DefaultListModel model;
    int monthNumber;
    String sel;
    int number;
    
    ArrayList al = new ArrayList();
    ArrayList al2 = new ArrayList();
    ArrayList al3 = new ArrayList();
    ArrayList al4 = new ArrayList();
    Datas data = new Datas();
Object Array;
Object Name;
String NCL;
double NCL2;
String PCL;
double  PCL2;
String RL;
double RL2;
String CurrentName;
int FlatID;
String t;

String totaled;
    Object arrayList;
    double Total;
    
    
PaymentCounter(int monthNumber, Object monthName, int FlatID,Object arrayList) {
      model = new DefaultListModel();
      this.Array = monthName;
      this.arrayList=arrayList;
      this.FlatID = FlatID;
      
      sel = (String) Array;
    
        
        initComponents();
        this.monthNumber = monthNumber;
        select_counters(monthNumber, FlatID);
 jLabel1.setText(sel);
  Rate150Field.setVisible(false);
             Calculation.setVisible(false);
             jLabel2.setVisible(false);
    }

    public void select_counters(int monthNumber, int FlatID) {

        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            //Регистрируем драйвер
            Connection c = null;//Соединение с БД
            c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
            Statement st = c.createStatement();//Готовим запрос
            String selection = "SELECT * FROM SASHA.PAYMENT_DETAILS WHERE PAYMENT_ID = %d AND FLAT_ID = %d";
            String select = String.format(selection, monthNumber, FlatID);
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {

                data.text = rs.getString("COUNTER_NAME");
                data.new_counter = rs.getDouble("NEW_COUNTER");
                data.previous_counter = rs.getDouble("PREVIOUS_COUNTER");
               data.rate = rs.getDouble("RATE");
               
                data.counter_difference = data.new_counter - data.previous_counter;
                data.total = data.counter_difference * data.rate;
                if ("Електроенергія".equals(data.text) && data.counter_difference > 150){
                    data.rate2 = rs.getDouble("RATE2");
                
                data.total = (data.counter_difference-150)*data.rate2 + 150 * data.rate;
                data.rate3 =String.valueOf(data.rate2);
                data.total2 ="(%f-150)*%f + 150 * %f)";
               data.total3 = String.format(data.total2, data.counter_difference, data.rate2, data.rate);
                }
                //al.add(data);
                al.add(data.new_counter);  al.add(data.previous_counter);  al.add(data.rate); al.add(data.counter_difference); al.add(data.total);
                 al2.add(data.counter_difference); al2.add(data.total); al2.add(data.text);
                 al3.add(data.total);
                model.addElement(data.text);

                CounterList.setModel(model);
            }
String updation1 = "UPDATE SASHA.PAYMENT_DETAILS SET COUNTER_DIFFERENCE = %f, TOTAL = %f "
        + "WHERE COUNTER_NAME = '%s' AND FLAT_ID = %d AND PAYMENT_ID = %d";
            for (int i = 0;i < al2.size(); i=i+3) {
                 
                String update1 = String.format(Locale.ENGLISH,updation1, al2.get(i), al2.get(i+1), al2.get(i+2), FlatID, monthNumber);
               st.execute(update1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }
    
      public void update_counters() {

        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            //Регистрируем драйвер
            Connection c = null;//Соединение с БД
            c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
            Statement st = c.createStatement();//Готовим запрос
            String update = "UPDATE SASHA.PAYMENT_DETAILS SET NEW_COUNTER = %f, PREVIOUS_COUNTER = %f, RATE = %f "
                    + "WHERE COUNTER_NAME = '%s' AND FLAT_ID = %d AND PAYMENT_ID = %d";
            String updation = String.format(Locale.ENGLISH,update, NCL2, PCL2, RL2, CurrentName, FlatID, monthNumber);
             st.execute(updation);

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }

   public void total() {

        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            //Регистрируем драйвер
            Connection c = null;//Соединение с БД
            c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
            Statement st = c.createStatement();//Готовим запрос
            String update = "UPDATE SASHA.PAYMENT SET TOTAL_COST = %f "
                    + "WHERE FLAT_ID = %d AND PAYMENT_ID = %d";
            String updation = String.format(Locale.ENGLISH, update,Total, FlatID, monthNumber);
             st.execute(updation);

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }
       public void true_false() {
       
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            //Регистрируем драйвер
            Connection c = null;//Соединение с БД
            c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
            Statement st = c.createStatement();//Готовим запрос
            String selection = "SELECT * FROM SASHA.COUNTER_TYPE ";
            ResultSet rs = st.executeQuery(selection);
            while(rs.next()) {
            boolean tf = rs.getBoolean("IS_COUNTER");
           al4.add(tf);
            
            
            }
            
           
            
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }
             
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CounterList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PreviousCounterLabel = new javax.swing.JTextField();
        NewCounterLabel = new javax.swing.JTextField();
        RateLabel = new javax.swing.JTextField();
        CounterDifferenceLabel = new javax.swing.JTextField();
        TotalLabel = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Rate150Field = new javax.swing.JTextField();
        Calculation = new javax.swing.JTextField();

        CounterList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CounterListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CounterList);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Previous Counter");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" New Counter");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Rate");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Counter Difference");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Total");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PreviousCounterLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousCounterLabelActionPerformed(evt);
            }
        });

        NewCounterLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewCounterLabelActionPerformed(evt);
            }
        });

        RateLabel.setEditable(false);
        RateLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RateLabelActionPerformed(evt);
            }
        });

        CounterDifferenceLabel.setEditable(false);
        CounterDifferenceLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CounterDifferenceLabelActionPerformed(evt);
            }
        });

        TotalLabel.setEditable(false);
        TotalLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalLabelActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Back");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText(" Rate > 150");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Rate150Field.setEditable(false);

        Calculation.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Calculation)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PreviousCounterLabel)
                                    .addComponent(RateLabel)
                                    .addComponent(NewCounterLabel)
                                    .addComponent(CounterDifferenceLabel)
                                    .addComponent(TotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addComponent(Rate150Field)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PreviousCounterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewCounterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CounterDifferenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Rate150Field, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(Calculation, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.setVisible(false);
          
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void PreviousCounterLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousCounterLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousCounterLabelActionPerformed

    private void CounterListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CounterListMouseClicked
        Rate150Field.setVisible(false);
             Calculation.setVisible(false);
             jLabel2.setVisible(false);
        true_false();
        number = CounterList.getSelectedIndex();
        data.Name = String.valueOf(CounterList.getSelectedValue());
        if ("Електроенергія".equals(data.Name)){
            Rate150Field.setVisible(true);
             Calculation.setVisible(true);
         Calculation.setText(data.total3);
         Rate150Field.setText(data.rate3);
         jLabel2.setVisible(true);
        }
        int i = (number)*5;
       boolean True_False = (boolean) al4.get(number);
       if (True_False == true){
       jLabel3.setVisible(true);
       PreviousCounterLabel.setVisible(true);
       jLabel5.setVisible(true);
       RateLabel.setVisible(true);
       jLabel6.setVisible(true);
       CounterDifferenceLabel.setVisible(true);
       }
       else {
        jLabel3.setVisible(false);
       PreviousCounterLabel.setVisible(false);
       jLabel5.setVisible(false);
       RateLabel.setVisible(false);
       jLabel6.setVisible(false);
       CounterDifferenceLabel.setVisible(false);
       }
       String NC = Double.toString((double) al.get(i));
        NewCounterLabel.setText(NC);
         String PC = Double.toString((double) al.get(i+1));
        PreviousCounterLabel.setText(PC);
        String RA = Double.toString((double) al.get(i+2));
        RateLabel.setText(RA);
        String CD = Double.toString((double) al.get(i+3));
        CounterDifferenceLabel.setText(CD);
        String TO = Double.toString((double) al.get(i+4));
        TotalLabel.setText(TO);
        
    }//GEN-LAST:event_CounterListMouseClicked

    private void NewCounterLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewCounterLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewCounterLabelActionPerformed

    private void RateLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RateLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RateLabelActionPerformed

    private void CounterDifferenceLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CounterDifferenceLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CounterDifferenceLabelActionPerformed

    private void TotalLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalLabelActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
      
        Name = CounterList.getSelectedValue();
       CurrentName = (String) Name;
        NCL = NewCounterLabel.getText();
        NCL2 = Double.parseDouble(NCL);
       PCL = PreviousCounterLabel.getText();
       PCL2 =Double.parseDouble(PCL);
       RL = RateLabel.getText();
       RL2 =Double.parseDouble(RL);
       update_counters();
       model.removeAllElements();
       al.clear();
       al2.clear();
      Total = (double) al3.get(0);
      for (int i=1;i<al3.size();i++){
      Total = Total + (double) al3.get(i);
      }
      total();
       select_counters(monthNumber,FlatID);
       
        
     
       // this.setVisible(false);
       // Months dialog = new Months(arrayList, FlatID, TOTAL);            dialog.setVisible(true);  
    }//GEN-LAST:event_SaveButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Calculation;
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField CounterDifferenceLabel;
    private javax.swing.JList CounterList;
    private javax.swing.JTextField NewCounterLabel;
    private javax.swing.JTextField PreviousCounterLabel;
    private javax.swing.JTextField Rate150Field;
    private javax.swing.JTextField RateLabel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField TotalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
