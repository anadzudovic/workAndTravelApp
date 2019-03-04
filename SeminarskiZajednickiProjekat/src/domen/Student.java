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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Student implements OpstaDomenskaKlasa, Serializable {

    private int sifraStudent;
    private String imeIPrezime;
    private Date datumRodjenja;
    private String kontaktTelefon;
    private String elektronskaPosta;
    private String JMBG;
    private String brojLicneKarte;
    private String brojPasosa;
    private String adresa;
//    private Grad grad;

    public Student(int sifraStudent, String imeIPrezime, Date datumRodjenja, String kontaktTelefon, String elektronskaPosta, String JMBG, String brojLicneKarte, String brojPasosa, String adresa) {
        this.sifraStudent = sifraStudent;
        this.imeIPrezime = imeIPrezime;
        this.datumRodjenja = datumRodjenja;
        this.kontaktTelefon = kontaktTelefon;
        this.elektronskaPosta = elektronskaPosta;
        this.JMBG = JMBG;
        this.brojLicneKarte = brojLicneKarte;
        this.brojPasosa = brojPasosa;
        this.adresa = adresa;
//        this.grad= grad;
    }

    public Student() {
    }

    public int getSifraStudent() {
        return sifraStudent;
    }

    public void setSifraStudent(int sifraStudent) {
        this.sifraStudent = sifraStudent;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    public String getBrojPasosa() {
        return brojPasosa;
    }

    public void setBrojPasosa(String brojPasosa) {
        this.brojPasosa = brojPasosa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.sifraStudent, other.sifraStudent)) {
            return false;
        }
        return true;
    }

//    public Grad getGrad() {
//        return grad;
//    }
//
//    public void setGrad(Grad grad) {
//        this.grad = grad;
//    }
    @Override
    public String toString() {

        return "Student{" + "sifraStudent=" + sifraStudent + ", imeIPrezime=" + imeIPrezime + ", datumRodjenja="
                + datumRodjenja + ", kontaktTelefon=" + kontaktTelefon
                + ", elektronskaPosta=" + elektronskaPosta
                + ", JMBG=" + JMBG
                + ", brojLicneKarte=" + brojLicneKarte
                + ", brojPasosa=" + brojPasosa
                + ", adresa=" + adresa
                + '}';
    }

    @Override
    public String vratiVrednostiAtributa() {
        return sifraStudent + ", " + (imeIPrezime == null ? null : "'" + imeIPrezime + "'")
                + ", " + (datumRodjenja == null ? null : "'" + datumRodjenja + "'") + ", "
                + (kontaktTelefon == null ? null : "'" + kontaktTelefon + "'") + ", "
                + (elektronskaPosta == null ? null : "'" + elektronskaPosta + "'") + ", "
                + (JMBG == null ? null : "'" + JMBG + "'") + ", "
                + (brojLicneKarte == null ? null : "'" + brojLicneKarte + "'") + ", "
                + (brojPasosa == null ? null : "'" + brojPasosa + "'") + ", "
                + (adresa == null ? null : "'" + adresa + "'");
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "sifraStudent=" + sifraStudent + ",imeiprezime='" + imeIPrezime + "',datumRodjenja='" + datumRodjenja
                + "',kontaktTelefon='" + kontaktTelefon + "',elektronskaPosta='" + elektronskaPosta + "',jmbg='" + JMBG
                + "',brojLicneKarte='" + brojLicneKarte + "',brojPasosa='" + brojPasosa + "',adresa='" + adresa + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "Student";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema studenata koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int sifraStudent = rs.getInt("sifraStudent");
                String imeIPrezime = rs.getString("imeIPrezime");
                Date datumRodjenja = rs.getDate("datumRodjenja");
                String kontaktTelefon = rs.getString("KontaktTelefon");
                String JMBG = rs.getString("JMBG");
                String elektronskaPosta = rs.getString("elektronskaposta");
                String brojPasosa = rs.getString("brojPasosa");
                String brojLicneKarte = rs.getString("brojLicneKarte");
                String adresa = rs.getString("Adresa");
                Student s = new Student(sifraStudent, imeIPrezime, datumRodjenja, kontaktTelefon, elektronskaPosta, JMBG, brojLicneKarte, brojPasosa, adresa);
                lista.add(s);
            }
        } catch (SQLException ex) {

            Logger.getLogger(Grad.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return lista;
    }

    @Override
    public String vratiUslovZaJednog() {
        return "sifraStudent= " + sifraStudent;
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
        return " WHERE imeiPrezime LIKE '%" + imeIPrezime + "%'";
    }

}
