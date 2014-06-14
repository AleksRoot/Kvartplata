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

/**
 *
 * @author Саша
 */
public class PaymentAndCounters extends javax.swing.JFrame {

    public DefaultListModel model;
    public DefaultListModel model2;
    int FlatID;

    PaymentAndCounters(Object arrayList, int Flatid) {
        model = new DefaultListModel();
        model2 = new DefaultListModel();
        initComponents();
        String select;
        select = (String) arrayList;
        jLabel1.setText(select);
        select_month(Flatid);
        FlatID = Flatid;
        jTextArea1.setText("lalala \nololo");
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
                int payment_id = rs.getInt("PAYMENT_ID");
                model.addElement(text);
                monthList.setModel(model);
                model2.addElement(payment_id);
                monthList.setModel(model2);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(removeMonth))))
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
        if (evt.getClickCount() == 2) {
            PaymentCounter dialog = new PaymentCounter(FlatID);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_monthListMouseClicked

    private void editCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCounterActionPerformed
        editCounters dialog3 = new editCounters(FlatID);
        dialog3.setVisible(true);
    }//GEN-LAST:event_editCounterActionPerformed

    private void addMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMonthActionPerformed

        newMonth dialog2 = new newMonth(FlatID, model, model2);
        dialog2.setVisible(true);
    }//GEN-LAST:event_addMonthActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed


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
