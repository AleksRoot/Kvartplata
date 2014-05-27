/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvartplata;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Саша
 */
public class flat extends javax.swing.JFrame {
addFlat af;
   String delete;
int delete_List;
    public DefaultListModel model;

   public void select_flat() {
       
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
            String selection = "SELECT * FROM SASHA.FLAT ";
            ResultSet rs = st.executeQuery(selection);
            while(rs.next()) {
                int id = rs.getInt("FLAT_ID");
            String text = rs.getString("FLAT_NAME");
            String street = id + ". " + text;
            model.addElement(street);
            flatList.setModel(model);}
           
            
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
            String deletion = "DELETE FROM SASHA.FLAT WHERE FLAT_ID =  %d";
            delete = String.format(deletion, delete_List);
            st.executeUpdate(delete);
        } catch (ClassNotFoundException | SQLException e) {
            String a = e.getMessage();
    }
   }

    public flat() {
       model = new DefaultListModel();
        initComponents();
        select_flat();
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
        flatList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        flatList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flatListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(flatList);

        addButton.setText("addName");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
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
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
         af = new addFlat(model);
          af.setVisible(true);
       

    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
int[] indexesForDeletion = flatList.getSelectedIndices();
        for (int i = 0; i < indexesForDeletion.length; i++) {
            model.remove(indexesForDeletion[i]);
        }    
        delete_List = flatList.getSelectedIndex();
        deletion(); 
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void flatListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flatListMouseClicked
        if (evt.getClickCount() == 2) {
           Object[] arrayList = flatList.getSelectedValues();
            PaymentAndCounters dialog = new PaymentAndCounters(arrayList);
            dialog.setVisible(true);    
        }
    }//GEN-LAST:event_flatListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new flat().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList flatList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
