/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.Poslodavac;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabelePoslodavac extends AbstractTableModel{
    List<Poslodavac> lista;
    String[] kolone= new String[] {"Naziv kompanije","Grad","Kontakt telefon"};

    public List<Poslodavac> getLista() {
        return lista;
    }

    public ModelTabelePoslodavac() {
        lista= new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Poslodavac p = lista.get(rowIndex);
       switch(columnIndex){
           case 0 : return p.getNazivKompanije();
           case 1: return p.getGrad();
           case 2: return p.getKontaktTelefon();
           default: return null;
       }
    }
    public void ubaci(Poslodavac s) {
        if(!lista.contains(s) && s!=null){
        lista.add(s);
        lista.sort(Comparator.comparing(Poslodavac :: getNazivKompanije));
        fireTableDataChanged();
        }
    } 
}
