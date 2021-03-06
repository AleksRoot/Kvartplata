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
    ArrayList al2 = new ArrayList();
    int FlatID;
    Object arrList;
    int payment_id;
    String sel;
    String delete;
    String delete_List;
    String delete_id;
    int DeleteNumber;
    String TOTAL;
    int monthNumber;
    String totaled;
    Double total;
    int YearName;
    String Year;
    int Payment_id;
    String updation;
    String Language_text;

    Months(Object arrayList, int Flatid, String Language_text) {
        this.arrList = arrayList;
        this.Language_text = Language_text;
        model = new DefaultListModel();
        model2 = new DefaultListModel();
        initComponents();

        sel = (String) arrList;
        jLabel1.setText(sel);

        FlatID = Flatid;
        jList1.setVisible(false);
        monthList.setVisible(false);
        jTextArea1.setVisible(false);
        addMonth.setVisible(false);
        removeMonth.setVisible(false);
        editCounter.setVisible(false);
        RefreshButton.setVisible(false);
        back.setVisible(false);
        if (Language_text == "Укр") {
        jLabel2.setText("Рік");
        SelectYearButton.setText("Вибрати рік");
        addMonth.setText("Добавити місяць");
        removeMonth.setText("Видалити місяць");
        RefreshButton.setText("Оновити");
        back.setText("Назад");
        }
        else {
         jLabel2.setText("Year");
         SelectYearButton.setText("Select year");
         addMonth.setText("Add month");
         removeMonth.setText("Delete month");
         RefreshButton.setText("Refresh");
          back.setText("Back");
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
        RefreshButton = new javax.swing.JButton();
        YearText = new javax.swing.JTextField();
        SelectYearButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        jList1.setEnabled(false);
        jScrollPane3.setViewportView(jList1);

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        YearText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        YearText.setText("2014");

        SelectYearButton.setText("Select Year");
        SelectYearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectYearButtonActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Year");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(YearText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(SelectYearButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(addMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(removeMonth))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(editCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectYearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addMonth)
                            .addComponent(removeMonth)
                            .addComponent(RefreshButton)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCounter)
                    .addComponent(back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthListMouseClicked
        TOTAL = "";

        monthNumber = monthList.getSelectedIndex() + 1;
        select_counters();
        for (int i = 0; i < al.size(); i = i + 2) {
            totaled = "'%s' = '%s'";
            TOTAL = TOTAL + String.format(totaled, al.get(i), al.get(i + 1)) + "\n";
        }
        select_total();
        TOTAL = TOTAL + "\n" + "Загальна сума = " + String.valueOf(total);
        jTextArea1.setText(TOTAL);
        al.clear();
        if (evt.getClickCount() == 2) {
            // Object array = monthList.getSelectedValue();
            // String select = (String) array;

            Object monthName = monthList.getSelectedValue();
            String sel2 = sel + " " + (String) monthName;

            PaymentCounter dialog = new PaymentCounter(monthNumber, sel2, FlatID, arrList, Year, Language_text);
            dialog.setVisible(true);

        }
    }//GEN-LAST:event_monthListMouseClicked

    private void editCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCounterActionPerformed
        monthNumber = monthList.getSelectedIndex() + 1;

        editCounters dialog3 = new editCounters();
        dialog3.setVisible(true);

    }//GEN-LAST:event_editCounterActionPerformed

    private void addMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMonthActionPerformed

        newMonth dialog2 = new newMonth(FlatID, model, model2, arrList, TOTAL, al, Language_text);
        dialog2.setVisible(true);

    }//GEN-LAST:event_addMonthActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void removeMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMonthActionPerformed
        int[] indexesForDeletion = monthList.getSelectedIndices();
        int[] indexesForDeletion2 = jList1.getSelectedIndices();
        DeleteNumber = monthList.getSelectedIndex() + 1;
        delete_List = (String) monthList.getSelectedValue();
        delete_id = (String) jList1.getSelectedValue();
        deletion();
        delete_payment_counter();
        for (int i = 0; i < indexesForDeletion.length; i++) {
            model.remove(indexesForDeletion[i]);
            model2.remove(indexesForDeletion[i]);

        }
    }//GEN-LAST:event_removeMonthActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        model.clear();
        model2.clear();
        select_month(FlatID);
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SelectYearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectYearButtonActionPerformed
        model.clear();
        model2.clear();
        Year = YearText.getText();
        YearName = Integer.parseInt(Year);
        jList1.setVisible(true);
        monthList.setVisible(true);
        jTextArea1.setVisible(true);
        addMonth.setVisible(true);
        removeMonth.setVisible(true);

        RefreshButton.setVisible(true);
        back.setVisible(true);
        select_month(FlatID);
        select_max_payment();
        select_last_first();
    }//GEN-LAST:event_SelectYearButtonActionPerformed
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
            String selection = "SELECT * FROM SASHA.PAYMENT WHERE FLAT_ID = %d AND YEARS = '%s' ORDER BY PAYMENT_ID";
            String select = String.format(selection, Flatid, Year);
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

    public void select_max_payment() {
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
            String selection1 = "SELECT MAX(PAYMENT_ID)  FROM SASHA.PAYMENT_DETAILS WHERE FLAT_ID = %d AND YEARS = '%s'";
            String select1 = String.format(selection1, FlatID, Year);

            ResultSet rs = st.executeQuery(select1);
            while (rs.next()) {
                Payment_id = rs.getInt("1");
            }

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }

    public void select_last_first() {
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

            String selection = "SELECT * FROM SASHA.PAYMENT_DETAILS WHERE PAYMENT_ID = %d AND FLAT_ID = %d AND YEARS = '%s'";
            int payment_id = Integer.valueOf(Payment_id);
            String select = String.format(selection, payment_id, FlatID, Year);
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                String text = rs.getString("COUNTER_NAME");
                double last_first = rs.getDouble("NEW_COUNTER");

                al2.add(last_first);
                al2.add(text);
            }
            String update = "UPDATE SASHA.COUNTER_TYPE SET LAST_FIRST = %f WHERE COUNTER_NAME = '%s'";

            for (int i = 0; i < al2.size(); i = i + 2) {
                updation = String.format(Locale.ENGLISH, update, al2.get(i), al2.get(i + 1));
                st.execute(updation);
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
            String deletion = "DELETE FROM SASHA.PAYMENT WHERE DATE =  '%s' AND YEARS = '%s'";

            delete = String.format(deletion, delete_List, Year);
            st.executeUpdate(delete);
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }
    }

    public void delete_payment_counter() {
        String driver = "org.apache.derby.jdbc.ClientDriver";//Имя драйвера
        String user = "sasha";//Логин пользователя
        String password = "sasha";//Пароль пользователя
        String url = "jdbc:derby://localhost:1527/komynPoslygu";//URL адрес

        try {
            Class.forName(driver);
            Connection c = null;
            c = DriverManager.getConnection(url, user, password);
            Statement st = c.createStatement();
            String deletion = "DELETE FROM SASHA.PAYMENT_DETAILS WHERE PAYMENT_ID =  %d AND YEARS = '%s'";

            delete = String.format(deletion, DeleteNumber, Year);
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
            String selection = "SELECT * FROM SASHA.PAYMENT_DETAILS WHERE FLAT_ID = %d AND PAYMENT_ID = %d AND YEARS = '%s'";
            String select = String.format(selection, FlatID, monthNumber, Year);
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
            String selection = "SELECT * FROM SASHA.PAYMENT WHERE PAYMENT_ID = %d AND FLAT_ID = %d AND YEARS = '%s'";
            String select = String.format(selection, monthNumber, FlatID, Year);
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {

                total = rs.getDouble("TOTAL_COST");

            }

        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SelectYearButton;
    private javax.swing.JTextField YearText;
    private javax.swing.JButton addMonth;
    private javax.swing.JButton back;
    private javax.swing.JButton editCounter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList monthList;
    private javax.swing.JButton removeMonth;
    // End of variables declaration//GEN-END:variables
}
