/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rm;

import domen.OpstaDomenskaKlasa;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOVratiSvaRM extends OpstaSistemskaOperacija{
    List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> getLista() {
        return lista;
    }
    @Override
    protected void validacija(Object objekat) throws Exception {
       
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
     lista= brokerBaze.vratiSve((OpstaDomenskaKlasa) object);
    }
    
}
