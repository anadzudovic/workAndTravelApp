/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TipRadnogMesta implements OpstaDomenskaKlasa,Serializable{
    private int sifraTipRadnogmesta;
    private String nazivTipaRadnogMesta;

    public TipRadnogMesta() {
    }

    public TipRadnogMesta(int sifraTipRadnogmesta, String nazivTipaRadnogMesta) {
        this.sifraTipRadnogmesta = sifraTipRadnogmesta;
        this.nazivTipaRadnogMesta = nazivTipaRadnogMesta;
    }

    public String getNazivTipaRadnogMesta() {
        return nazivTipaRadnogMesta;
    }

    public void setNazivTipaRadnogMesta(String nazivTipaRadnogMesta) {
        this.nazivTipaRadnogMesta = nazivTipaRadnogMesta;
    }

    public int getSifraTipRadnogmesta() {
        return sifraTipRadnogmesta;
    }

    public void setSifraTipRadnogmesta(int sifraTipRadnogmesta) {
        this.sifraTipRadnogmesta = sifraTipRadnogmesta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipRadnogMesta other = (TipRadnogMesta) obj;
        if (!Objects.equals(this.sifraTipRadnogmesta, other.sifraTipRadnogmesta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivTipaRadnogMesta ;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "TipRadnogMesta";
    }

 


    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) {
        List<OpstaDomenskaKlasa> lista= new ArrayList<>();
        try {
            while(rs.next()){
                int id = rs.getInt(1);
                String naziv= rs.getString(2);
                TipRadnogMesta rm= new TipRadnogMesta(id, naziv);
                lista.add(rm);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipRadnogMesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
