/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.kasirfrontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import dtos.invoiceTour.InvoiceTour;
import dtos.invoiceTour.InvoiceTours;
import dtos.order.OrderDetailsRequest;
import dtos.order.OrderRequest;
import dtos.product.Product;
import dtos.product.ProductsApi;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import views.auth.Login;
import web.Http;

/**
 *
 * @author Lenovo
 */
public class HomePageKasir extends javax.swing.JFrame {

    String[] fields;
    DefaultTableModel list;
    List<Product> productList = new ArrayList<>();
    List<InvoiceTour> invoiceTourList = new ArrayList<>();
    public HomePageKasir() {
       initComponents();
       fields = new String[]{"Barcode", "Nama Barang", "Qty", "Harga","Sub Total", "Aksi"};
       list = new DefaultTableModel(null, fields);
       cb_selectTour.addItem("Person");
        cb_tour();
        jam();
    }
    
    private void cb_tour(){
        Http http = new Http();
        InvoiceTours invoiceTours = http.sendGetRequest("invoice/tour/status?status=NOW", InvoiceTours.class);
        for(InvoiceTour invoiceTour : invoiceTours.getData()){
            invoiceTourList.add(invoiceTour);
            cb_selectTour.addItem(invoiceTour.getTourId().getName());
        }
    }
    
    private List<OrderDetailsRequest> orderDetails(){
        List<OrderDetailsRequest> list = new ArrayList<>();
        for(int i = 0; i < tb_order.getRowCount(); i++){
            OrderDetailsRequest details = OrderDetailsRequest.builder()
                    .productId(productList.get(i).getProductId())
                    .profitSharingAmount(productList.get(i).getProfitSharingAmount())
                    .price(productList.get(i).getPrice())
                    .quantity((int) tb_order.getValueAt(i, 2))
                    .subtotal((Long) tb_order.getValueAt(i, 4))
                    .build();
            list.add(details);
        }
        return list;
    }
    
    private Long invoiceTourId(){
        for(int i = 0; i < invoiceTourList.size(); i++){
            if(invoiceTourList.get(i).getTourId().getName().equals(cb_selectTour.getSelectedItem().toString())){
                return invoiceTourList.get(i).getInvoiceTourId();
            }
        }
        return null;
    }
    
    private void addProductInRow(){
        Http http = new Http();
        ProductsApi products = http.sendGetRequest("products/barcode?barcode=" + tf_barcode.getText(), ProductsApi.class);
        int rowIndex = isFieldInRow(products.getData().getBarcode());
        if(rowIndex >= 0){
            int currentQty = (int)tb_order.getValueAt( rowIndex, 2) + 1;
            list.setValueAt(currentQty, rowIndex, 2);
            list.setValueAt(currentQty * products.getData().getPrice(), rowIndex, 4);
        }else{
            productList.add(products.getData());
            list.addRow(new Object[]{
                products.getData().getBarcode(),
                products.getData().getName(),
                1,
                products.getData().getPrice(),
                products.getData().getPrice()
            });
            
            
        }
        tb_order.setModel(list);
    }
    
    private int isFieldInRow(String barcode){
        for(int i = 0; i < tb_order.getRowCount(); i++){
            if(barcode.equals(tb_order.getValueAt(i, 0))){
                return i;
            }
        }
        return -1;
    }
    
     private void sumAmount() {
        Long totalPrice = list.getRowCount() > 0 ? list.getDataVector().stream()
                .mapToLong(row -> (Long) row.elementAt(4))
                .sum() : 0;
        
        DecimalFormat df = new DecimalFormat("Rp #,##0.00");
        tfGrandTotal.setText(df.format(totalPrice));
     }
       
