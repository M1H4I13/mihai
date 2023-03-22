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
public class Serviciu {
    
    private int cod_serviciu;
    private String tip_asigurare;
    private int cod_angajat;

    public Serviciu(int cod_serviciu, String tip_asigurare, int cod_angajat) {
        this.cod_serviciu = cod_serviciu;
        this.tip_asigurare = tip_asigurare;
        this.cod_angajat = cod_angajat;
    }

    public Serviciu() {
    }

    public int getCod_serviciu() {
        return cod_serviciu;
    }

    public void setCod_serviciu(int cod_serviciu) {
        this.cod_serviciu = cod_serviciu;
    }

    public String getTip_asigurare() {
        return tip_asigurare;
    }

    public void setTip_asigurare(String tip_asigurare) {
        this.tip_asigurare = tip_asigurare;
    }

    public int getCod_angajat() {
        return cod_angajat;
    }

    public void setCod_angajat(int cod_angajat) {
        this.cod_angajat = cod_angajat;
    }

    @Override
    public String toString() {
        return "Serviciu{" + "cod_serviciu=" + cod_serviciu + ", tip_asigurare=" + tip_asigurare + ", cod_angajat=" + cod_angajat + '}';
    }
    
    
    
    
    
}
