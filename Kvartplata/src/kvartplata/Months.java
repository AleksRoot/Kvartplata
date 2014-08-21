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
import javax.swing.DefaultListModel;

/**
 *
 * @author Саша
 */
public class Months extends javax.swing.JFrame {

    public DefaultListModel model;
    public DefaultListModel model2;
     ArrayList al = new ArrayList();
    int FlatID;
Object arrList;
int payment_id;
String sel;
  String delete;
String delete_List;
String delete_id;
String TOTAL;
int monthNumber;
String totaled;
Double total;



    Months(Object arrayList, int Flatid) {
       this.arrList= arrayList;
       
        model = new DefaultListModel();
        model2 = new DefaultListModel();
        initComponents();
        
        sel = (String) arrList;
        jLabel1.setText(sel);
        select_month(Flatid);
        FlatID = Flatid;
       
    }

    public void select_month(int Flatid) {

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
            String selection = "SELECT * FROM SASHA.PAYMENT WHERE FLAT_ID = %d";
            String select = String.format(selection, Flatid);
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                String text = rs.getString("DATE");
               payment_id = rs.getInt("PAYMENT_ID");
                model.addElement(text);
                monthList.setModel(model);
                model2.addElement(payment_id);
                jList1.setModel(model2);
            }

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }
 public void deletion() {
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
            String deletion = "DELETE FROM SASHA.PAYMENT WHERE DATE =  '%s'";
            delete = String.format(deletion, delete_List);
            st.executeUpdate(delete);
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
    }
   }
 public void select_counters() {

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
            String selection = "SELECT * FROM SASHA.PAYMENT_DETAILS WHERE FLAT_ID = %d AND PAYMENT_ID = %d";
            String select = String.format(selection, FlatID, monthNumber);
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                String text = rs.getString("COUNTER_NAME");
             double Total = rs.getDouble("TOTAL");
                al.add(text);
                al.add(Total);
            }

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }
 public void select_total() {

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
            String selection = "SELECT * FROM SASHA.PAYMENT WHERE PAYMENT_ID = %d AND FLAT_ID = %d";
            String select = String.format(selection, monthNumber, FlatID);
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {

                
                total =  rs.getDouble("TOTAL_COST");
                
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
        monthList = new javax.swing.JList();
        addMonth = new javax.swing.JButton();
        removeMonth = new javax.swing.JButton();
        editCounter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        monthList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(monthList);

        addMonth.setText("Add Month");
        addMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMonthActionPerformed(evt);
            }
        });

        removeMonth.setText("Remove Month");
        removeMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMonthActionPerformed(evt);
            }
        });

        editCounter.setText("editCounters");
        editCounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCounterActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(removeMonth)))
                .addGap(19, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addMonth)
                        .addComponent(removeMonth)))
                .addGap(18, 18, 18)
                .addComponent(editCounter))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthListMouseClicked
         TOTAL = "";
         
        monthNumber = monthList.getSelectedIndex() + 1;
          select_counters();
           for (int i =0;i<al.size();i=i+2){
        totaled = "'%s' = '%s'";
        TOTAL = TOTAL + String.format(totaled, al.get(i), al.get(i+1)) + "\n";
        }
           select_total();
           TOTAL = TOTAL + "\n"+ "Загальна сума = "  + String.valueOf(total);
          jTextArea1.setText(TOTAL);
          al.clear();
         if (evt.getClickCount() == 2) {
           // Object array = monthList.getSelectedValue();
            // String select = (String) array;
        
        Object monthName = monthList.getSelectedValue();  
          
       PaymentCounter dialog = new PaymentCounter(monthNumber, monthName, FlatID,  arrList);  dialog.setVisible(true);   
           
        }
    }//GEN-LAST:event_monthListMouseClicked

    private void editCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCounterActionPerformed
          monthNumber = monthList.getSelectedIndex() + 1;
        editCounters dialog3 = new editCounters(monthNumber, FlatID);         dialog3.setVisible(true);
    }//GEN-LAST:event_editCounterActionPerformed

    private void addMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMonthActionPerformed

        newMonth dialog2 = new newMonth(FlatID, model, model2, arrList, TOTAL);        dialog2.setVisible(true);
    }//GEN-LAST:event_addMonthActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void removeMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMonthActionPerformed
       int[] indexesForDeletion = monthList.getSelectedIndices();
        int[] indexesForDeletion2 = jList1.getSelectedIndices();

delete_List = (String) monthList.getSelectedValue();
delete_id = (String) jList1.getSelectedValue();
deletion(); 
        for (int i = 0; i < indexesForDeletion.length; i++) {
            model.remove(indexesForDeletion[i]);
            model2.remove(indexesForDeletion[i]);
            
        }   
    }//GEN-LAST:event_removeMonthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMonth;
    private javax.swing.JButton back;
    private javax.swing.JButton editCounter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList monthList;
    private javax.swing.JButton removeMonth;
    // End of variables declaration//GEN-END:variables
}
