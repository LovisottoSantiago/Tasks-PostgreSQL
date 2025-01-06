
package org.tasks;

import java.sql.Connection;
import java.util.Scanner;


public class Login extends javax.swing.JFrame {

		public Login() {
				initComponents();
		}

		@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        getUsername = new javax.swing.JTextField();
        getPassword = new javax.swing.JPasswordField();
        login = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getUsername.setBackground(new java.awt.Color(255, 255, 255));
        getUsername.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        getUsername.setForeground(new java.awt.Color(51, 102, 255));
        getUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getUsername.setText("username");
        getUsername.setToolTipText("");
        getUsername.setActionCommand("<Not Set>");
        getUsername.setBorder(null);
        getUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getUsername.setOpaque(true);
        getUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(getUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 370, 62));

        getPassword.setBackground(new java.awt.Color(255, 255, 255));
        getPassword.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        getPassword.setForeground(new java.awt.Color(51, 102, 255));
        getPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getPassword.setText("jPasswordField1");
        getPassword.setBorder(null);
        getPassword.setOpaque(true);
        getPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(getPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 370, 62));

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        login.setForeground(new java.awt.Color(0, 0, 0));
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login.png"))); // NOI18N
        login.setText("Login");
        login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        login.setOpaque(true);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 310, 70));

        jLabel1.setBackground(null);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setDisabledIcon(null);
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 872, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getUsernameActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
				try {
						DatabaseConnection db = new DatabaseConnection();

						String username = getUsername.getText();
						String password = new String(getPassword.getPassword()); 

						Connection connection = db.getConnection(username, password);

						if (connection != null) {
								System.out.println("Connection successfully\n");
						}
						else {
								System.out.println("Error");
						}
				}
				catch(Exception e){
						System.out.println("Error" + e.getMessage());
				}
    }//GEN-LAST:event_loginActionPerformed

    private void getPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getPasswordActionPerformed

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
						java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
				//</editor-fold>

				/* Create and display the form */
				java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
								new Login().setVisible(true);
						}
				});
		}

		
		
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField getPassword;
    private javax.swing.JTextField getUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton login;
    // End of variables declaration//GEN-END:variables
}
