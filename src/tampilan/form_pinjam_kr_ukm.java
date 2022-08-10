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
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public final class form_pinjam_kr_ukm extends javax.swing.JInternalFrame {
    public final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;
    private DefaultTableModel tabmode3;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    String sql;

    private void aktif() {
        txt_no_form.setEnabled(false);
        txt_nama_debitur.setEnabled(false);
        txt_unit_bisnis.setEnabled(true);
        txt_jumlah_file.setEnabled(true);
        txt_keperluan.setEnabled(true);
        btn_tanggal_pinjam.setEnabled(true);
        btn_simpan.setEnabled(true);
        btn_batal.setEnabled(true);
        cari_nama_debitur.setEnabled(true);
        btn_tambah.setEnabled(false);
        cari_nama_marketing.setEnabled(true);
        txt_nama_marketing.setEnabled(false);
    }
    
    private void nonaktif() {
        txt_no_form.setEnabled(false);
        txt_nama_debitur.setEnabled(false);
        txt_unit_bisnis.setEnabled(false);
        txt_jumlah_file.setEnabled(false);
        txt_keperluan.setEnabled(false);
        btn_tanggal_pinjam.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        cari_nama_debitur.setEnabled(false);
        cari_nama_marketing.setEnabled(false);
        txt_nama_marketing.setEnabled(false);
    }
    
    protected void kosong() {
        txt_no_form.setText(null);
        txt_nama_debitur.setText(null);
        txt_nama_marketing.setText(null);
        txt_unit_bisnis.setText(null);
        txt_jumlah_file.setText(null);
        txt_keperluan.setText(null);
        btn_tanggal_pinjam.setDate(null);
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
        btn_tanggal_pinjam.setDate(tgl);
        
    }

    public void lebarKolom() {
        TableColumn kolom;
        tbl_peminjaman.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        kolom = tbl_peminjaman.getColumnModel().getColumn(0);
        kolom.setPreferredWidth(30);
        kolom = tbl_peminjaman.getColumnModel().getColumn(1);
        kolom.setPreferredWidth(100);
        kolom = tbl_peminjaman.getColumnModel().getColumn(2);
        kolom.setPreferredWidth(150);
        kolom = tbl_peminjaman.getColumnModel().getColumn(3);
        kolom.setPreferredWidth(150);
        kolom = tbl_peminjaman.getColumnModel().getColumn(4);
        kolom.setPreferredWidth(150);
        kolom = tbl_peminjaman.getColumnModel().getColumn(5);
        kolom.setPreferredWidth(150);
        kolom = tbl_peminjaman.getColumnModel().getColumn(6);
        kolom.setPreferredWidth(150);
    }
    
    public void lebarKolom2() {
    TableColumn kolom2;
    tbl_data_peminjaman.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    kolom2 = tbl_data_peminjaman.getColumnModel().getColumn(0);
    kolom2.setPreferredWidth(40);
    kolom2 = tbl_data_peminjaman.getColumnModel().getColumn(1);
    kolom2.setPreferredWidth(150);
    kolom2 = tbl_data_peminjaman.getColumnModel().getColumn(2);
    kolom2.setPreferredWidth(200);
} 
    
     public void dataTable() {
        Object[] Baris = {"No", "Nomor Form", "Nama Debitur","Nama Marketing", "Unit Bisnis", "Jumlah File", "Keperluan", "Tanggal Pinjam"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_peminjaman.setModel(tabmode);
        String sql = "select * from tb_peminjaman order by no_form asc";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_form = hasil.getString("no_form");
                String nama_debitur = hasil.getString("nama_debitur");
                String nama_marketing = hasil.getString("nama_marketing");
                String unit_bisnis = hasil.getString("unit_bisnis");
                String jumlah_file = hasil.getString("jumlah_file");
                String keperluan = hasil.getString("keperluan");
                String tanggal_pinjam = hasil.getString("tanggal_pinjam");
                String[] data = {"", no_form, nama_debitur, nama_marketing, unit_bisnis, jumlah_file, keperluan, tanggal_pinjam};
                tabmode.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (SQLException e) {
        }
    }
    
    public void dataTable2() {
        Object[] Baris = {"No", "No Pinjaman", "Nama Debitur"};
        tabmode2 = new DefaultTableModel(null, Baris);
        tbl_data_peminjaman.setModel(tabmode2);
            String sql = "select * from tb_kr_ukm where no_pinjaman_ukm desc";        
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pinjaman_ukm = hasil.getString("no_pinjaman_ukm");
                String nama_debitur_ukm = hasil.getString("nama_debitur_ukm");
                String[] data = {"", no_pinjaman_ukm, nama_debitur_ukm};
                tabmode2.addRow(data);
                noTable2();
                lebarKolom2();
            }
      
        } catch (SQLException e) {
        }
    }
     

    public void pencarian(String sql) {
        Object[] Baris = {"No", "Nomor Form", "Nama Debitur","Nama Marketing", "Unit Bisnis", "Jumlah File", "Keperluan", "Tanggal Pinjam"};
        tabmode = new DefaultTableModel(null, Baris);
        tbl_peminjaman.setModel(tabmode);
        int brs = tbl_peminjaman.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_form = hasil.getString("no_form");
                String nama_debitur = hasil.getString("nama_debitur");
                String nama_marketing = hasil.getString("nama_marketing");
                String unit_bisnis = hasil.getString("unit_bisnis");
                String jumlah_file = hasil.getString("jumlah_file");
                String keperluan = hasil.getString("keperluan");
                String tanggal_pinjam = hasil.getString("tanggal_pinjam");
                String[] data = {"", no_form, nama_debitur, nama_marketing, unit_bisnis, jumlah_file, keperluan, tanggal_pinjam};
                tabmode.addRow(data);
                noTable();
            }
        } catch (SQLException e) {
        }
    }
    
    public void pencarian2(String sql) {
        Object[] Baris = {"No", "No Pinjaman", "Nama Debitur"};
        tabmode2 = new DefaultTableModel(null, Baris);
        tbl_data_peminjaman.setModel(tabmode2);
        int brs = tbl_data_peminjaman.getRowCount();
        for (int i = 0; 1 < brs; i++) {
            tabmode2.removeRow(1);
        }
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String no_pinjaman_ukm = hasil.getString("no_pinjaman_ukm");
                String nama_debitur_ukm = hasil.getString("nama_debitur_ukm");
                String[] data = {"", no_pinjaman_ukm, nama_debitur_ukm};
                tabmode2.addRow(data);
                noTable2();
                lebarKolom2();
            }
        } catch (SQLException e) {
        }
    }
    
    public void noTable3() {
        int Baris = tabmode2.getRowCount();
        for (int a = 0; a < Baris; a++) {
        String nomor = String.valueOf(a + 1);
        tabmode2.setValueAt(nomor + ".", a, 0);
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

    
    private void noForm(){
       try {
            sql="select * from tb_peminjaman order by no_form desc";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next()) {
                String noform = rs.getString("no_form").substring(3);
                String AN = "" + (Integer.parseInt(noform) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
               txt_no_form.setText("GNS" + Nol + AN);
            } else {
               txt_no_form.setText("GNS0001");
            }

           }catch(NumberFormatException | SQLException e){
           JOptionPane.showMessageDialog(null, e);
           }
     }
    
    /**
     * Creates new form Form_Jaminan_Personal
     */
    public form_pinjam_kr_ukm() {
        initComponents();
        dataTable();
        dataTable2();
        dataTable3();
        noForm();
        lebarKolom();
        lebarKolom2();
        lebarKolom3();
        nonaktif();
        tanggal();
        utxt_no_form.setEditable(false);
        utxt_nama_debitur.setEditable(false);
        utxt_nama_marketing.setEditable(false);
        txt_no_form.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uform_peminjaman = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        ubtn_batal = new javax.swing.JButton();
        ubtn_simpan = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        utxt_unit_bisnis = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        utxt_jumlah_file = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        utxt_no_form = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        utxt_nama_debitur = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        ubtn_tanggal_pinjam = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        utxt_keperluan = new javax.swing.JTextArea();
        utxt_nama_marketing = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        data_peminjaman = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        cari_nasabah = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_data_peminjaman = new javax.swing.JTable();
        cetak_form = new javax.swing.JDialog();
        CtkForm = new javax.swing.JButton();
        CariDebitur = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        form_marketing = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        data_marketing = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txt_unit_bisnis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_jumlah_file = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_no_form = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nama_debitur = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_tanggal_pinjam = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_keperluan = new javax.swing.JTextArea();
        cari_nama_debitur = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        cari_nama_marketing = new javax.swing.JButton();
        txt_nama_marketing = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        txt_cari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_peminjaman = new javax.swing.JTable();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        CetakForm = new javax.swing.JButton();

        uform_peminjaman.setMinimumSize(new java.awt.Dimension(640, 600));

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
        jLabel30.setText("UBAH DATA PEMINJAMAN");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(30, 40, 570, 29);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel9.setPreferredSize(new java.awt.Dimension(420, 455));

        utxt_unit_bisnis.setBackground(new java.awt.Color(204, 204, 204));
        utxt_unit_bisnis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Keperluan");

        utxt_jumlah_file.setBackground(new java.awt.Color(204, 204, 204));
        utxt_jumlah_file.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Tanggal Pinjam");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Nomor Form");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Nama Debitur");

        utxt_no_form.setBackground(new java.awt.Color(204, 204, 204));
        utxt_no_form.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Unit Bisnis");

        utxt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Jumlah File");

        utxt_keperluan.setColumns(20);
        utxt_keperluan.setRows(5);
        jScrollPane1.setViewportView(utxt_keperluan);

        utxt_nama_marketing.setBackground(new java.awt.Color(204, 204, 204));
        utxt_nama_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Nama Peminjam");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(utxt_jumlah_file, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(utxt_unit_bisnis, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(utxt_no_form, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addComponent(ubtn_tanggal_pinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1))
                            .addComponent(utxt_nama_debitur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(utxt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_no_form, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_unit_bisnis, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utxt_jumlah_file, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel18))
                    .addComponent(ubtn_tanggal_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel9);
        jPanel9.setBounds(30, 90, 420, 450);

        javax.swing.GroupLayout uform_peminjamanLayout = new javax.swing.GroupLayout(uform_peminjaman.getContentPane());
        uform_peminjaman.getContentPane().setLayout(uform_peminjamanLayout);
        uform_peminjamanLayout.setHorizontalGroup(
            uform_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        uform_peminjamanLayout.setVerticalGroup(
            uform_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uform_peminjamanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        data_peminjaman.setMinimumSize(new java.awt.Dimension(502, 431));
        data_peminjaman.setResizable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cari Nama Nasabah");

        cari_nasabah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cari_nasabah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_nasabahActionPerformed(evt);
            }
        });
        cari_nasabah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cari_nasabahKeyTyped(evt);
            }
        });

        tbl_data_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_data_peminjamanMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_data_peminjaman);

        javax.swing.GroupLayout data_peminjamanLayout = new javax.swing.GroupLayout(data_peminjaman.getContentPane());
        data_peminjaman.getContentPane().setLayout(data_peminjamanLayout);
        data_peminjamanLayout.setHorizontalGroup(
            data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_peminjamanLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(data_peminjamanLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari_nasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        data_peminjamanLayout.setVerticalGroup(
            data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_peminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cari_nasabah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        cetak_form.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        cetak_form.setTitle("CETAK FORM");
        cetak_form.setBackground(new java.awt.Color(255, 180, 0));
        cetak_form.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cetak_form.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cetak_form.setResizable(false);
        cetak_form.setSize(350, 170);

        CtkForm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CtkForm.setText("CETAK");
        CtkForm.setBorder(null);
        CtkForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CtkFormActionPerformed(evt);
            }
        });

        CariDebitur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("| Cetak Form Peminjaman");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nama Debitur");

        javax.swing.GroupLayout cetak_formLayout = new javax.swing.GroupLayout(cetak_form.getContentPane());
        cetak_form.getContentPane().setLayout(cetak_formLayout);
        cetak_formLayout.setHorizontalGroup(
            cetak_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cetak_formLayout.createSequentialGroup()
                .addGroup(cetak_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CtkForm, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cetak_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cetak_formLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8))
                        .addGroup(cetak_formLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CariDebitur, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        cetak_formLayout.setVerticalGroup(
            cetak_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cetak_formLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(cetak_formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariDebitur)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CtkForm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        form_marketing.setMinimumSize(new java.awt.Dimension(502, 431));
        form_marketing.setResizable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("| Data Marketing");

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
                    .addComponent(jLabel13))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        form_marketingLayout.setVerticalGroup(
            form_marketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_marketingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PEMINJAMAN FILE");
        setMinimumSize(new java.awt.Dimension(1293, 588));

        jPanel1.setBackground(new java.awt.Color(255, 180, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(1277, 554));
        jPanel1.setMinimumSize(new java.awt.Dimension(1277, 554));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 50)); // NOI18N
        jLabel1.setText("PEMINJAMAN FILE");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel4.setPreferredSize(new java.awt.Dimension(420, 455));

        txt_unit_bisnis.setBackground(new java.awt.Color(204, 204, 204));
        txt_unit_bisnis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_unit_bisnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_unit_bisnisKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Keperluan");

        txt_jumlah_file.setBackground(new java.awt.Color(204, 204, 204));
        txt_jumlah_file.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_jumlah_file.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_jumlah_fileKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Tanggal Pinjam");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Nomor Form");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nama Debitur");

        txt_no_form.setBackground(new java.awt.Color(204, 204, 204));
        txt_no_form.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_no_form.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_no_formKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Unit Bisnis");

        txt_nama_debitur.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_debitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nama_debitur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nama_debiturKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Jumlah File");

        txt_keperluan.setColumns(20);
        txt_keperluan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_keperluan.setRows(5);
        jScrollPane3.setViewportView(txt_keperluan);

        cari_nama_debitur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cari_nama_debitur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_search_16px.png"))); // NOI18N
        cari_nama_debitur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_nama_debiturActionPerformed(evt);
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

        cari_nama_marketing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cari_nama_marketing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_search_16px.png"))); // NOI18N
        cari_nama_marketing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_nama_marketingActionPerformed(evt);
            }
        });

        txt_nama_marketing.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama_marketing.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Nama Peminjam");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_unit_bisnis)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(btn_tanggal_pinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_jumlah_file)
                            .addComponent(txt_no_form, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_nama_marketing)
                                    .addComponent(txt_nama_debitur))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cari_nama_debitur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cari_nama_marketing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_no_form, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_nama_debitur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cari_nama_debitur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txt_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cari_nama_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_unit_bisnis, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_jumlah_file, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tanggal_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

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

        tbl_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_peminjamanMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_peminjaman);

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

        CetakForm.setBackground(new java.awt.Color(51, 51, 51));
        CetakForm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        CetakForm.setForeground(new java.awt.Color(255, 255, 255));
        CetakForm.setText("CETAK FORM");
        CetakForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cari, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(CetakForm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CetakForm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(379, 379, 379))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1293, 640));
    }// </editor-fold>//GEN-END:initComponents

    private void ubtn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_batalActionPerformed
        // TODO add your handling code here:
        uform_peminjaman.setVisible(false);
    }//GEN-LAST:event_ubtn_batalActionPerformed

    private void ubtn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtn_simpanActionPerformed
        // TODO add your handling code here:
       String sql = "update tb_peminjaman set no_form=?,nama_debitur=?,nama_marketing=?,unit_bisnis=?,jumlah_file=?,keperluan=?,tanggal_pinjam=? where no_form='" + utxt_no_form.getText() + "'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal_pinjam = String.valueOf(fm.format(ubtn_tanggal_pinjam.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, utxt_no_form.getText());
                stat.setString(2, utxt_nama_debitur.getText());
                stat.setString(3, utxt_nama_marketing.getText());
                stat.setString(4, utxt_unit_bisnis.getText());
                stat.setString(5, utxt_jumlah_file.getText());
                stat.setString(6, utxt_keperluan.getText());
                stat.setString(7, tanggal_pinjam);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_form.requestFocus();
                uform_peminjaman.dispose();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" + e);
        }

    }//GEN-LAST:event_ubtn_simpanActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        // TODO add your handling code here:
        try {
            String path="src/laporan/report_peminjaman.jasper";
            Map param = new HashMap();
            param.put("pnama_debitur", txt_cari.getText());
            JasperPrint jp = JasperFillManager.fillReport(path, param, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
        }
        txt_cari.setText(null);
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, " Apakah Anda Yakin Ingin Menghapus Data", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from tb_peminjaman where no_form='" + txt_no_form.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_form.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus" + e);
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        uform_peminjaman.setLocationRelativeTo(this);
        utxt_no_form.setEditable(false);
        uform_peminjaman.setVisible(true);
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void tbl_peminjamanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_peminjamanMousePressed
        // TODO add your handling code here:
        int bar = tbl_peminjaman.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue_kembali = null;
        try {
            dateValue_kembali = date.parse((String) tbl_peminjaman.getValueAt(bar, 7));
        } catch (ParseException ex) {
            Logger.getLogger(form_pinjam_kpr.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_no_form.setText(b);
        utxt_no_form.setText(b);
        txt_nama_debitur.setText(c);
        utxt_nama_debitur.setText(c);
        txt_nama_marketing.setText(d);
        utxt_nama_marketing.setText(d);
        txt_unit_bisnis.setText(e);
        utxt_unit_bisnis.setText(e);
        txt_jumlah_file.setText(f);
        utxt_jumlah_file.setText(f);
        txt_keperluan.setText(g);
        utxt_keperluan.setText(g);
        btn_tanggal_pinjam.setDate(dateValue_kembali);
        ubtn_tanggal_pinjam.setDate(dateValue_kembali);
    }//GEN-LAST:event_tbl_peminjamanMousePressed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        String sqlPencarian = "select * from tb_peminjaman where no_form like '%" + txt_cari.getText() + "%' or "
        + "nama_debitur like '%" + txt_cari.getText() + "%' or "
        + "no_form like '%" + txt_cari.getText() + "%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        if (txt_no_form.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No Form Tidak boleh kosong");
        } else if (txt_nama_debitur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Debitur Tidak boleh kosong");
        } else if (txt_nama_marketing.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Peminjam Tidak boleh kosong");
        } else if (txt_unit_bisnis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Unit Bisnis Tidak boleh kosong");
        } else if (txt_jumlah_file.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah File Tidak boleh kosong");
        } else if (txt_keperluan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Keperluan Tidak boleh kosong");
        } else{
            String sql = "insert into tb_peminjaman values (?,?,?,?,?,?,?)";
            String tampilan = "dd-MM-yyyy";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal_pinjam = String.valueOf(fm.format(btn_tanggal_pinjam.getDate()));
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txt_no_form.getText());
                stat.setString(2, txt_nama_debitur.getText());
                stat.setString(3, txt_nama_marketing.getText());                
                stat.setString(4, txt_unit_bisnis.getText());
                stat.setString(5, txt_jumlah_file.getText());
                stat.setString(6, txt_keperluan.getText());
                stat.setString(7, tanggal_pinjam);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                kosong();
                dataTable();
                lebarKolom();
                txt_no_form.requestFocus();
                nonaktif();
                btn_tambah.setEnabled(true);
                noForm();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, " Data Gagal Disimpan " + e);
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

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

    private void txt_nama_debiturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_debiturKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_unit_bisnis.requestFocus();
        }
    }//GEN-LAST:event_txt_nama_debiturKeyPressed

    private void txt_no_formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_no_formKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_nama_debitur.requestFocus();
        }
    }//GEN-LAST:event_txt_no_formKeyPressed

    private void txt_unit_bisnisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_unit_bisnisKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_jumlah_file.requestFocus();
        }
    }//GEN-LAST:event_txt_unit_bisnisKeyPressed

    private void cari_nama_debiturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_nama_debiturActionPerformed
        // TODO add your handling code here:
    dataTable2();
    lebarKolom2();
    data_peminjaman.setLocationRelativeTo(this);
    data_peminjaman.setVisible(true);
    }//GEN-LAST:event_cari_nama_debiturActionPerformed

    private void tbl_data_peminjamanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data_peminjamanMousePressed
        // TODO add your handling code here:                                       
    int bar = tbl_data_peminjaman.getSelectedRow();
    String a = tabmode2.getValueAt(bar, 0).toString();
    String b = tabmode2.getValueAt(bar, 1).toString();
    String c = tabmode2.getValueAt(bar, 2).toString();
   // txt_no_form.setText(b);
    txt_nama_debitur.setText(c);
    data_peminjaman.dispose();
    txt_unit_bisnis.requestFocus();
    }//GEN-LAST:event_tbl_data_peminjamanMousePressed

    private void cari_nasabahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_nasabahKeyTyped
        String sqlPencarian2 = "select * from tb_kr_ukm where no_pinjaman_ukm like '%" + cari_nasabah.getText() + "%' or "
        + "nama_debitur_ukm like '%" + cari_nasabah.getText() + "%'"; 
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_cari_nasabahKeyTyped

    private void CetakFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakFormActionPerformed
        // TODO add your handling code here:
        cetak_form.setLocationRelativeTo(this);
        cetak_form.setVisible(true);
    }//GEN-LAST:event_CetakFormActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        kosong();
        noForm();
        dataTable();
        aktif();
        btn_tanggal_pinjam.requestFocus();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void cari_nasabahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_nasabahActionPerformed
        // TODO add your handling code here:
        String sqlPencarian2 = "select * from tb_kr_ukm where no_pinjaman_ukm like '%" + cari_nasabah.getText() + "%' or "
        + "nama_debitur_ukm like '%" + cari_nasabah.getText() + "%'"; 
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_cari_nasabahActionPerformed

    private void CtkFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CtkFormActionPerformed
        // TODO add your handling code here:
        try {
            String path="src/laporan/FormPinjam.jasper";
            Map param = new HashMap();
            param.put("pnama_debitur", CariDebitur.getText());
            JasperPrint jp = JasperFillManager.fillReport(path, param, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
        }
        CariDebitur.setText(null);
    }//GEN-LAST:event_CtkFormActionPerformed

    private void txt_jumlah_fileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlah_fileKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_keperluan.requestFocus();
        }
        if(Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Anda Hanya Bisa Masukkan Angka", "Masukkan Jumlah File", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_jumlah_fileKeyPressed

    private void cari_nama_marketingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_nama_marketingActionPerformed
        // TODO add your handling code here:
        dataTable3();
        lebarKolom3();
        form_marketing.setLocationRelativeTo(this);
        form_marketing.setVisible(true);
    }//GEN-LAST:event_cari_nama_marketingActionPerformed

    private void data_marketingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_marketingMousePressed
        // TODO add your handling code here:
        int bar = data_marketing.getSelectedRow();
        String a = tabmode3.getValueAt(bar, 0).toString();
        String b = tabmode3.getValueAt(bar, 1).toString();
        String c = tabmode3.getValueAt(bar, 2).toString();
        txt_nama_marketing.setText(c);
        form_marketing.dispose();
        txt_nama_marketing.requestFocus();
    }//GEN-LAST:event_data_marketingMousePressed
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CariDebitur;
    private javax.swing.JButton CetakForm;
    private javax.swing.JButton CtkForm;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private com.toedter.calendar.JDateChooser btn_tanggal_pinjam;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JButton cari_nama_debitur;
    private javax.swing.JButton cari_nama_marketing;
    private javax.swing.JTextField cari_nasabah;
    private javax.swing.JDialog cetak_form;
    private javax.swing.JTable data_marketing;
    private javax.swing.JDialog data_peminjaman;
    private javax.swing.JDialog form_marketing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbl_data_peminjaman;
    private javax.swing.JTable tbl_peminjaman;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_jumlah_file;
    private javax.swing.JTextArea txt_keperluan;
    private javax.swing.JTextField txt_nama_debitur;
    private javax.swing.JTextField txt_nama_marketing;
    private javax.swing.JTextField txt_no_form;
    private javax.swing.JTextField txt_unit_bisnis;
    private javax.swing.JButton ubtn_batal;
    private javax.swing.JButton ubtn_simpan;
    private com.toedter.calendar.JDateChooser ubtn_tanggal_pinjam;
    private javax.swing.JFrame uform_peminjaman;
    private javax.swing.JTextField utxt_jumlah_file;
    private javax.swing.JTextArea utxt_keperluan;
    private javax.swing.JTextField utxt_nama_debitur;
    private javax.swing.JTextField utxt_nama_marketing;
    private javax.swing.JTextField utxt_no_form;
    private javax.swing.JTextField utxt_unit_bisnis;
    // End of variables declaration//GEN-END:variables

}
