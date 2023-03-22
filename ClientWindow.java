/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import com.mysql.cj.xdevapi.Client;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import loader_tabele_asig.AngajatiLoader;
import loader_tabele_asig.BeneficiarLoader;
import loader_tabele_asig.ClientiLoader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proiect_asigurari_bd2.Connectare_BD;
import tabele_asig.Angajati;
import tabele_asig.Beneficiar;
import tabele_asig.Clienti;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author gingh
 */
public class ClientWindow extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    DefaultTableModel model = new DefaultTableModel();
    
    public ClientWindow() {
        initComponents();
    }
    
    
    public void loadTableClient() throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<Clienti> listaclient = new ClientiLoader().load();
        Object rowData[] = new Object[8];
        for (int i = 0; i < listaclient.size(); i++) {
            rowData[0] = listaclient.get(i).getCod_client();
            rowData[1] = listaclient.get(i).getNume_client();
            rowData[2] = listaclient.get(i).getPrenume_client();
            rowData[3] = listaclient.get(i).getCNP_client();
            rowData[4] = listaclient.get(i).getData_nastere_client();
            rowData[5] = listaclient.get(i).getStare_civila_client();
            rowData[6] = listaclient.get(i).getAdresa_client();
            rowData[7] = listaclient.get(i).getTelefon_client();
            model.addRow(rowData);
        }
    }
    
    
    public void adaugareClient() throws ClassNotFoundException, SQLException{
        //INSERT
        Clienti client = new Clienti(); 
        
        client.setCod_client(Integer.parseInt(jTextCod.getText()));
        client.setNume_client(jTextNume.getText());
        client.setPrenume_client(jTextPrenume.getText());
        client.setCNP_client(jTextCNP.getText());
        client.setData_nastere_client(Date.valueOf(jTextDataNastere.getText()));
        client.setStare_civila_client(jTextStare.getText());
        client.setAdresa_client(jTextAdresa.getText());
        client.setTelefon_client(jTextTelefon.getText());
        
        ClientiLoader.insertClient(client);
        loadTableClient();
        
    }
    
    public void stergereClient() throws ClassNotFoundException, SQLException{
        /////////////////////////////////////////////////////////
        //Angajati angajati = new Angajati(); 
        
        int a=Integer.parseInt(jTextCod.getText());
        ClientiLoader.deleteClient(a);
        loadTableClient();
        
    }
    
   
    
    private void cleanActionPerformed() {
        
        jTextCod.setText("");
        jTextNume.setText("");
        jTextPrenume.setText("");
        jTextCNP.setText("");
        jTextDataNastere.setText("");
        jTextStare.setText("");
        jTextAdresa.setText("");
        jTextTelefon.setText("");
        
    }
    
    
    public void angajatiCrescator() throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<Clienti> listaclient = new ClientiLoader().loadAscendent();
        Object rowData[] = new Object[8];
        for (int i = 0; i < listaclient.size(); i++) {
            rowData[0] = listaclient.get(i).getCod_client();
            rowData[1] = listaclient.get(i).getNume_client();
            rowData[2] = listaclient.get(i).getPrenume_client();
            rowData[3] = listaclient.get(i).getCNP_client();
            rowData[4] = listaclient.get(i).getData_nastere_client();
            rowData[5] = listaclient.get(i).getStare_civila_client();
            rowData[6] = listaclient.get(i).getAdresa_client();
            rowData[7] = listaclient.get(i).getTelefon_client();
            model.addRow(rowData);
        }
    }
    
    public void angajatiDescrescator() throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<Clienti> listaclient = new ClientiLoader().loadDescendent();
        Object rowData[] = new Object[8];
        for (int i = 0; i < listaclient.size(); i++) {
            rowData[0] = listaclient.get(i).getCod_client();
            rowData[1] = listaclient.get(i).getNume_client();
            rowData[2] = listaclient.get(i).getPrenume_client();
            rowData[3] = listaclient.get(i).getCNP_client();
            rowData[4] = listaclient.get(i).getData_nastere_client();
            rowData[5] = listaclient.get(i).getStare_civila_client();
            rowData[6] = listaclient.get(i).getAdresa_client();
            rowData[7] = listaclient.get(i).getTelefon_client();
            model.addRow(rowData);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextNume = new javax.swing.JTextField();
        jTextPrenume = new javax.swing.JTextField();
        jTextCNP = new javax.swing.JTextField();
        jTextDataNastere = new javax.swing.JTextField();
        jTextStare = new javax.swing.JTextField();
        jTextAdresa = new javax.swing.JTextField();
        jTextTelefon = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clean = new javax.swing.JButton();
        jTextCod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Export = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Afisare Client");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nume", "Prenume", "Functie", "Data nastere", "Adresa", "Telefon", "E-mail", "Salariu"
            }
        ));
        jTable1.setSize(100,90);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Afisare toti clientii");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nume");

        jLabel4.setText("Prenume");

        jLabel5.setText("CNP");

        jLabel6.setText("Data nastere");

        jLabel7.setText("Stare civila");

        jLabel8.setText("Adresa");

        jLabel9.setText("telefon");

        jTextNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumeActionPerformed(evt);
            }
        });

        jTextPrenume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrenumeActionPerformed(evt);
            }
        });

        jTextCNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCNPActionPerformed(evt);
            }
        });

        jTextDataNastere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDataNastereActionPerformed(evt);
            }
        });

        jTextStare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStareActionPerformed(evt);
            }
        });

        jTextAdresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAdresaActionPerformed(evt);
            }
        });

        jTextTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTelefonActionPerformed(evt);
            }
        });

        jButton2.setText("Adauga");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        delete.setText("Stergere");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clean.setText("Curata campuri");
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });

        jTextCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodActionPerformed(evt);
            }
        });

        jLabel11.setText("Cod");

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel12.setText("Sortaredupa salariu");

        jButton4.setText("Descrescator");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Crescator");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Export.setText("Export PDF");
        Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(jTextNume, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(26, 26, 26)
                        .addComponent(jButton4))
                    .addComponent(Export))
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11)
                        .addGap(61, 61, 61)
                        .addComponent(jTextCod, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(329, 329, 329)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextDataNastere, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextStare, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(47, 47, 47)
                                    .addComponent(jTextTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextCNP, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(45, 45, 45)
                        .addComponent(clean)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(update)
                                .addGap(22, 22, 22)
                                .addComponent(delete)
                                .addGap(27, 27, 27)
                                .addComponent(clean))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel7)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextDataNastere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Export)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextStare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jTextAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jTextTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton4)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //adaugare valori in tabel
        try {
            loadTableClient();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumeActionPerformed

    private void jTextPrenumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrenumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrenumeActionPerformed

    private void jTextCNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCNPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCNPActionPerformed

    private void jTextDataNastereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDataNastereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDataNastereActionPerformed

    private void jTextStareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextStareActionPerformed

    private void jTextAdresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAdresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAdresaActionPerformed

    private void jTextTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //INSERT
        try {
            loadTableClient();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       
        try {
            //DELETE

            stergereClient();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        //CLEAN
        
        cleanActionPerformed();
        
    }//GEN-LAST:event_cleanActionPerformed

    private void jTextCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        try{conn = Connectare_BD.getConnection();
                    pstmt = conn.prepareStatement("UPDATE client SET nume_client=?, prenume_client=?, CNP_client=?, data_nastere_client=?, "
                            + "stare_civila_client=?, adresa_client=?, telefon_client=? where cod_client=?;");
                
                        //pstmt.setInt(1, jTextCod.getText());
                        pstmt.setString(1,jTextNume.getText());
                        pstmt.setString(2, jTextPrenume.getText());
                        pstmt.setString(3, jTextCNP.getText());
                        pstmt.setString(4, jTextDataNastere.getText());
                        pstmt.setString(5, jTextStare.getText());
                        pstmt.setString(6, jTextAdresa.getText());
                        pstmt.setString(7, jTextTelefon.getText());
                        pstmt.setString(9, jTextCod.getText());
                        
                        pstmt.executeUpdate();
                        System.out.println("UPDATE cu succes");
                        
                }
            catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadTableClient();
            cleanActionPerformed();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            //descrescator

            angajatiDescrescator();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            //Salariu crescator

            angajatiCrescator();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportActionPerformed
        try {
            //EXPORT
            
            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ClientWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_ExportActionPerformed

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
            java.util.logging.Logger.getLogger(ClientWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Export;
    private javax.swing.JButton clean;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAdresa;
    private javax.swing.JTextField jTextCNP;
    private javax.swing.JTextField jTextCod;
    private javax.swing.JTextField jTextDataNastere;
    private javax.swing.JTextField jTextNume;
    private javax.swing.JTextField jTextPrenume;
    private javax.swing.JTextField jTextStare;
    private javax.swing.JTextField jTextTelefon;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    
}
