/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.Odgovor;
import transfer.Zahtev;
import util.PodesavanjaKonekcije;

/**
 *
 * @author User
 */
public class Komunikacija {

    private static Komunikacija instanca;
    Socket s;
    

    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    private Komunikacija() {
        try {
            int port = Integer.parseInt(PodesavanjaKonekcije.getInstanca().getProperty("port"));
            String adresa = PodesavanjaKonekcije.getInstanca().getProperty("adresa");
            s = new Socket(adresa, port);
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Greska prilikom uspostavljanja konekcije", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
////            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void posaljiZahtev(Zahtev z) {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(z);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
//            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Odgovor vratiOdgovor() {
        Odgovor o = new Odgovor();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            o = (Odgovor) ois.readObject();
            System.out.println(o);
        } catch (Exception ex) {
//            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }

        return o;
    }
}
