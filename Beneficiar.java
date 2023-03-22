/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele_asig;

import java.sql.Date;

/**
 *
 * @author gingh
 */
public class Beneficiar {
    
    private int cod_benef;
    private String nume_benef;
    private String prenume_benef;
    private String CNP_benef;
    private Date data_nastere_benef;
    private String stare_civila_benef;
    private String adresa_benef;
    private String telefon_benef;

    public Beneficiar(int cod_benef, String nume_benef, String prenume_benef, String CNP_benef, Date data_nastere_benef, String stare_civila_benef, String adresa_benef, String telefon_benef) {
        this.cod_benef = cod_benef;
        this.nume_benef = nume_benef;
        this.prenume_benef = prenume_benef;
        this.CNP_benef = CNP_benef;
        this.data_nastere_benef = data_nastere_benef;
        this.stare_civila_benef = stare_civila_benef;
        this.adresa_benef = adresa_benef;
        this.telefon_benef = telefon_benef;
    }

    public Beneficiar() {
    }
    
    

    public int getCod_benef() {
        return cod_benef;
    }

    public void setCod_benef(int cod_benef) {
        this.cod_benef = cod_benef;
    }

    public String getNume_benef() {
        return nume_benef;
    }

    public void setNume_benef(String nume_benef) {
        this.nume_benef = nume_benef;
    }

    public String getPrenume_benef() {
        return prenume_benef;
    }

    public void setPrenume_benef(String prenume_benef) {
        this.prenume_benef = prenume_benef;
    }

    public String getCNP_benef() {
        return CNP_benef;
    }

    public void setCNP_benef(String CNP_benef) {
        this.CNP_benef = CNP_benef;
    }

    public Date getData_nastere_benef() {
        return data_nastere_benef;
    }

    public void setData_nastere_benef(Date data_nastere_benef) {
        this.data_nastere_benef = data_nastere_benef;
    }

    public String getStare_civila_benef() {
        return stare_civila_benef;
    }

    public void setStare_civila_benef(String stare_civila_benef) {
        this.stare_civila_benef = stare_civila_benef;
    }

    public String getAdresa_benef() {
        return adresa_benef;
    }

    public void setAdresa_benef(String adresa_benef) {
        this.adresa_benef = adresa_benef;
    }

    public String getTelefon_benef() {
        return telefon_benef;
    }

    public void setTelefon_benef(String telefon_benef) {
        this.telefon_benef = telefon_benef;
    }

    @Override
    public String toString() {
        return "Beneficiar{" + "cod_benef=" + cod_benef + ", nume_benef=" + nume_benef + ", prenume_benef=" + prenume_benef + ", CNP_benef=" + CNP_benef + ", data_nastere_benef=" + data_nastere_benef + ", stare_civila_benef=" + stare_civila_benef + ", adresa_benef=" + adresa_benef + ", telefon_benef=" + telefon_benef + '}';
    }
    
    
    
    
    
}
