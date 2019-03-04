/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.student;

import domen.OpstaDomenskaKlasa;
import domen.Student;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOIzmeniStudenta extends OpstaSistemskaOperacija {

    public SOIzmeniStudenta() {
    }

    @Override
    protected void validacija(Object objekat) throws Exception {
        if(!(objekat instanceof Student)){
        throw new Exception("Neodgovarajuci parametar!");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        brokerBaze.izmeni((OpstaDomenskaKlasa) object);
    }
    
}
