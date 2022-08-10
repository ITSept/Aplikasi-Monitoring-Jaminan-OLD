package tampilan;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import koneksi.koneksi;

public class login extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private menu_utama mn = new menu_utama();
    
    public login() {
        initComponents();
        hi.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Tuser = new javax.swing.JTextField();
        Blogin = new javax.swing.JButton();
        Tpass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        target = new javax.swing.JLabel();
        hi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 180, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        Tuser.setBackground(new java.awt.Color(204, 204, 204));
        Tuser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Tuser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Tuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TuserMouseClicked(evt);
            }
        });
        Tuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TuserKeyReleased(evt);
            }
        });

        Blogin.setBackground(new java.awt.Color(51, 51, 51));
        Blogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Blogin.setForeground(new java.awt.Color(255, 255, 255));
        Blogin.setText("Login");
        Blogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloginActionPerformed(evt);
            }
        });

        Tpass.setBackground(new java.awt.Color(204, 204, 204));
        Tpass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Tpass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Tpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TpassKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Blogin, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tpass, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tuser, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tpass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Blogin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 147, -1, 160));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo_user.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 11, 301, -1));

        target.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        target.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        target.setText("LOGIN");
        jPanel2.add(target, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 107, 290, 30));

        hi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(hi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 58, 22));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 380, 330);

        setSize(new java.awt.Dimension(382, 367));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void TpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TpassKeyReleased
        // TODO add your handling code here:
        hi.setVisible(true);
        hi.setText("HI,");                     
    }//GEN-LAST:event_TpassKeyReleased

    private void BloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloginActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet result=stat.executeQuery ("select * from tb_login where username='" +Tuser.getText()+"'");
            if (result.next()) {
                if (Tpass.getText().equals(result.getString("password"))) {
                    
                if(result.getString("level").equals("admin")){
                    mn.infouser.setText(result.getString("username"));
                    mn.infonama.setText(result.getString("nama"));
                    mn.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    mn.setVisible(true);
                    this.dispose();
                }else if(result.getString("level").equals("user")){
                    mn.infouser.setText(result.getString("username"));
                    mn.infonama.setText(result.getString("nama"));
                    mn.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    mn.setVisible(true);
                    mn.menusistem.setEnabled(true);
                    mn.add_user.setEnabled(false);
                    mn.marketing.setEnabled(false);
                    this.dispose();
                }
                    } else {
                    JOptionPane.showMessageDialog(rootPane,"Password Salah, Silahkan masukkan ulang");
                    Tpass.setText("");
                    Tuser.requestFocus();                
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Username Salah, Silahkan masukkan ulang");
                Tuser.setText("");
                Tpass.setText("");
                Tuser.requestFocus();
            }
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Login");
        }
    }//GEN-LAST:event_BloginActionPerformed

    private void TuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TuserKeyReleased
        // TODO add your handling code here:
        hi.setVisible(false);
        if(!Tuser.getText().equalsIgnoreCase("")){
            target.setText(Tuser.getText());
        } else {
            target.setText("LOGIN");
        }
    }//GEN-LAST:event_TuserKeyReleased

    private void TuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TuserMouseClicked
        // TODO add your handling code here:
     //   JOptionPane.showInputDialog(null, "Masukkan Angka");
    }//GEN-LAST:event_TuserMouseClicked

    public static void main(String args[]) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Blogin;
    private javax.swing.JPasswordField Tpass;
    private javax.swing.JTextField Tuser;
    private javax.swing.JLabel hi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel target;
    // End of variables declaration//GEN-END:variables
}
