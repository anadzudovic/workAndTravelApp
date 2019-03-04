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
import transfer.util.Operacija;

/**
 *
 * @author User
 */
public class Angazovanje implements OpstaDomenskaKlasa, Serializable {

    private int sifraAngazovanje;
    private boolean besplatanSmestaj;
    private boolean besplatniObrok;
    private StatusUgovora statusUgovora;
    private Student student;
    private RadnoMesto radnoMesto;

    public Angazovanje() {
    }

    public Angazovanje(int sifraAngazovanje, boolean besplatanSmestaj, boolean besplatniObrok, StatusUgovora statusUgovota, Student student, RadnoMesto radnoMesto) {
        this.sifraAngazovanje = sifraAngazovanje;
        this.besplatanSmestaj = besplatanSmestaj;
        this.besplatniObrok = besplatniObrok;
        this.statusUgovora = statusUgovota;
        this.student = student;
        this.radnoMesto = radnoMesto;
    }

    public StatusUgovora getStatusUgovora() {
        return statusUgovora;
    }

    public void setStatusUgovora(StatusUgovora statusUgovora) {
        this.statusUgovora = statusUgovora;
    }

    public int getSifraAngazovanje() {
        return sifraAngazovanje;
    }

    public void setSifraAngazovanje(int sifraAngazovanje) {
        this.sifraAngazovanje = sifraAngazovanje;
    }

    public boolean isBesplatanSmestaj() {
        return besplatanSmestaj;
    }

    public void setBesplatanSmestaj(boolean besplatanSmestaj) {
        this.besplatanSmestaj = besplatanSmestaj;
    }

    public boolean isBesplatniObrok() {
        return besplatniObrok;
    }

    public void setBesplatniObrok(boolean besplatniObrok) {
        this.besplatniObrok = besplatniObrok;
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
        final Angazovanje other = (Angazovanje) obj;
        if (this.sifraAngazovanje != other.sifraAngazovanje) {
            return false;
        }
        return true;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public RadnoMesto getRadnoMesto() {
        return radnoMesto;
    }

    public void setRadnoMesto(RadnoMesto radnoMesto) {
        this.radnoMesto = radnoMesto;
    }

    @Override
    public String toString() {
        return "Angazovanje{" + "sifraAngazovanje=" + sifraAngazovanje + ", besplatanSmestaj=" + besplatanSmestaj + ", besplatniObrok=" + besplatniObrok + ", statusUgovora=" + statusUgovora + ", student=" + student + ", radnoMesto=" + radnoMesto + '}';
    }

    @Override
    public String vratiVrednostiAtributa() {

        return sifraAngazovanje + ", " + besplatanSmestaj + ", " + besplatniObrok + ", '" + statusUgovora.toString() + "', " + student.getSifraStudent() + ", " + radnoMesto.getSifraRadnogMesta();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return " statusUgovora='" + statusUgovora.toString() + "' ";
    }

    @Override
    public String vratiImeKlase() {
        return "Angazovanje";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "sifraAngazovanje= " + sifraAngazovanje;
    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where";
        if (student != null) {
            rez += " a.sifrastudent=" + student.getSifraStudent() + " and";
        }
        if (radnoMesto != null) {
            rez += " a.sifrarm=" + radnoMesto.getSifraRadnogMesta() + " and";
        }

        if (statusUgovora != null) {
            rez += " a.statusUgovora='" + StatusUgovora.vazeci.toString() + "' and";

        }

        if (rez.equals(" where")) {
            return "";
        }
        return rez.substring(0, rez.length() - 4);
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema angazovanja koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int sifraRM = rs.getInt("rm.sifraRadnoMesto");
                String opis = rs.getString("rm.opisRadnoMesto");
                boolean napojnica = rs.getBoolean("rm.mogucaNapojnica");
                double satnica = rs.getDouble("rm.satnica");
                int uk = rs.getInt("rm.ukupanBrojIzvrsioca");
                int preostao = rs.getInt("rm.preostaoBrojIzvrsioca");
                Date datumOd = rs.getDate("rm.datumOd");
                Date datumDo = rs.getDate("rm.datumDo");
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
                int id1 = rs.getInt("rm.sifraTipRM");
                String naziv1 = rs.getString("t.nazivtipradnogmesta");
                TipRadnogMesta trm = new TipRadnogMesta(id1, naziv1);
                RadnoMesto rm = new RadnoMesto(sifraRM, opis, napojnica, satnica, datumOd, datumDo, uk, trm, p);
                rm.setPreostaoBrojIzvrsioca(preostao);
                int sifraStudent = rs.getInt("st.sifraStudent");
                String imeIPrezime = rs.getString("st.imeIPrezime");
                Date datumRodjenja = rs.getDate("st.datumRodjenja");
                String kontaktTelefon = rs.getString("st.KontaktTelefon");
                String JMBG = rs.getString("st.JMBG");
                String elektronskaPosta = rs.getString("st.elektronskaposta");
                String brojPasosa = rs.getString("st.brojPasosa");
                String brojLicneKarte = rs.getString("st.brojLicneKarte");
                String adresa = rs.getString("st.Adresa");
                Student s = new Student(sifraStudent, imeIPrezime, datumRodjenja, kontaktTelefon, elektronskaPosta, JMBG, brojLicneKarte, brojPasosa, adresa);
                int sifraA = rs.getInt("a.sifraAngazovanje");
                boolean smestaj = rs.getBoolean("a.besplatansmestaj");
                boolean obrok = rs.getBoolean("a.besplatanobrok");
                String status0 = rs.getString("a.statusugovora");
                String status1 = StatusUgovora.ponisten.toString();
                Angazovanje a = new Angazovanje(sifraA, smestaj, obrok, StatusUgovora.vazeci, s, rm);
                if (status0.equals(status1)) {
                    a.setStatusUgovora(StatusUgovora.ponisten);
                }
                lista.add(a);

            }
        } catch (SQLException ex) {

            Logger.getLogger(Angazovanje.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return lista;
    }

    @Override
    public String vratiSpajanje() {
        return " a inner join radnomesto rm on a.sifrarm=rm.sifraradnomesto  inner join poslodavac p on rm.sifraposlodavac=p.sifraposlodavac"
                + " inner join tipradnogmesta t on rm.sifratiprm=t.sifratipradnogmesta "
                + "inner join grad g on p.sifragrad=g.sifragrad "
                + "inner join drzava d on g.sifradrzava=d.sifradrzava inner join student st on a.sifrastudent=st.sifrastudent";
    }

    @Override
    public String vratiSortiranje() {
        return " order by p.nazivkompanije";
    }

}
