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
public class Clienti {
    
    private int cod_client;
    private String nume_client;
    private String prenume_client;
    private String CNP_client;
    private Date data_nastere_client;
    private String stare_civila_client;
    private String adresa_client;
    private String telefon_client;

    public Clienti(int cod_client, String nume_client, String prenume_client, String CNP_client, Date data_nastere_client, String stare_civila_client, String adresa_client, String telefon_client) {
        this.cod_client = cod_client;
        this.nume_client = nume_client;
        this.prenume_client = prenume_client;
        this.CNP_client = CNP_client;
        this.data_nastere_client = data_nastere_client;
        this.stare_civila_client = stare_civila_client;
        this.adresa_client = adresa_client;
        this.telefon_client = telefon_client;
    }

    public Clienti() {
    }

    public int getCod_client() {
        return cod_client;
    }

    public void setCod_client(int cod_client) {
        this.cod_client = cod_client;
    }

    public String getNume_client() {
        return nume_client;
    }

    public void setNume_client(String nume_client) {
        this.nume_client = nume_client;
    }

    public String getPrenume_client() {
        return prenume_client;
    }

    public void setPrenume_client(String prenume_client) {
        this.prenume_client = prenume_client;
    }

    public String getCNP_client() {
        return CNP_client;
    }

    public void setCNP_client(String CNP_client) {
        this.CNP_client = CNP_client;
    }

    public Date getData_nastere_client() {
        return data_nastere_client;
    }

    public void setData_nastere_client(Date data_nastere_client) {
        this.data_nastere_client = data_nastere_client;
    }

    public String getStare_civila_client() {
        return stare_civila_client;
    }

    public void setStare_civila_client(String stare_civila_client) {
        this.stare_civila_client = stare_civila_client;
    }

    public String getAdresa_client() {
        return adresa_client;
    }

    public void setAdresa_client(String adresa_client) {
        this.adresa_client = adresa_client;
    }

    public String getTelefon_client() {
        return telefon_client;
    }

    public void setTelefon_client(String telefon_client) {
        this.telefon_client = telefon_client;
    }

    @Override
    public String toString() {
        return "Clienti{" + "cod_client=" + cod_client + ", nume_client=" + nume_client + ", prenume_client=" + prenume_client + ", CNP_client=" + CNP_client + ", data_nastere_client=" + data_nastere_client + ", stare_civila_client=" + stare_civila_client + ", adresa_client=" + adresa_client + ", telefon_client=" + telefon_client + '}';
    }
    
    
    
    
}
