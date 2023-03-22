/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proiect_asigurari_bd2.Connectare_BD;
import tabele_asig.Angajati;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author gingh
 */
public class AngajatiWindow extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    DefaultTableModel model = new DefaultTableModel();
    
    public AngajatiWindow() {
        initComponents();
    }
    
    
    public void loadTableAngajati() throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<Angajati> listaangajati = new AngajatiLoader().load();
        Object rowData[] = new Object[9];
        for (int i = 0; i < listaangajati.size(); i++) {
            rowData[0] = listaangajati.get(i).getCod_angajat();
            rowData[1] = listaangajati.get(i).getNume_angajat();
            rowData[2] = listaangajati.get(i).getPrenume_angajat();
            rowData[3] = listaangajati.get(i).getCond_functie_angajat();
            rowData[4] = listaangajati.get(i).getData_nastere_angajat();
            rowData[5] = listaangajati.get(i).getAdresa_angajat();
            rowData[6] = listaangajati.get(i).getTelefon_angajat();
            rowData[7] = listaangajati.get(i).getEmail_angajat();
            rowData[8] = listaangajati.get(i).getSalariu_angajat();
            model.addRow(rowData);
        }
    }
    
    
    public void adaugareAngajati() throws ClassNotFoundException, SQLException{
        //INSERT
        Angajati angajati = new Angajati(); 
        
        angajati.setCod_angajat(Integer.parseInt(jTextCod.getText()));
        angajati.setNume_angajat(jTextNume.getText());
        angajati.setPrenume_angajat(jTextPrenume.getText());
        angajati.setCond_functie_angajat(Integer.parseInt(jTextFunctie.getText()));
        angajati.setData_nastere_angajat(Date.valueOf(jTextDataNastere.getText()));
        angajati.setAdresa_angajat(jTextAdresa.getText());
        angajati.setTelefon_angajat(jTextTelefon.getText());
        angajati.setEmail_angajat(jTextEmail.getText());
        angajati.setSalariu_angajat(Integer.parseInt(jTextSalariu.getText()));
        
        AngajatiLoader.insertAngajati(angajati);
        loadTableAngajati();
        
    }
    
    public void stergereAngajati() throws ClassNotFoundException, SQLException{
        /////////////////////////////////////////////////////////
        //Angajati angajati = new Angajati(); 
        
        int a=Integer.parseInt(jTextCod.getText());
        AngajatiLoader.deleteAngajati(a);
        loadTableAngajati();
        
    }
    
   
    
    private void cleanActionPerformed() {
        
        jTextCod.setText("");
        jTextNume.setText("");
        jTextPrenume.setText("");
        jTextFunctie.setText("");
        jTextDataNastere.setText("");
        jTextAdresa.setText("");
        jTextTelefon.setText("");
        jTextEmail.setText("");
        jTextSalariu.setText("");
        
    }
    
    
    public void angajatiCrescator() throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<Angajati> listaangajati = new AngajatiLoader().loadAscendent();
        Object rowData[] = new Object[9];
        for (int i = 0; i < listaangajati.size(); i++) {
            rowData[0] = listaangajati.get(i).getCod_angajat();
            rowData[1] = listaangajati.get(i).getNume_angajat();
            rowData[2] = listaangajati.get(i).getPrenume_angajat();
            rowData[3] = listaangajati.get(i).getCond_functie_angajat();
            rowData[4] = listaangajati.get(i).getData_nastere_angajat();
            rowData[5] = listaangajati.get(i).getAdresa_angajat();
            rowData[6] = listaangajati.get(i).getTelefon_angajat();
            rowData[7] = listaangajati.get(i).getEmail_angajat();
            rowData[8] = listaangajati.get(i).getSalariu_angajat();
            model.addRow(rowData);
        }
    }
    
    public void angajatiDescrescator() throws ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<Angajati> listaangajati = new AngajatiLoader().loadDescendent();
        Object rowData[] = new Object[9];
        for (int i = 0; i < listaangajati.size(); i++) {
            rowData[0] = listaangajati.get(i).getCod_angajat();
            rowData[1] = listaangajati.get(i).getNume_angajat();
            rowData[2] = listaangajati.get(i).getPrenume_angajat();
            rowData[3] = listaangajati.get(i).getCond_functie_angajat();
            rowData[4] = listaangajati.get(i).getData_nastere_angajat();
            rowData[5] = listaangajati.get(i).getAdresa_angajat();
            rowData[6] = listaangajati.get(i).getTelefon_angajat();
            rowData[7] = listaangajati.get(i).getEmail_angajat();
            rowData[8] = listaangajati.get(i).getSalariu_angajat();
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
        jLabel10 = new javax.swing.JLabel();
        jTextNume = new javax.swing.JTextField();
        jTextPrenume = new javax.swing.JTextField();
        jTextFunctie = new javax.swing.JTextField();
        jTextDataNastere = new javax.swing.JTextField();
        jTextAdresa = new javax.swing.JTextField();
        jTextTelefon = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jTextSalariu = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clean = new javax.swing.JButton();
        jTextCod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        filtrareNume = new javax.swing.JCheckBox();
        filtrarePrenume = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        filtrareSalMin = new javax.swing.JCheckBox();
        filtrareSalMax = new javax.swing.JCheckBox();
        Export = new javax.swing.JButton();
        Export1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Afisare angajati");

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

        jButton1.setText("Afisare toti angajatii");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nume");

        jLabel4.setText("Prenume");

        jLabel5.setText("Functie");

        jLabel6.setText("Data nastere");

        jLabel7.setText("Adresa");

        jLabel8.setText("Telefon ");

        jLabel9.setText("E-mail");

        jLabel10.setText("Slariu");

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

        jTextFunctie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFunctieActionPerformed(evt);
            }
        });

        jTextDataNastere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDataNastereActionPerformed(evt);
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

        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jTextSalariu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSalariuActionPerformed(evt);
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

        jButton3.setText("Filtrare !");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Descrescator");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        filtrareNume.setBackground(new java.awt.Color(0, 0, 0));
        filtrareNume.setForeground(new java.awt.Color(255, 255, 255));
        filtrareNume.setText("Nume angajat");
        filtrareNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrareNumeActionPerformed(evt);
            }
        });

        filtrarePrenume.setBackground(new java.awt.Color(0, 0, 0));
        filtrarePrenume.setForeground(new java.awt.Color(255, 255, 255));
        filtrarePrenume.setText("Prenume angajat");
        filtrarePrenume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarePrenumeActionPerformed(evt);
            }
        });

        jButton5.setText("Crescator");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        filtrareSalMin.setBackground(new java.awt.Color(0, 0, 0));
        filtrareSalMin.setForeground(new java.awt.Color(255, 255, 255));
        filtrareSalMin.setText("Salariu minim");
        filtrareSalMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrareSalMinActionPerformed(evt);
            }
        });

        filtrareSalMax.setBackground(new java.awt.Color(0, 0, 0));
        filtrareSalMax.setForeground(new java.awt.Color(255, 255, 255));
        filtrareSalMax.setText("Salariu maxim");
        filtrareSalMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrareSalMaxActionPerformed(evt);
            }
        });

        Export.setText("Export PDF");
        Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportActionPerformed(evt);
            }
        });

        Export1.setText("Export EXCEL");
        Export1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Export1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextDataNastere, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update)
                    .addComponent(delete))
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtrareSalMin)
                            .addComponent(filtrareSalMax))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(filtrareNume))
                            .addComponent(filtrarePrenume))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFunctie, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(190, 190, 190)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextSalariu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addComponent(clean)
                                .addGap(137, 137, 137)
                                .addComponent(Export)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Export1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(50, 50, 50)
                                .addComponent(jTextNume, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton1)
                                .addGap(131, 131, 131)
                                .addComponent(jButton5)
                                .addGap(12, 12, 12)
                                .addComponent(jButton4)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
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
                    .addComponent(jTextNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
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
                        .addComponent(jTextFunctie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton3)))
                .addGap(12, 12, 12)
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
                        .addComponent(jTextAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(update)
                        .addGap(22, 22, 22)
                        .addComponent(delete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(filtrareSalMin)
                        .addGap(11, 11, 11)
                        .addComponent(filtrareSalMax)
                        .addGap(12, 12, 12)
                        .addComponent(filtrareNume)
                        .addGap(12, 12, 12)
                        .addComponent(filtrarePrenume)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextSalariu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clean)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Export)
                            .addComponent(Export1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //adaugare valori in tabel
        try {
            loadTableAngajati();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumeActionPerformed

    private void jTextPrenumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrenumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrenumeActionPerformed

    private void jTextFunctieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFunctieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFunctieActionPerformed

    private void jTextDataNastereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDataNastereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDataNastereActionPerformed

    private void jTextAdresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAdresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAdresaActionPerformed

    private void jTextTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailActionPerformed

    private void jTextSalariuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSalariuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSalariuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //INSERT
        try {
            adaugareAngajati();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            //DELETE

            stergereAngajati();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
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
                    pstmt = conn.prepareStatement("UPDATE angajati SET nume_angajat=?, prenume_angajat=?, cod_functie_angajat=?, data_nastere_angajat=?, "
                            + "adresa_angajat=?, telefon_angajat=?, email_angajat=?, salariu_angajat=? where cod_angajat=?;");
                
                        //pstmt.setInt(1, jTextCod.getText());
                        pstmt.setString(1,jTextNume.getText());
                        pstmt.setString(2, jTextPrenume.getText());
                        pstmt.setString(3, jTextFunctie.getText());
                        pstmt.setString(4, jTextDataNastere.getText());
                        pstmt.setString(5, jTextAdresa.getText());
                        pstmt.setString(6, jTextTelefon.getText());
                        pstmt.setString(7, jTextEmail.getText());
                        pstmt.setString(8, jTextSalariu.getText());
                        pstmt.setString(9, jTextCod.getText());
                        
                        pstmt.executeUpdate();
                        System.out.println("UPDATE cu succes");
                        
                }
            catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadTableAngajati();
            cleanActionPerformed();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //FILTRARE ELEMENTE
        
        if(filtrareSalMin.isSelected() && filtrareNume.isSelected() && filtrarePrenume.isSelected()){
            try{conn = Connectare_BD.getConnection();
                    pstmt = conn.prepareStatement("SELECT * from angajati where salariu<? and nume=? and prenume=?;");
                rs = pstmt.executeQuery();
                        pstmt.setString(1, jTextSalariu.getText());
                        pstmt.setString(2, jTextNume.getText());
                        pstmt.setString(3, jTextPrenume.getText());
                        model.setRowCount(0);
                Object[] columnData = new Object[8];
                while (rs.next()) {
                    columnData[0] = rs.getString("cod_angajat");
            columnData[1] = rs.getString("ume_angajat");
            columnData[2] = rs.getString("renume_angajat");
            columnData[3] = rs.getString("ond_functie_angajat");
            columnData[4] = rs.getString("ata_nastere_angajat");
            columnData[5] = rs.getString("dresa_angajat");
            columnData[6] = rs.getString("elefon_angajat");
            columnData[7] = rs.getString("mail_angajat");
            columnData[8] = rs.getString("alariu_angajat");
                    model.addRow(columnData);
                }
            
        }   catch (SQLException ex) {
                Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            loadTableAngajati();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            //descrescator

            angajatiDescrescator();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void filtrareNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrareNumeActionPerformed
        // 
    }//GEN-LAST:event_filtrareNumeActionPerformed

    private void filtrarePrenumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarePrenumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarePrenumeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            //Salariu crescator

            angajatiCrescator();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void filtrareSalMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrareSalMinActionPerformed
        if(filtrareSalMin.isSelected()){
            filtrareSalMax.setSelected(false);
            
        }
    }//GEN-LAST:event_filtrareSalMinActionPerformed

    private void filtrareSalMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrareSalMaxActionPerformed
        if(filtrareSalMax.isSelected()){
            filtrareSalMin.setSelected(false);
            
        }
    }//GEN-LAST:event_filtrareSalMaxActionPerformed

    private void ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportActionPerformed
        try {
            //EXPORT
            
            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(AngajatiWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_ExportActionPerformed

    private void Export1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Export1ActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
        //Choose Location For Saving Excel File
        String defaultCurrentDirectoryPath = "C:\\Users\\gingh\\OneDrive\\Desktop\\Proiect BD2";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Save As");
        //Filter only files with these extensions:
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Exportarea s-a efectuat cu succes!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.getProperties();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_Export1ActionPerformed

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
            java.util.logging.Logger.getLogger(AngajatiWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AngajatiWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AngajatiWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AngajatiWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AngajatiWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Export;
    private javax.swing.JButton Export1;
    private javax.swing.JButton clean;
    private javax.swing.JButton delete;
    private javax.swing.JCheckBox filtrareNume;
    private javax.swing.JCheckBox filtrarePrenume;
    private javax.swing.JCheckBox filtrareSalMax;
    private javax.swing.JCheckBox filtrareSalMin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jTextCod;
    private javax.swing.JTextField jTextDataNastere;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextFunctie;
    private javax.swing.JTextField jTextNume;
    private javax.swing.JTextField jTextPrenume;
    private javax.swing.JTextField jTextSalariu;
    private javax.swing.JTextField jTextTelefon;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    
}
