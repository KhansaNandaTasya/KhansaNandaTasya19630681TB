/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import toko.koneksi;

/**
 *
 * @author Rifqi
 */
public class Form_data_penjualan extends javax.swing.JInternalFrame {

    /**
     * Creates new form Form_data_penjualan
     */
    Connection kon = koneksi.koneksiDb();
    public Form_data_penjualan() {
        initComponents();
        tabeltransaksi();
    }
     public void tabeltransaksi(){
       DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Transaksi");
        model.addColumn("Id Buku");
        model.addColumn("Tanggal");
        model.addColumn("Judul");
        model.addColumn("Kategori");
        model.addColumn("Harga Stuan");
        model.addColumn("Jumlah Beli");
        model.addColumn("Harga");
        model.addColumn("Bayar");
        model.addColumn("Kembalian");
        //menampilkan data database kedalam tabel
        try {
            String sql = "select * from penjualan";
            java.sql.Statement stm=kon.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
                               ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)});
            }
            tabeltransaksi.setModel(model);
            
        } catch (Exception e) {
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

        jPanel2 = new javax.swing.JPanel();
        srlpane = new javax.swing.JScrollPane();
        tabeltransaksi = new javax.swing.JTable();
        txnota = new javax.swing.JTextField();
        btnhapus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kelola Data Penjualan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltransaksiMouseClicked(evt);
            }
        });
        srlpane.setViewportView(tabeltransaksi);

        txnota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txnotaKeyPressed(evt);
            }
        });

        btnhapus.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jButton1.setText("Cetak Semua data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cari Kode Nota");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srlpane, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txnota, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapus)))
                .addGap(0, 126, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txnota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(srlpane, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnhapus))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        if(tabeltransaksi.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"Silahkan pilih baris data yang akan di hapus");
            return ;
        }
        if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akaan menghapus data ini?")==JOptionPane.OK_OPTION){
            try{

                String sql="DELETE FROM penjualan WHERE id_transaksi='"+txnota.getText()+"'";
                PreparedStatement pst=kon.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data berhasil di hapus");

            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            tabeltransaksi();
       
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tabeltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltransaksiMouseClicked
        // TODO add your handling code here:
       int row = tabeltransaksi.getSelectedRow();
        txnota.setText(tabeltransaksi.getModel().getValueAt(row, 0).toString());
    }//GEN-LAST:event_tabeltransaksiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con=null;
        try {
            String jdbcDriver ="com.mysql.jdbc.Driver";
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/dbtoko","root","");
            Statement stm = koneksi.createStatement();
            
            try{
            String report=("C:\\Users\\Rifqi\\Documents\\NetBeansProjects\\toko\\src\\report\\cetakalltransaksi.jrxml");
            HashMap hash = new HashMap();
            hash.put("all",all.getText());
            JasperReport JRpt = JasperCompileManager.compileReport(report);
            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, kon);
            JasperViewer.viewReport(JPrint, false);
            }catch(Exception rptexcpt){
                System.out.println("maaf cetak gagal"+rptexcpt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txnotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txnotaKeyPressed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Transaksi");
        model.addColumn("Id Buku");
        model.addColumn("Tanggal");
        model.addColumn("Judul");
        model.addColumn("Kategori");
        model.addColumn("Harga Stuan");
        model.addColumn("Jumlah Beli");
        model.addColumn("Harga");
        model.addColumn("Bayar");
        model.addColumn("Kembalian");
        //menampilkan data database kedalam tabel
        try {
            String nota = txnota.getText();
            String sql = "select * from penjualan where id_transaksi like'%"+nota+"%'";
            java.sql.Statement stm=kon.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
                               ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)});
            }
            tabeltransaksi.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
    }//GEN-LAST:event_txnotaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane srlpane;
    private javax.swing.JTable tabeltransaksi;
    private javax.swing.JTextField txnota;
    // End of variables declaration//GEN-END:variables
}