    private void jam() {
        try {
            ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String Vjam;
                String noljam = "";
                String nolmenit = "";
                String noldetik = "";
                Calendar dt = Calendar.getInstance();
                int jam = dt.get(Calendar.HOUR_OF_DAY);
                int menit = dt.get(Calendar.MINUTE);
                int detik = dt.get(Calendar.SECOND);
                if (jam < 10) {
                    noljam = "0";
                }
                if (menit < 10) {
                    nolmenit = "0";
                }
                if (detik < 10) {
                    noldetik = "0";
                }
                String Sjam = noljam + Integer.toString(jam);
                String Smenit = nolmenit + Integer.toString(menit);
                String Sdetik = noldetik + Integer.toString(detik);
                Vjam = Sjam + ":" + Smenit + ":" + Sdetik;
                tfWaktu.setText(Vjam);
            }};
            new javax.swing.Timer(1000, taskPerformer).start();
        } catch (Exception e) {
            System.out.println("Error : " + e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_order = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnlogout = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfWaktu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNamaBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cb_selectTour = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBayar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tfGrandTotal = new javax.swing.JLabel();
        btnHapusFieldTabel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tb_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_order.setRowHeight(40);
        jScrollPane1.setViewportView(tb_order);

        jPanel2.setBackground(new java.awt.Color(200, 191, 173));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnlogout.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\ImageFolder\\logout.png"));
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel8.setText("Tanggal");

        tfWaktu.setEnabled(false);
        tfWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfWaktuActionPerformed(evt);
            }
        });

        jLabel1.setText("User");

        tfUser.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUser, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(tfWaktu))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Barcode");

        jLabel4.setText("Harga");

        tf_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_barcodeActionPerformed(evt);
            }
        });
        tf_barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_barcodeKeyPressed(evt);
            }
        });

        tfHarga.setEnabled(false);

        jLabel5.setText("Nama ");

        tfNamaBarang.setEnabled(false);
        tfNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaBarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Mitra");

        cb_selectTour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_selectTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_selectTourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_barcode, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(tfHarga))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNamaBarang)
                    .addComponent(cb_selectTour, 0, 187, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cb_selectTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Total :");

        btnBayar.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\ImageFolder\\payment.png"));
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        tfGrandTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        tfGrandTotal.setForeground(new java.awt.Color(255, 255, 0));
        tfGrandTotal.setText("Rp 0.00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnHapusFieldTabel.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\ImageFolder\\delete.png"));
        btnHapusFieldTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusFieldTabelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHapusFieldTabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBayar)
                .addGap(75, 75, 75)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(btnHapusFieldTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        int totalItem = 0;
        Long totalPrice = 0L;
        for(int i = 0; i < tb_order.getRowCount(); i++){
            totalItem += (int)tb_order.getValueAt(i, 2);
            totalPrice += (Long)tb_order.getValueAt(i, 4);
        }
        OrderRequest order = OrderRequest.builder()
                .userId(1L)
                .invoiceTourId(invoiceTourId())
                .totalItems(totalItem)
                .totalPrice(totalPrice)
                .amount(0L)
                .refund(0L)
                .orderDetailsRequests(orderDetails())
                .build();
        KasirPaymentPage paymentPage = new KasirPaymentPage(order);
        paymentPage.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
     Login loginFrame = new Login();
    loginFrame.setVisible(true);
    this.dispose(); //
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void tfWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfWaktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfWaktuActionPerformed

    private void tf_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_barcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_barcodeActionPerformed

    private void tfNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaBarangActionPerformed

    private void btnHapusFieldTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusFieldTabelActionPerformed
    DefaultTableModel model = (DefaultTableModel)tb_order.getModel();
    model.setRowCount(0);// TODO add your handling code here:
    }//GEN-LAST:event_btnHapusFieldTabelActionPerformed

    private void cb_selectTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_selectTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_selectTourActionPerformed

    private void tf_barcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_barcodeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            addProductInRow();
            sumAmount();
        }
    }//GEN-LAST:event_tf_barcodeKeyPressed


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
            java.util.logging.Logger.getLogger(HomePageKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePageKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnHapusFieldTabel;
    private javax.swing.JButton btnlogout;
    private javax.swing.JComboBox<String> cb_selectTour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_order;
    private javax.swing.JLabel tfGrandTotal;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfNamaBarang;
    private javax.swing.JTextField tfUser;
    private javax.swing.JTextField tfWaktu;
    private javax.swing.JTextField tf_barcode;
    // End of variables declaration//GEN-END:variables
}
