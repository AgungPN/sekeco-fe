package views.superkasirfrontend;


import dtos.product.ProductsPagination;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import web.Http;


/**
 *
 * @author Rosemary
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();
        setTable();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void setTable() {
        Http http = new Http();
        ProductsPagination products = http.sendGetRequest("products", ProductsPagination.class);

//         Example set table from data API
        String[] fields = new String [] {
                "No", "Barcode", "Nama Barang", "Harga Beli", "Harga Jual", "Profit Sharing Amount", "Stok"};
        DefaultTableModel list = new DefaultTableModel(null, fields);
        for (dtos.product.Product product : products.getContent()) {
            list.addRow(new Object[]{
                    product.getProductId(),
                    product.getBarcode(),
                    product.getName(),
                    product.getPrice(),
                    product.getPrice(), //TODO : tambahkan harga beli
                    product.getProfitSharingAmount(),
                    product.getStock()
                    
            });
        }
        tableProduct.setModel(list);
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
        tableProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        BtnAddProduct = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnNext = new javax.swing.JButton();
        BtnPrevious = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txthalaman = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tableProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Barcode", "Nama Barang", "Harga Beli", "Harga Jual", "Profit Sharing Amount", "Stok"
            }
        ));
        tableProduct.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableProductPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PRODUCT");

        txtsearch.setText("Pencarian");
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        BtnAddProduct.setText("Add Product");
        BtnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddProductActionPerformed(evt);
            }
        });

        BtnDelete.setBackground(new java.awt.Color(255, 51, 51));
        BtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        BtnDelete.setText("Hapus");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnNext.setText("Next");
        BtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNextActionPerformed(evt);
            }
        });

        BtnPrevious.setText("Previous");
        BtnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPreviousActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\ImageFolder\\kembali.png"));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 255, 51));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txthalaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthalamanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BtnAddProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(BtnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(txthalaman, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(BtnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(BtnAddProduct))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete)
                    .addComponent(btnEdit)
                    .addComponent(BtnPrevious)
                    .addComponent(txthalaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNext))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableProductPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tableProductPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tableProductPropertyChange

    private void BtnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPreviousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPreviousActionPerformed

    private void BtnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddProductActionPerformed
        // TODO add your handling code here:

                // Membuka file inputBarang.java
                Purchase addframe = new Purchase();
                addframe.setVisible(true);
                this.dispose();
            
   
    }//GEN-LAST:event_BtnAddProductActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        DsbSAdmin dsbSAdminFrame = new DsbSAdmin();
    dsbSAdminFrame.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        editProduct editframe = new editProduct();
                editframe.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
//        int selectedRow = yourTableName.getSelectedRow(); // Ganti "yourTableName" dengan nama tabel Anda
//
//    if (selectedRow != -1) {
//        DefaultTableModel model = (DefaultTableModel) yourTableName.getModel(); // Ganti "yourTableName" dengan nama tabel Anda
//        model.removeRow(selectedRow);
//    }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnNextActionPerformed

    private void txthalamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthalamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthalamanActionPerformed

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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddProduct;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnNext;
    private javax.swing.JButton BtnPrevious;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txthalaman;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
