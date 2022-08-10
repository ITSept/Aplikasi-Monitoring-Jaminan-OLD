package tampilan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.DriverManager;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public final class form_jm_personal extends javax.swing.JInternalFrame {
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;
    
    private void aktif() {
        txt_no_pinjaman.setEnabled(true);
        txt_no_cif.setEnabled(true);
        txt_nama_debitur.setEnabled(true);
        txt_jenis_pinjaman.setEnabled(true);
        txt_plafon.setEnabled(true);
        txt_nama_marketing.setEnabled(false);
        cari_marketing.setEnabled(true);
        txt_no_dokumen.setEnabled(true);
        txt_ket.setEnabled(true);
        btn_tanggal.setEnabled(true);
        btn_tambah.setEnabled(false);
        btn_simpan.setEnabled(true);
        btn_batal.setEnabled(true);
        btn_keluar.setEnabled(true);
    }
    
    private void nonaktif() {
        txt_no_pinjaman.setEnabled(false);
        txt_no_cif.setEnabled(false);
        txt_nama_debitur.setEnabled(false);
        txt_jenis_pinjaman.setEnabled(false);
        txt_plafon.setEnabled(false);
        txt_nama_marketing.setEnabled(false);
        cari_marketing.setEnabled(false);
        txt_no_dokumen.setEnabled(false);
        txt_ket.setEnabled(false);
        btn_tanggal.setEnabled(false);
        btn_tambah.setEnabled(true);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        btn_keluar.setEnabled(true);
    }

    protected void kosong() {
//        txt_no_pinjaman.setText(null);
        txt_nama_debitur.setText(null);
        txt_jenis_pinjaman.setText(null);
        txt_plafon.setText(null);
        tanggal();
        txt_nama_marketing.setText(null);
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
    
    public void noTable2() {
        int Baris = tabmode2.getRowCount();
        for (int a = 0; a < Baris; a++) {
        String nomor = String.valueOf(a + 1);
        tabmode2.setValueAt(nomor + ".", a, 0);
    }
}

    public void tanggal() {
        Date tgl = new Date();
        btn_tanggal.setDate(tgl);
    }

    public void lebarKolom() {
        TableColumn kolom;
        tbl_jaminan_personal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(30);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(80);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(80);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(6);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(7);
        kolom.setPreferredWidth(124);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(8);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_personal.getColumnModel().getColumn(9);
        kolom.setPreferredWidth(124);
    }
    
    public void lebarKolom2() {
        TableColumn kolom2;
        data_marketing.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom2 = data_marketing.getColumnModel().getColumn(0);
        kolom2.setPreferredWidth(40);
        kolom2 = data_marketing.getColumnModel().getColumn(1);
        kolom2.setPreferredWidth(200);
        kolom2 = data_marketing.getColumnModel().getColumn(2);
        kolom2.setPreferredWidth(250);
    }

    public void dataTable() {
        Object[] Baris = {"No", "No Pinjaman", "No CIF", "Nama Debitur", "Janis Peminjaman", "Plafon", "Tanggal Pencairan", "Nama Marketing", "No Surat Jaminan", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_jaminan_personal.setModel(tabmode);
        String sql = "select * from tb_jm_personal order by no_pinjaman asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pinjaman = hasil.getString("no_pinjaman");
                String no_cif = hasil.getString("no_cif");
                String nama_debitur = hasil.getString("nama_debitur");
                String jenis_pinjaman = hasil.getString("jenis_pinjaman");
                String plafon = hasil.getString("plafon");
                String tanggal = hasil.getString("tanggal");
                String nama_marketing = hasil.getString("nama_marketing");
                String no_dokumen = hasil.getString("no_dokumen");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", no_pinjaman, no_cif, nama_debitur, jenis_pinjaman, plafon, tanggal, nama_marketing, no_dokumen, keterangan};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (SQLException e) {
        }
    }
    
        public void dataTable2() {
        Object[] Baris = {"No", "Kode Marketing", "Nama Marketing"};
        tabmode2 = new DefaultTableModel(null, Baris);
        data_marketing.setModel(tabmode2);
        String sql = "select * from tb_marketing";        
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String kode_marketing = hasil.getString("kode_marketing");
                String nama_marketing = hasil.getString("nama_marketing");
                String[] data = {"", kode_marketing, nama_marketing};
                tabmode2.addRow(data);
                noTable2();
                lebarKolom2();
            }  
        } catch (SQLException e) {
        }
    }
    

    public void pencarian(String sql) {
        Object[] Baris = {"No", "No Pinjaman", "No CIF", "Nama Debitur", "Janis Peminjaman", "Plafon", "Tanggal Pencairan", "Nama Marketing", "No Surat Jaminan", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_jaminan_personal.setModel(tabmode);
        int brs = tbl_jaminan_personal.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pinjaman = hasil.getString("no_pinjaman");
                String no_cif = hasil.getString("no_cif");
                String nama_debitur = hasil.getString("nama_debitur");
                String jenis_pinjaman = hasil.getString("jenis_pinjaman");
                String plafon = hasil.getString("plafon");
                String tanggal = hasil.getString("tanggal");                
                String nama_marketing = hasil.getString("nama_marketing");
                String no_dokumen = hasil.getString("no_dokumen");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", no_pinjaman, no_cif, nama_debitur, jenis_pinjaman, plafon, tanggal, nama_marketing, no_dokumen, keterangan};
                tabmode.addRow(data);
                noTable();
            }
        } catch (SQLException e) {
        }
    }
    
        public void pencarian2(String sql) {
        Object[] Baris = {"No", "Kode Marketing", "Nama Marketing"};
        tabmode2 = new DefaultTableModel(null, Baris);
        data_marketing.setModel(tabmode2);
        int brs = data_marketing.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode2.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String kode_marketing = hasil.getString("kode_marketing");
                String nama_marketing = hasil.getString("nama_marketing");
                String[] data = {"", kode_marketing, nama_marketing};
                tabmode2.addRow(data);
                noTable2();
                lebarKolom2();
            }
        } catch (SQLException e) {
        }
    }

    public form_jm_personal() {
        initComponents();
        dataTable();
        lebarKolom();
        dataTable2();
        lebarKolom2();
        nonaktif();
        tanggal();
        txt_nama_debitur.requestFocus();
        txt_no_cif.setEditable(false);
        txt_no_pinjaman.setEditable(false);
        txt_no_pinjaman.setText("4501"+new SimpleDateFormat("hhmmss").format(new java.util.Date()));
        txt_no_cif.setText(new SimpleDateFormat("mmss").format(new java.util.Date()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uform_jm_personal = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        utxt_nama_debitur = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        utxt_jenis_pinjaman = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        utxt_ket = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        utxt_nama_marketing = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        utxt_no_pinjaman = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        utxt_no_cif = new javax.swing.JTextField();
        utxt_no_dokumen = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        utxt_plafon = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        ubtn_tanggal = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        ubtn_batal = new javax.swing.JButton();
        ubtn_simpan = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        form_marketing = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        data_marketing = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_nama_debitur = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_jenis_pinjaman = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ket = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txt_nama_marketing = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_no_pinjaman = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_no_cif = new javax.swing.JTextField();
        txt_no_dokumen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_plafon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_tanggal = new com.toedter.calendar.JDateChooser();
        cari_marketing = new javax.swing.JButton();
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
        tbl_jaminan_personal = new javax.swing.JTable();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();

        uform_jm_personal.setMinimumSize(new java.awt.Dimension(640, 600));

        jPanel7.setBackground(new java.awt.Color(255, 180, 0));
        jPanel7.setFocusable(false);
        jPanel7.setMinimumSize(new java.awt.Dimension(620, 600));
        jPanel7.setPreferredSize(new java.awt.Dimension(620, 600));
        jPanel7.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel9.setLayout(null);

        utxt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_nama_debiturKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_nama_debitur);
        utxt_nama_debitur.setBounds(140, 100, 252, 30);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Jenis Pengajuan");
        jPanel9.add(jLabel21);
        jLabel21.setBounds(10, 150, 104, 17);

        utxt_jenis_pinjaman.setBackground(new java.awt.Color(204, 204, 204));
        utxt_jenis_pinjaman.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel9.add(utxt_jenis_pinjaman);
        utxt_jenis_pinjaman.setBounds(140, 140, 252, 30);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Keterangan");
        jPanel9.add(jLabel22);
        jLabel22.setBounds(10, 350, 74, 17);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Plafon");
        jPanel9.add(jLabel23);
        jLabel23.setBounds(10, 190, 40, 17);

        utxt_ket.setBackground(new java.awt.Color(204, 204, 204));
        utxt_ket.setColumns(20);
        utxt_ket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_ket.setRows(5);
        jScrollPane4.setViewportView(utxt_ket);

        jPanel9.add(jScrollPane4);
        jScrollPane4.setBounds(140, 340, 252, 90);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Nama Marketing");
        jPanel9.add(jLabel24);
        jLabel24.setBounds(10, 270, 102, 17);

        utxt_nama_marketing.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_nama_marketing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_nama_marketingKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_nama_marketing);
        utxt_nama_marketing.setBounds(140, 260, 252, 30);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("No Dokumen");
        jPanel9.add(jLabel25);
        jLabel25.setBounds(10, 310, 81, 17);

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("No Pinjaman");
        jPanel9.add(jLabel26);
        jLabel26.setBounds(10, 30, 79, 17);

        utxt_no_pinjaman.setBackground(new java.awt.Color(204, 204, 204));
        utxt_no_pinjaman.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_no_pinjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_no_pinjamanKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_no_pinjaman);
        utxt_no_pinjaman.setBounds(140, 20, 252, 30);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("No CIF");
        jPanel9.add(jLabel27);
        jLabel27.setBounds(10, 70, 43, 17);

        utxt_no_cif.setBackground(new java.awt.Color(204, 204, 204));
        utxt_no_cif.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_no_cif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_no_cifKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_no_cif);
        utxt_no_cif.setBounds(140, 60, 252, 30);

        utxt_no_dokumen.setBackground(new java.awt.Color(204, 204, 204));
        utxt_no_dokumen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel9.add(utxt_no_dokumen);
        utxt_no_dokumen.setBounds(140, 300, 252, 30);

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Nama Debitur");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(10, 110, 86, 17);

        utxt_plafon.setBackground(new java.awt.Color(204, 204, 204));
        utxt_plafon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_plafon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_plafonKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_plafon);
        utxt_plafon.setBounds(140, 180, 252, 30);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Tanggal Pencairan");
        jPanel9.add(jLabel29);
        jLabel29.setBounds(10, 230, 120, 17);
        jPanel9.add(ubtn_tanggal);
        ubtn_tanggal.setBounds(140, 220, 250, 30);

        jPanel7.add(jPanel9);
        jPanel9.setBounds(40, 90, 410, 450);

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
        jLabel30.setText("UBAH DATA JAMINAN PERSONAL");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(110, 40, 396, 29);

        javax.swing.GroupLayout uform_jm_personalLayout = new javax.swing.GroupLayout(uform_jm_personal.getContentPane());
        uform_jm_personal.getContentPane().setLayout(uform_jm_personalLayout);
        uform_jm_personalLayout.setHorizontalGroup(
            uform_jm_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        uform_jm_personalLayout.setVerticalGroup(
            uform_jm_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uform_jm_personalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        form_marketing.setMinimumSize(new java.awt.Dimension(502, 431));
        form_marketing.setResizable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("| Data Marketing");

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
                .addContainerGap()
                .addGroup(form_marketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        form_marketingLayout.setVerticalGroup(
            form_marketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_marketingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("JAMINAN PERSONAL");

        jPanel1.setBackground(new java.awt.Color(255, 180, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel1.setText("JAMINAN PERSONAL");

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
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Jenis Pengajuan");

        txt_jenis_pinjaman.setBackground(new java.awt.Color(204, 204, 204));
        txt_jenis_pinjaman.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Keterangan");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Plafon");

        txt_ket.setBackground(new java.awt.Color(204, 204, 204));
        txt_ket.setColumns(20);
        txt_ket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_ket.setRows(5);
        jScrollPane1.setViewportView(txt_ket);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Nama Marketing");

        txt_nama_marketing.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nama_marketing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nama_marketingKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("No Dokumen");

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
        jLabel3.setText("No CIF");

        txt_no_cif.setBackground(new java.awt.Color(204, 204, 204));
        txt_no_cif.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_no_cif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_no_cifKeyPressed(evt);
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

        txt_plafon.setBackground(new java.awt.Color(204, 204, 204));
        txt_plafon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_plafon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_plafonKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Tanggal Pencairan");

        cari_marketing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cari_marketing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_search_16px.png"))); // NOI18N
        cari_marketing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_marketingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_no_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cari_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_no_cif, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(txt_jenis_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_nama_debitur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_no_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_plafon, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(btn_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_pinjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_cif, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_jenis_pinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_plafon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(btn_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari_marketing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_dokumen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
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
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
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
                .addContainerGap(318, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
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

        tbl_jaminan_personal.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_jaminan_personal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jaminan_personalMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_jaminan_personalMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_jaminan_personal);

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
                .addGap(338, 338, 338)
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
            String sql = "delete from tb_jm_personal where no_pinjaman='" + txt_no_pinjaman.getText() + "'";
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
        } else if (txt_no_cif.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No CIF  Tidak boleh kosong");
        } else if (txt_nama_debitur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Debitur  Tidak boleh kosong");
        } else if (txt_jenis_pinjaman.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "janis Pengajuan  Tidak boleh kosong");
        } else if (txt_plafon.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Plafon  Tidak boleh kosong");
        } else if (txt_nama_marketing.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Marketing Tidak boleh kosong");
        } else if(txt_no_dokumen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No dokumen Tidak boleh kosong");
        } else {
            String sql = "insert into tb_jm_personal values (?,?,?,?,?,?,?,?,?)";
            String tampilan = "dd-MM-yyyy";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(btn_tanggal.getDate()));
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_no_pinjaman.getText());
                stat.setString(2, txt_no_cif.getText());
                stat.setString(3, txt_nama_debitur.getText());
                stat.setString(4, txt_jenis_pinjaman.getText());
                stat.setString(5, txt_plafon.getText());
                stat.setString(6, tanggal);
                stat.setString(7, txt_nama_marketing.getText());
                stat.setString(8, txt_no_dokumen.getText());
                stat.setString(9, txt_ket.getText());
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

    private void utxt_nama_marketingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_nama_marketingKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Marketing", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_nama_marketingKeyPressed

    private void utxt_plafonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_plafonKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Plafon", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_plafonKeyPressed

    private void tbl_jaminan_personalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jaminan_personalMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tbl_jaminan_personalMouseClicked

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        uform_jm_personal.setLocationRelativeTo(this);
        utxt_no_pinjaman.setEditable(false);
        uform_jm_personal.setVisible(true);
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void ubtn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_batalActionPerformed
        // TODO add your handling code here:
        uform_jm_personal.setVisible(false);
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
        String sqlPencarian = "select * from tb_jm_personal where no_pinjaman like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur like '%" + txt_cari.getText() + "%' or "
        + "keterangan like '%" + txt_cari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
//        String sqlPencarian = "select * from tb_jm_personal where no_pinjaman like '%" + txt_cari.getText() + "%' or "
//        + "nama_debitur like '%" + txt_cari.getText() + "%' or "
//        + "keterangan like '%" + txt_cari.getText() + "%'";
//        pencarian(sqlPencarian);
//        lebarKolom();
    }//GEN-LAST:event_txt_cariKeyTyped

    private void txt_plafonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_plafonKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_nama_marketing.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Plafon", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_plafonKeyPressed

    private void txt_no_dokumenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_dokumenKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_ket.requestFocus();
        }
    }//GEN-LAST:event_txt_no_dokumenKeyPressed

    private void txt_no_pinjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_pinjamanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_no_cif.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor Pinjaman", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_no_pinjamanKeyPressed

    private void txt_nama_marketingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_marketingKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_no_dokumen.requestFocus();
        }
    }//GEN-LAST:event_txt_nama_marketingKeyPressed

    private void ubtn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_simpanActionPerformed
        // TODO add your handling code here:
        String sql = "update tb_jm_personal set no_pinjaman=?,no_cif=?,nama_debitur=?,jenis_pinjaman=?,plafon=?,tanggal=?,nama_marketing=?,no_dokumen=?,keterangan=? where no_pinjaman='" + utxt_no_pinjaman.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(ubtn_tanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, utxt_no_pinjaman.getText());
                stat.setString(2, utxt_no_cif.getText());
                stat.setString(3, utxt_nama_debitur.getText());
                stat.setString(4, utxt_jenis_pinjaman.getText());
                stat.setString(5, utxt_plafon.getText());
                stat.setString(6, tanggal);
                stat.setString(7, utxt_nama_marketing.getText());
                stat.setString(8, utxt_no_dokumen.getText());
                stat.setString(9, utxt_ket.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_pinjaman.setEnabled(false);
                txt_no_pinjaman.requestFocus();
                uform_jm_personal.dispose();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }

    }//GEN-LAST:event_ubtn_simpanActionPerformed

    private void tbl_jaminan_personalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jaminan_personalMousePressed
        // TODO add your handling code here:
        int bar = tbl_jaminan_personal.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
        String j = tabmode.getValueAt(bar, 9).toString();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try {
            dateValue = date.parse((String) tbl_jaminan_personal.getValueAt(bar, 6));
        } catch (ParseException ex) {
            Logger.getLogger(form_jm_personal.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_no_pinjaman.setText(b);
        utxt_no_pinjaman.setText(b);
        txt_no_cif.setText(c);
        utxt_no_cif.setText(c);
        txt_nama_debitur.setText(d);
        utxt_nama_debitur.setText(d);
        txt_jenis_pinjaman.setText(e);
        utxt_jenis_pinjaman.setText(e);
        txt_plafon.setText(f);
        utxt_plafon.setText(f);
        btn_tanggal.setDate(dateValue);
        ubtn_tanggal.setDate(dateValue);
        txt_nama_marketing.setText(h);
        utxt_nama_marketing.setText(h);
        txt_no_dokumen.setText(i);
        utxt_no_dokumen.setText(i);
        txt_ket.setText(j);
        utxt_ket.setText(j); 
    }//GEN-LAST:event_tbl_jaminan_personalMousePressed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {
            String path="src/laporan/report_jm_personal.jasper";
            Map param = new HashMap();
            param.put("pnama_debitur", txt_cari.getText());
            param.put("pno_pinjaman", txt_cari.getText());
            JasperPrint jp = JasperFillManager.fillReport(path, param, conn);
            JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
        }
        txt_cari.setText(null);
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void txt_no_cifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_cifKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor CIF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_no_cifKeyPressed

    private void txt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_debiturKeyPressed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        aktif();
        kosong();
        txt_nama_debitur.requestFocus();
        txt_no_pinjaman.setText("4501"+new SimpleDateFormat("hhmmss").format(new java.util.Date()));
        txt_no_cif.setText(new SimpleDateFormat("mmss").format(new java.util.Date()));
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void utxt_no_pinjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_no_pinjamanKeyPressed
        // TODO add your handling code here:
