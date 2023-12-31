
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Issue_Book extends javax.swing.JFrame {

    /**
     * Creates new form Issue_Book
     */
    public Issue_Book() {
        initComponents();
        

    }
    
    public void getStdDetails() {
        int StdId = Integer.parseInt(text2.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from manage_std where Id=?");

            ps.setInt(1, StdId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                l1.setText(rs.getString("Id"));
                l2.setText(rs.getString("stdName"));
                l3.setText(rs.getString("stdNumber"));
                l4.setText(rs.getString("stdDepartment"));

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Student Id!!");
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
        }
    }

    public void getBookDetials() {
        
        int BookId = Integer.parseInt(text1.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
            PreparedStatement ps = con.prepareStatement("select * from manage_book where Id=?");

            ps.setInt(1, BookId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                l11.setText(rs.getString("Id"));
                l12.setText(rs.getString("BookName"));
                l13.setText(rs.getString("AuthorName"));
                l14.setText(rs.getString("Quantity"));

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Student Id!!");
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
        }
    }

    public Void UpdateBookCount(){
        int bookid = Integer.parseInt(text1.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
            String sql = ("UPDATE manage_book set Quantity = Quantity - 1 where Id = ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookid);
            ps.executeUpdate();
            
            int initialcount = Integer.parseInt(l14.getText());
            l14.setText(Integer.toString(initialcount - 1));
            JOptionPane.showMessageDialog(this, "Successfully");
                
            
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
        }
        return null;
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
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        l11 = new javax.swing.JLabel();
        l12 = new javax.swing.JLabel();
        l13 = new javax.swing.JLabel();
        l14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        text2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        IssueDate = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        DueDate = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Book Name");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Author Name");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Book Id");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel20.setBackground(new java.awt.Color(255, 0, 102));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Book Detail");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Back");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        l11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l11.setForeground(new java.awt.Color(255, 255, 255));
        l11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l11.setText("NULL");
        jPanel5.add(l11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        l12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l12.setForeground(new java.awt.Color(255, 255, 255));
        l12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l12.setText("NULL");
        jPanel5.add(l12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        l13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l13.setForeground(new java.awt.Color(255, 255, 255));
        l13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l13.setText("NULL");
        jPanel5.add(l13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        l14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l14.setForeground(new java.awt.Color(255, 255, 255));
        l14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l14.setText("NULL");
        jPanel5.add(l14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Quantity");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 680));

        jPanel6.setBackground(new java.awt.Color(255, 0, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Student Name");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Student Number");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Department");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, -1, -1));

        l4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l4.setForeground(new java.awt.Color(255, 255, 255));
        l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l4.setText("NULL");
        jPanel6.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, -1, -1));

        jLabel23.setBackground(new java.awt.Color(255, 0, 102));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Student Detail");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Studnet Id");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        l1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("NULL");
        jPanel6.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        l2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setText("NULL");
        jPanel6.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        l3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        l3.setForeground(new java.awt.Color(255, 255, 255));
        l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l3.setText("NULL");
        jPanel6.add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 440, 680));

        jPanel9.setBackground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 120, -1, -1));

        jLabel33.setBackground(new java.awt.Color(255, 51, 102));
        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 51, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Book Issue");
        jLabel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 60, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Book Id");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 160, -1, -1));

        text2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 51, 102)));
        text2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text2FocusLost(evt);
            }
        });
        text2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text2ActionPerformed(evt);
            }
        });
        jPanel1.add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 390, 40));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 51, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Issue Date");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, -1, -1));

        text1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 51, 102)));
        text1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text1FocusLost(evt);
            }
        });
        text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text1ActionPerformed(evt);
            }
        });
        jPanel1.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, 390, 40));

        IssueDate.setBackground(new java.awt.Color(255, 0, 102));
        IssueDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 430, 380, 40));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 51, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Student Id");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 280, -1, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 51, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Due Date");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 500, -1, -1));

        DueDate.setBackground(new java.awt.Color(255, 0, 102));
        DueDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 540, 380, 40));

        jButton3.setBackground(new java.awt.Color(255, 51, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton3.setText("Issue Book");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 610, 230, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        Home me = new Home();
        me.show();
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        UpdateBookCount();
        if (text1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Book Id!");
        } else if (text2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Student Id!");
        } else {
            
            try {
                String Id = text1.getText();
                String stdName = text2.getText();
                String stdNumber = l12.getText();
                String stdDepartment = l2.getText();

                java.util.Date issue = IssueDate.getDate();
                java.util.Date Due = DueDate.getDate();
//            Date due = (Date) DueDate.getDate();
//            java.sql.Date Dates = new java.sql.Date(due.getTime());

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
                PreparedStatement ps = con.prepareStatement("insert into issuebook (BookId,StdId,BookName,StdName,IssueDate,DueDate) values(?,?,?,?,?,?)");
                ps.setString(1, Id);
                ps.setString(2, stdName);
                ps.setString(3, stdNumber);
                ps.setString(4, stdDepartment);
                ps.setDate(5, new java.sql.Date(issue.getTime()));
                ps.setDate(6, new java.sql.Date(Due.getTime()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Issued Book Successfully!");
 
            } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            }
            
            try {
                String Id = text1.getText();
                String stdName = text2.getText();
                String stdNumber = l12.getText();
                String stdDepartment = l2.getText();

                java.util.Date issue = IssueDate.getDate();
                java.util.Date Due = DueDate.getDate();
//            Date due = (Date) DueDate.getDate();
//            java.sql.Date Dates = new java.sql.Date(due.getTime());

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
                PreparedStatement ps = con.prepareStatement("insert into issuedbooks (BookId,StdId,BookName,StdName,IssueDate,DueDate) values(?,?,?,?,?,?)");
                ps.setString(1, Id);
                ps.setString(2, stdName);
                ps.setString(3, stdNumber);
                ps.setString(4, stdDepartment);
                ps.setDate(5, new java.sql.Date(issue.getTime()));
                ps.setDate(6, new java.sql.Date(Due.getTime()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Issued Book Successfully!");

                l1.setText("");
                l2.setText("");
                l3.setText("");
                l4.setText("");

                l11.setText("");
                l12.setText("");
                l13.setText("");
                l14.setText("");

                text1.setText("");
                text2.setText("");
                IssueDate.setCalendar(null);
                DueDate.setCalendar(null);

            } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void text1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text1FocusLost
        // TODO add your handling code here:

        getBookDetials();
    }//GEN-LAST:event_text1FocusLost

    private void text2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text2FocusLost
        // TODO add your handling code here:
        getStdDetails();

    }//GEN-LAST:event_text2FocusLost

    private void text2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text2ActionPerformed

    private void text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text1ActionPerformed

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
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issue_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issue_Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DueDate;
    private com.toedter.calendar.JDateChooser IssueDate;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel l12;
    private javax.swing.JLabel l13;
    private javax.swing.JLabel l14;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    // End of variables declaration//GEN-END:variables
}
