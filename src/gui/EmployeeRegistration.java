
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Avishka
 */
public class EmployeeRegistration extends javax.swing.JFrame {

    private static HashMap<String,String> employeeTypeMap = new HashMap<>();
    private static HashMap<String,String> employeeGenderMap = new HashMap<>();
  
    
   
    public EmployeeRegistration() {
        initComponents();
        loadTypes();
        loadEmployeeGenders();
        loadEmployees();
    }
    
    private void loadTypes(){
        
        try {
            
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee_type`");
            
            Vector<String> vector = new Vector<>();
            vector.add("Select");
            
            while(resultSet.next()){
                vector.add(resultSet.getString("name"));  
                employeeTypeMap.put(resultSet.getString("name") , resultSet.getString("id"));
          
            }
            
            DefaultComboBoxModel  model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);
                               
        } catch (Exception e) {
         e.printStackTrace();
        }
         
    }
    
  
    
    private void loadEmployeeGenders(){
        
          try {
            
            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `gender`");
            
            Vector<String> vector = new Vector<>();
            vector.add("Select");
            
            while(resultSet.next()){
                vector.add(resultSet.getString("name"));  
                employeeGenderMap.put(resultSet.getString("name") , resultSet.getString("id"));
          
            }
            
            DefaultComboBoxModel  model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);
                               
        } catch (Exception e) {
         e.printStackTrace();
        }
              
    }
    
    private void loadEmployees(){
        
        try {
        
        ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee` INNER JOIN `employee_type` ON `employee`.`employee_type_id`= `employee_type`.`id`"
                                                  + "  INNER JOIN `gender` ON `employee`.`gender_id` = `gender`.`id` ");
                
            DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
            tableModel.setRowCount(0);
            
         while(resultSet.next()){
             
             Vector<String> vector =  new Vector<>();
             vector.add(resultSet.getString("email"));
             vector.add(resultSet.getString("first_name"));
             vector.add(resultSet.getString("last_name"));
             vector.add(resultSet.getString("nic"));
             vector.add(resultSet.getString("mobile"));
             vector.add(resultSet.getString("password"));
             vector.add(resultSet.getString("gender.name"));
             vector.add(resultSet.getString("employee_type.name"));
             
             tableModel.addRow(vector);                 
         }
                  
        } catch (Exception e) {
         e.printStackTrace();
        }
             
    }
    
     private void clearField(){
         
         jTextField1.setText("");
         jTextField2.setText("");
         jTextField3.setText("");
         jTextField4.setText("");
         jTextField5.setText("");
         jTextField6.setText("");
         jPasswordField1.setText("");
         jComboBox1.setSelectedIndex(0);
         jComboBox2.setSelectedIndex(0);
         
         jTextField2.setEditable(true);
                               
     }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Registration");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "E-Mail", "First Name", "Last Name", "NIC", "Mobile", "Password", "Gender", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Gotham", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Employee Registration");

        jLabel2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel2.setText("E-Mail");

        jLabel3.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel5.setText("NIC");

        jLabel6.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel6.setText("Mobile");

        jLabel7.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel7.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel9.setText("Type");

        jTextField2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jTextField3.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jTextField4.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jTextField5.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jTextField6.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(53, 53, 53)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(24, 24, 24)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(26, 26, 26)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(68, 68, 68)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(50, 50, 50)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(59, 59, 59)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPasswordField1))))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel3))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel4))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel6))
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel7))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9))
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(6, 6, 6)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
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
                          
        String email = jTextField2.getText(); 
        String firstname = jTextField3.getText(); 
        String lastname = jTextField4.getText(); 
        String nic = jTextField5.getText(); 
        String mobile = jTextField6.getText(); 
        String password = String.valueOf(jPasswordField1.getPassword());
        
      String gender = String.valueOf(jComboBox1.getSelectedItem());
      String type = String.valueOf(jComboBox2.getSelectedItem());
            
             if(email.isEmpty()){
                    JOptionPane.showMessageDialog(this, "E-Mail Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")){ 
   
                JOptionPane.showMessageDialog(this, "Invalid E-mail !", "Warning", JOptionPane.WARNING_MESSAGE);
         
            }else if(firstname.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Fisrt Name Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(lastname.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Last Name Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(nic.isEmpty()){
                    JOptionPane.showMessageDialog(this, "NIC Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(!nic.matches("^[0-9]{12}$")){
                    JOptionPane.showMessageDialog(this, "Inavlid NIC!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(mobile.isEmpty()){
                  JOptionPane.showMessageDialog(this, "Mobile Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
         
            }else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")){
                 JOptionPane.showMessageDialog(this, "Mobile Is Invalid!", "Warning", JOptionPane.WARNING_MESSAGE);
                 
            }else if(password.isEmpty()){
                  JOptionPane.showMessageDialog(this, "Password Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                  
            }else if(!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$" )) {
                 JOptionPane.showMessageDialog(this, "Password Should be Minimum eight characters, at least one letter and one number!", "Warning", JOptionPane.WARNING_MESSAGE);
                 
            }else if(gender.equals("Select")){
                  JOptionPane.showMessageDialog(this, "Select Gender!", "Warning", JOptionPane.WARNING_MESSAGE);
            
            }else if(type.equals("Select")){
                   JOptionPane.showMessageDialog(this, "Select Type!", "Warning", JOptionPane.WARNING_MESSAGE);
                   
            }else {
                
              ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee` WHERE `email`='"+email+"' OR `nic`='"+nic+"' OR `mobile`='"+mobile+"' ");
                
            if(resultSet.next()){
                
                 JOptionPane.showMessageDialog(this, "Already Registered !", "Warning", JOptionPane.WARNING_MESSAGE);
                    
                      
            }else {
                
                 Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.format(date);
                
                MySQL.executeIUD(" INSERT INTO `employee` (`email`,`password`,`first_name`,`last_name`,`nic`,`mobile`,`date_registered`"
                        + ",`employee_type_id`, `gender_id` ) VALUES ('"+email+"','"+password+"','"+firstname+"','"+lastname+"',"
                                + "'"+nic+"','"+mobile+"','"+sdf.format(date)+"','"+employeeTypeMap.get(type)+"','"+employeeGenderMap.get(gender)+"') ");
                loadEmployees();
                clearField();                             
            } 
                
            }
      
                                          
        } catch (Exception e) {
         e.printStackTrace();
        }
      
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
       jTable1.clearSelection();
       clearField();
       jTextField2.setEditable(true);
       jButton1.setEnabled(true);
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        jButton1.setEnabled(false);
        
        int row = jTable1.getSelectedRow();
        
     String email = String.valueOf( jTable1.getValueAt(row, 0));
     String fname =String.valueOf(  jTable1.getValueAt(row,1));
     String lname = String.valueOf(jTable1.getValueAt(row, 2));
     String nic = String.valueOf(jTable1.getValueAt(row, 3));
     String mobile = String.valueOf(jTable1.getValueAt(row, 4));
     String password = String.valueOf(jTable1.getValueAt(row, 5));
     String gender = String.valueOf(jTable1.getValueAt(row, 6));
     String type = String.valueOf(jTable1.getValueAt(row, 7));
     
         jTextField2.setText(email);
         jTextField2.setEditable(false);
         
         jTextField3.setText(fname);
         jTextField4.setText(lname);
         jTextField5.setText(nic);
         jTextField6.setText(mobile);
         jPasswordField1.setText(password);
        
         jComboBox1.setSelectedItem(gender);
         jComboBox2.setSelectedItem(type);
         
         if(evt.getClickCount()==2){
             
             int row1 = jTable1.getSelectedRow();
             String email1 = String.valueOf(jTable1.getValueAt(row1,0));
             
             AddressView addressView = new AddressView(this,true,email1);
             addressView.setVisible(true);
         }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        try {
          
        String email = jTextField2.getText(); 
        String firstname = jTextField3.getText(); 
        String lastname = jTextField4.getText(); 
        String nic = jTextField5.getText(); 
        String mobile = jTextField6.getText(); 
        String password = String.valueOf(jPasswordField1.getPassword());
        
      String gender = String.valueOf(jComboBox1.getSelectedItem());
      String type = String.valueOf(jComboBox2.getSelectedItem());
      
            if(firstname.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Fisrt Name Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(lastname.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Last Name Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(nic.isEmpty()){
                    JOptionPane.showMessageDialog(this, "NIC Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(!nic.matches("^[0-9]{12}$")){
                    JOptionPane.showMessageDialog(this, "Inavlid NIC!", "Warning", JOptionPane.WARNING_MESSAGE);
             
            }else if(mobile.isEmpty()){
                  JOptionPane.showMessageDialog(this, "Mobile Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
         
            }else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")){
                 JOptionPane.showMessageDialog(this, "Mobile Is Invalid!", "Warning", JOptionPane.WARNING_MESSAGE);
                 
            }else if(password.isEmpty()){
                  JOptionPane.showMessageDialog(this, "Password Is Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                  
            }else if(!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$" )) {
                 JOptionPane.showMessageDialog(this, "Password Should be Minimum eight characters, at least one letter and one number!", "Warning", JOptionPane.WARNING_MESSAGE);
                 
            }else if(gender.equals("Select")){
                  JOptionPane.showMessageDialog(this, "Select Gender!", "Warning", JOptionPane.WARNING_MESSAGE);
            
            }else if(type.equals("Select")){
                   JOptionPane.showMessageDialog(this, "Select Type!", "Warning", JOptionPane.WARNING_MESSAGE);
                   
            }else {
                
               ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee` WHERE `nic`='"+nic+"' OR `mobile`='"+mobile+"' ");
               
               boolean canUpdate = false;
               
              if(resultSet.next()){
                                   
                  if(!resultSet.getString("email").equals(email)){
                         JOptionPane.showMessageDialog(this, "This Mobile Number or NIC Already Used !", "Warning", JOptionPane.WARNING_MESSAGE);
                  }else{
                     canUpdate = true;
                  }
                                   
              }else{
                   canUpdate = true;                                 
              }
              
              if(canUpdate){
                  
                  MySQL.executeIUD("UPDATE `employee` SET `password`='"+password+"', `first_name`='"+firstname+"', `last_name`='"+lastname+"', `nic` ='"+nic+"', "
                          + "`mobile`='"+mobile+"', `employee_type_id`='"+employeeTypeMap.get(type)+"', `gender_id`='"+employeeGenderMap.get(gender)+"'"
                          + " WHERE `email`='"+email+"' ");
                  
                  loadEmployees();
                  clearField();
                                  
              }
                                             
            }
               
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
