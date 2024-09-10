
package gui;

import javax.swing.table.DefaultTableModel;
import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Avishka
 */
public class AddressView extends javax.swing.JDialog {

       private  HashMap<String,String> citymap = new HashMap<>();
    
    private String email;
    
 
    public AddressView(java.awt.Frame parent, boolean model, String email) {  
        super(parent,model);
         initComponents();
         jLabel5.setText(email);
         this.email = email;
         loadCity();
         loadAddress();
       
    }
    
    private void loadAddress(){
        
        try {
            
           ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee_address` INNER JOIN `city` ON `employee_address`.`city_id` = `city`.`id`"
                    + " WHERE `employee_email`='"+this.email+"' ");
            
            DefaultTableModel defaulttableModel = (DefaultTableModel)jTable1.getModel();
            defaulttableModel.setRowCount(0);
            
            while(resultSet.next()){
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("line1"));
                vector.add(resultSet.getString("line2"));
                vector.add(resultSet.getString("city.name"));
                
               defaulttableModel.addRow(vector); 

            }
            
        } catch (Exception e) {
         e.printStackTrace();
        }
    }

    
    
    
    private void loadCity(){
        
          try {
            
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `city`");
            
            Vector<String> vector = new Vector<>();
            vector.add("Select");
            
            while(resultSet.next()){
                vector.add(resultSet.getString("name"));  
               citymap.put(resultSet.getString("name") ,resultSet.getString("id"));       
            }
            
            DefaultComboBoxModel  model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);
                               
        } catch (Exception e) {
         e.printStackTrace();
        }
              
    }
    
    private void reset(){       
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedItem("Select");
        
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Address View");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Gotham", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Address View");

        jLabel2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel2.setText("Address Line 1");

        jLabel3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel3.setText("Address Line 2");

        jTextField1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel4.setText("City");

        jComboBox1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jButton3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Line 1", "Line 2", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Employee Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField2))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        try {
            
           String line1 = jTextField1.getText();
           String line2 = jTextField2.getText();
           String city = String.valueOf(jComboBox1.getSelectedItem());
          
           if(line1.isEmpty()){
               JOptionPane.showMessageDialog(this, "Line 1 in Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
          
           }else if(line2.isEmpty()){
                JOptionPane.showMessageDialog(this, "Line 2 in Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
              
           }else if(city.equals("Select") ){
                   JOptionPane.showMessageDialog(this, "Select City!", "Warning", JOptionPane.WARNING_MESSAGE);
          
           }else {
                     
                boolean isFound = false;
                
                  for(int i = 0; i < jTable1.getRowCount(); i++){
                   
                   String getline1 = String.valueOf(jTable1.getValueAt(i, 1));
                   String getline2 = String.valueOf(jTable1.getValueAt(i, 2));
                   String getCity = String.valueOf(jTable1.getValueAt(i, 3));
                   
                   if(getline1.equals(line1)&& getline2.equals(line2) && getCity.equals(city)){
                       
                       JOptionPane.showMessageDialog(this, "Address Already Added!", "Warning", JOptionPane.WARNING_MESSAGE);
                       isFound = true;
                       break;
                   }
                   
               }
               
                  if(!isFound){
                        
               MySQL.executeIUD("INSERT INTO `employee_address` (`line1`,`line2`,`city_id`,`employee_email`)"
                       + " VALUES ('"+line1+"','"+line2+"','"+citymap.get(city)+"','"+this.email+"') ");
               
               loadAddress();
               reset();
                  }
               
             
           }
                      
        } catch (Exception e) {
         e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
       int row = jTable1.getSelectedRow();
        
          jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 1)));  
          jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2)));   
          jComboBox1.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 3)));
                  
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        int row = jTable1.getSelectedRow();
     
        
        if(row == -1){       
           
            JOptionPane.showMessageDialog(this, "Please Select row to Update", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }else{
            
               String id = String.valueOf(jTable1.getValueAt(row,0));
       try {
                              
           String line1 = jTextField1.getText();
           String line2 = jTextField2.getText();
           String city = String.valueOf(jComboBox1.getSelectedItem());
          
           if(line1.isEmpty()){
               JOptionPane.showMessageDialog(this, "Line 1 in Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
          
           }else if(line2.isEmpty()){
                JOptionPane.showMessageDialog(this, "Line 2 in Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
              
           }else if(city.equals("Select") ){
                   JOptionPane.showMessageDialog(this, "Select City!", "Warning", JOptionPane.WARNING_MESSAGE);
          
           }else {  
               
                boolean isFound = false;
                
                  for(int i = 0; i < jTable1.getRowCount(); i++){
                   
                   String getline1 = String.valueOf(jTable1.getValueAt(i, 1));
                   String getline2 = String.valueOf(jTable1.getValueAt(i, 2));
                   String getCity = String.valueOf(jTable1.getValueAt(i, 3));
                   
                   if(getline1.equals(line1)&& getline2.equals(line2) && getCity.equals(city)){
                       
                       JOptionPane.showMessageDialog(this, "Address Already Added!", "Warning", JOptionPane.WARNING_MESSAGE);
                       isFound = true;
                       break;
                   }
                   
               }
               
                  if(!isFound){
                              
                    MySQL.executeIUD("UPDATE  `employee_address` SET `line1`='"+line1+"', `line2`='"+line2+"',  `city_id`='"+citymap.get(city)+"' "
                       + " WHERE `id`='"+id+"' ");             
               loadAddress();
               reset();
               
                  }
 
           }
                     
        } catch (Exception e) {
         e.printStackTrace();
        }
           
        }
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
        int row = jTable1.getSelectedRow();
        
        if(row == -1){       
           
            JOptionPane.showMessageDialog(this, "Please Select row to Remove", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }else{
            
             
       try {
           
               String id = String.valueOf(jTable1.getValueAt(row,0));                             
               MySQL.executeIUD("DELETE FROM `employee_address` WHERE `id`='"+id+"'");  
               JOptionPane.showMessageDialog(this, "Address Removed Successfully!", "Inofrmation", JOptionPane.INFORMATION_MESSAGE);
               loadAddress();
               reset();
         
                     
        } catch (Exception e) {
         e.printStackTrace();
        }
           
        }
   
    }//GEN-LAST:event_jButton3ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
