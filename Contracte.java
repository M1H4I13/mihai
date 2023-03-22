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
public class Contracte {
    
    private int cod_contract;
    private int asigurat;       //cod_client
    private int beneficiar;     //cod_benef 
    private int contractant;    //cod_angajat
    private int nr_pers_asig;
    private int nr_minori_asig;
    private int nr_adulti_asig;
    private Date data_incepere;
    private Date data_incheiere;
    private int suma_asigurata;
    private int pret_platit;
    private int cod_serviciu;

    public Contracte(int cod_contract, int asigurat, int beneficiar, int contractant, int nr_pers_asig, int nr_minori_asig, int nr_adulti_asig, Date data_incepere, Date data_incheiere, int suma_asigurata, int pret_platit, int cod_serviciu) {
        this.cod_contract = cod_contract;
        this.asigurat = asigurat;
        this.beneficiar = beneficiar;
        this.contractant = contractant;
        this.nr_pers_asig = nr_pers_asig;
        this.nr_minori_asig = nr_minori_asig;
        this.nr_adulti_asig = nr_adulti_asig;
        this.data_incepere = data_incepere;
        this.data_incheiere = data_incheiere;
        this.suma_asigurata = suma_asigurata;
        this.pret_platit = pret_platit;
        this.cod_serviciu = cod_serviciu;
    }

    public Contracte() {
    }

    public int getCod_contract() {
        return cod_contract;
    }

    public void setCod_contract(int cod_contract) {
        this.cod_contract = cod_contract;
    }

    public int getAsigurat() {
        return asigurat;
    }

    public void setAsigurat(int asigurat) {
        this.asigurat = asigurat;
    }

    public int getBeneficiar() {
        return beneficiar;
    }

    public void setBeneficiar(int beneficiar) {
        this.beneficiar = beneficiar;
    }

    public int getContractant() {
        return contractant;
    }

    public void setContractant(int contractant) {
        this.contractant = contractant;
    }

    public int getNr_pers_asig() {
        return nr_pers_asig;
    }

    public void setNr_pers_asig(int nr_pers_asig) {
        this.nr_pers_asig = nr_pers_asig;
    }

    public int getNr_minori_asig() {
        return nr_minori_asig;
    }

    public void setNr_minori_asig(int nr_minori_asig) {
        this.nr_minori_asig = nr_minori_asig;
    }

    public int getNr_adulti_asig() {
        return nr_adulti_asig;
    }

    public void setNr_adulti_asig(int nr_adulti_asig) {
        this.nr_adulti_asig = nr_adulti_asig;
    }

    public Date getData_incepere() {
        return data_incepere;
    }

    public void setData_incepere(Date data_incepere) {
        this.data_incepere = data_incepere;
    }

    public Date getData_incheiere() {
        return data_incheiere;
    }

    public void setData_incheiere(Date data_incheiere) {
        this.data_incheiere = data_incheiere;
    }

    public int getSuma_asigurata() {
        return suma_asigurata;
    }

    public void setSuma_asigurata(int suma_asigurata) {
        this.suma_asigurata = suma_asigurata;
    }

    public int getPret_platit() {
        return pret_platit;
    }

    public void setPret_platit(int pret_platit) {
        this.pret_platit = pret_platit;
    }

    public int getCod_serviciu() {
        return cod_serviciu;
    }

    public void setCod_serviciu(int cod_serviciu) {
        this.cod_serviciu = cod_serviciu;
    }

    @Override
    public String toString() {
        return "Contracte{" + "cod_contract=" + cod_contract + ", asigurat=" + asigurat + ", beneficiar=" + beneficiar + ", contractant=" + contractant + ", nr_pers_asig=" + nr_pers_asig + ", nr_minori_asig=" + nr_minori_asig + ", nr_adulti_asig=" + nr_adulti_asig + ", data_incepere=" + data_incepere + ", data_incheiere=" + data_incheiere + ", suma_asigurata=" + suma_asigurata + ", pret_platit=" + pret_platit + ", cod_serviciu=" + cod_serviciu + '}';
    }
    
    
    
    
    
}
