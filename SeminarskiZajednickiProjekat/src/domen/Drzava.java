/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Drzava implements Serializable,OpstaDomenskaKlasa{
    private int sifraDrzava;
    private String nazivDrzava;

    public Drzava() {
    }

    public Drzava(int  sifraDrzava, String nazivDrzava) {
        this.sifraDrzava = sifraDrzava;
        this.nazivDrzava = nazivDrzava;
    }

    public String getNazivDrzava() {
        return nazivDrzava;
    }

    public void setNazivDrzava(String nazivDrzava) {
        this.nazivDrzava = nazivDrzava;
    }

    public int getSifraDrzava() {
        return sifraDrzava;
    }

    public void setSifraDrzava(int sifraDrzava) {
        this.sifraDrzava = sifraDrzava;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drzava other = (Drzava) obj;
        if (!Objects.equals(this.sifraDrzava, other.sifraDrzava)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   nazivDrzava;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "Drzava d";
    }

   

   
    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
        return OpstaDomenskaKlasa.super.vratiUslovZaVise(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  


    
    
}
