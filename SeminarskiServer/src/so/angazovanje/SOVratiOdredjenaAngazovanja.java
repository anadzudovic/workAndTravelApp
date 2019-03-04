/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.angazovanje;

import domen.Angazovanje;
import domen.OpstaDomenskaKlasa;

import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOVratiOdredjenaAngazovanja extends OpstaSistemskaOperacija {

    List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> getLista() {
        return lista;
    }

    @Override
    protected void validacija(Object objekat) throws Exception {
        if (!(objekat instanceof Angazovanje)) {
            throw new Exception("Pogresni parametri");

        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        lista = brokerBaze.vratiVise((OpstaDomenskaKlasa) object);
    }

}
