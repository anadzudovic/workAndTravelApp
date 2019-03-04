/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.baza.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.PodesavanjaBaze;

/**
 *
 * @author User
 */
public class BazaKonekcija {
    private final Connection konekcija;
    private static BazaKonekcija instanca;

    private BazaKonekcija()throws SQLException, Exception{
        try{
        String url = PodesavanjaBaze.getInstanca().getProperty("url");
        String dbuser = PodesavanjaBaze.getInstanca().getProperty("user");
        String dbpassword = PodesavanjaBaze.getInstanca().getProperty("password");
        konekcija = DriverManager.getConnection(url, dbuser, dbpassword);
        konekcija.setAutoCommit(false);}
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Pogresni parametri za bazu");
            throw new Exception("Greska prilikom rada servera");
        
        }
    }

    public static BazaKonekcija getInstanca() throws SQLException, Exception {
        if (instanca == null) {
            instanca = new BazaKonekcija();
        }
        return instanca;
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public void zapocniTransakciju() throws SQLException {
        konekcija.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        konekcija.commit();
    }

    public void rollback() throws SQLException {
        konekcija.rollback();
    }
}
