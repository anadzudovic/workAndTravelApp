/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rm;

import domen.OpstaDomenskaKlasa;
import domen.RadnoMesto;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOUnesiRM extends OpstaSistemskaOperacija{

    @Override
    protected void validacija(Object objekat) throws Exception {
       if(!(objekat instanceof RadnoMesto)){
       throw new Exception("Neodgovarajuc parametar!");
       
       }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        brokerBaze.sacuvaj((OpstaDomenskaKlasa) object);
    }
    
}
