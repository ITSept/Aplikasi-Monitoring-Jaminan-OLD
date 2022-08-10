package tampilan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public final class form_jm_kpr extends javax.swing.JInternalFrame {
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
  
    private void aktif() {
        txt_cif.setEnabled(true);
        txt_ktp.setEnabled(true);
        txt_nama_debitur.setEnabled(true);
        txt_no_vault.setEnabled(true);
        txt_nama_dokumen.setEnabled(true);
        txt_no_dokumen.setEnabled(true);
        txt_ket.setEnabled(true);
        btn_tambah.setEnabled(false);
        btn_simpan.setEnabled(true);
        btn_batal.setEnabled(true);
        btn_keluar.setEnabled(true);
    }

        private void nonaktif() {
        txt_cif.setEnabled(true);
        txt_ktp.setEnabled(false);
        txt_nama_debitur.setEnabled(false);
        txt_no_vault.setEnabled(false);
        txt_nama_dokumen.setEnabled(false);
        txt_no_dokumen.setEnabled(false);
        txt_ket.setEnabled(false);
        btn_tambah.setEnabled(true);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        btn_keluar.setEnabled(true);   
    }

    protected void kosong() {
        txt_ktp.setText(null);
        txt_nama_debitur.setText(null);
        txt_no_vault.setText(null);
        txt_nama_dokumen.setText(null);
        txt_no_dokumen.setText(null);
        txt_ket.setText(null);
    }
    
      public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }

    public void tanggal() {
        //Date tgl = new Date();
        //btn_tanggal.setDate(tgl);
    }

    public void lebarKolom() {
        TableColumn kolom;
        tbl_jaminan_kpr.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(30);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(100);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(200);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(6);
        kolom.setPreferredWidth(200);
        kolom = tbl_jaminan_kpr.getColumnModel().getColumn(7);
        kolom.setPreferredWidth(200);
    }

    public void dataTable() {
        Object[] Baris = {"No", "No CIF", "No KTP", "Nama Debitur", "Nomor Vault", "Nama Dokumen", "Nomor Dokumen", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_jaminan_kpr.setModel(tabmode);
        String sql = "select * from tb_jm_kpr order by no_cif asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_cif = hasil.getString("no_cif");
                String no_ktp = hasil.getString("no_ktp");
                String nama_debitur = hasil.getString("nama_debitur");
                String no_vault = hasil.getString("no_vault");
                String nama_dokumen = hasil.getString("nama_dokumen");
                String no_dokumen = hasil.getString("no_dokumen");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", no_cif, no_ktp, nama_debitur, no_vault, nama_dokumen, no_dokumen, keterangan};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (SQLException e) {
        }
    }

    public void pencarian(String sql) {
        Object[] Baris = {"No", "No CIF", "No KTP", "Nama Debitur", "Nomor Vault", "Nama Dokumen", "Nomor Dokumen", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_jaminan_kpr.setModel(tabmode);
        int brs = tbl_jaminan_kpr.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
               String no_cif = hasil.getString("no_cif");
                String no_ktp = hasil.getString("no_ktp");
                String nama_debitur = hasil.getString("nama_debitur");
                String no_vault = hasil.getString("no_vault");
                String nama_dokumen = hasil.getString("nama_dokumen");
                String no_dokumen = hasil.getString("no_dokumen");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", no_cif, no_ktp, nama_debitur, no_vault, nama_dokumen, no_dokumen, keterangan};
                tabmode.addRow(data);
                noTable();
            }
        } catch (SQLException e) {
        }
    }

    public form_jm_kpr() {
        initComponents();
        dataTable();
        lebarKolom();
        nonaktif();
//        aktif();
        tanggal();
        txt_ktp.requestFocus();
        txt_cif.setEditable(false);
        txt_cif.setText(new SimpleDateFormat("mmss").format(new java.util.Date()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uform_jm_kpr = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        ubtn_batal = new javax.swing.JButton();
        ubtn_simpan = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        utxt_nama_debitur = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        utxt_no_vault = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        utxt_ket = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        utxt_cif = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        utxt_ktp = new javax.swing.JTextField();
        utxt_no_dokumen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        utxt_nama_dokumen = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_nama_debitur = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_no_vault = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ket = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cif = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_ktp = new javax.swing.JTextField();
        txt_no_dokumen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nama_dokumen = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_jaminan_kpr = new javax.swing.JTable();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();

        uform_jm_kpr.setMinimumSize(new java.awt.Dimension(640, 600));

        jPanel7.setBackground(new java.awt.Color(255, 180, 0));
        jPanel7.setFocusable(false);
        jPanel7.setMinimumSize(new java.awt.Dimension(620, 600));
        jPanel7.setPreferredSize(new java.awt.Dimension(620, 600));
        jPanel7.setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Execute"));
        jPanel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel10.setMinimumSize(new java.awt.Dimension(146, 420));
        jPanel10.setLayout(null);

        ubtn_batal.setBackground(new java.awt.Color(51, 51, 51));
        ubtn_batal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ubtn_batal.setForeground(new java.awt.Color(255, 255, 255));
        ubtn_batal.setText("BATAL");
        ubtn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubtn_batalActionPerformed(evt);
            }
        });
        jPanel10.add(ubtn_batal);
        ubtn_batal.setBounds(14, 72, 108, 34);

        ubtn_simpan.setBackground(new java.awt.Color(51, 51, 51));
        ubtn_simpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ubtn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        ubtn_simpan.setText("SIMPAN");
        ubtn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubtn_simpanActionPerformed(evt);
            }
        });
        jPanel10.add(ubtn_simpan);
        ubtn_simpan.setBounds(14, 27, 108, 34);

        jPanel7.add(jPanel10);
        jPanel10.setBounds(450, 90, 146, 450);

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("UBAH DATA JAMINAN KPR");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(40, 40, 560, 29);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        utxt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_nama_debiturKeyPressed(evt);
            }
        });
        jPanel8.add(utxt_nama_debitur, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 103, 252, 27));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Nomor Vault");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 146, -1, -1));

        utxt_no_vault.setBackground(new java.awt.Color(204, 204, 204));
        utxt_no_vault.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_no_vault.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_no_vaultKeyPressed(evt);
            }
        });
        jPanel8.add(utxt_no_vault, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 141, 252, 27));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Keterangan");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Nama Dokumen");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 184, -1, -1));

        utxt_ket.setBackground(new java.awt.Color(204, 204, 204));
        utxt_ket.setColumns(20);
        utxt_ket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_ket.setRows(5);
        jScrollPane3.setViewportView(utxt_ket);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 255, 252, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Nomor Dokumen");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 222, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("No CIF");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 32, -1, -1));

        utxt_cif.setBackground(new java.awt.Color(204, 204, 204));
        utxt_cif.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_cif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_cifKeyPressed(evt);
            }
        });
        jPanel8.add(utxt_cif, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 27, 252, 27));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("No KTP");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 70, -1, -1));

        utxt_ktp.setBackground(new java.awt.Color(204, 204, 204));
        utxt_ktp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_ktp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_ktpKeyPressed(evt);
            }
        });
        jPanel8.add(utxt_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 65, 252, 27));

        utxt_no_dokumen.setBackground(new java.awt.Color(204, 204, 204));
        utxt_no_dokumen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel8.add(utxt_no_dokumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 217, 252, 27));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Nama Debitur");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 108, -1, -1));

        utxt_nama_dokumen.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_dokumen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_nama_dokumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_nama_dokumenKeyPressed(evt);
            }
        });
        jPanel8.add(utxt_nama_dokumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 179, 252, 27));

        jPanel7.add(jPanel8);
        jPanel8.setBounds(40, 90, 392, 450);

        javax.swing.GroupLayout uform_jm_kprLayout = new javax.swing.GroupLayout(uform_jm_kpr.getContentPane());
        uform_jm_kpr.getContentPane().setLayout(uform_jm_kprLayout);
        uform_jm_kprLayout.setHorizontalGroup(
            uform_jm_kprLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        uform_jm_kprLayout.setVerticalGroup(
            uform_jm_kprLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uform_jm_kprLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("JAMINAN KPR");

        jPanel1.setBackground(new java.awt.Color(255, 180, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel1.setText("JAMINAN KPR");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));

        txt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nama_debiturKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nama_debiturKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Nomor Vault");

        txt_no_vault.setBackground(new java.awt.Color(204, 204, 204));
        txt_no_vault.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_no_vault.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_no_vaultKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_no_vaultKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Keterangan");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Nama Dokumen");

        txt_ket.setBackground(new java.awt.Color(204, 204, 204));
        txt_ket.setColumns(20);
        txt_ket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_ket.setRows(5);
        jScrollPane1.setViewportView(txt_ket);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Nomor Dokumen");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("No CIF");

        txt_cif.setBackground(new java.awt.Color(204, 204, 204));
        txt_cif.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cifKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cifKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("No KTP");

        txt_ktp.setBackground(new java.awt.Color(204, 204, 204));
        txt_ktp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_ktp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ktpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ktpKeyTyped(evt);
            }
        });

        txt_no_dokumen.setBackground(new java.awt.Color(204, 204, 204));
        txt_no_dokumen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_no_dokumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_no_dokumenKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nama Debitur");

        txt_nama_dokumen.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_dokumen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nama_dokumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nama_dokumenKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_no_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txt_no_vault, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nama_debitur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cif, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_nama_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cif, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_vault, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nama_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(82, 82, 82))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Execute"));
        jPanel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_simpan.setBackground(new java.awt.Color(51, 51, 51));
        btn_simpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_save_16px.png"))); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_keluar.setBackground(new java.awt.Color(51, 51, 51));
        btn_keluar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_keluar.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_sign_16px.png"))); // NOI18N
        btn_keluar.setText("KELUAR");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        btn_batal.setBackground(new java.awt.Color(51, 51, 51));
        btn_batal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_refresh_16px.png"))); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(51, 51, 51));
        btn_tambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_plus_math_16px.png"))); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_batal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Input Data", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian"));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Pencarian");

        btn_cari.setBackground(new java.awt.Color(51, 51, 51));
        btn_cari.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_search_16px.png"))); // NOI18N
        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        txt_cari.setBackground(new java.awt.Color(204, 204, 204));
        txt_cari.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });

        tbl_jaminan_kpr.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_jaminan_kpr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_jaminan_kprMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_jaminan_kpr);

        btn_ubah.setBackground(new java.awt.Color(51, 51, 51));
        btn_ubah.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_edit_16px.png"))); // NOI18N
        btn_ubah.setText("UBAH");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(51, 51, 51));
        btn_hapus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_erase_16px.png"))); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_cetak.setBackground(new java.awt.Color(51, 51, 51));
        btn_cetak.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_cetak.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_print_16px_1.png"))); // NOI18N
        btn_cetak.setText("CETAK");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tabel Data", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1200, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
          int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from tb_jm_kpr where no_cif='" + txt_cif.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txt_cif.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus" + e);
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
          if (txt_cif.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No CIF Tidak boleh kosong");
        } else if (txt_ktp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No KTP Tidak boleh kosong");
        } else if (txt_nama_debitur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Debitur Tidak boleh kosong");
        } else if (txt_no_vault.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Vault Tidak boleh kosong");
        } else if (txt_nama_dokumen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Dokumen Tidak boleh kosong");
        } else if(txt_no_dokumen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No dokumen Tidak boleh kosong");
        } else {
            String sql = "insert into tb_jm_kpr values (?,?,?,?,?,?,?)";
          //  String tampilan = "dd-MM-yyyy";
          //  SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_cif.getText());
                stat.setString(2, txt_ktp.getText());
                stat.setString(3, txt_nama_debitur.getText());
                stat.setString(4, txt_no_vault.getText());
                stat.setString(5, txt_nama_dokumen.getText());
                stat.setString(6, txt_no_dokumen.getText());
                stat.setString(7, txt_ket.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong();
                dataTable();
                lebarKolom();
                txt_cif.requestFocus();
                nonaktif();
                btn_tambah.setEnabled(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, " Data Gagal Disimpan " + e);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed
    
    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        uform_jm_kpr.setLocationRelativeTo(this);
        utxt_cif.setEditable(false);
        uform_jm_kpr.setVisible(true);
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void ubtn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_batalActionPerformed
        // TODO add your handling code here:
        uform_jm_kpr.setVisible(false);
    }//GEN-LAST:event_ubtn_batalActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        tanggal();
        kosong();
        nonaktif();
        btn_tambah.setEnabled(true);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        String sqlPencarian = "select * from tb_jm_kpr where no_cif like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur like '%" + txt_cari.getText() + "%' or "
        + "keterangan like '%" + txt_cari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
      /**  String sqlPencarian = "select * from tb_jm_kpr where no_pinjaman like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur like '%" + txt_cari.getText() + "%' or "
        + "keterangan like '%" + txt_cari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom(); **/
    }//GEN-LAST:event_txt_cariKeyTyped

    private void txt_ktpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ktpKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_nama_debitur.requestFocus();
        }
    }//GEN-LAST:event_txt_ktpKeyPressed

    private void txt_cifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cifKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_ktp.requestFocus();
        }
    }//GEN-LAST:event_txt_cifKeyPressed

    private void txt_no_vaultKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_vaultKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_nama_dokumen.requestFocus();
        }
    }//GEN-LAST:event_txt_no_vaultKeyPressed

    private void txt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_no_vault.requestFocus();
        }
    }//GEN-LAST:event_txt_nama_debiturKeyPressed

    private void ubtn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_simpanActionPerformed
        // TODO add your handling code here:
        String sql = "update tb_jm_kpr set no_cif=?,no_ktp=?,nama_debitur=?,no_vault=?,nama_dokumen=?,no_dokumen=?,keterangan=? where no_cif='" + utxt_cif.getText() + "'";
