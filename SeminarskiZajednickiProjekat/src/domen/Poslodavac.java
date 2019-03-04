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
public class Poslodavac implements OpstaDomenskaKlasa, Serializable {

    private int sifraPoslodavac;
    private String nazivKompanije;
    private String imeIPrezimeVlasnika;
    private String kontaktTelefon;
    private String elektronskaPosta;
    private Grad grad;

    public Poslodavac(int sifraPoslodavac, String nazivKompanije, String imeIPrezimeVlasnika, String kontaktTelefon, String elektronskaPosta, Grad grad) {
        this.sifraPoslodavac = sifraPoslodavac;
        this.nazivKompanije = nazivKompanije;
        this.imeIPrezimeVlasnika = imeIPrezimeVlasnika;
        this.kontaktTelefon = kontaktTelefon;
        this.elektronskaPosta = elektronskaPosta;
        this.grad = grad;
    }

    public Poslodavac() {
        grad = new Grad();
    }

    public int getSifraPoslodavac() {
        return sifraPoslodavac;
    }

    public void setSifraPoslodavac(int sifraPoslodavac) {
        this.sifraPoslodavac = sifraPoslodavac;
    }

    public String getNazivKompanije() {
        return nazivKompanije;
    }

    public void setNazivKompanije(String nazivKompanije) {
        this.nazivKompanije = nazivKompanije;
    }

    public String getImeIPrezimeVlasnika() {
        return imeIPrezimeVlasnika;
    }

    public void setImeIPrezimeVlasnika(String imeIPrezimeVlasnika) {
        this.imeIPrezimeVlasnika = imeIPrezimeVlasnika;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getElektronskaPosta() {
        return elektronskaPosta;
    }

    public void setElektronskaPosta(String elektronskaPosta) {
        this.elektronskaPosta = elektronskaPosta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Poslodavac other = (Poslodavac) obj;
        if (!Objects.equals(this.sifraPoslodavac, other.sifraPoslodavac)) {
            return false;
        }
        return true;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return nazivKompanije + ", " + grad.getNazivGrad();
    }

    @Override
    public String vratiVrednostiAtributa() {
        return sifraPoslodavac + ", " + (nazivKompanije == null ? null : "'" + nazivKompanije + "'")
                + ", " + (imeIPrezimeVlasnika == null ? null : "'" + imeIPrezimeVlasnika + "'") + ", "
                + (kontaktTelefon == null ? null : "'" + kontaktTelefon + "'") + ", "
                + (elektronskaPosta == null ? null : "'" + elektronskaPosta + "'") + ", "
                + grad.getSifraGrad();
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "Poslodavac";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSpajanje() {
        return " p inner join grad g on p.sifragrad=g.sifragrad inner join drzava d on g.sifradrzava=d.sifradrzava";
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema poslodavaca koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("p.sifraPoslodavac");
                String naziv = rs.getString("p.nazivKompanije");
                String vlasnik = rs.getString("p.imeiprezimevlasnik");
                String tel = rs.getString("p.kontaktelefon");
                String email = rs.getString("p.elektronskaposta");
                int gradid = rs.getInt("g.sifragrad");
                String nazivGrad = rs.getString("g.nazivgrad");
                int drzavaid = rs.getInt("g.sifradrzava");
                String nazivdr = rs.getString("d.nazivdrzava");
                Drzava d = new Drzava(drzavaid, nazivdr);
                Grad g = new Grad(gradid, nazivGrad, d);
                Poslodavac p = new Poslodavac(id, naziv, vlasnik, tel, email, g);
                lista.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TipRadnogMesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public String vratiUslovZaJednog() {
        return "sifraPoslodavac= " + sifraPoslodavac;
    }

    @Override
    public String vratiUslovZaVise() {
        if (nazivKompanije != null && grad != null) {
            return " WHERE p.nazivKompanije LIKE'" + nazivKompanije + "%'" + " AND p.sifraGrad= " + grad.getSifraGrad();

        } else if (nazivKompanije == null) {
            return " WHERE p.sifraGrad=" + grad.getSifraGrad();
        } else {
            return " WHERE p.nazivKompanije LIKE'" + nazivKompanije + "'";

        }
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSortiranje() {
        return OpstaDomenskaKlasa.super.vratiSortiranje(); //To change body of generated methods, choose Tools | Templates.
    }

}
