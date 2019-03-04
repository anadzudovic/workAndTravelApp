/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Agent;
import domen.Angazovanje;
import domen.Grad;
import domen.OpstaDomenskaKlasa;
import domen.Poslodavac;
import domen.RadnoMesto;
import domen.Student;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;
import kontroler.Kontroler;

/**
 *
 * @author User
 */
public class ObradaZahteva extends Thread {

    private Socket soket;
    private boolean kraj = false;
    private Agent a;

    public ObradaZahteva(Socket s) {
        this.soket = s;
    }

    public Socket getSoket() {
        return soket;
    }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public Agent getA() {
        return a;
    }

    public void setA(Agent a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            while (!kraj) {
                Zahtev z = vratiZahtev();
                System.out.println(z);
                Odgovor o = new Odgovor();
                List<OpstaDomenskaKlasa> lista = new ArrayList<>();
                try {
                    switch (z.getOperacija()) {
                        case Operacija.PRIJAVA:

                            a = (Agent) z.getPodaci();

                            a = Kontroler.getInstanca().prijaviSe(a);
                            o.setPodaci(a);
                            //System.out.println(a);
                            o.setStatus(StatusOdgovora.OK);
                            Kontroler.getInstanca().getPrijavljeniKorisnici().add(this);
                            Kontroler.getInstanca().getForma().dodajPrijavljenogAgenta(a);

                            break;
                        case Operacija.VRATI_SVE_GRADOVE:

                            List<OpstaDomenskaKlasa> gradovi = Kontroler.getInstanca().vratiSveGradove();
                            o.setPodaci(gradovi);
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.UNESI_STUDENTA:

                            Student s = (Student) z.getPodaci();
                            Kontroler.getInstanca().ubaciStudenta(s);
                            o.setPodaci("Uspesno ste uneli studenta");
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.UNESI_POSLODAVCA:

                            Poslodavac p = (Poslodavac) z.getPodaci();
                            Kontroler.getInstanca().ubaciPoslodavca(p);
                            o.setPodaci("Uspesno ste uneli poslodavca");
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.VRATI_SVE_STUDENTE:

                            lista = Kontroler.getInstanca().vratiSveStudente();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;

                        case Operacija.VRATI_ODREDJENE_STUDENTE:

                            lista = Kontroler.getInstanca().vratiOdredjeneStudente((Student) z.getPodaci());
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.IZMENI_STUDENTA:

                            s = (Student) z.getPodaci();
                            Kontroler.getInstanca().izmeniStudenta(s);
                            o.setPodaci("Uspesno ste izmenili studenta");
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.VRATI_SVE_POSLODAVCE:

                            lista = Kontroler.getInstanca().vratiSvePoslodavce();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.VRATI_ODREDJENE_POSLODAVCE:

                            lista = Kontroler.getInstanca().vratiOdredjenePoslodavce((Poslodavac) z.getPodaci());
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.VRATI_SVE_TIPRM:
                            lista = Kontroler.getInstanca().vratiSveTipRM();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.UNESI_RM:

                            RadnoMesto rm = (RadnoMesto) z.getPodaci();
                            Kontroler.getInstanca().ubaciRM(rm);
                            o.setPodaci("Uspesno ste uneli radno mesto");
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.UNESI_ANGAZOVANJE:
                            Angazovanje a = (Angazovanje) z.getPodaci();
                            Kontroler.getInstanca().ubaciAngazovanje(a);
                            o.setPodaci("Uspesno ste uneli angazovanje");
                            o.setStatus(StatusOdgovora.OK);

                            break;
                            case Operacija.UNESI_ANGAZOVANJA:
                            List<Angazovanje> ang = (List<Angazovanje>) z.getPodaci();
                            Kontroler.getInstanca().ubaciAngazovanja(ang);
                            o.setPodaci("Uspesno ste uneli angazovanja");
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.IZMENI_ANGAZOVANJE:

                           Angazovanje a1 = (Angazovanje) z.getPodaci();
                            Kontroler.getInstanca().izmeniAngazovanje(a1);
                            o.setPodaci("Uspesno ste ponistili angazovanje");
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.VRATI_SVA_RM:
                            lista = Kontroler.getInstanca().vratiSvaRM();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.VRATI_SVA_ANGAZOVANJA:
                            lista = Kontroler.getInstanca().vratiSvaAngazovanja();
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.VRATI_ODREDJENA_RM:
                            lista = Kontroler.getInstanca().vratiOdredjenaRM((RadnoMesto) z.getPodaci());
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                            case Operacija.VRATI_ODREDJENA_ANGAZOVANJA:
                            lista = Kontroler.getInstanca().vratiOdredjenaAngazovanja((Angazovanje) z.getPodaci());
                            o.setPodaci(lista);
                            o.setStatus(StatusOdgovora.OK);

                            break;
                        case Operacija.ODJAVA:
                            if (z.getPodaci() == null) {
                                Kontroler.getInstanca().getPrijavljeniKorisnici().remove(this);
                                kraj = true;
                                break;
                            } else {
                                Agent an = (Agent) z.getPodaci();
                                Kontroler.getInstanca().odjaviAgenta(an);
                                o.setStatus(StatusOdgovora.OK);
                                o.setPodaci("Uspesno ste se odjavili sa servera!");
                            }
                    }
                } catch (Exception ex) {
                    o.setStatus(StatusOdgovora.GRESKA);
                    o.setGreska(ex);
                }
                System.out.println(o);
                posaljiOdgovor(o);
            }

        } catch (Exception e) {

//            e.printStackTrace();
        }
        System.out.println("Klijent se odjavio");
    }

    public void posaljiOdgovor(Odgovor o) {
        try {
//            System.out.println(o);
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(o);
        } catch (Exception ex) {
//            ex.printStackTrace();
        }

    }

    public Zahtev vratiZahtev() {
        Zahtev z = new Zahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            z = (Zahtev) ois.readObject();
        } catch (Exception ex) {
//            ex.printStackTrace();
        }

        return z;
    }

}
