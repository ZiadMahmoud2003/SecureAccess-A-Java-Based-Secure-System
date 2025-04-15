package loginandsignup;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class monitoring extends javax.swing.JFrame {

    public monitoring() {
        initComponents();
        setTitle("SignIn and SignUp Monitoring");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void runMonitorLogins() {
        try {
            // Fetch login data from the database
        List<String> loginDetails = getLoginDataFromDatabase();

            // Display data in output area
            output.append("=== User Login Information ===\n");
            if (loginDetails.isEmpty()) {
                output.append("No login activity recorded.\n");
            } else {
                for (String login : loginDetails) {
                    output.append(login + "\n");
                }
            }
            // Scroll the output area to the end after appending new data
            output.setCaretPosition(output.getDocument().getLength());
        } catch (Exception ex) {
            ex.printStackTrace();
            output.append("Error retrieving user login data.\n");
        }
    }
    // Method to fetch login data from the database
    private List<String> getLoginDataFromDatabase() throws Exception {
        List<String> loginData = new ArrayList<>();
        String dbURL = "jdbc:mysql://localhost:3306/java_users_database"; // Database URL
        String username = "root"; // Database username
        String password = ""; // Database password
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT full_name, login_time FROM users")) {
            
            while (rs.next()) {
                String user = rs.getString("full_name");
                String loginTime = rs.getString("login_time");
                loginData.add("User: " + user + ", Login Time: " + loginTime);
            }
        }
        return loginData;
    
    }

    // Get the PID of the running process using jps
    private String getPidFromJps() {
    try {
        Process process = Runtime.getRuntime().exec("jps");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        System.out.println("=== JPS Output ===");
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // Print each line of jps output
            if (line.contains("LoginAndSignUp")) { // Replace with your actual main class name
                return line.split(" ")[0]; // Extract and return the PID
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null; // If PID not found

    }
    /*private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jstack = new javax.swing.JButton();
        jmap = new javax.swing.JButton();
        jstat = new javax.swing.JButton();
        jstat1 = new javax.swing.JButton();
        backToLoginBtn = new javax.swing.JButton(); 

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        output.setBackground(new java.awt.Color(153, 255, 204));
        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jstack.setBackground(new java.awt.Color(0, 204, 204));
        jstack.setText("JSTACK");
        jstack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jstackActionPerformed(evt);
            }
        });

        jmap.setBackground(new java.awt.Color(0, 204, 204));
        jmap.setText("JMAP");
        jmap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmapActionPerformed(evt);
            }
        });

        jstat.setBackground(new java.awt.Color(0, 204, 204));
        jstat.setText("JSTAT");
        jstat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jstatActionPerformed(evt);
            }
        });

        jstat1.setBackground(new java.awt.Color(0, 204, 204));
        jstat1.setText("Users");
        jstat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jstat1ActionPerformed(evt);
            }
        });

        // Configure the Back to Login button
    backToLoginBtn.setBackground(new java.awt.Color(255, 102, 102));
    backToLoginBtn.setText("Back to Login");
    backToLoginBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            backToLoginBtnActionPerformed(evt);
        }
    });

//layout :

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmap, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jstack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jstat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)) // Added Button
                .addContainerGap(35, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jstack)
                    .addComponent(jmap))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jstat1)
                    .addComponent(jstat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backToLoginBtn) // Added Button
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
    );

    pack();
}*/



private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    output = new javax.swing.JTextArea();
    jstack = new javax.swing.JButton();
    jmap = new javax.swing.JButton();
    jstat = new javax.swing.JButton();
    jstat1 = new javax.swing.JButton();
    backToLoginBtn = new javax.swing.JButton(); // New Button for "Back to Login"

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(240, 248, 255)); // Light background color

    output.setBackground(new java.awt.Color(255, 255, 255)); // White background for output
    output.setColumns(20);
    output.setRows(5);
    output.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
    jScrollPane1.setViewportView(output);

    // Styling and Configuration for Buttons
    jstack.setText("JSTACK");
    jstack.setBackground(new java.awt.Color(0, 153, 204));
    jstack.setForeground(new java.awt.Color(255, 255, 255));
    jstack.setFocusPainted(false);
    jstack.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jstack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jstackActionPerformed(evt);
        }
    });

    jmap.setText("JMAP");
    jmap.setBackground(new java.awt.Color(0, 153, 204));
    jmap.setForeground(new java.awt.Color(255, 255, 255));
    jmap.setFocusPainted(false);
    jmap.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jmap.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jmapActionPerformed(evt);
        }
    });

    jstat.setText("JSTAT");
    jstat.setBackground(new java.awt.Color(0, 153, 204));
    jstat.setForeground(new java.awt.Color(255, 255, 255));
    jstat.setFocusPainted(false);
    jstat.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jstat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jstatActionPerformed(evt);
        }
    });

    jstat1.setText("Users");
    jstat1.setBackground(new java.awt.Color(0, 153, 204));
    jstat1.setForeground(new java.awt.Color(255, 255, 255));
    jstat1.setFocusPainted(false);
    jstat1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    jstat1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jstat1ActionPerformed(evt);
        }
    });

    // Styling for the "Back to Login" Button
    backToLoginBtn.setText("Back to Login");
    backToLoginBtn.setBackground(new java.awt.Color(255, 69, 58));
    backToLoginBtn.setForeground(new java.awt.Color(255, 255, 255));
    backToLoginBtn.setFocusPainted(false);
    backToLoginBtn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    backToLoginBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            backToLoginBtnActionPerformed(evt);
        }
    });

    // Layout Configuration
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50) // Left Padding
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jstat1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jmap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jstat, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jstack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addComponent(backToLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)) // Right Padding
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30) // Top Padding
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jmap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jstack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jstat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)) // Bottom Padding
    );

    pack();
}




    private void jmapActionPerformed(java.awt.event.ActionEvent evt) {
try {
        String pid = getPidFromJps();
        if (pid != null) {
            String command = "jhsdb jmap --heap --pid " + pid;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader stdOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            output.append("=== JMAP Output ===\n");
            while ((line = stdOutput.readLine()) != null) {
                output.append(line + "\n");
            }
            while ((line = stdError.readLine()) != null) {
                output.append("ERROR: " + line + "\n");
            }

            stdOutput.close();
            stdError.close();
        } else {
            output.append("PID not found for the running process.\n");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        output.append("Error running jmap command.\n");
    }


    }

    private void jstackActionPerformed(java.awt.event.ActionEvent evt) {
 try {
        String pid = getPidFromJps();
        if (pid != null) {
            Process process = Runtime.getRuntime().exec("jstack " + pid);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            output.append("=== JSTACK Output ===\n");
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            reader.close();
        } else {
            output.append("PID not found for the running process.\n");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        output.append("Error running jstack command.\n");
    }
    }

    private void jstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jstatActionPerformed
try {
        String pid = getPidFromJps();
        if (pid != null) {
            Process process = Runtime.getRuntime().exec("jstat -gc " + pid);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            output.append("=== JSTAT Output ===\n");
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            reader.close();
        } else {
            output.append("PID not found for the running process.\n");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        output.append("Error running jstat command.\n");
    }
    }

    private void jstat1ActionPerformed(java.awt.event.ActionEvent evt) {
        runMonitorLogins();
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(monitoring.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                new monitoring();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new monitoring().setVisible(true);
            }
        });
    }

    // Action listener for the Back to Login button
    private void backToLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {
    this.dispose(); // Close the monitoring window
    Login loginPage = new Login(); // Replace with your Login class
    loginPage.setVisible(true); // Open the Login page
}

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jmap;
    private javax.swing.JButton jstack;
    private javax.swing.JButton jstat;
    private javax.swing.JButton jstat1;
    private javax.swing.JTextArea output;
    private javax.swing.JButton backToLoginBtn;
}
