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
public class newMonth extends javax.swing.JFrame {

    public DefaultListModel model;
    public DefaultListModel model2;
    String Month;
    String MonthNumber;
    int MN;
    int Flatid;
    Object arrayList;
    ArrayList al3 = new ArrayList();
    ArrayList al = new ArrayList();
    ArrayList al2 = new ArrayList();
    ArrayList al4 = new ArrayList();
    String TOTAL;
    Datas data = new Datas();
    String YearName;
    String Language_text;

    public newMonth(int FlatID, DefaultListModel model, DefaultListModel model2, Object arrayList, String TOTAL, ArrayList al3, String Language_text) {
        this.al3 = al3;
        this.Language_text=Language_text;
        this.arrayList = arrayList;
        Flatid = FlatID;
        initComponents();
        this.model = model;
        this.model2 = model2;
        this.TOTAL = TOTAL;
         if (Language_text == "Укр") {
       jLabel1.setText("Імя місяця");
       jLabel2.setText("Номер місяця");
        jLabel3.setText("Імя року");
       cancelButton.setText("Назад");
      MonthName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жовтень", "Листопад", "Грудень" }));
        }
        else {
       jLabel1.setText("Month name");
         jLabel2.setText("Month number");
          jLabel3.setText("Year name");
         cancelButton.setText("Back");
         MonthName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
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

        jLabel1 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        MonthName = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        YearNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Month name");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Month Number");

        MonthName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "October", "December" }));

        jLabel3.setText("Year Name");

        YearNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        YearNameField.setText("2014");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MonthName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(YearNameField))
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MonthName)
                    .addComponent(YearNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        YearName = YearNameField.getText();
        MonthNumber = jTextField1.getText();
        MN = Integer.parseInt(MonthNumber);
        Month = (String) MonthName.getSelectedItem();
        insert_month();
        select_counters();
        insert_counters();
        model.addElement(Month);
        model2.addElement(MonthNumber);
        Months m = new Months(arrayList, Flatid, Language_text);
        m.select_month(Flatid);

        this.setVisible(false);


    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed
    public void insert_month() {
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
            String insertion = "INSERT INTO SASHA.PAYMENT(FLAT_ID, PAYMENT_ID, DATE, YEARS) VALUES (%d, %d, '%s', '%s')";
            String insert = String.format(insertion, Flatid, MN, Month, YearName);

            st.execute(insert);
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
            String selection = "SELECT * FROM SASHA.COUNTER_TYPE";
            ResultSet rs = st.executeQuery(selection);
            while (rs.next()) {
                data.text = rs.getString("COUNTER_NAME");
                data.rate = rs.getDouble("RATE");
                data.rate2 = rs.getDouble("RATE2");
                data.last_first = rs.getDouble("LAST_FIRST");
                data.Is_Counter = rs.getBoolean("IS_COUNTER");
                al2.add(data.text);
                al2.add(data.rate);
                al2.add(data.rate2);
                al4.add(data.last_first);
                if (data.Is_Counter == true)
                al4.add("PREVIOUS_COUNTER");
                else al4.add("NEW_COUNTER");
            }

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }

    public void insert_counters() {
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
           
                    String insertion = "INSERT INTO SASHA.PAYMENT_DETAILS(FLAT_ID, YEARS, COUNTER_NAME, %s, RATE, RATE2, PAYMENT_ID) VALUES (%d, '%s','%s',%f, %f, %f, %d)";
                    for (int i = 0, j = 0; i < al2.size(); i = i + 3, j = j + 2) {
                        
                        String insert = String.format(Locale.ENGLISH, insertion, al4.get(j+1), Flatid, YearName, al2.get(i), al4.get(j), al2.get(i + 1), al2.get(i + 2), MN);
                        st.execute(insert);
                   
               
            }
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox MonthName;
    private javax.swing.JTextField YearNameField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
