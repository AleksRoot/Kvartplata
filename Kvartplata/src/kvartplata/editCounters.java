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
public class editCounters extends javax.swing.JFrame {

    public DefaultListModel model;
    double Rate;
    double Rate2;
    boolean Is_Counter;
    String Type_Id;
    String text;
   
    String delete;
String delete_List;
String delete_id;
String RF;
double RF2;
String R150F;
double R150F2;

int number;
String Name;
String CounterName;
ArrayList al = new ArrayList();
ArrayList al2 = new ArrayList();
ArrayList al3 = new ArrayList();
 Datas data = new Datas();

  
     editCounters() {
        
       model = new DefaultListModel();
        initComponents();
        Rate150Field.setVisible(false);
        Rate150Label.setVisible(false);
       
        select();
       
    }
      public void select() {
       
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
            String select = "SELECT * FROM SASHA.COUNTER_TYPE";
            
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
           // Type_Id = rs.getString("TYPE_ID");
           data.text = rs.getString("COUNTER_NAME");
            data.rate = rs.getDouble("RATE");
            data.rate2 = rs.getDouble("RATE2");
            data.Is_Counter = rs.getBoolean("IS_COUNTER");
            al.add(data.text);
            al.add(data.rate);
            al2.add(data.rate2);
            al3.add(data.Is_Counter);
           // Is_Counter = rs.getBoolean("IS_COUNTER");
            model.addElement(data.text);
            serviceList.setModel(model);
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
            String deletion = "DELETE FROM  SASHA.COUNTER_TYPE WHERE COUNTERS_NAME =  '%s'";
            delete = String.format(deletion, delete_List);
            st.executeUpdate(delete);
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
    }
   }
 public void update_counter() {

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
            String update = "UPDATE SASHA.COUNTER_TYPE SET RATE = %f, IS_COUNTER = %b WHERE COUNTER_NAME = '%s'";
            String updation = String.format(Locale.ENGLISH,update, RF2, data.Is_Counter, CounterName);
             st.execute(updation);

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
            String update = "UPDATE SASHA.PAYMENT_DETAILS SET RATE = %f WHERE COUNTER_NAME = '%s'";
            String updation = String.format(Locale.ENGLISH,update, RF2,  CounterName);
             st.execute(updation);

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }
 public void update_counter_el() {

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
            String update = "UPDATE SASHA.PAYMENT_DETAILS SET RATE = %f, RATE2 = %f WHERE COUNTER_NAME = '%s'";
            String updation = String.format(Locale.ENGLISH,update, RF2,  R150F2,CounterName);
             st.execute(updation);

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }
 public void update_counters_el() {

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
            String update = "UPDATE SASHA.COUNTER_TYPE SET RATE = %f, RATE2 = %f WHERE COUNTER_NAME = '%s'";
            String updation = String.format(Locale.ENGLISH,update, RF2, R150F2, CounterName);
             st.execute(updation);

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
        serviceList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        RateField = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        Rate150Label = new javax.swing.JLabel();
        Rate150Field = new javax.swing.JTextField();
        AddCounterButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        serviceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(serviceList);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Name");

        jLabel3.setText("Rate");

        jLabel4.setText("Is Counter");

        NameField.setEditable(false);
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        RateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RateFieldActionPerformed(evt);
            }
        });

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        Rate150Label.setText("Rate > 150");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(Rate150Label)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addComponent(RateField, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addComponent(Rate150Field)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rate150Label)
                    .addComponent(Rate150Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AddCounterButton.setText("Add Counter");
        AddCounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCounterButtonActionPerformed(evt);
            }
        });

        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.setToolTipText("");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        BackButton.setText("Back");
        BackButton.setToolTipText("");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddCounterButton)
                        .addGap(41, 41, 41)
                        .addComponent(RemoveButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(SaveButton)
                        .addGap(72, 72, 72)
                        .addComponent(BackButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddCounterButton)
                    .addComponent(RemoveButton)
                    .addComponent(SaveButton)
                    .addComponent(BackButton))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
       
    }//GEN-LAST:event_NameFieldActionPerformed

    private void serviceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceListMouseClicked
RateField.setEditable(true);
Rate150Field.setVisible(false);
Rate150Label.setVisible(false);
        number = serviceList.getSelectedIndex();
    Name =  (String)al.get((number)*2);
     NameField.setText(Name);
        String Rate2 =    String.valueOf(al.get((number*2 + 1))) ;
        RateField.setText(Rate2);
        //№3... 3 - 1 = 2.... a v array №5. №4... 4 -1 = 3. a v array №7
      if ((boolean)al3.get(number) == true){
jCheckBox1.setSelected(true);
}
else jCheckBox1.setSelected(false);
       
        if ("Холодна вода кухня".equals(Name)){
         Rate2 =    String.valueOf(al.get((1))) ;
        RateField.setText(Rate2);
        
       
RateField.setEditable(false);
        }
        
        if ("Стоки кухня".equals(Name)){
        Rate2 =    String.valueOf(al.get((5))) ;
        RateField.setText(Rate2);
        
       
RateField.setEditable(false);
        }
       
       if ("Електроенергія".equals(Name))
       {
           
Rate150Field.setVisible(true);
Rate150Label.setVisible(true);
String Rate3 = String.valueOf(al2.get((number))) ;
Rate150Field.setText(Rate3);

       }
    }//GEN-LAST:event_serviceListMouseClicked

    private void RateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RateFieldActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

Rate150Field.setVisible(false);
Rate150Label.setVisible(false);
CounterName = NameField.getText();
RF = RateField.getText();
RF2 = Double.parseDouble(RF);
if (jCheckBox1.isSelected()){
data.Is_Counter = true;
}
else data.Is_Counter = false;
update_counter();

if ("Електроенергія".equals(Name)){
    R150F = Rate150Field.getText();
R150F2 = Double.parseDouble(R150F);
      update_counters_el();
      update_counter_el();
      }
update_counters();
 model.removeAllElements();
 serviceList.removeAll();
 al.clear();
select();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void AddCounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCounterButtonActionPerformed
    newCounter dialog = new newCounter(model);dialog.setVisible(true);
    }//GEN-LAST:event_AddCounterButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
         int[] indexesForDeletion = serviceList.getSelectedIndices();
       

delete_List = (String) serviceList.getSelectedValue();

deletion(); 
        for (int i = 0; i < indexesForDeletion.length; i++) {
            model.remove(indexesForDeletion[i]);
           
            
        }   
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCounterButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField Rate150Field;
    private javax.swing.JLabel Rate150Label;
    private javax.swing.JTextField RateField;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList serviceList;
    // End of variables declaration//GEN-END:variables
}
