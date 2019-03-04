package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class PodesavanjaKonekcije {
    private static PodesavanjaKonekcije instanca;
    private Properties props;

    private PodesavanjaKonekcije() {
        try {
            props = new Properties();
            props.load(new FileInputStream("../SeminarskiZajednickiProjekat/podesavanja_konekcije.properties"));
        } catch (Exception ex) {
            Logger.getLogger(PodesavanjaKonekcije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PodesavanjaKonekcije getInstanca() {
        if (instanca == null) {
            instanca = new PodesavanjaKonekcije();
        }
        return instanca;
    }

    public String getProperty(String key) {
        return props.getProperty(key, "n/a");
    }
      public void setAdresa(String adresa) {
        props.setProperty("adresa", adresa);
        try {
            props.store(new FileOutputStream(new File("../SeminarskiZajednickiProjekat/podesavanja_konekcije.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PodesavanjaKonekcije.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PodesavanjaKonekcije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setPort(String port) {
        props.setProperty("port", port);
        try {
            props.store(new FileOutputStream(new File("../SeminarskiZajednickiProjekat/podesavanja_konekcije.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PodesavanjaKonekcije.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PodesavanjaKonekcije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
