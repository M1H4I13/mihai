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
public class Angajati {
    
    private int cod_angajat;
    private String nume_angajat;
    private String prenume_angajat;
    private int cond_functie_angajat;
    private Date data_nastere_angajat;
    private String adresa_angajat;
    private String telefon_angajat;
    private String email_angajat;
    private float salariu_angajat;

    public Angajati(int cod_angajat, String nume_angajat, String prenume_angajat, int cond_functie_angajat, Date data_nastere_angajat, 
            String adresa_angajat, String telefon_angajat, String email_angajat, float salariu_angajat) {
        this.cod_angajat = cod_angajat;
        this.nume_angajat = nume_angajat;
        this.prenume_angajat = prenume_angajat;
        this.cond_functie_angajat = cond_functie_angajat;
        this.data_nastere_angajat = data_nastere_angajat;
        this.adresa_angajat = adresa_angajat;
        this.telefon_angajat = telefon_angajat;
        this.email_angajat = email_angajat;
        this.salariu_angajat = salariu_angajat;
    }

    public Angajati() {
        
    }

    public int getCod_angajat() {
        return cod_angajat;
    }

    public void setCod_angajat(int cod_angajat) {
        this.cod_angajat = cod_angajat;
    }

    public String getNume_angajat() {
        return nume_angajat;
    }

    public void setNume_angajat(String nume_angajat) {
        this.nume_angajat = nume_angajat;
    }

    public String getPrenume_angajat() {
        return prenume_angajat;
    }

    public void setPrenume_angajat(String prenume_angajat) {
        this.prenume_angajat = prenume_angajat;
    }

    public int getCond_functie_angajat() {
        return cond_functie_angajat;
    }

    public void setCond_functie_angajat(int cond_functie_angajat) {
        this.cond_functie_angajat = cond_functie_angajat;
    }

    public Date getData_nastere_angajat() {
        return data_nastere_angajat;
    }

    public void setData_nastere_angajat(Date data_nastere_angajat) {
        this.data_nastere_angajat = data_nastere_angajat;
    }

    public String getAdresa_angajat() {
        return adresa_angajat;
    }

    public void setAdresa_angajat(String adresa_angajat) {
        this.adresa_angajat = adresa_angajat;
    }

    public String getTelefon_angajat() {
        return telefon_angajat;
    }

    public void setTelefon_angajat(String telefon_angajat) {
        this.telefon_angajat = telefon_angajat;
    }

    public String getEmail_angajat() {
        return email_angajat;
    }

    public void setEmail_angajat(String email_angajat) {
        this.email_angajat = email_angajat;
    }

    public float getSalariu_angajat() {
        return salariu_angajat;
    }

    public void setSalariu_angajat(float salariu_angajat) {
        this.salariu_angajat = salariu_angajat;
    }

    @Override
    public String toString() {
        return "Angajati{" + "cod_angajat=" + cod_angajat + ", nume_angajat=" + nume_angajat + ", prenume_angajat=" + prenume_angajat + 
                ", cond_functie_angajat=" + cond_functie_angajat + ", data_nastere_angajat=" + data_nastere_angajat + ", adresa_angajat=" + adresa_angajat + 
                ", telefon_angajat=" + telefon_angajat + ", email_angajat=" + email_angajat + ", salariu_angajat=" + salariu_angajat +"\n" + '}';
    }
    
    
    
    
    
}
