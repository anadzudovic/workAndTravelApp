/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.student;

import domen.OpstaDomenskaKlasa;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOVratiOdredjeneStudente extends OpstaSistemskaOperacija {
    private List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> getLista() {
        return lista;
    }
    public SOVratiOdredjeneStudente() {
        lista= new ArrayList<>();
    }

    @Override
    protected void validacija(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        lista=brokerBaze.vratiVise((OpstaDomenskaKlasa) object);
    }
    
}
