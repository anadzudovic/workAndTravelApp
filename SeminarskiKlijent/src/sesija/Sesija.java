/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Agent;
import domen.Angazovanje;
import domen.OpstaDomenskaKlasa;
import domen.RadnoMesto;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class Sesija {

    private static Sesija instanca;
    private Agent agent;
    private final Map<String, OpstaDomenskaKlasa> mapa;
    List<RadnoMesto> radnaMesta;
    private List<Angazovanje> angazovanja;

    public List<RadnoMesto> getRadnaMesta() {
        return radnaMesta;
    }

    public void setRadnaMesta(List<RadnoMesto> radnaMesta) {
        this.radnaMesta = radnaMesta;
    }

    public static Sesija getInstanca() {
        if (instanca == null) {
            instanca = new Sesija();
        }
        return instanca;
    }

    private Sesija() {

        mapa = new HashMap<>();
        radnaMesta= new LinkedList<>();
        angazovanja= new LinkedList<>();
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Map<String, OpstaDomenskaKlasa> getMapa() {
        return mapa;
    }

    public List<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

   
}
