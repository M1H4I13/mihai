/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect_asigurari_bd2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import loader_tabele_asig.AngajatiLoader;
import loader_tabele_asig.BeneficiarLoader;
import tabele_asig.Angajati;
import tabele_asig.Beneficiar;

/**
 *
 * @author gingh
 */
public class Proiect_Asigurari_BD2 {

    static final String DB_URL = "jdbc:mysql://localhost:3306/asigurari";
    static final String USER = "root";
    static final String PASS = "";
    static final String QUERY = "SELECT * FROM angajati;";
    static final String QUERY1 = "SELECT * FROM beneficiar;";
    static String QUERY2 = "INSERT INTO ANGAJATI(cod_angajat, nume_angajat, prenume_angajaat, cod_functie_angajat, data_nastere_angajat, ) VALUES (115,'A',?,?,?,?,?,?,?)";
    
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        // afisare angajati
        try {
            conn = DriverManager.getConnection(DB_URL, USER, null);
            pstmt = conn.prepareStatement(QUERY);
            rs = pstmt.executeQuery();
            
            
            System.out.println("Conectare reusita \n");
            System.out.println("ANGAJATI: \n");
            
            while (rs.next()) {
                System.out.print("-cod angajat: " + rs.getInt("cod_angajat"));
                System.out.print(" | nume angajat: " + rs.getString("nume_angajat"));
                System.out.print(" | prenume angajat: " + rs.getString("prenume_angajat"));
                System.out.print(" | cod functie angajat: " + rs.getInt("cod_functie_angajat"));
                System.out.print(" | data nastere angajat: " + rs.getDate("data_nastere_angajat"));
                System.out.print(" | adresa angajat: " + rs.getString("adresa_angajat"));
                System.out.print(" | telefon angajat: " + rs.getString("telefon_angajat"));
                System.out.print(" | email angajat: " + rs.getString("email_angajat"));
                System.out.print(" | salariu angajat: " + rs.getFloat("salariu_angajat"));
                System.out.println("\n");
                
                
            }
            
        } catch (SQLException se) {
            
            System.out.println("Exceptie citire din BD");
            se.printStackTrace();
        } finally{
            System.out.println("\n  Finalizat cu succes !\n");
            rs.close();
            pstmt.close();
            conn.close();
        }
        
        
        //afisare beneficiari
        try {
            conn = DriverManager.getConnection(DB_URL, USER, null);
            pstmt = conn.prepareStatement(QUERY1);
            rs = pstmt.executeQuery();
            
            
            System.out.println("Conectare reusita \n");
            System.out.println("Beneficiari: \n");
            
            while (rs.next()) {
                System.out.print("-cod beneficiar: " + rs.getInt("cod_benef"));
                System.out.print(" | nume beneficiar " + rs.getString("nume_benef"));
                System.out.print(" | prenume beneficiar " + rs.getString("prenume_benef"));
                System.out.print(" | CNP beneficiar " + rs.getString("CNP_benef"));
                System.out.print(" | data nastere beneficiar " + rs.getDate("data_nastere_benef"));
                System.out.print(" | stare civila beneficiar " + rs.getString("stare_civila_benef"));
                System.out.print(" | adresa beneficiar " + rs.getString("adresa_benef"));
                System.out.print(" | telefon beneficiar " + rs.getString("telefon_benef"));
                System.out.println("\n");
                
            }
            
        } catch (SQLException se) {
            
            System.out.println("Exceptie citire din BD");
            se.printStackTrace();
        } finally{
            System.out.println("\n  Finalizat cu succes !\n");
            rs.close();
            pstmt.close();
            conn.close();
        }
        
         //insert angajati//////////////////
       
         //int cod_angajat, String nume_angajat, String prenume_angajat, int cond_functie_angajat, Date data_nastere_angajat, 
            //String adresa_angajat, String telefon_angajat, String email_angajat, float salariu_angajat
        // Angajati angajat = new Angajati(115, "A", "B", 111111, 1999-11-11, "str Dafinilor", "0123456789", "asdfg", 1234);
         
         

        //System.out.println(QUERY2);
    
        
        
        
        System.out.println("\n---------------------\n");
        
        //////////////////////////
        System.out.println("LISTA Angajati: \n");
        List<Angajati> listaangajati= new AngajatiLoader().load();
             for (int i = 0; i < listaangajati.size(); i++) {
		System.out.println("\t"+listaangajati.get(i).getCod_angajat()+" | "+listaangajati.get(i).getNume_angajat() + " | " + listaangajati.get(i).getPrenume_angajat() + " | " + listaangajati.get(i).getCond_functie_angajat()+ " | " + 
                        listaangajati.get(i).getData_nastere_angajat()+ " | " + listaangajati.get(i).getAdresa_angajat()+ " | " + listaangajati.get(i).getEmail_angajat()+ " | " + listaangajati.get(i).getSalariu_angajat());
            }

        System.out.println("\n LISTA Beneficiari: \n");
        List<Beneficiar> listabeneficiar= new BeneficiarLoader().load();
             for (int i = 0; i < listabeneficiar.size(); i++) {
		System.out.println("\t"+listabeneficiar.get(i).getCod_benef()+" "+listabeneficiar.get(i).getNume_benef()+" "+listabeneficiar.get(i).getPrenume_benef());
                
             }
    }
}


