/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.poslodavac;

import domen.OpstaDomenskaKlasa;
import domen.Poslodavac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOUnesiPoslodavca extends OpstaSistemskaOperacija {

    @Override
    protected void validacija(Object objekat) throws Exception {
        if (!(objekat instanceof Poslodavac)) {
            throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        brokerBaze.sacuvaj((OpstaDomenskaKlasa) object);
    }
}
