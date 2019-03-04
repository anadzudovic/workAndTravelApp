/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.angazovanje;

import domen.Angazovanje;
import domen.OpstaDomenskaKlasa;

import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOUnesiAngazovanje extends OpstaSistemskaOperacija{

   @Override
    protected void validacija(Object objekat) throws Exception {
       if(!(objekat instanceof Angazovanje)){
       throw new Exception("Neodgovarajuc parametar!");
       
       }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        brokerBaze.sacuvaj((OpstaDomenskaKlasa) object);
        Angazovanje a =(Angazovanje) object;
        a.getRadnoMesto().setPreostaoBrojIzvrsioca(a.getRadnoMesto().getPreostaoBrojIzvrsioca()-1);
        brokerBaze.izmeni(a.getRadnoMesto());
    }
    
}
