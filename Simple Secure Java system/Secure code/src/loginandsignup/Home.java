package loginandsignup;

import java.awt.Desktop;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {
    String result;
    public Home() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        LogoutBtn1 = new javax.swing.JButton();
        ScholarBtn = new javax.swing.JButton();
        FacebookBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOME");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome Back");

        user.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        user.setForeground(new java.awt.Color(0, 51, 102));
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("John");

        ScholarBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ScholarBtn.setText("Access Scholar");
        ScholarBtn.setBackground(new java.awt.Color(0, 153, 153));
        ScholarBtn.setForeground(new java.awt.Color(255, 255, 255));
        ScholarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScholarBtnActionPerformed(evt);
            }
        });

        FacebookBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FacebookBtn.setText("Access Facebook");
        FacebookBtn.setBackground(new java.awt.Color(204, 0, 51));
        FacebookBtn.setForeground(new java.awt.Color(255, 255, 255));
        FacebookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacebookBtnActionPerformed(evt);
            }
        });

        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoutBtn.setText("Monitoring");
        LogoutBtn.setBackground(new java.awt.Color(102, 102, 255));
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        LogoutBtn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoutBtn1.setText("LOGOUT");
        LogoutBtn1.setBackground(new java.awt.Color(255, 102, 0));
        LogoutBtn1.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScholarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(FacebookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(LogoutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(user)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScholarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FacebookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(result);
        if(result.equals("admin")){
            monitoring LoginFrame = new monitoring();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "You're not allowed to access monitor app");
        }
    }
    
    

    private void LogoutBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        int confirmed = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            this.dispose();
            Login loginFrame = new Login(); 
            loginFrame.setVisible(true);
        }
    }
    


    private void ScholarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        accessWebsite("https://scholar.google.com/",result);
    }

    private void FacebookBtnActionPerformed(java.awt.event.ActionEvent evt) {
        accessWebsite("https://www.facebook.com/",result);
    }

    public String setUser(String name) {
        user.setText(name);
        String url = "jdbc:mysql://localhost:3306/java_users_database";
        String username = "root";
        String password = "";
        String query = "SELECT `role` FROM users WHERE `full_name` = ?";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = rs.getString("role");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }

        return result;
    }
    public static void accessWebsite(String site, String role) {
        if (isAllowedToAccess(site, role)) {
            try {
                URL url = new URL(site);
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(url.toURI());
                } else {
                    JOptionPane.showMessageDialog(null, "Desktop is not supported on this system.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error accessing site: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Access Denied for " + site);
        }
    }

    public static boolean isAllowedToAccess(String site, String role) {
        if (role.equals("admin")) {
            return true;
        }
        else {
            return site.equalsIgnoreCase("https://scholar.google.com/");
        }
    }

    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton LogoutBtn1;
    private javax.swing.JButton ScholarBtn;
    private javax.swing.JButton FacebookBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel user;
}
