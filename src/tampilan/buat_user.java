package tampilan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;

public final class buat_user extends javax.swing.JInternalFrame {
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    String sql;

    private void nonaktif() {
        txt_id.setEnabled(false);
        txt_user.setEnabled(false);
        txt_pass.setEnabled(false);
        txt_nama.setEnabled(false);
        txt_level.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_kosong.setEnabled(false);
        
    }
    
    private void aktif() {
        txt_id.setEnabled(false);
        txt_user.setEnabled(true);
        txt_pass.setEnabled(true);
        txt_nama.setEnabled(true);
        txt_level.setEnabled(true);
        btn_simpan.setEnabled(true);
        btn_kosong.setEnabled(true);
        btn_tambah.setEnabled(false);
    }

    protected void kosong() {
        txt_id.setText(null);
        txt_user.setText(null);
        txt_pass.setText(null);
        txt_nama.setText(null);
    }
    
    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }

    public void lebarKolom() {
        TableColumn kolom;
        tbl_login.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tbl_login.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(30);
        kolom = tbl_login.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(60);
        kolom = tbl_login.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(80);
        kolom = tbl_login.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(100);
        kolom = tbl_login.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(100);
        kolom = tbl_login.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(100);
    }

    public void dataTable() {
        Object[] Baris = {"No", "ID", "Username", "Password", "Nama User", "Level"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_login.setModel(tabmode);
        String sql = "select * from tb_login order by id asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String id = hasil.getString("id");
                String username = hasil.getString("username");
                String password = hasil.getString("password");
                String nama = hasil.getString("nama");
                String level = hasil.getString("level");
                String[] data = {"", id, username, password, nama, level};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (SQLException e) {
        }
    }
    
        private void ID(){
       try {
            sql="select * from tb_login order by id desc";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()) {
                String id = rs.getString("id").substring(3);
                String AN = "" + (Integer.parseInt(id) + 1);
                String Nol = "";

                switch (AN.length()) {
                    case 1:
                        Nol = "000";
                        break;
                    case 2:
                        Nol = "00";
                        break;
                    case 3:
                        Nol = "0";
                        break;
                    case 4:
                        Nol = "";
                        break;
                    default:
                        break;
                }
               txt_id.setText("ID" + Nol + AN);
            } else {
               txt_id.setText("ID0001");
            }

           }catch(NumberFormatException | SQLException e){
           JOptionPane.showMessageDialog(null, e);
           }
     }

//    public void pencarian(String sql) {
//        Object[] Baris = {"No", "ID", "Username", "Nama User", "Level"};
//        tabmode = new DefaultTableModel(null, Baris);
//        tbl_login.setModel(tabmode);
//        int brs = tbl_login.getRowCount();
//        for (int i = 0; 1 < brs; i++) {
//            tabmode.removeRow(1);
//        }
//            try {
//            java.sql.Statement stat = conn.createStatement();
//            ResultSet hasil = stat.executeQuery(sql);
//            while (hasil.next()) {
//                String id = hasil.getString("id");
//                String username = hasil.getString("username");
//                String nama = hasil.getString("nama");
//                String level = hasil.getString("level");
//                String[] data = {"", id, username, nama, level};
//                tabmode.addRow(data);
//                noTable();
//                lebarKolom();
//            }
//        } catch (SQLException e) {
//        }
//    }

    /**
     * Creates new form Form_Jaminan_Personal
     */
    public buat_user() {
        initComponents();
        nonaktif();
        ID();
        dataTable();
        lebarKolom();
        txt_id.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txt_pass = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_tutup = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_kosong = new javax.swing.JButton();
        txt_level = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_login = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("USER");
        setMinimumSize(new java.awt.Dimension(948, 441));

        jPanel11.setBackground(new java.awt.Color(255, 180, 0));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar User"));
        jPanel9.setMinimumSize(new java.awt.Dimension(381, 341));

        txt_pass.setBackground(new java.awt.Color(204, 204, 204));
        txt_pass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Nama User");

        txt_nama.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Level");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("ID");

        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        txt_id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Username");

        txt_user.setBackground(new java.awt.Color(204, 204, 204));
        txt_user.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Password");

        btn_tambah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_plus_math_16px.png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_2_16px.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_edit_16px.png"))); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_tutup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_tutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_sign_16px.png"))); // NOI18N
        btn_tutup.setText("Tutup");
        btn_tutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tutupActionPerformed(evt);
            }
        });

        btn_simpan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_save_16px.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_kosong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_kosong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_erase_16px.png"))); // NOI18N
        btn_kosong.setText("Reset");
        btn_kosong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kosongActionPerformed(evt);
            }
        });

        txt_level.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- Pilih -->", "admin", "user" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)
                            .addComponent(jLabel17)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_pass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_kosong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(btn_tambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_tutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_ubah)
                    .addComponent(btn_simpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus)
                    .addComponent(btn_kosong)
                    .addComponent(btn_tutup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("| Daftar User");

        tbl_login.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_loginMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_login);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(948, 403));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        kosong();
        aktif();
        ID();
        txt_id.requestFocus();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, " Apakah Anda Yakin Ingin Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from tb_login where id ='" + txt_id.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                ID();
                nonaktif();
                btn_tambah.setEnabled(true);
                txt_id.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus" + e);
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        String sql = "update tb_login set id=?,username=?,password=(?),nama=?,level=? where id='" + txt_id.getText() + "'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_id.getText());
                stat.setString(2, txt_user.getText());
                stat.setString(3, txt_pass.getText());
                stat.setString(4, txt_nama.getText());
                stat.setString(5, (String) txt_level.getSelectedItem());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                kosong();
                dataTable();
                lebarKolom();
                ID();
                txt_id.requestFocus();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_tutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tutupActionPerformed
        // TODO add your handling code here:
        dispose();
        ID();
    }//GEN-LAST:event_btn_tutupActionPerformed

    private void tbl_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_loginMouseClicked
        // TODO add your handling code here:
        int bar = tbl_login.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        txt_id.setText(b);
        txt_user.setText(c);
        txt_pass.setText(d);
        txt_nama.setText(e);
        txt_level.setSelectedItem(f);
        aktif();
    }//GEN-LAST:event_tbl_loginMouseClicked

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        if (txt_id.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada yang kosong");
        } else if (txt_user.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada yang kosong");
        } else if (txt_pass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada yang kosong");
        } else if (txt_nama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada yang kosong");
        } else if (txt_level.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada yang kosong");
        } else {
            String sql = "insert into tb_login values (?,?,?,?,?)";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_id.getText());
                stat.setString(2, txt_user.getText());
                stat.setString(3, txt_pass.getText());
                stat.setString(4, txt_nama.getText());
                stat.setString(5, (String) txt_level.getSelectedItem());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                dataTable();
                lebarKolom();
                kosong();
                ID();
                nonaktif();
                btn_tambah.setEnabled(true);
                txt_user.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, " Data Gagal Disimpan " + e);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_kosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kosongActionPerformed
        // TODO add your handling code here:
        kosong();
        ID();
    }//GEN-LAST:event_btn_kosongActionPerformed
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kosong;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_tutup;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_login;
    private javax.swing.JTextField txt_id;
    private javax.swing.JComboBox<String> txt_level;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

}
