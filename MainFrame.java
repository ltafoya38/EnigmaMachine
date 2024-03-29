/***************************************************************
* File:  MainFrame.java
* Larry Tafoya  
* tafoya87513@gmail.com
* Inheritance, Polymorphism, Interfaces, Packages, and Enigma classes
****************************************************************/

package EnigmaMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame {
    
    //create array for enigma objects
    private EnigmaClass e[] = new EnigmaClass[3];
    
    //create subclass objects
    TexasEnigma te = new TexasEnigma();
    PrimeShiftEnigma pse = new PrimeShiftEnigma();
    ShiftyEnigma se = new ShiftyEnigma();
    
    //variables
    private String messageFromFile;
    private int keyFromFile;
    private int enigmaUsed;
    private boolean fileOpened = false;
    
    
    public MainFrame() {
        
        //initializes components to default values
        initComponents();
        
        //put enigma objects into array
        e[0] = te;
        e[1] = pse;
        e[2] = se;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jlblTitle = new javax.swing.JLabel();
        jrbRandomKey = new javax.swing.JRadioButton();
        jrbUserKey = new javax.swing.JRadioButton();
        jtfMessage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaCodedMessage = new javax.swing.JTextArea();
        jlblCodedMessageTitle = new javax.swing.JLabel();
        jbEncode = new javax.swing.JButton();
        jbDecode = new javax.swing.JButton();
        jbReset = new javax.swing.JButton();
        jtfEnterKey = new javax.swing.JTextField();
        jrbTexas = new javax.swing.JRadioButton();
        jrbPrimeShift = new javax.swing.JRadioButton();
        jrbShifty = new javax.swing.JRadioButton();
        jlblKey = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiOpenFile = new javax.swing.JMenuItem();
        jmiSaveFile = new javax.swing.JMenuItem();
        jmAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlblTitle.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jlblTitle.setForeground(new java.awt.Color(0, 0, 0));
        jlblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitle.setText("The Enigma Coding Machine");

        buttonGroup1.add(jrbRandomKey);
        jrbRandomKey.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jrbRandomKey.setForeground(new java.awt.Color(0, 0, 0));
        jrbRandomKey.setSelected(true);
        jrbRandomKey.setText("Use Random Key");

        buttonGroup1.add(jrbUserKey);
        jrbUserKey.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jrbUserKey.setForeground(new java.awt.Color(0, 0, 0));
        jrbUserKey.setText("Enter Key");

        jtfMessage.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jtfMessage.setForeground(new java.awt.Color(0, 0, 0));
        jtfMessage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMessage.setText("Enter Your Message Here");
        jtfMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfMessageMouseClicked(evt);
            }
        });

        jtaCodedMessage.setColumns(20);
        jtaCodedMessage.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jtaCodedMessage.setForeground(new java.awt.Color(0, 0, 0));
        jtaCodedMessage.setRows(5);
        jScrollPane1.setViewportView(jtaCodedMessage);

        jlblCodedMessageTitle.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jlblCodedMessageTitle.setForeground(new java.awt.Color(0, 0, 0));
        jlblCodedMessageTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblCodedMessageTitle.setText("Your Coded Message");

        jbEncode.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jbEncode.setForeground(new java.awt.Color(0, 0, 0));
        jbEncode.setText("Get Code");
        jbEncode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEncodeActionPerformed(evt);
            }
        });

        jbDecode.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jbDecode.setForeground(new java.awt.Color(0, 0, 0));
        jbDecode.setText("Decode");
        jbDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDecodeActionPerformed(evt);
            }
        });

        jbReset.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jbReset.setForeground(new java.awt.Color(0, 0, 0));
        jbReset.setText("Reset");
        jbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetActionPerformed(evt);
            }
        });

        jtfEnterKey.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jtfEnterKey.setForeground(new java.awt.Color(0, 0, 0));
        jtfEnterKey.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonGroup2.add(jrbTexas);
        jrbTexas.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jrbTexas.setForeground(new java.awt.Color(0, 0, 0));
        jrbTexas.setSelected(true);
        jrbTexas.setText("Texas Enigma");

        buttonGroup2.add(jrbPrimeShift);
        jrbPrimeShift.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jrbPrimeShift.setForeground(new java.awt.Color(0, 0, 0));
        jrbPrimeShift.setText("Prime Shift Enigma");

        buttonGroup2.add(jrbShifty);
        jrbShifty.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jrbShifty.setForeground(new java.awt.Color(0, 0, 0));
        jrbShifty.setText("Shifty Enigma");

        jlblKey.setFont(new java.awt.Font("Georgia", 1, 10)); // NOI18N
        jlblKey.setForeground(new java.awt.Color(0, 0, 0));
        jlblKey.setText("Key:");

        jmFile.setText("File");

        jmiOpenFile.setText("Open File");
        jmiOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenFileActionPerformed(evt);
            }
        });
        jmFile.add(jmiOpenFile);

        jmiSaveFile.setText("Save File");
        jmiSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveFileActionPerformed(evt);
            }
        });
        jmFile.add(jmiSaveFile);

        jMenuBar1.add(jmFile);

        jmAbout.setText("About Enigma");
        jmAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmAboutMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCodedMessageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbTexas)
                                    .addComponent(jrbPrimeShift)
                                    .addComponent(jrbShifty))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbRandomKey)
                                    .addComponent(jrbUserKey)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlblKey)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfEnterKey, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbEncode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDecode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbReset)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMessage)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbTexas)
                    .addComponent(jrbRandomKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPrimeShift)
                    .addComponent(jrbUserKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfEnterKey, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlblKey))
                    .addComponent(jrbShifty))
                .addGap(46, 46, 46)
                .addComponent(jtfMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jlblCodedMessageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEncode)
                    .addComponent(jbReset)
                    .addComponent(jbDecode))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    //event handler for get code button
    private void jbEncodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEncodeActionPerformed
        
        //get type of enigma user selected
        if(jrbTexas.isSelected()){
        
            enigmaUsed = 0;
        }        
        if(jrbPrimeShift.isSelected()){
        
            enigmaUsed = 1;
        }        
        if(jrbShifty.isSelected()){
        
            enigmaUsed = 2;
        }
        
        //check if user chose to use random key
        if(jrbRandomKey.isSelected()) {
            
            //set message into selected enigma object
            e[enigmaUsed].setMessage(jtfMessage.getText());
            
            //display coded message and key on ui
            jtaCodedMessage.setText(e[enigmaUsed].getCodedMessage());
            jtfEnterKey.setText(Integer.toString(e[enigmaUsed].getKey()));
        }
        
        //check if user chose to manually enter key
        if(jrbUserKey.isSelected()) {
            
            //use exception handling to ensure user enters a valid key
            try{
                
                //get key value from jtfEnterKey
                int key = Integer.parseInt(jtfEnterKey.getText());
  
                //ensure key is valid 1-50
                if(key > 0 && key < 51) {
                    
                    //set message and key into selected enigma object
                    e[enigmaUsed].setMessage(jtfMessage.getText(), key);
                    
                    //display coded message and key on ui
                    jtaCodedMessage.setText(e[enigmaUsed].getCodedMessage());
                    jtfEnterKey.setText(Integer.toString(e[enigmaUsed].getKey()));
                }
                //give user message that key is outside valid range
                else {
                    
                    JOptionPane.showMessageDialog(null, "Key Must Be 1 - 50");
                }
                
            }
            //use catch(NumberFormatException) to ensure ints are only entered
            catch(NumberFormatException e) {
                
                JOptionPane.showMessageDialog(null, "Enter Integers Only");
            }
        }     
    }//GEN-LAST:event_jbEncodeActionPerformed

    private void jtfMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfMessageMouseClicked
        
        //sets text to "" when box is clicked
        jtfMessage.setText("");
    }//GEN-LAST:event_jtfMessageMouseClicked

    private void jbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetActionPerformed
        
        //reset button resets all text boxs
        jtfEnterKey.setText("");
        jtfMessage.setText("Enter Your Message Here");
        jtaCodedMessage.setText("");
        jrbTexas.doClick();
        jrbRandomKey.doClick();
    }//GEN-LAST:event_jbResetActionPerformed

    private void jmiSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveFileActionPerformed
        
        //get enigma used from radio buttons
        if(jrbTexas.isSelected()){
        
            enigmaUsed = 0;
        }     
        if(jrbPrimeShift.isSelected()){
        
            enigmaUsed = 1;
        }        
        if(jrbShifty.isSelected()){
        
            enigmaUsed = 2;
        }
    
        //save file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int iSaveOrCancel = fileChooser.showSaveDialog(this);
        if(iSaveOrCancel == JFileChooser.APPROVE_OPTION) {
            try {
        
                File file = fileChooser.getSelectedFile();
                e[enigmaUsed].writeFile(file);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jmiSaveFileActionPerformed

    private void jmiOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenFileActionPerformed
        
        //open file for decode
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open A File to be Decoded");       
        fileChooser.setCurrentDirectory(new java.io.File("."));
        String filename = "";
        int status = fileChooser.showOpenDialog(null);
        if(status == JFileChooser.APPROVE_OPTION) {
            try {                            
                File selectedFile = fileChooser.getSelectedFile();
                filename = selectedFile.getPath();
                File myFile = new File(filename);
                Scanner inputFile = new Scanner(myFile);               
               
                //get input from file
                messageFromFile = inputFile.nextLine();
                keyFromFile = inputFile.nextInt();
                enigmaUsed = inputFile.nextInt();
                
                //use boolean to prevent exception for decode butto
                fileOpened = true;
               
                //close file
                inputFile.close();
              
            } catch (FileNotFoundException ex) {
                   JOptionPane.showMessageDialog(this, "The selected file, " + filename + " was not found. Try again.",
                "FileNotFoundException", JOptionPane.WARNING_MESSAGE);
                }
        }
    }//GEN-LAST:event_jmiOpenFileActionPerformed

    private void jbDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDecodeActionPerformed
        
        //use if to ensure file is opened
        if(fileOpened) {

            //set coded message to be decoded
            e[enigmaUsed].setCodedMessage(messageFromFile, keyFromFile);
        
            //display message and key on ui
            jtaCodedMessage.setText(e[enigmaUsed].getDecodedMessage());
            jtfEnterKey.setText(Integer.toString(e[enigmaUsed].getKey()));
            
            //set fileOpen to false for next use
            fileOpened = false;
        }
        else {
             JOptionPane.showMessageDialog(null, "File Has Not Been Opened!");
        }  
    }//GEN-LAST:event_jbDecodeActionPerformed

    private void jmAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmAboutMouseClicked
        
        //jOption panes for About menu button
         String message1 = "To Encode a Message: " + "\n1. Choose Random Key or Manual Key (1-50)"
                + "\n2. Enter Message" + "\n3. Click Get Code" + "\n4. You May Save by "
                + "Clicking File ==> Save";
        String message2 = "To Decode a Message: " + "\n1. Click File ==> Open File" + 
                "\n2. Select File to Decode" + "\n3. Click Decode";
        
        //show instructions on ui
        JOptionPane.showMessageDialog(null, message1);
        JOptionPane.showMessageDialog(null, message2);
    }//GEN-LAST:event_jmAboutMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
           
            public void run() {
                new MainFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDecode;
    private javax.swing.JButton jbEncode;
    private javax.swing.JButton jbReset;
    private javax.swing.JLabel jlblCodedMessageTitle;
    private javax.swing.JLabel jlblKey;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JMenu jmAbout;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuItem jmiOpenFile;
    private javax.swing.JMenuItem jmiSaveFile;
    private javax.swing.JRadioButton jrbPrimeShift;
    private javax.swing.JRadioButton jrbRandomKey;
    private javax.swing.JRadioButton jrbShifty;
    private javax.swing.JRadioButton jrbTexas;
    private javax.swing.JRadioButton jrbUserKey;
    private javax.swing.JTextArea jtaCodedMessage;
    private javax.swing.JTextField jtfEnterKey;
    private javax.swing.JTextField jtfMessage;
    // End of variables declaration//GEN-END:variables
}
