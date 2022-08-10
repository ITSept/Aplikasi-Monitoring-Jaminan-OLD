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
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public final class form_kr_ukm extends javax.swing.JInternalFrame {
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode,tabmode3;
    
    private void aktif() {
        txt_no_pinjaman.setEnabled(true);
        txt_index.setEnabled(true);
        txt_nama_debitur.setEnabled(true);
        txt_kode_marketing.setEnabled(true);
        txt_nama_marketing.setEnabled(true);
        cb_jenis_bantex.setSelectedItem(true);
        txt_jumlah_bantex.setEnabled(true);
        btn_tambah.setEnabled(false);
        btn_simpan.setEnabled(true);
        btn_batal.setEnabled(true);
        btn_keluar.setEnabled(true);
        cari_nama_marketing.setEnabled(true);
    }
    
    private void nonaktif() {
        txt_no_pinjaman.setEnabled(false);
        txt_index.setEnabled(false);
        txt_nama_debitur.setEnabled(false);
        txt_kode_marketing.setEnabled(false);
        txt_nama_marketing.setEnabled(false);
        cb_jenis_bantex.setSelectedItem(false);
        txt_jumlah_bantex.setEnabled(false);
        btn_tambah.setEnabled(true);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        btn_keluar.setEnabled(true);
        cari_nama_marketing.setEnabled(false);
    }

    protected void kosong() {
        txt_no_pinjaman.setText(null);
        txt_index.setText(null);
        txt_nama_debitur.setText(null);
        txt_kode_marketing.setText(null);
        txt_nama_marketing.setText(null);
        cb_jenis_bantex.setSelectedItem(null);
        txt_jumlah_bantex.setText(null);
    }

    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }

    public void tanggal() {
//        Date tgl = new Date();
//        btn_tanggal.setDate(tgl);
    }

    public void lebarKolom() {
        TableColumn kolom;
        tbl_kr_ukm.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(30);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(150);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(200);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(200);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(150);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(6);
        kolom.setPreferredWidth(150);
        kolom = tbl_kr_ukm.getColumnModel().getColumn(7);
        kolom.setPreferredWidth(150);
    }

    public void dataTable() {
        Object[] Baris = {"No", "No Pinjaman", "Index", "Nama Debitur", "Kode Marketing", "Nama Marketing", "Jenis Bantex", "Jumlah Bantex"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_kr_ukm.setModel(tabmode);
        String sql = "select * from tb_kr_ukm order by no_pinjaman_ukm asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pinjaman_ukm = hasil.getString("no_pinjaman_ukm");
                String index_ = hasil.getString("index_");
                String nama_debitur_ukm = hasil.getString("nama_debitur_ukm");
                String kode_marketing = hasil.getString("kode_marketing");
                String nama_marketing = hasil.getString("nama_marketing");
                String jenis_bantex = hasil.getString("jenis_bantex");
                String jumlah_bantex = hasil.getString("jumlah_bantex");
                String[] data = {"", no_pinjaman_ukm, index_, nama_debitur_ukm, kode_marketing, nama_marketing, jenis_bantex, jumlah_bantex};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (SQLException e) {
        }
    }

    public void pencarian(String sql) {
        Object[] Baris = {"No", "No Pinjaman", "Index", "Nama Debitur", "Kode Marketing", "Nama Marketing", "Jenis Bantex", "Jumlah Bantex"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_kr_ukm.setModel(tabmode);
        int brs = tbl_kr_ukm.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                 String no_pinjaman_ukm = hasil.getString("no_pinjaman_ukm");
                String index_ = hasil.getString("index_");
                String nama_debitur_ukm = hasil.getString("nama_debitur_ukm");
                String kode_marketing = hasil.getString("kode_marketing");
                String nama_marketing = hasil.getString("nama_marketing");
                String jenis_bantex = hasil.getString("jenis_bantex");
                String jumlah_bantex = hasil.getString("jumlah_bantex");
                String[] data = {"", no_pinjaman_ukm, index_, nama_debitur_ukm, kode_marketing, nama_marketing, jenis_bantex, jumlah_bantex};
                tabmode.addRow(data);
                noTable();
            }
        } catch (SQLException e) {
        }
    }
    
    public void noTable3() {
        int Baris = tabmode3.getRowCount();
        for (int a = 0; a < Baris; a++) {
        String nomor = String.valueOf(a + 1);
        tabmode3.setValueAt(nomor + ".", a, 0);
            }
    } 

    
    public void lebarKolom3() {
        TableColumn kolom2;
        data_marketing.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom2 = data_marketing.getColumnModel().getColumn(0);
        kolom2.setPreferredWidth(40);
        kolom2 = data_marketing.getColumnModel().getColumn(1);
        kolom2.setPreferredWidth(200);
        kolom2 = data_marketing.getColumnModel().getColumn(2);
        kolom2.setPreferredWidth(200);
    } 

        public void dataTable3() {
        Object[] Baris = {"No", "Kode Marketing", "Nama Marketing"};
        tabmode3 = new DefaultTableModel(null, Baris);
        data_marketing.setModel(tabmode3);
        String sql = "select * from tb_marketing";        
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String kode_marketing = hasil.getString("kode_marketing");
                String nama_marketing = hasil.getString("nama_marketing");
                String[] data = {"", kode_marketing, nama_marketing};
                tabmode3.addRow(data);
                noTable3();
                lebarKolom3();
            }  
        } catch (SQLException e) {
        }
    }
   
    public form_kr_ukm() {
        initComponents();
        dataTable();
        lebarKolom();
        nonaktif();
        tanggal();
        txt_kode_marketing.setEditable(false);
        txt_nama_marketing.setEditable(true);
        txt_index.requestFocus();
        txt_no_pinjaman.setText("4501"+new SimpleDateFormat("hhmmss").format(new java.util.Date()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uform_kr_ukm = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        ubtn_batal = new javax.swing.JButton();
        ubtn_simpan = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        utxt_nama_debitur = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        utxt_kode_marketing = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        utxt_no_pinjaman = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        utxt_index = new javax.swing.JTextField();
        utxt_jumlah_bantex = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        utxt_nama_marketing = new javax.swing.JTextField();
        ucb_jenis_bantex = new javax.swing.JComboBox<>();
        form_marketing = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        data_marketing = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_nama_debitur = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_kode_marketing = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_no_pinjaman = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_index = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nama_marketing = new javax.swing.JTextField();
        txt_jumlah_bantex = new javax.swing.JTextField();
        cb_jenis_bantex = new javax.swing.JComboBox<>();
        cari_nama_marketing = new javax.swing.JButton();
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
        tbl_kr_ukm = new javax.swing.JTable();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();

        uform_kr_ukm.setMinimumSize(new java.awt.Dimension(640, 600));

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
        jPanel10.setBounds(460, 90, 146, 450);

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("UBAH DATA KREDIT UKM");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(36, 40, 570, 29);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel8.setPreferredSize(new java.awt.Dimension(421, 447));

        utxt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_nama_debiturKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Kode Marketing");

        utxt_kode_marketing.setBackground(new java.awt.Color(204, 204, 204));
        utxt_kode_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_kode_marketing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_kode_marketingKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Jumlah Bantex");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Nama Marketing");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Jenis Bantex");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("No Pinjaman");

        utxt_no_pinjaman.setBackground(new java.awt.Color(204, 204, 204));
        utxt_no_pinjaman.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_no_pinjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_no_pinjamanKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Index");

        utxt_index.setBackground(new java.awt.Color(204, 204, 204));
        utxt_index.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_index.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_indexKeyPressed(evt);
            }
        });

        utxt_jumlah_bantex.setBackground(new java.awt.Color(204, 204, 204));
        utxt_jumlah_bantex.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_jumlah_bantex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_jumlah_bantexKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Nama Debitur");

        utxt_nama_marketing.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_nama_marketing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_nama_marketingKeyPressed(evt);
            }
        });

        ucb_jenis_bantex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ucb_jenis_bantex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMK", "JAMINAN", "KREDIT" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(utxt_jumlah_bantex, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(ucb_jenis_bantex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(utxt_index, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(utxt_kode_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(utxt_nama_debitur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(utxt_no_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(utxt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_no_pinjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_index, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_kode_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ucb_jenis_bantex, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(utxt_jumlah_bantex, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153))
        );

        jPanel7.add(jPanel8);
        jPanel8.setBounds(40, 90, 421, 450);

        javax.swing.GroupLayout uform_kr_ukmLayout = new javax.swing.GroupLayout(uform_kr_ukm.getContentPane());
        uform_kr_ukm.getContentPane().setLayout(uform_kr_ukmLayout);
        uform_kr_ukmLayout.setHorizontalGroup(
            uform_kr_ukmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        uform_kr_ukmLayout.setVerticalGroup(
            uform_kr_ukmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uform_kr_ukmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        form_marketing.setMaximumSize(new java.awt.Dimension(502, 210));
        form_marketing.setMinimumSize(new java.awt.Dimension(502, 210));
        form_marketing.setResizable(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("| Data Marketing");

        data_marketing.setModel(new javax.swing.table.DefaultTableModel(
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
        data_marketing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                data_marketingMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(data_marketing);

        javax.swing.GroupLayout form_marketingLayout = new javax.swing.GroupLayout(form_marketing.getContentPane());
        form_marketing.getContentPane().setLayout(form_marketingLayout);
        form_marketingLayout.setHorizontalGroup(
            form_marketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_marketingLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(form_marketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        form_marketingLayout.setVerticalGroup(
            form_marketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_marketingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("KREDIT UKM");

        jPanel1.setBackground(new java.awt.Color(255, 180, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel1.setText("KREDIT UKM");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel4.setPreferredSize(new java.awt.Dimension(421, 438));

        txt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nama_debiturKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Kode Marketing");

        txt_kode_marketing.setBackground(new java.awt.Color(204, 204, 204));
        txt_kode_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_kode_marketing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_kode_marketingKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Jumlah Bantex");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Nama Marketing");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Jenis Bantex");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("No Pinjaman");

        txt_no_pinjaman.setBackground(new java.awt.Color(204, 204, 204));
        txt_no_pinjaman.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_no_pinjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_no_pinjamanKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Index");

        txt_index.setBackground(new java.awt.Color(204, 204, 204));
        txt_index.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_index.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_indexKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nama Debitur");

        txt_nama_marketing.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nama_marketing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nama_marketingKeyPressed(evt);
            }
        });

        txt_jumlah_bantex.setBackground(new java.awt.Color(204, 204, 204));
        txt_jumlah_bantex.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jumlah_bantex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jumlah_bantexKeyPressed(evt);
            }
        });

        cb_jenis_bantex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cb_jenis_bantex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMK", "JAMINAN", "KREDIT" }));

        cari_nama_marketing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cari_nama_marketing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_search_16px.png"))); // NOI18N
        cari_nama_marketing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_nama_marketingActionPerformed(evt);
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
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_jumlah_bantex, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_index, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nama_debitur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_kode_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cari_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_no_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_jenis_bantex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nama_marketing, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_index, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_kode_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(cari_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_jenis_bantex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_jumlah_bantex, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148))
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
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

        tbl_kr_ukm.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_kr_ukm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_kr_ukmMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_kr_ukm);

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
        // TODO add your handling code here:
          int ok = JOptionPane.showConfirmDialog(null, " Apakah Anda Yakin Ingin Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from tb_kr_ukm where no_pinjaman_ukm='" + txt_no_pinjaman.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_pinjaman.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus" + e);
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
          if (txt_no_pinjaman.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Pinjaman Tidak boleh kosong");
        } else if (txt_index.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Index Tidak boleh kosong");
        } else if (txt_nama_debitur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Debitur Tidak boleh kosong");
        } else if (txt_kode_marketing.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Marketing Tidak boleh kosong");
        } else if (txt_nama_marketing.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Marketing Tidak boleh kosong");
        } else if(cb_jenis_bantex.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Jenis Bantex Tidak boleh kosong");
        } else if(txt_jumlah_bantex.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Bantex Tidak boleh kosong");
        } else {
            String sql = "insert into tb_kr_ukm values (?,?,?,?,?,?,?)";
 //           String tampilan = "dd-MM-yyyy";
 //           SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_no_pinjaman.getText());
                stat.setString(2, txt_index.getText());
                stat.setString(3, txt_nama_debitur.getText());
                stat.setString(4, txt_kode_marketing.getText());
                stat.setString(5, txt_nama_marketing.getText());
                stat.setString(6, (String) cb_jenis_bantex.getSelectedItem());
                stat.setString(7, txt_jumlah_bantex.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_pinjaman.requestFocus();
                nonaktif();
                btn_tambah.setEnabled(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, " Data Gagal Disimpan " + e);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        uform_kr_ukm.setLocationRelativeTo(this);
        utxt_no_pinjaman.setEditable(false);
        uform_kr_ukm.setVisible(true);
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void ubtn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_batalActionPerformed
        // TODO add your handling code here:
        uform_kr_ukm.setVisible(false);
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
        // TODO add your handling code here:
        String sqlPencarian = "select * from tb_kr_ukm where no_pinjaman_ukm like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur_ukm like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur_ukm like '%" + txt_cari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_nama_marketingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_marketingKeyPressed
        // TODO add your handling code here:
    if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Marketing", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_marketingKeyPressed

    private void txt_indexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_indexKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_nama_debitur.requestFocus();
        }
    }//GEN-LAST:event_txt_indexKeyPressed

    private void txt_no_pinjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_pinjamanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_index.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor Pinjaman", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_no_pinjamanKeyPressed

    private void txt_kode_marketingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kode_marketingKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_nama_marketing.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Kode Marketing", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_kode_marketingKeyPressed

    private void txt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_kode_marketing.requestFocus();
        }
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_debiturKeyPressed

    private void ubtn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_simpanActionPerformed
        // TODO add your handling code here:
        String sql = "update tb_kr_ukm set no_pinjaman_ukm=?,index_=?,nama_debitur_ukm=?,kode_marketing=?,nama_marketing=?,jenis_bantex=?,jumlah_bantex=? where no_pinjaman_ukm='" + utxt_no_pinjaman.getText() + "'";
//        String tampilan = "dd-MM-yyyy";
//        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
//        String tanggal = String.valueOf(fm.format(ubtn_tanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, utxt_no_pinjaman.getText());
                stat.setString(2, utxt_index.getText());
                stat.setString(3, utxt_nama_debitur.getText());
                stat.setString(4, utxt_kode_marketing.getText());
                stat.setString(5, utxt_nama_marketing.getText());
                stat.setString(6, (String) ucb_jenis_bantex.getSelectedItem());
                stat.setString(7, utxt_jumlah_bantex.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_pinjaman.requestFocus();
                uform_kr_ukm.dispose();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }

    }//GEN-LAST:event_ubtn_simpanActionPerformed

    private void tbl_kr_ukmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kr_ukmMousePressed
        // TODO add your handling code here:
        int bar = tbl_kr_ukm.getSelectedRow();
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
        txt_no_pinjaman.setText(b);
        utxt_no_pinjaman.setText(b);
        txt_index.setText(c);
        utxt_index.setText(c);
        txt_nama_debitur.setText(d);
        utxt_nama_debitur.setText(d);
        txt_kode_marketing.setText(e);
        utxt_kode_marketing.setText(e);
        txt_nama_marketing.setText(f);
        utxt_nama_marketing.setText(f);
        cb_jenis_bantex.setSelectedItem(g);
        ucb_jenis_bantex.setSelectedItem(g);
        txt_jumlah_bantex.setText(h);
        utxt_jumlah_bantex.setText(h); 
    }//GEN-LAST:event_tbl_kr_ukmMousePressed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {
            String path="src/laporan/report_kr_ukm.jasper";
            Map param = new HashMap();
            param.put("pnama_debitur_ukm", txt_cari.getText());
            param.put("pno_pinjaman_ukm", txt_cari.getText());
            JasperPrint jp = JasperFillManager.fillReport(path, param, conn);
            JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
        }
        txt_cari.setText(null);
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void utxt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_nama_debiturKeyPressed

    private void utxt_kode_marketingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_kode_marketingKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Kode Marketing", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_kode_marketingKeyPressed

    private void utxt_no_pinjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_no_pinjamanKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor Pinjaman", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_no_pinjamanKeyPressed

    private void utxt_indexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_indexKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_utxt_indexKeyPressed

    private void utxt_jumlah_bantexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_jumlah_bantexKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Bantex", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_jumlah_bantexKeyPressed

    private void utxt_nama_marketingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_nama_marketingKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Marketing", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_nama_marketingKeyPressed

    private void txt_jumlah_bantexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlah_bantexKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Bantex", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_jumlah_bantexKeyPressed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        aktif();
        kosong();
        txt_index.requestFocus();
        txt_no_pinjaman.setText("4501"+new SimpleDateFormat("hhmmss").format(new java.util.Date()));
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void data_marketingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_marketingMousePressed
        // TODO add your handling code here:
        int bar = data_marketing.getSelectedRow();
        String a = tabmode3.getValueAt(bar, 0).toString();
        String b = tabmode3.getValueAt(bar, 1).toString();
        String c = tabmode3.getValueAt(bar, 2).toString();
        txt_kode_marketing.setText(b);
        txt_nama_marketing.setText(c);
        form_marketing.dispose();
        txt_nama_marketing.requestFocus();
    }//GEN-LAST:event_data_marketingMousePressed

    private void cari_nama_marketingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_nama_marketingActionPerformed
        // TODO add your handling code here:
        dataTable3();
        lebarKolom3();
        form_marketing.setLocationRelativeTo(this);
        form_marketing.setVisible(true);
    }//GEN-LAST:event_cari_nama_marketingActionPerformed
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JButton cari_nama_marketing;
    private javax.swing.JComboBox<String> cb_jenis_bantex;
    private javax.swing.JTable data_marketing;
    private javax.swing.JDialog form_marketing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_kr_ukm;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_index;
    private javax.swing.JTextField txt_jumlah_bantex;
    private javax.swing.JTextField txt_kode_marketing;
    private javax.swing.JTextField txt_nama_debitur;
    private javax.swing.JTextField txt_nama_marketing;
    private javax.swing.JTextField txt_no_pinjaman;
    private javax.swing.JButton ubtn_batal;
    private javax.swing.JButton ubtn_simpan;
    private javax.swing.JComboBox<String> ucb_jenis_bantex;
    private javax.swing.JFrame uform_kr_ukm;
    private javax.swing.JTextField utxt_index;
    private javax.swing.JTextField utxt_jumlah_bantex;
    private javax.swing.JTextField utxt_kode_marketing;
    private javax.swing.JTextField utxt_nama_debitur;
    private javax.swing.JTextField utxt_nama_marketing;
    private javax.swing.JTextField utxt_no_pinjaman;
    // End of variables declaration//GEN-END:variables

}
