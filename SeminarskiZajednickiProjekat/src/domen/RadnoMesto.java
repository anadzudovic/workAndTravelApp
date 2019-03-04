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
public class RadnoMesto implements OpstaDomenskaKlasa, Serializable {

    private int sifraRadnogMesta;
    private String opisRadnogMesta;
    private boolean mogucaNapojnica;
    private double satnica;
    private Date datumOd;
    private Date datumDo;
    private int ukupanBrIzvrsioca;
    private int preostaoBrojIzvrsioca;
    private TipRadnogMesta tipRadnogMesta;
    private Poslodavac poslodavac;

    public RadnoMesto() {
    }

    public RadnoMesto(int sifraRadnogMesta, String opisRadnogMesta, boolean mogucaNapojnica, double satnica, Date datumOd, Date datumDo, int ukupanBrIzvrsioca, TipRadnogMesta tipRadnogMesta, Poslodavac poslodavac) {
        this.sifraRadnogMesta = sifraRadnogMesta;
        this.opisRadnogMesta = opisRadnogMesta;
        this.mogucaNapojnica = mogucaNapojnica;
        this.satnica = satnica;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.ukupanBrIzvrsioca = ukupanBrIzvrsioca;
        this.preostaoBrojIzvrsioca = ukupanBrIzvrsioca;
        this.tipRadnogMesta = tipRadnogMesta;
        this.poslodavac = poslodavac;

    }

    public int getUkupanBrIzvrsioca() {
        return ukupanBrIzvrsioca;
    }

    public void setUkupanBrIzvrsioca(int ukupanBrIzvrsioca) {
        this.ukupanBrIzvrsioca = ukupanBrIzvrsioca;
    }

    public int getSifraRadnogMesta() {
        return sifraRadnogMesta;
    }

    public void setSifraRadnogMesta(int sifraRadnogMesta) {
        this.sifraRadnogMesta = sifraRadnogMesta;
    }

    public String getOpisRadnogMesta() {
        return opisRadnogMesta;
    }

    public void setOpisRadnogMesta(String opisRadnogMesta) {
        this.opisRadnogMesta = opisRadnogMesta;
    }

    public boolean isMogucaNapojnica() {
        return mogucaNapojnica;
    }

    public void setMogucaNapojnica(boolean mogucaNapojnica) {
        this.mogucaNapojnica = mogucaNapojnica;
    }

    public double getSatnica() {
        return satnica;
    }

    public void setSatnica(double satnica) {
        this.satnica = satnica;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
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
        final RadnoMesto other = (RadnoMesto) obj;
        if (!Objects.equals(this.sifraRadnogMesta, other.sifraRadnogMesta)) {
            return false;
        }
        return true;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public int getPreostaoBrojIzvrsioca() {
        return preostaoBrojIzvrsioca;
    }

    public void setPreostaoBrojIzvrsioca(int preostaoBrojIzvrsioca) {
        this.preostaoBrojIzvrsioca = preostaoBrojIzvrsioca;
    }

    public TipRadnogMesta getTipRadnogMesta() {
        return tipRadnogMesta;
    }

    public void setTipRadnogMesta(TipRadnogMesta tipRadnogMesta) {
        this.tipRadnogMesta = tipRadnogMesta;
    }

    public Poslodavac getPoslodavac() {
        return poslodavac;
    }

    public void setPoslodavac(Poslodavac poslodavac) {
        this.poslodavac = poslodavac;
    }

    @Override
    public String toString() {
        return "RadnoMesto{" + "sifraRadnogMesta=" + sifraRadnogMesta + ", opisRadnogMesta=" + opisRadnogMesta + ", mogucaNapojnica=" + mogucaNapojnica + ", satnica=" + satnica + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", ukupanBrIzvrsioca=" + ukupanBrIzvrsioca + ", preostaoBrojIzvrsioca=" + preostaoBrojIzvrsioca + ", tipRadnogMesta=" + tipRadnogMesta + ", poslodavac=" + poslodavac + '}';
    }

    @Override
    public String vratiVrednostiAtributa() {
        return sifraRadnogMesta + ", " + (opisRadnogMesta == null ? null : "'" + opisRadnogMesta + "'")
                + ", " + mogucaNapojnica + ", "
                + (datumOd == null ? null : "'" + datumOd + "'") + ", "
                + (datumDo == null ? null : "'" + datumDo + "'") + ", "
                + satnica + ", "
                + ukupanBrIzvrsioca + ", " + preostaoBrojIzvrsioca + ", "
                + tipRadnogMesta.getSifraTipRadnogmesta() + ", " + poslodavac.getSifraPoslodavac();
    }

    @Override
    public String postaviVrednostiAtributa() {

        return "preostaoBrojIzvrsioca= " + preostaoBrojIzvrsioca;
    }

    @Override
    public String vratiImeKlase() {
        return "RadnoMesto";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema radnih mesta koji odgovaraju unetim kriterijumima");
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
                lista.add(rm);

            }
        } catch (SQLException ex) {

            Logger.getLogger(Grad.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return lista;
    }

    @Override
    public String vratiUslovZaJednog() {
        return "sifraRadnoMesto= " + sifraRadnogMesta;
    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where";
        if (poslodavac != null) {
            rez += " rm.sifraposlodavac=" + poslodavac.getSifraPoslodavac() + " and";
        }
        if (tipRadnogMesta != null) {
            rez += " rm.sifratiprm=" + tipRadnogMesta.getSifraTipRadnogmesta() + " and";
        }

//          if(datumOd!=null) {
//            rez += " rm.datumOd>="+datumOd+" and";
//        }
//            if(datumDo!=null) {
//            rez += " rm.datumDo<="+datumDo+" and";
//        }
        if (mogucaNapojnica) {
            rez += " rm.mogucaNapojnica=" + mogucaNapojnica + " and";
        }
        if (preostaoBrojIzvrsioca == 1) {
            rez += " rm.preostaoBrojIzvrsioca>0 and";

        }

        if (rez.equals(" where")) {
            return "";
        }
        return rez.substring(0, rez.length() - 4);
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSpajanje() {
        return " rm inner join poslodavac p on rm.sifraposlodavac=p.sifraposlodavac"
                + " inner join tipradnogmesta t on rm.sifratiprm=t.sifratipradnogmesta "
                + "inner join grad g on p.sifragrad=g.sifragrad "
                + "inner join drzava d on g.sifradrzava=d.sifradrzava";
    }

    @Override
    public String vratiSortiranje() {
        return " order by p.nazivkompanije";
    }

}
