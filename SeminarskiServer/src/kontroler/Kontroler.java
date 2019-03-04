/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import so.student.SOVratiSveStudente;
import so.student.SOVratiOdredjeneStudente;
import so.student.SOIzmeniStudenta;
import domen.Agent;
import domen.Angazovanje;
import domen.Grad;
import domen.OpstaDomenskaKlasa;
import domen.Poslodavac;
import domen.RadnoMesto;
import domen.Student;
import domen.TipRadnogMesta;
import forma.GlavnaForma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaZahteva;
import so.OpstaSistemskaOperacija;
import so.SOPrijavljivanje;
import so.poslodavac.SOUnesiPoslodavca;
import so.student.SOUnesiStudenta;

import so.grad.SOVratiSveGradove;
import so.tipRM.SOVratiSveTipRM;
import so.angazovanje.SOIzmeniAngazovanje;
import so.angazovanje.SOUnesiAngazovanja;
import so.angazovanje.SOUnesiAngazovanje;
import so.angazovanje.SOVratiOdredjenaAngazovanja;
import so.angazovanje.SOVratiSvaAngazovanja;
import so.poslodavac.SOVratiOdredjenePoslodavce;
import so.poslodavac.SOVratiSvePoslodavce;
import so.rm.SOUnesiRM;
import so.rm.SOVratiOdredjenaRM;
import so.rm.SOVratiSvaRM;
import transfer.Odgovor;
import transfer.util.StatusOdgovora;

/**
 *
 * @author User
 */
public class Kontroler {

    private static Kontroler instanca;
    private List<ObradaZahteva> prijavljeniKorisnici;
    private GlavnaForma forma;

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    private Kontroler() {
        prijavljeniKorisnici = new ArrayList<>();
    }

    public List<ObradaZahteva> getPrijavljeniKorisnici() {
        return prijavljeniKorisnici;
    }

    public GlavnaForma getForma() {
        return forma;
    }

    public void setForma(GlavnaForma forma) {
        this.forma = forma;
    }

    public Agent prijaviSe(Agent a) throws Exception {
        OpstaSistemskaOperacija so = new SOPrijavljivanje();
        so.opsteIzvrsenje(a);
        return ((SOPrijavljivanje) so).getA();

    }

    public void izbaciAgenta(Agent a) {
        for (int i = 0; i < prijavljeniKorisnici.size(); i++) {
            if (prijavljeniKorisnici.get(i).getA().equals(a)) {
                Odgovor o = new Odgovor();
                o.setGreska("Gotovo");
                o.setPodaci("Gotovo! Odjavljeni ste sa sistema!");
                o.setStatus(StatusOdgovora.KRAJ_RADA);
                System.out.println(o);
                prijavljeniKorisnici.get(i).posaljiOdgovor(o);
                prijavljeniKorisnici.get(i).setKraj(true);
                try {
                    prijavljeniKorisnici.get(i).getSoket().close();
                } catch (IOException ex) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                }
                prijavljeniKorisnici.remove(i);

            }

        }
    }

    public List<OpstaDomenskaKlasa> vratiSveGradove() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSveGradove();
        so.opsteIzvrsenje(new Grad());
        return ((SOVratiSveGradove) so).getGradovi();

    }

    public void ubaciStudenta(Student s) throws Exception {
        OpstaSistemskaOperacija so = new SOUnesiStudenta();
        so.opsteIzvrsenje(s);
    }

    public void ubaciPoslodavca(Poslodavac p) throws Exception {
        OpstaSistemskaOperacija so = new SOUnesiPoslodavca();
        so.opsteIzvrsenje(p);
    }

    public List<OpstaDomenskaKlasa> vratiSveStudente() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSveStudente();
        so.opsteIzvrsenje(new Student());
        return ((SOVratiSveStudente) so).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiOdredjeneStudente(Student student) throws Exception {
        OpstaSistemskaOperacija so = new SOVratiOdredjeneStudente();
        so.opsteIzvrsenje(student);
        return ((SOVratiOdredjeneStudente) so).getLista();

    }

    public void izmeniStudenta(Student s) throws Exception {
        OpstaSistemskaOperacija so = new SOIzmeniStudenta();
        so.opsteIzvrsenje(s);

    }

    public List<OpstaDomenskaKlasa> vratiSvePoslodavce() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSvePoslodavce();
        so.opsteIzvrsenje(new Poslodavac());
        return ((SOVratiSvePoslodavce) so).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiOdredjenePoslodavce(Poslodavac poslodavac) throws Exception {
        OpstaSistemskaOperacija so = new SOVratiOdredjenePoslodavce();
        so.opsteIzvrsenje(poslodavac);
        return ((SOVratiOdredjenePoslodavce) so).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiSveTipRM() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSveTipRM();
        so.opsteIzvrsenje(new TipRadnogMesta());
        return ((SOVratiSveTipRM) so).getLista();
    }

    public void ubaciRM(RadnoMesto rm) throws Exception {
        OpstaSistemskaOperacija so = new SOUnesiRM();
        so.opsteIzvrsenje(rm);
    }

    public List<OpstaDomenskaKlasa> vratiSvaRM() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSvaRM();
        so.opsteIzvrsenje(new RadnoMesto());
        return ((SOVratiSvaRM) so).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiOdredjenaRM(RadnoMesto radnoMesto) throws Exception {
        OpstaSistemskaOperacija so = new SOVratiOdredjenaRM();
        so.opsteIzvrsenje(radnoMesto);
        return ((SOVratiOdredjenaRM) so).getLista();
    }

    public void odjaviAgenta(Agent a) {
        forma.odjaviAgenta(a);
    }

    public void ubaciAngazovanje(Angazovanje a) throws Exception {
        OpstaSistemskaOperacija so = new SOUnesiAngazovanje();
        so.opsteIzvrsenje(a);
    }

    public List<OpstaDomenskaKlasa> vratiSvaAngazovanja() throws Exception {
        OpstaSistemskaOperacija so = new SOVratiSvaAngazovanja();
        so.opsteIzvrsenje(new Angazovanje());
        return ((SOVratiSvaAngazovanja) so).getLista();
    }

    public void izmeniAngazovanje(Angazovanje a) throws Exception {
        OpstaSistemskaOperacija so = new SOIzmeniAngazovanje();
        so.opsteIzvrsenje(a);
    }

    public List<OpstaDomenskaKlasa> vratiOdredjenaAngazovanja(Angazovanje angazovanje) throws Exception {
        OpstaSistemskaOperacija so = new SOVratiOdredjenaAngazovanja();
        so.opsteIzvrsenje(angazovanje);
        return ((SOVratiOdredjenaAngazovanja) so).getLista();
    }

    public void ubaciAngazovanja(List<Angazovanje> an) throws Exception{
       OpstaSistemskaOperacija so = new SOUnesiAngazovanja();
        so.opsteIzvrsenje(an);
    }

}
