/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.baza;

import domen.OpstaDomenskaKlasa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladiste.BrokerBazeInterfejs;
import skladiste.baza.konekcija.BazaKonekcija;

/**
 *
 * @author User
 */
public class BrokerBaze implements BrokerBazeInterfejs {

    @Override
    public OpstaDomenskaKlasa vratiJednog(OpstaDomenskaKlasa ok) throws Exception {
        Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
        String upit = "SELECT * FROM " + ok.vratiImeKlase() + " WHERE " + ok.vratiUslovZaJednog();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        ok = ok.napuni(rs);
        rs.close();
        s.close();
        return ok;

    }

    @Override
    public List<OpstaDomenskaKlasa> vratiSve(OpstaDomenskaKlasa ok) throws Exception {
        Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
        String upit = "select * from " + ok.vratiImeKlase() + ok.vratiSpajanje()+ok.vratiSortiranje();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        List<OpstaDomenskaKlasa> lista = ok.napuniListu(rs);
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public List<OpstaDomenskaKlasa> vratiVise(OpstaDomenskaKlasa ok) throws Exception {
        Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
       String upit = "select * from " + ok.vratiImeKlase() + ok.vratiSpajanje() + ok.vratiUslovZaVise() + ok.vratiSortiranje();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        List<OpstaDomenskaKlasa> lista= ok.napuniListu(rs);
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public int sacuvaj(OpstaDomenskaKlasa ok) throws Exception {

        try {
            Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
            String upit = "insert into " + ok.vratiImeKlase() + " values (" + ok.vratiVrednostiAtributa() + ")";
            System.out.println(upit);
            PreparedStatement ps = konekcija.prepareStatement(upit, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
//            Logger.getLogger(BrokerBaze.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno cuvanje!");
        }

    }

    @Override
    public void izmeni(OpstaDomenskaKlasa ok) throws Exception {
       try {
            Connection konekcija = BazaKonekcija.getInstanca().getKonekcija();
            String upit = "update " + ok.vratiImeKlase() + " set " + ok.postaviVrednostiAtributa() + " where " + ok.vratiUslovZaJednog();
            System.out.println(upit);
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.executeUpdate();
        } catch (SQLException ex) {
//            ex.printStackTrace();
            throw new Exception("Neuspesna izmena!");
        }
    }
}