//        if(Character.isAlphabetic(evt.getKeyChar())){
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor Pinjaman", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_utxt_no_pinjamanKeyPressed

    private void utxt_no_cifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_no_cifKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor CIF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_no_cifKeyPressed

    private void utxt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_nama_debiturKeyPressed

    private void cari_marketingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_marketingActionPerformed
        // TODO add your handling code here:
        dataTable2();
        lebarKolom2();
        form_marketing.setLocationRelativeTo(this);
        form_marketing.setVisible(true);
   
    }//GEN-LAST:event_cari_marketingActionPerformed

    private void data_marketingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_marketingMousePressed
        // TODO add your handling code here:
        int bar = data_marketing.getSelectedRow();
        String a = tabmode2.getValueAt(bar, 0).toString();
        String b = tabmode2.getValueAt(bar, 1).toString();
        String c = tabmode2.getValueAt(bar, 2).toString();
        txt_nama_marketing.setText(c);
        form_marketing.dispose();
        txt_nama_marketing.requestFocus();

    }//GEN-LAST:event_data_marketingMousePressed
          

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private com.toedter.calendar.JDateChooser btn_tanggal;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JButton cari_marketing;
    private javax.swing.JTable data_marketing;
    private javax.swing.JDialog form_marketing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_jaminan_personal;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_jenis_pinjaman;
    private javax.swing.JTextArea txt_ket;
    private javax.swing.JTextField txt_nama_debitur;
    private javax.swing.JTextField txt_nama_marketing;
    private javax.swing.JTextField txt_no_cif;
    private javax.swing.JTextField txt_no_dokumen;
    private javax.swing.JTextField txt_no_pinjaman;
    private javax.swing.JTextField txt_plafon;
    private javax.swing.JButton ubtn_batal;
    private javax.swing.JButton ubtn_simpan;
    private com.toedter.calendar.JDateChooser ubtn_tanggal;
    private javax.swing.JFrame uform_jm_personal;
    private javax.swing.JTextField utxt_jenis_pinjaman;
    private javax.swing.JTextArea utxt_ket;
    private javax.swing.JTextField utxt_nama_debitur;
    private javax.swing.JTextField utxt_nama_marketing;
    private javax.swing.JTextField utxt_no_cif;
    private javax.swing.JTextField utxt_no_dokumen;
    private javax.swing.JTextField utxt_no_pinjaman;
    private javax.swing.JTextField utxt_plafon;
    // End of variables declaration//GEN-END:variables

//    private Object koneksi() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
