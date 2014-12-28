/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvartplata2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Саша
 */
public class newMonth extends javax.swing.JFrame {

    String MonthName;
    ArrayList CN = new ArrayList();
    ArrayList R = new ArrayList();
    ArrayList R2 = new ArrayList();
    ArrayList LF = new ArrayList();
    ArrayList IC = new ArrayList();
    ArrayList DATE = new ArrayList();
    String PC = "0";
    String NC = "0";
    String RC = "0";
    String CD = "0";
    String T = "0";
    String MS = "0";
    String DateName;
    String DayName;
    String YearName;
    String lastFirst;
    int Language;
    boolean is_counter;
    boolean warning;

    public newMonth(int Language) {
        this.Language = Language;
        initComponents();
        warningMessage.setVisible(false);
        warning = false;
        if (Language == 0) {
            labelMonth.setText("Введіть дату");
            buttonCreate.setText("Створити");
            buttonCancel.setText("Відмінити");
            checkBox.setText("Теперішня");
            warningMessage.setText("Місяць вже існує!");
        } else {
            labelMonth.setText("Enter date");
            buttonCreate.setText("Create");
            buttonCancel.setText("Cancel");
            checkBox.setText("Current");
            warningMessage.setText("Month already exists!");
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

        buttonCreate = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelMonth = new javax.swing.JLabel();
        dayName = new javax.swing.JTextField();
        checkBox = new javax.swing.JCheckBox();
        monthName = new javax.swing.JTextField();
        yearName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        warningMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonCreate.setText("Створити");
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });

        buttonCancel.setText("Відмінити");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        labelMonth.setBackground(new java.awt.Color(255, 255, 255));
        labelMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonth.setText("Введіть дату");
        labelMonth.setEnabled(false);
        labelMonth.setOpaque(true);

        checkBox.setText("Теперішня");

        yearName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearNameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(".");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(".");

        warningMessage.setBackground(new java.awt.Color(0, 0, 0));
        warningMessage.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        warningMessage.setForeground(new java.awt.Color(255, 0, 51));
        warningMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(dayName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monthName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearName, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBox)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(buttonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(labelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(warningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addComponent(checkBox))
                    .addComponent(dayName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreate)
                    .addComponent(buttonCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
        DayName = dayName.getText();
        MonthName = monthName.getText();
        YearName = yearName.getText();
        DateName = DayName + "." + MonthName + "." + YearName;
        if (checkBox.isSelected()) {
            Date d = new Date();
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            DateName = format1.format(d);

        }
        month_checker();
        for (int i = 0; i<DATE.size();i++){
        if (DATE.get(i).equals(DateName))
            warning = true;
            }
        if (warning  == true){
        warningMessage.setVisible(true);
        }
        else{
            select_defaultCounters();
        insert_month();
        update_lastFirst();
        this.setVisible(false);
        }
        
    }//GEN-LAST:event_buttonCreateActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void yearNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearNameActionPerformed

    /**
     * @param args the command line arguments
     */
  public void  month_checker(){
  String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "aleks";//Логин пользователя
        String password = "roots";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komyn2";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
            String selection = "SELECT * FROM MONTHS";
            ResultSet rs = st.executeQuery(selection);
            while (rs.next()) {
                String text = rs.getString("MONTH_NAME");
               DATE.add(text);

            }
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    
  }

    public void select_defaultCounters() {
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "aleks";//Логин пользователя
        String password = "roots";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komyn2";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
            String selection = "SELECT * FROM DEFAULT_COUNTERS";
            ResultSet rs = st.executeQuery(selection);
            while (rs.next()) {
                String text = rs.getString("COUNTER_NAME");
                String rate = rs.getString("RATE");
                String rate2 = rs.getString("RATE2");
                lastFirst = rs.getString("LAST_FIRST");
                is_counter = rs.getBoolean("IS_COUNTER");
                CN.add(text);
                R.add(rate);
                R2.add(rate2);
                LF.add(lastFirst);
                IC.add(is_counter);

            }
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }

    public void insert_month() {
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "aleks";//Логин пользователя
        String password = "roots";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komyn2";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
            String insertion = "INSERT INTO MONTHS (MONTH_NAME, MONTH_SUM) VALUES ('%s', '%s')";
            String insert = String.format(insertion, DateName, MS);
            st.execute(insert);
            for (int i = 0; i < CN.size(); i++) {
                insertion = "INSERT INTO ALEKS.COUNTERS (MONTH_NAME, COUNTER_NAME, RATE, RATE150, "
                        + " NEW_COUNTER, PREVIOUS_COUNTER, COUNTER_DIFFERENCE, TOTAL) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
                insert = String.format(insertion, DateName, CN.get(i), R.get(i), R2.get(i), NC, PC, CD, T);
                st.execute(insert);
            }
           
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }
    
    public void update_lastFirst() {
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "aleks";//Логин пользователя
        String password = "roots";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komyn2";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
            String insertion;
            String insert;
            for (int j = 0; j < IC.size();j++){
            if ((boolean)IC.get(j) == true){
                insertion = "UPDATE ALEKS.COUNTERS SET NEW_COUNTER = '%s', PREVIOUS_COUNTER = '%s' "
                        + "WHERE MONTH_NAME = '%s' AND COUNTER_NAME = '%s'";
                insert = String.format(insertion, NC, LF.get(j), DateName, CN.get(j));
                st.execute(insert);
            }
            else {
             insertion = "UPDATE ALEKS.COUNTERS SET NEW_COUNTER = '%s', PREVIOUS_COUNTER = '%s'" 
                     + "WHERE MONTH_NAME = '%s' AND COUNTER_NAME = '%s'";
                insert = String.format(insertion, LF.get(j), PC, DateName, CN.get(j));
                st.execute(insert);
            }
            }
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonCreate;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JTextField dayName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelMonth;
    private javax.swing.JTextField monthName;
    private javax.swing.JLabel warningMessage;
    private javax.swing.JTextField yearName;
    // End of variables declaration//GEN-END:variables
}