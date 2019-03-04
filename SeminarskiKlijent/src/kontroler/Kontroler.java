/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Agent;
import domen.Angazovanje;
import domen.Grad;
import domen.Poslodavac;
import domen.RadnoMesto;
import domen.Student;
import domen.TipRadnogMesta;
import forma.GlavnaForma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import komunikacija.Komunikacija;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author User
 */
public class Kontroler {

    private static Kontroler instanca;
    private GlavnaForma forma;

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    private Kontroler() {
    }

    public void setForma(GlavnaForma forma) {
        this.forma = forma;
    }

    public GlavnaForma getForma() {
        return forma;
    }

    public Agent prijavaNaSistem(String korisnickoIme, String sifra) throws Exception {
        Agent a = new Agent();
        a.setKorisnickoIme(korisnickoIme);
        a.setLozinka(sifra);
        System.out.println(a);
        Zahtev z = new Zahtev(Operacija.PRIJAVA, a);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            sesija.Sesija.getInstanca().setAgent((Agent) o.getPodaci());

            return (Agent) o.getPodaci();

        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Grad> vratiSveGradove() throws IOException, ClassNotFoundException {
        Zahtev z = new Zahtev(Operacija.VRATI_SVE_GRADOVE, new Grad());
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<Grad> gradovi = new ArrayList<>();
        gradovi = (List<Grad>) o.getPodaci();
        return gradovi;
    }

    public String unesiStudenta(Student s) throws Exception {

        Zahtev z = new Zahtev(Operacija.UNESI_STUDENTA, s);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public String unesiPoslodavca(Poslodavac p) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_POSLODAVCA, p);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Student> vratiSveStudente() throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_SVE_STUDENTE, new Student());
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<Student> lista = new ArrayList<>();
        lista = (List<Student>) o.getPodaci();
        return lista;
    }

    public List<Student> vratiStudente(Student st) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_ODREDJENE_STUDENTE, st);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if(o.getStatus()==StatusOdgovora.OK){
        List<Student> lista = new ArrayList<>();
        lista = (List<Student>) o.getPodaci();
        return lista;}
         Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public String izmeniStudenta(Student s) throws Exception {
        Zahtev z = new Zahtev(Operacija.IZMENI_STUDENTA, s);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Poslodavac> vratiPoslodavce(Poslodavac p) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_ODREDJENE_POSLODAVCE, p);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if(o.getStatus()==StatusOdgovora.OK){
        List<Poslodavac> lista = new ArrayList<>();
        lista = (List<Poslodavac>) o.getPodaci();
        return lista;}
         Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Poslodavac> vratiSvePoslodavce() {
       
        Zahtev z = new Zahtev(Operacija.VRATI_SVE_POSLODAVCE, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<Poslodavac> lista = new ArrayList<>();
        lista = (List<Poslodavac>) o.getPodaci();
        return lista;
    }

    public List<TipRadnogMesta> vratiSveTipoveRM() throws Exception {
         Zahtev z = new Zahtev(Operacija.VRATI_SVE_TIPRM, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<TipRadnogMesta> lista = new ArrayList<>();
        lista = (List<TipRadnogMesta>) o.getPodaci();
        return lista;
    }

    public String unesiRM(RadnoMesto rm) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_RM, rm);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<RadnoMesto> vratiSvaRM() throws Exception{
         Zahtev z = new Zahtev(Operacija.VRATI_SVA_RM, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<RadnoMesto> lista = new ArrayList<>();
        lista = (List<RadnoMesto>) o.getPodaci();
        return lista;
    }

    public List<RadnoMesto> vratiRM(RadnoMesto rm) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_ODREDJENA_RM, rm);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if(o.getStatus()==StatusOdgovora.OK){
        List<RadnoMesto> lista = new ArrayList<>();
        lista = (List<RadnoMesto>) o.getPodaci();
        return lista;}
         Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public String odjavaSaSistema(Agent agent) throws Exception {
       Zahtev zahtev = new Zahtev(Operacija.ODJAVA, agent);
        Komunikacija.getInstanca().posaljiZahtev(zahtev);
        
        Odgovor odgovor = Komunikacija.getInstanca().vratiOdgovor();
        if(odgovor.getStatus() == StatusOdgovora.OK){
            return (String) odgovor.getPodaci();
        }
        throw (Exception)odgovor.getGreska();
    }

    public String unesiAngazovanje(Angazovanje a) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_ANGAZOVANJE, a);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Angazovanje> vratiSvaAngazovanja() throws Exception{
         Zahtev z = new Zahtev(Operacija.VRATI_SVA_ANGAZOVANJA, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        List<Angazovanje> lista = new ArrayList<>();
        lista = (List<Angazovanje>) o.getPodaci();
        return lista;
    }

    public String izmeniAngazovanje(Angazovanje a) throws Exception{
        Zahtev z = new Zahtev(Operacija.IZMENI_ANGAZOVANJE, a);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public List<Angazovanje> vratiAngazovanja(Angazovanje a) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_ODREDJENA_ANGAZOVANJA, a);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if(o.getStatus()==StatusOdgovora.OK){
        List<Angazovanje> lista = new ArrayList<>();
        lista = (List<Angazovanje>) o.getPodaci();
        return lista;}
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    public String unesiAngazovanja(List<Angazovanje> a) throws Exception {
       Zahtev z = new Zahtev(Operacija.UNESI_ANGAZOVANJA, a);
        Komunikacija.getInstanca().posaljiZahtev(z);
        System.out.println(z);
        Odgovor o = Komunikacija.getInstanca().vratiOdgovor();
        if (o.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) o.getPodaci();
            return poruka;
        }
        Exception ex = (Exception) o.getGreska();
        throw ex;
    }

    
}
