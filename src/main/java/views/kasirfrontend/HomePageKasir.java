package views.kasirfrontend;

import dtos.invoiceTour.InvoiceTour;
import dtos.invoiceTour.InvoiceTours;
import dtos.order.OrderDetailsRequest;
import dtos.order.OrderRequest;
import dtos.product.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

import dtos.product.ProductsApi;
import java.util.ArrayList;
import java.util.List;

import helpers.Auth;
import web.Http;

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
        GrandTotal.setText(df.format(totalPrice));
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
                tf_waktu.setText(Vjam);
            }};
            new javax.swing.Timer(1000, taskPerformer).start();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_order = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_waktu = new javax.swing.JTextField();
        tf_username = new javax.swing.JTextField();
        cb_selectTour = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        BtnBayar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        GrandTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_order);

        jPanel1.setBackground(new java.awt.Color(200, 191, 173));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Waktu");

        jLabel3.setText("User");

        jLabel4.setText("Mitra");

        tf_waktu.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        tf_waktu.setEnabled(false);

        tf_username.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        tf_username.setEnabled(false);

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
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_username, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(tf_waktu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_selectTour, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(tf_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_selectTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(200, 191, 173));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Barcode");

        tf_barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_barcodeKeyPressed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageFolder/logout.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Total :");

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageFolder/delete.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        BtnBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageFolder/payment.png"))); // NOI18N
        BtnBayar.setPreferredSize(new java.awt.Dimension(55, 55));
        BtnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBayarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        GrandTotal.setBackground(new java.awt.Color(255, 255, 255));
        GrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        GrandTotal.setForeground(new java.awt.Color(255, 255, 0));
        GrandTotal.setText("Rp 0.00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
    }

    private void BtnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBayarActionPerformed
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
        paymentPage.setVisible(true);  
    }//GEN-LAST:event_BtnBayarActionPerformed

    private void tf_barcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_barcodeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            addProductInRow();
            sumAmount();
        }
    }//GEN-LAST:event_tf_barcodeKeyPressed

    private void cb_selectTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_selectTourActionPerformed
        
        
    }//GEN-LAST:event_cb_selectTourActionPerformed

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
    private javax.swing.JButton BtnBayar;
    private javax.swing.JLabel GrandTotal;
    private javax.swing.JButton btn_delete;
    private javax.swing.JComboBox<String> cb_selectTour;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_order;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_username;
    private javax.swing.JTextField tf_waktu;
    // End of variables declaration//GEN-END:variables
}
