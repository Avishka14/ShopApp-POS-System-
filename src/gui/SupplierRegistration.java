
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Avishka
 */
public class SupplierRegistration extends javax.swing.JFrame {
    
     private GRN grn;

    public void setGrn(GRN grn) {
        this.grn = grn;
    }
    
    
       private String companyId;

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

   
    public SupplierRegistration() {
        initComponents();
        loadSuppliers("first_name", "ASC", "");
    }
    
    public void setCompanyName(String name){
        jLabel2.setText(name);
        
    }
    
    public void mobileGrabFocus() {
        jTextField1.grabFocus();
    }
    
    private void loadSuppliers(String column, String orderby, String mobile){
        
        try {
       
             ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier` INNER JOIN `company`"
                    + "ON `supplier`.`company_id` = `company`.`id` WHERE `mobile` LIKE '" + mobile + "%' ORDER BY `" + column + "` " + orderby + "");
            
             DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
             model.setRowCount(0);
             
             while(resultSet.next()){
                   Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("company.name"));

                model.addRow(vector);
                 
             }
             
             
             
            
            
        } catch (Exception e) {
         e.printStackTrace();
        }
               
    }
    
    private void clearField(){
        
        jTextField1.setText("");
        jTextField2.setText("");
        jLabel2.setText("Company Name Here");
        companyId = null;
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
        jLabel10.setText("0");
        jLabel11.setText("0");
        jTextField1.grabFocus();
        jTable1.clearSelection();
        loadSuppliers("first_name", "ASC", jTextField1.getText());
        jTextField1.setEnabled(true);
    
        
    }
    
      private void search() {
        String mobile = jTextField1.getText();

        if (jComboBox1.getSelectedIndex() == 0) {
            loadSuppliers("first_name", "ASC", mobile);
        } else if (jComboBox1.getSelectedIndex() == 1) {
            loadSuppliers("first_name", "DESC", mobile);
        } else if (jComboBox1.getSelectedIndex() == 2) {
            loadSuppliers("company`.`name", "ASC", mobile);
        } else if (jComboBox1.getSelectedIndex() == 3) {
            loadSuppliers("company`.`name", "DESC", mobile);
        }
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supplier Registration");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Gotham", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Supplier Registration");

        jButton1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton1.setText("Select Company");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("COMPANY NAME HERE");

        jLabel3.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel3.setText("Mobile");

        jLabel4.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel6.setText("E-Mail");

        jTextField1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton2.setText("Create Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton3.setText("Update Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton4.setText("Clear All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel7.setText("Supplier Sort By");

        jComboBox1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name ASC", "Name DESC", "Company ASC", "Company DESC" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "E-Mail", "Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel8.setText("Total GRN:");

        jLabel9.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("0");

        jLabel10.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel10.setText("Pending Payemnt:");

        jLabel11.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CompanyRegistration CR = new CompanyRegistration(this, true);
        CR.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField4.getText();

        if (companyId == null) {
            JOptionPane.showMessageDialog(this, "Please select a company", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {

            JOptionPane.showMessageDialog(this, "Please enter valid email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                
                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier` WHERE `mobile` = '" + mobile + "' OR `email` = '" + email + "'");

               
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Supplier already registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                    MySQL.executeIUD("INSERT INTO `supplier`(`mobile`,`first_name`,`last_name`,`email`,`company_id`)"
                            + "VALUES ('" + mobile + "','" + fname + "','" + lname + "','" + email + "','" + companyId + "')");
                  clearField();
                    
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearField();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       search();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        search();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        int row = jTable1.getSelectedRow();

        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 0)));
        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 1)));
        jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 2)));
        jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 3)));
        jLabel2.setText(String.valueOf(jTable1.getValueAt(row, 4)));

        jTextField1.setEnabled(false);
        
             if (evt.getClickCount() == 2) {

            if (grn != null) {
                grn.getjTextField2().setText(String.valueOf(jTable1.getValueAt(row, 0)));
                grn.getjLabel21().setText(String.valueOf(jTable1.getValueAt(row, 1)));
                this.dispose();
            }
        }
        

        try {

            double total = 0;
           
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `grn` INNER JOIN `grn_item`"
                    + "ON `grn`.`id` = `grn_item`.`grn_id` WHERE `supplier_mobile` = '" + String.valueOf(jTable1.getValueAt(row, 0)) + "'");
         
            HashMap<Long, Double> grns = new HashMap<>();
            
            while (resultSet.next()) {
                double qty = resultSet.getDouble("grn_item.qty");

                double buyingPrice = resultSet.getDouble("grn_item.price");

                double itemTotal = qty * buyingPrice;
                
                 //total = total + itemTotal;
                total += itemTotal;
                grns.put(resultSet.getLong("grn.id"), resultSet.getDouble("grn.paid_amount"));
                         
            }
            
             double totalPaid = 0;

            for (Double paid : grns.values()) {

                //totalPaid+=paid;
                totalPaid = totalPaid + paid;
            }

            jLabel10.setText(String.valueOf(grns.size()));
            jLabel11.setText(String.valueOf(total - totalPaid));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String mobile = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        String email = jTextField4.getText();

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+"
                + "(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {

            JOptionPane.showMessageDialog(this, "Please enter valid email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `supplier` WHERE `email` = '" + email + "' AND `mobile` !='" + mobile + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Email already used", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    String a;

                    if (jLabel2.getText().equals(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 4)))) {
                        //company update  not requeried
                        a = "";
                    } else {
                        //company update requeried
                        a = ",`company_id` ='" + companyId + "'";
                    }

                        MySQL.executeIUD("UPDATE `supplier` SET "
                            + "`first_name` = '" + fname + "' , `last_name` = '" + lname + "',`email` = '" + email + "' " + a + " WHERE `mobile` = '" + mobile + "'");
                    clearField();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static void main(String args[]) {
        
        FlatMacDarkLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
