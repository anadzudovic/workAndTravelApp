/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author User
 */
public class Agent implements Serializable, OpstaDomenskaKlasa {

    private int sifraAgent;
    private String korisnickoIme;
    private String lozinka;
    private String imeIPrezime;

    public Agent(int sifraKorisnik, String korisnickoIme, String sifra, String imeIPrezime) {
        this.sifraAgent = sifraKorisnik;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = sifra;
        this.imeIPrezime = imeIPrezime;
    }

    public Agent() {
    }

    public int getSifraAgent() {
        return sifraAgent;
    }

    public void setSifraAgent(int sifraAgent) {
        this.sifraAgent = sifraAgent;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    @Override
    public String toString() {
        return "Agent{" + "sifraAgent=" + sifraAgent + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", imeIPrezime=" + imeIPrezime + '}';
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
        final Agent other = (Agent) obj;
        return true;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return sifraAgent + ", " + (korisnickoIme == null ? null : "'" + korisnickoIme + "'") + ", " + (lozinka == null ? null : "'" + lozinka + "'") + ", " + (imeIPrezime == null ? null : "'" + imeIPrezime + "'");
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "sifraAgent=" + sifraAgent + ", " + "korisnickoIme=" + "'" + korisnickoIme + "', " + "lozinka='" + lozinka + "', " + "imeIPrezime='" + imeIPrezime + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "Agent";
    }

    @Override
    public String vratiUslovZaJednog() {
        
        return "korisnickoIme='" + korisnickoIme + "' and lozinka='" + lozinka + "'";
    }

    @Override
    public String vratiUslovZaVise() {
        return "korisnickoIme='" + korisnickoIme + "' and lozinka='" + lozinka + "'";

    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {

        if (rs.next()) {
            int sifraAgent1 = rs.getInt("sifraAgent");
            String korisnickoIme1 = rs.getString("korisnickoIme");
            String lozinka1 = rs.getString("lozinka");
            String imeIPrezime1 = rs.getString("imeIPrezime");
            return new Agent(sifraAgent1, korisnickoIme1, lozinka1, imeIPrezime1);

        }
        
        throw new Exception("Uneli ste pogresne podatke, nema agenta sa ovim podacima");
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        String[] kolone = {"sifraAgent", "korisnickoIme", "lozinka", "imeIPrezime"};
        return kolone[kolona];
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
