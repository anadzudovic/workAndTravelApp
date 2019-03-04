/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.grad;

import domen.OpstaDomenskaKlasa;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOVratiSveGradove extends OpstaSistemskaOperacija {

    private List<OpstaDomenskaKlasa> gradovi;

    @Override
    protected void validacija(Object objekat) throws Exception {

    }

    @Override
    protected void izvrsi(Object object) throws Exception {
      gradovi=brokerBaze.vratiSve((OpstaDomenskaKlasa) object);
    }

    public List<OpstaDomenskaKlasa> getGradovi() {
        return gradovi;
    }

   
}
