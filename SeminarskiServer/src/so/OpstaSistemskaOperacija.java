/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import java.sql.SQLException;
import skladiste.BrokerBazeInterfejs;
import skladiste.baza.BrokerBaze;
import skladiste.baza.konekcija.BazaKonekcija;

/**
 *
 * @author User
 */
public abstract class OpstaSistemskaOperacija {

    protected BrokerBazeInterfejs brokerBaze;

    public OpstaSistemskaOperacija() {
        brokerBaze = new BrokerBaze();

    }

    public final void opsteIzvrsenje(Object objekat) throws Exception {
        try {
            validacija(objekat);
            try {
                zapocniTransakciju();
                izvrsi(objekat);
                commit();
            } catch (Exception ex) {
                System.out.println("BACEN U ROLLBACK");
                
                rollback();
                throw ex;

            }
        } catch (Exception ex) {
           ex.printStackTrace();
            throw ex;
        }

    }

    protected abstract void validacija(Object objekat) throws Exception;

    private void zapocniTransakciju() throws Exception {
        BazaKonekcija.getInstanca().zapocniTransakciju();
    }

    protected abstract void izvrsi(Object object) throws Exception;

    private void commit() throws Exception {

        BazaKonekcija.getInstanca().commit();
    }

    private void rollback() throws Exception {

        BazaKonekcija.getInstanca().rollback();

    }
}
