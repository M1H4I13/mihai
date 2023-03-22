/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele_asig;

/**
 *
 * @author gingh
 */
public class Functie {
    
    private int cod_functie;
    private String denumire_functie;

    public Functie(int cod_functie, String denumire_functie) {
        this.cod_functie = cod_functie;
        this.denumire_functie = denumire_functie;
    }

    public Functie() {
    }

    public int getCod_functie() {
        return cod_functie;
    }

    public void setCod_functie(int cod_functie) {
        this.cod_functie = cod_functie;
    }

    public String getDenumire_functie() {
        return denumire_functie;
    }

    public void setDenumire_functie(String denumire_functie) {
        this.denumire_functie = denumire_functie;
    }

    @Override
    public String toString() {
        return "Functie{" + "cod_functie=" + cod_functie + ", denumire_functie=" + denumire_functie + '}';
    }
    
    
    
    
}
