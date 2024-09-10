
package gui;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Avishka
 */
public class CompanyRegistration extends javax.swing.JDialog {

    SupplierRegistration sr;
   
    public CompanyRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCompanies();
        sr = (SupplierRegistration) parent;
    }

    private void loadCompanies(){
        
        try {
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `company`  ");
                    
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            while(resultSet.next()){
                
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("hotline"));
               model.addRow(vector);
                
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    private void reset(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField1.grabFocus();
        jButton1.setEnabled(true);
        jTable1.clearSelection();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Company Registration");

        jLabel1.setFont(new java.awt.Font("Gotham", 0, 16)); // NOI18N
        jLabel1.setText("Company Name");

        jLabel2.setFont(new java.awt.Font("Gotham", 0, 16)); // NOI18N
        jLabel2.setText("Hotline");

        jTextField1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Company Name", "Hotline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jButton3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String name = jTextField1.getText();
        String hotline = jTextField2.getText();
        
        if(name.isEmpty()){
            
            JOptionPane.showMessageDialog(this, "Please enter your Company Name !", "Warning", JOptionPane.ERROR_MESSAGE);
            
        }else if(hotline.isEmpty()){
             JOptionPane.showMessageDialog(this, "Please enter your Hotline !", "Warning", JOptionPane.ERROR_MESSAGE);
            
        } else if (!hotline.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid hotline number", "Warning", JOptionPane.WARNING_MESSAGE);

        }else {
            
            try {
                
                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `company` WHERE `name`='"+name+"' OR `hotline`='"+hotline+"' ");
                
                if(resultSet.next()){
                     JOptionPane.showMessageDialog(this, "Company name or Hotline already used!", "Warning", JOptionPane.WARNING_MESSAGE);
                    
                }else{
                    MySQL.executeIUD("INSERT INTO `company`(`name`,`hotline`) VALUES('" + name + "','" + hotline + "')");
                    loadCompanies();
                    reset();
                    
                }
      
            } catch (Exception e) {
             e.printStackTrace();
            }
            
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
           String name = jTextField1.getText();
        String hotline = jTextField2.getText();
     
        int row = jTable1.getSelectedRow();
        
        String selectedID =  String.valueOf(jTable1.getValueAt(row, 0));
        String selectedName =  String.valueOf(jTable1.getValueAt(row, 0));
        String selectedHotline =  String.valueOf(jTable1.getValueAt(row, 0));
        
        
        if(name.isEmpty()){
            
            JOptionPane.showMessageDialog(this, "Please enter your Company Name !", "Warning", JOptionPane.ERROR_MESSAGE);
            
        }else if(hotline.isEmpty()){
             JOptionPane.showMessageDialog(this, "Please enter your Hotline !", "Warning", JOptionPane.ERROR_MESSAGE);
            
        } else if (!hotline.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            JOptionPane.showMessageDialog(this, "Please enter valid hotline number", "Warning", JOptionPane.WARNING_MESSAGE);

        }else if(selectedName.equals(name) && selectedHotline.equals(hotline) ){
            
                 JOptionPane.showMessageDialog(this, "Please change name or hotline to Update!", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }else {
            
            try {
                
                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `company` WHERE `name`='"+name+"' OR `hotline`='"+hotline+"' ");
                
                if(resultSet.next()){
                     JOptionPane.showMessageDialog(this, "Company name or Hotline already used!", "Warning", JOptionPane.WARNING_MESSAGE);
                    
                }else{
                    MySQL.executeIUD("UPDATE `company` SET `name`='"+name+"', `hotline`='"+hotline+"' WHERE `id`='"+selectedID+"' ");
                    loadCompanies();
                    reset();                 
                }
                
                            
      
            } catch (Exception e) {
             e.printStackTrace();
            }
            
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
       int row = jTable1.getSelectedRow();
       
       jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 1)));
       jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2)));
       
       jButton1.setEnabled(false);
       
       if(evt.getClickCount() == 2){
           
           String name = String.valueOf(jTable1.getValueAt(row,1));
           
           sr.setCompanyName(name);
           this.dispose();
        
            sr.mobileGrabFocus();
           
            sr.setCompanyId(String.valueOf(jTable1.getValueAt(row, 0)));
           
       }
 
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
