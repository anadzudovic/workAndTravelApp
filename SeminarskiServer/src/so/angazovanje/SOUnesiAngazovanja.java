/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.angazovanje;

import domen.Angazovanje;
import domen.OpstaDomenskaKlasa;
import java.util.LinkedList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author User
 */
public class SOUnesiAngazovanja extends OpstaSistemskaOperacija {

    List<Angazovanje> lista = new LinkedList<Angazovanje>();

    @Override
    protected void validacija(Object objekat) throws Exception {

    }

    @Override
    protected void izvrsi(Object object) throws Exception {

        lista = (List<Angazovanje>) object;
        for (Angazovanje a : lista) {
            brokerBaze.sacuvaj((OpstaDomenskaKlasa) a);
//            a.getRadnoMesto().setPreostaoBrojIzvrsioca(a.getRadnoMesto().getPreostaoBrojIzvrsioca() - 1);
            brokerBaze.izmeni(a.getRadnoMesto());
        }
    }

}
