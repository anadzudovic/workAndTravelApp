/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.PodesavanjaKonekcije;
import kontroler.Kontroler;


/**
 *
 * @author User
 */
public class PokretanjeServera extends Thread {

    ServerSocket ss;
    boolean kraj = false;
//    List<ObradaZahteva> aktivneNiti = new ArrayList<>();

    @Override
    public void run() {
        int port = Integer.parseInt(PodesavanjaKonekcije.getInstanca().getProperty("port"));
        try {

            ss = new ServerSocket(port);
            System.out.println("Pokrenuo se server");
            Kontroler.getInstanca().getForma().postaviStatus("Server je uspesno pokrenut na portu: " + port, false);
            while (!kraj) {

                Socket s = ss.accept();
                ObradaZahteva oz = new ObradaZahteva(s);
                oz.start();
               Kontroler.getInstanca().getPrijavljeniKorisnici().add(oz);

            }
        } catch (SocketException ex) {
            Kontroler.getInstanca().getForma().postaviStatus("Server nije pokrenut ", true);         
//            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
            kraj=true;
        } catch (Exception ex) {
            Kontroler.getInstanca().getForma().postaviStatus("Server nije pokrenut ", true);
            JOptionPane.showMessageDialog(null,"Neodgovarajuci broj porta!");
             kraj=true;
//            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("GOTOVO");
    }

    public void zaustaviServer() {
         try {
            
            for (ObradaZahteva kn : Kontroler.getInstanca().getPrijavljeniKorisnici()) {
                kn.setKraj(true);
                kn.getSoket().close();
            }
            kraj = true;
            ss.close();
            Kontroler.getInstanca().getForma().popuniTabelu();
            System.out.println("Server je zaustavljen");
            Kontroler.getInstanca().getForma().postaviStatus("Server nije pokrenut", true);
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }

    

}
