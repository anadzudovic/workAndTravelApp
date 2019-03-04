/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Grad implements Serializable, OpstaDomenskaKlasa {

    private int sifraGrad;
    private String nazivGrad;
    private Drzava drzava;

    public Grad() {
    }

    public Grad(int sifraGrad, String nazivGrad, Drzava drzava) {
        this.sifraGrad = sifraGrad;
        this.nazivGrad = nazivGrad;
        this.drzava = drzava;
    }

    public String getNazivGrad() {
        return nazivGrad;
    }

    public void setNazivGrad(String nazivGrad) {
        this.nazivGrad = nazivGrad;
    }

    public int getSifraGrad() {
        return sifraGrad;
    }

    public void setSifraGrad(int sifraGrad) {
        this.sifraGrad = sifraGrad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Grad other = (Grad) obj;
        if (!Objects.equals(this.sifraGrad, other.sifraGrad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivGrad + ", " + drzava;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
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
        return "Grad";
    }



    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) {
        List<OpstaDomenskaKlasa> gradovi = new ArrayList<>();
        try {
            while (rs.next()) {
                int gradid = rs.getInt("g.sifraGrad");
                String naziv = rs.getString("g.nazivGrad");
                int drzavaid = rs.getInt("d.sifradrzava");
                String nazivDrzave = rs.getString("d.nazivdrzava");
                Drzava d = new Drzava(drzavaid,nazivDrzave);
                Grad g = new Grad(gradid, naziv, d);
                gradovi.add(g);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Grad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gradovi;
    }

    @Override
    public String vratiSpajanje() {
        return " g inner join drzava d on g.sifraDrzava=d.sifraDrzava";
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
        if(drzava == null) {
            return "";
        }
        return " where g.sifraDrzava="+drzava.getSifraDrzava();
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public String vratiSortiranje() {
         return " order by g.nazivgrad";
    }

}
