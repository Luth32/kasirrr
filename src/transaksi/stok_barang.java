/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author Hadi Firmansyah
 */
public class stok_barang extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();

    /**
     * Creates new form stok_barang
     */
    public stok_barang() {
        initComponents();
        
        koneksi conn = new koneksi();
        koneksi.getKoneksi();
        
        tabel_barang.setModel(table);
        table.addColumn("Kode Barang");
        table.addColumn("Nama Barang");
        table.addColumn("Harga");
        table.addColumn("Stok");
        
        tampilData();
            
    }
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tabel_barang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `tb_databarang` ";
        
        try{
            Connection connect = koneksi.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode_barang");
                    String nama = rslt.getString("nama_barang");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,stok};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tabel_barang.setModel(table);
            
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
    private void cari(){
        int row = tabel_barang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String cari = txt_cari.getText();
        
        String query = "SELECT * FROM `tb_databarang` WHERE `kode_barang`  LIKE '%"+cari+"%' OR `nama_barang` LIKE '%"+cari+"%' ";
                
       try{
           Connection connect = koneksi.getKoneksi();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode_barang");
                    String nama = rslt.getString("nama_barang");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,stok};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tabel_barang.setModel(table);
           
        
    }catch(Exception e){
           System.out.println(e);
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

        jPanel1 = new javax.swing.JPanel();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(565, 695));
        getContentPane().setLayout(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 220, 30));

        btn_cari.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/cari.png"))); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_barang);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 870, 320));

        btn_back.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/back.png"))); // NOI18N
        btn_back.setText("Kembali");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, -1));

        btn_refresh.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        btn_refresh.setText("Muat Ulang");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        jPanel1.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/SBN2.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/interlaced.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 290, 380));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/interlaced.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, 140, 170));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/interlaced.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 370, 380));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/interlaced.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 380));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/interlaced.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 400, 170));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/interlaced.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, 170));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 550);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        cari();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        int row = tabel_barang.getSelectedRow();
        formTransaksi menu = new formTransaksi();

        String kode = table.getValueAt(row, 0).toString();
        menu.txt_kodebarang.setText(kode);

        String nama = table.getValueAt(row, 1).toString();
        menu.txt_namabarang.setText(nama);

        String harga = table.getValueAt(row, 2).toString();
        menu.txt_harga.setText(harga);

        menu.setVisible(true);
        menu.pack();
        menu.setDefaultCloseOperation(formTransaksi.DISPOSE_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        new formTransaksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
//        tabel_barang.setModel(table);
        tampilData();

  //      dispose();
    //    new stok_barang().setVisible(true);
    }//GEN-LAST:event_btn_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new stok_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
