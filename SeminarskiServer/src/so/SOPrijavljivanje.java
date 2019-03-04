/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Agent;
import domen.OpstaDomenskaKlasa;

/**
 *
 * @author User
 */
public class SOPrijavljivanje extends OpstaSistemskaOperacija{
    private Agent a;
    @Override
    protected void validacija(Object objekat) throws Exception {
        if(!(objekat instanceof Agent)){
        throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
       a= (Agent) brokerBaze.vratiJednog((OpstaDomenskaKlasa) object);
    }

    public Agent getA() {
        return a;
    }

    public void setA(Agent a) {
        this.a = a;
    }
    
}
