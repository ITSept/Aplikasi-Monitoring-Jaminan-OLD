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
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public final class form_jm_ukm extends javax.swing.JInternalFrame {
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;

    private void aktif() {
        txt_no_pinjaman.setEnabled(true);
        txt_nama_debitur.setEnabled(true);
        txt_plafon.setEnabled(true);
        txt_outstanding.setEnabled(true);
        txt_jenis_kredit.setEnabled(true);
        txt_coll.setEnabled(true);
        txt_jaminan.setEnabled(true);
        txt_ket.setEnabled(true);
        btn_jangka_waktu.setEnabled(true);
        btn_tambah.setEnabled(false);
        btn_simpan.setEnabled(true);
        btn_batal.setEnabled(true);
        btn_keluar.setEnabled(true);
    }
    
    private void nonaktif() {
        txt_no_pinjaman.setEnabled(false);
        txt_nama_debitur.setEnabled(false);
        txt_plafon.setEnabled(false);
        txt_outstanding.setEnabled(false);
        txt_jenis_kredit.setEnabled(false);
        txt_coll.setEnabled(false);
        txt_jaminan.setEnabled(false);
        txt_ket.setEnabled(false);
        btn_jangka_waktu.setEnabled(false);
        btn_tambah.setEnabled(true);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        btn_keluar.setEnabled(true);
    }

    protected void kosong() {
        txt_no_pinjaman.setText(null);
        txt_nama_debitur.setText(null);
        txt_plafon.setText(null);
        txt_outstanding.setText(null);
        txt_jenis_kredit.setText(null);
        jangka_waktu();
        txt_coll.setText(null);
        txt_jaminan.setText(null);
        txt_ket.setText(null);
    }

    public void noTable() {
        int Baris = tabmode.getRowCount();
        for (int a = 0; a < Baris; a++) {
            String nomor = String.valueOf(a + 1);
            tabmode.setValueAt(nomor + ".", a, 0);
        }
    }

    public void jangka_waktu() {
        Date tgl = new Date();
        btn_jangka_waktu.setDate(tgl);
    }

    public void lebarKolom() {
        TableColumn kolom;
        tbl_jaminan_ukm.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(30);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(80);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(80);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(6);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(7);
        kolom.setPreferredWidth(124);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(8);
        kolom.setPreferredWidth(150);
        kolom = tbl_jaminan_ukm.getColumnModel().getColumn(9);
        kolom.setPreferredWidth(124);
    }

    public void dataTable() {
        Object[] Baris = {"No", "No Pinjaman","Nama Debitur","Plafon","Outstanding","Jenis Kredit","Jangka Waktu","Coll","Jaminan", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_jaminan_ukm.setModel(tabmode);
        String sql = "select * from tb_jm_ukm order by no_pinjaman asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pinjaman = hasil.getString("no_pinjaman");
                String nama_debitur = hasil.getString("nama_debitur");
                String plafon = hasil.getString("plafon");
                String outstanding = hasil.getString("outstanding");
                String jenis_kredit = hasil.getString("jenis_kredit");
                String jangka_waktu = hasil.getString("jangka_waktu");
                String coll = hasil.getString("coll");
                String jaminan = hasil.getString("jaminan");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", no_pinjaman, nama_debitur, plafon, outstanding, jenis_kredit, jangka_waktu, coll, jaminan, keterangan};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (SQLException e) {
        }
    }

    public void pencarian(String sql) {
       Object[] Baris = {"No", "No Pinjaman","Nama Debitur","Plafon","Outstanding","Jenis Kredit","Jangka Waktu","Coll","Jaminan", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_jaminan_ukm.setModel(tabmode);
        int brs = tbl_jaminan_ukm.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pinjaman = hasil.getString("no_pinjaman");
                String nama_debitur = hasil.getString("nama_debitur");
                String plafon = hasil.getString("plafon");
                String outstanding = hasil.getString("outstanding");
                String jenis_kredit = hasil.getString("jenis_kredit");
                String jangka_waktu = hasil.getString("jangka_waktu");
                String coll = hasil.getString("coll");
                String jaminan = hasil.getString("jaminan");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"", no_pinjaman, nama_debitur, plafon, outstanding, jenis_kredit, jangka_waktu, coll, jaminan, keterangan};
                tabmode.addRow(data);
                noTable();
            }
        } catch (SQLException e) {
        }
    }

    public form_jm_ukm() {
        initComponents();
        dataTable();
        lebarKolom();
        nonaktif();
        jangka_waktu();
        txt_nama_debitur.requestFocus();
        txt_no_pinjaman.setText("4501"+new SimpleDateFormat("hhmmss").format(new java.util.Date()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uform_jm_ukm = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        utxt_plafon = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        utxt_outstanding = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        utxt_ket = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        utxt_coll = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        utxt_no_pinjaman = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        utxt_nama_debitur = new javax.swing.JTextField();
        utxt_jaminan = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        utxt_jenis_kredit = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        ubtn_jangka_waktu = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        ubtn_batal = new javax.swing.JButton();
        ubtn_simpan = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_plafon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_outstanding = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ket = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txt_coll = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_no_pinjaman = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nama_debitur = new javax.swing.JTextField();
        txt_jaminan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_jenis_kredit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_jangka_waktu = new com.toedter.calendar.JDateChooser();
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
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_jaminan_ukm = new javax.swing.JTable();

        uform_jm_ukm.setMinimumSize(new java.awt.Dimension(640, 600));

        jPanel7.setBackground(new java.awt.Color(255, 180, 0));
        jPanel7.setFocusable(false);
        jPanel7.setMinimumSize(new java.awt.Dimension(620, 600));
        jPanel7.setPreferredSize(new java.awt.Dimension(620, 600));
        jPanel7.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel9.setLayout(null);

        utxt_plafon.setBackground(new java.awt.Color(204, 204, 204));
        utxt_plafon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_plafon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_plafonKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_plafon);
        utxt_plafon.setBounds(140, 100, 252, 30);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Outstanding");
        jPanel9.add(jLabel21);
        jLabel21.setBounds(10, 150, 77, 17);

        utxt_outstanding.setBackground(new java.awt.Color(204, 204, 204));
        utxt_outstanding.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_outstanding.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_outstandingKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_outstanding);
        utxt_outstanding.setBounds(140, 140, 252, 30);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Keterangan");
        jPanel9.add(jLabel22);
        jLabel22.setBounds(10, 350, 74, 17);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Jenis Kredit");
        jPanel9.add(jLabel23);
        jLabel23.setBounds(10, 190, 100, 17);

        utxt_ket.setBackground(new java.awt.Color(204, 204, 204));
        utxt_ket.setColumns(20);
        utxt_ket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_ket.setRows(5);
        jScrollPane4.setViewportView(utxt_ket);

        jPanel9.add(jScrollPane4);
        jScrollPane4.setBounds(140, 340, 252, 90);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Call");
        jPanel9.add(jLabel24);
        jLabel24.setBounds(10, 270, 24, 17);

        utxt_coll.setBackground(new java.awt.Color(204, 204, 204));
        utxt_coll.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_coll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_collKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_coll);
        utxt_coll.setBounds(140, 260, 252, 30);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Jaminan");
        jPanel9.add(jLabel25);
        jLabel25.setBounds(10, 310, 52, 17);

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
        jLabel27.setText("Nama Debitur");
        jPanel9.add(jLabel27);
        jLabel27.setBounds(10, 70, 100, 17);

        utxt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        utxt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                utxt_nama_debiturKeyPressed(evt);
            }
        });
        jPanel9.add(utxt_nama_debitur);
        utxt_nama_debitur.setBounds(140, 60, 252, 30);

        utxt_jaminan.setBackground(new java.awt.Color(204, 204, 204));
        utxt_jaminan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel9.add(utxt_jaminan);
        utxt_jaminan.setBounds(140, 300, 252, 30);

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Plafon");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(10, 110, 40, 17);

        utxt_jenis_kredit.setBackground(new java.awt.Color(204, 204, 204));
        utxt_jenis_kredit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel9.add(utxt_jenis_kredit);
        utxt_jenis_kredit.setBounds(140, 180, 252, 30);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Jangka Waktu");
        jPanel9.add(jLabel29);
        jLabel29.setBounds(10, 230, 89, 17);
        jPanel9.add(ubtn_jangka_waktu);
        ubtn_jangka_waktu.setBounds(140, 220, 250, 30);

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
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("UBAH DATA JAMINAN UKM");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(40, 40, 560, 29);

        javax.swing.GroupLayout uform_jm_ukmLayout = new javax.swing.GroupLayout(uform_jm_ukm.getContentPane());
        uform_jm_ukm.getContentPane().setLayout(uform_jm_ukmLayout);
        uform_jm_ukmLayout.setHorizontalGroup(
            uform_jm_ukmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        uform_jm_ukmLayout.setVerticalGroup(
            uform_jm_ukmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uform_jm_ukmLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("JAMINAN UKM");

        jPanel1.setBackground(new java.awt.Color(255, 180, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel1.setText("JAMINAN UKM");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));

        txt_plafon.setBackground(new java.awt.Color(204, 204, 204));
        txt_plafon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_plafon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_plafonKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Outstanding");

        txt_outstanding.setBackground(new java.awt.Color(204, 204, 204));
        txt_outstanding.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_outstanding.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_outstandingKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Keterangan");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Jenis Kredit");

        txt_ket.setBackground(new java.awt.Color(204, 204, 204));
        txt_ket.setColumns(20);
        txt_ket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_ket.setRows(5);
        jScrollPane1.setViewportView(txt_ket);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Call");

        txt_coll.setBackground(new java.awt.Color(204, 204, 204));
        txt_coll.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_coll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_collKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Jaminan");

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
        jLabel3.setText("Nama Debitur");

        txt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nama_debiturKeyPressed(evt);
            }
        });

        txt_jaminan.setBackground(new java.awt.Color(204, 204, 204));
        txt_jaminan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jaminan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jaminanKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Plafon");

        txt_jenis_kredit.setBackground(new java.awt.Color(204, 204, 204));
        txt_jenis_kredit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jenis_kredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jenis_kreditKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Jangka Waktu");

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
                                .addComponent(txt_jaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_coll, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(txt_outstanding, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_plafon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(txt_jenis_kredit, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(btn_jangka_waktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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
                    .addComponent(txt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_plafon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_outstanding, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_jenis_kredit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(btn_jangka_waktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_coll, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_jaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_erase_16px.png"))); // NOI18N
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
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
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

        tbl_jaminan_ukm.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_jaminan_ukm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_jaminan_ukmMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_jaminan_ukm);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(393, 393, 393)
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
            String sql = "delete from tb_jm_ukm where no_pinjaman='" + txt_no_pinjaman.getText() + "'";
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
        } else if (txt_nama_debitur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Debitur Tidak boleh kosong");
        } else if (txt_plafon.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Plafon Tidak boleh kosong");
        } else if (txt_outstanding.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Outstanding Tidak boleh kosong");
        } else if (txt_jenis_kredit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jenis Kredit Tidak boleh kosong");
        } else if (txt_coll.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Call Tidak boleh kosong");
        } else if(txt_jaminan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jaminan Tidak boleh kosong");
        } else {
            String sql = "insert into tb_jm_ukm values (?,?,?,?,?,?,?,?,?)";
            String tampilan = "dd-MM-yyyy";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String jangka_waktu = String.valueOf(fm.format(btn_jangka_waktu.getDate()));
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_no_pinjaman.getText());
                stat.setString(2, txt_nama_debitur.getText());
                stat.setString(3, txt_plafon.getText());
                stat.setString(4, txt_outstanding.getText());
                stat.setString(5, txt_jenis_kredit.getText());
                stat.setString(6, jangka_waktu);
                stat.setString(7, txt_coll.getText());
                stat.setString(8, txt_jaminan.getText());
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

    private void utxt_plafonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_plafonKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Plafon", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_plafonKeyPressed

    private void utxt_outstandingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_outstandingKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Outstanding", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_outstandingKeyPressed

    private void utxt_collKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_collKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Angka", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_collKeyPressed

    private void utxt_no_pinjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_no_pinjamanKeyPressed
        // TODO add your handling code here:
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda tidak bisa mengubah nomor pinjaman, Silahkan hapus dan input ulang data", "Warning !!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_no_pinjamanKeyPressed

    private void utxt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_utxt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_utxt_nama_debiturKeyPressed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        uform_jm_ukm.setLocationRelativeTo(this);
        utxt_no_pinjaman.setEditable(false);
        uform_jm_ukm.setVisible(true);
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void ubtn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_batalActionPerformed
        // TODO add your handling code here:
        uform_jm_ukm.setVisible(false);
    }//GEN-LAST:event_ubtn_batalActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        jangka_waktu();
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
        String sqlPencarian = "select * from tb_jm_ukm where no_pinjaman like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur like '%" + txt_cari.getText() + "%' or "
        + "keterangan like '%" + txt_cari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        // TODO add your handling code here:
      /**  String sqlPencarian = "select * from tb_jm_ukm where no_pinjaman like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur like '%" + txt_cari.getText() + "%' or "
        + "keterangan like '%" + txt_cari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom(); **/
    }//GEN-LAST:event_txt_cariKeyTyped

    private void txt_jenis_kreditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jenis_kreditKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_coll.requestFocus();
        }
    }//GEN-LAST:event_txt_jenis_kreditKeyPressed

    private void txt_jaminanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jaminanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_ket.requestFocus();
        }
    }//GEN-LAST:event_txt_jaminanKeyPressed

    private void txt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_plafon.requestFocus();
        }
        if(Character.isDigit(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Huruf", "Masukkan Nama Debitur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_nama_debiturKeyPressed

    private void txt_no_pinjamanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_pinjamanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_nama_debitur.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Nomor Pinjaman", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_no_pinjamanKeyPressed

    private void txt_collKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_collKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_jaminan.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Angka", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_collKeyPressed

    private void txt_outstandingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_outstandingKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_jenis_kredit.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Outstanding", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_outstandingKeyPressed

    private void txt_plafonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_plafonKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_outstanding.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah Plafon", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_plafonKeyPressed

    private void ubtn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_simpanActionPerformed
        // TODO add your handling code here:
        String sql = "update tb_jm_ukm set no_pinjaman=?,nama_debitur=?,plafon=?,outstanding=?,jenis_kredit=?,jangka_waktu=?,coll=?,jaminan=?,keterangan=? where no_pinjaman='" + utxt_no_pinjaman.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String jangka_waktu = String.valueOf(fm.format(ubtn_jangka_waktu.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, utxt_no_pinjaman.getText());
                stat.setString(2, utxt_nama_debitur.getText());
                stat.setString(3, utxt_plafon.getText());
                stat.setString(4, utxt_outstanding.getText());
                stat.setString(5, utxt_jenis_kredit.getText());
                stat.setString(6, jangka_waktu);
                stat.setString(7, utxt_coll.getText());
                stat.setString(8, utxt_jaminan.getText());
                stat.setString(9, utxt_ket.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_pinjaman.requestFocus();
                uform_jm_ukm.dispose();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }

    }//GEN-LAST:event_ubtn_simpanActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {
            String path="src/laporan/report_jm_ukm.jasper";
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

    private void tbl_jaminan_ukmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jaminan_ukmMousePressed
        // TODO add your handling code here:
        int bar = tbl_jaminan_ukm.getSelectedRow();
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
            dateValue = date.parse((String) tbl_jaminan_ukm.getValueAt(bar, 6));
        } catch (ParseException ex) {
            Logger.getLogger(form_jm_ukm.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_no_pinjaman.setText(b);
        utxt_no_pinjaman.setText(b);
        txt_nama_debitur.setText(c);
        utxt_nama_debitur.setText(c);
        txt_plafon.setText(d);
        utxt_plafon.setText(d);
        txt_outstanding.setText(e);
        utxt_outstanding.setText(e);
        txt_jenis_kredit.setText(f);
        utxt_jenis_kredit.setText(f);
        btn_jangka_waktu.setDate(dateValue);
        ubtn_jangka_waktu.setDate(dateValue);
        txt_coll.setText(h);
        utxt_coll.setText(h);
        txt_jaminan.setText(i);
        utxt_jaminan.setText(i);
        txt_ket.setText(j);
        utxt_ket.setText(j); 
    }//GEN-LAST:event_tbl_jaminan_ukmMousePressed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        aktif();
        kosong();
        txt_nama_debitur.requestFocus();
        txt_no_pinjaman.setText("4501"+new SimpleDateFormat("hhmmss").format(new java.util.Date()));
    }//GEN-LAST:event_btn_tambahActionPerformed
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private com.toedter.calendar.JDateChooser btn_jangka_waktu;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_jaminan_ukm;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_coll;
    private javax.swing.JTextField txt_jaminan;
    private javax.swing.JTextField txt_jenis_kredit;
    private javax.swing.JTextArea txt_ket;
    private javax.swing.JTextField txt_nama_debitur;
    private javax.swing.JTextField txt_no_pinjaman;
    private javax.swing.JTextField txt_outstanding;
    private javax.swing.JTextField txt_plafon;
    private javax.swing.JButton ubtn_batal;
    private com.toedter.calendar.JDateChooser ubtn_jangka_waktu;
    private javax.swing.JButton ubtn_simpan;
    private javax.swing.JFrame uform_jm_ukm;
    private javax.swing.JTextField utxt_coll;
    private javax.swing.JTextField utxt_jaminan;
    private javax.swing.JTextField utxt_jenis_kredit;
    private javax.swing.JTextArea utxt_ket;
    private javax.swing.JTextField utxt_nama_debitur;
    private javax.swing.JTextField utxt_no_pinjaman;
    private javax.swing.JTextField utxt_outstanding;
    private javax.swing.JTextField utxt_plafon;
    // End of variables declaration//GEN-END:variables

    private Object koneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