//        String tampilan = "dd-MM-yyyy";
//        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
//        String tanggal = String.valueOf(fm.format(ubtn_tanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, utxt_cif.getText());
                stat.setString(2, utxt_ktp.getText());
                stat.setString(3, utxt_nama_debitur.getText());
                stat.setString(4, utxt_no_vault.getText());
                stat.setString(5, utxt_nama_dokumen.getText());
                stat.setString(6, utxt_no_dokumen.getText());
                stat.setString(7, utxt_ket.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                kosong();
                dataTable();
                lebarKolom();
                txt_cif.requestFocus();
                uform_jm_kpr.dispose();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }
    }//GEN-LAST:event_ubtn_simpanActionPerformed

    private void tbl_jaminan_kprMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jaminan_kprMousePressed
        // TODO add your handling code here:
        int bar = tbl_jaminan_kpr.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
//        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
//        Date dateValue = null;
//            dateValue = date.parse((String) tbl_jaminan_kpr.getValueAt(bar, 6));
        txt_cif.setText(b);
        utxt_cif.setText(b);
        txt_ktp.setText(c);
        utxt_ktp.setText(c);
        txt_nama_debitur.setText(d);
        utxt_nama_debitur.setText(d);
        txt_no_vault.setText(e);
        utxt_no_vault.setText(e);
        txt_nama_dokumen.setText(f);
        utxt_nama_dokumen.setText(f);
        txt_no_dokumen.setText(g);
        utxt_no_dokumen.setText(g);
        txt_ket.setText(h);
        utxt_ket.setText(h); 
    }//GEN-LAST:event_tbl_jaminan_kprMousePressed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {
            String path ="src/laporan/report_jm_kpr.jasper";
            Map param = new HashMap();
            param.put("pnama_debitur", txt_cari.getText());
            param.put("pno_cif", txt_cari.getText());
            JasperPrint jp = JasperFillManager.fillReport(path, param, conn);
            JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
        }
        txt_cari.setText(null);
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void txt_cifKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cifKeyTyped
        // TODO add your handling code here:
       // char enter = evt.getKeyChar();
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor CIF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_cifKeyTyped

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        aktif();
        kosong();
        txt_ktp.requestFocus();
        txt_cif.setText(new SimpleDateFormat("mmss").format(new java.util.Date()));
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_no_dokumenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_dokumenKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_ket.requestFocus();
        }
    }//GEN-LAST:event_txt_no_dokumenKeyPressed

    private void txt_ktpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ktpKeyTyped
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor KTP", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_ktpKeyTyped

    private void txt_nama_debiturKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_debiturKeyTyped
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_debiturKeyTyped

    private void txt_no_vaultKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_vaultKeyTyped
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor KTP", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_no_vaultKeyTyped

    private void txt_nama_dokumenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_dokumenKeyTyped
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_dokumenKeyTyped

    private void utxt_cifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_cifKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor CIF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_cifKeyPressed

    private void utxt_ktpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_ktpKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor KTP", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_ktpKeyPressed

    private void utxt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_nama_debiturKeyPressed

    private void utxt_no_vaultKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_no_vaultKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor Vault", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_no_vaultKeyPressed

    private void utxt_nama_dokumenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_nama_dokumenKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Dokumen", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_nama_dokumenKeyPressed
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_jaminan_kpr;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_cif;
    private javax.swing.JTextArea txt_ket;
    private javax.swing.JTextField txt_ktp;
    private javax.swing.JTextField txt_nama_debitur;
    private javax.swing.JTextField txt_nama_dokumen;
    private javax.swing.JTextField txt_no_dokumen;
    private javax.swing.JTextField txt_no_vault;
    private javax.swing.JButton ubtn_batal;
    private javax.swing.JButton ubtn_simpan;
    private javax.swing.JFrame uform_jm_kpr;
    private javax.swing.JTextField utxt_cif;
    private javax.swing.JTextArea utxt_ket;
    private javax.swing.JTextField utxt_ktp;
    private javax.swing.JTextField utxt_nama_debitur;
    private javax.swing.JTextField utxt_nama_dokumen;
    private javax.swing.JTextField utxt_no_dokumen;
    private javax.swing.JTextField utxt_no_vault;
    // End of variables declaration//GEN-END:variables

}
