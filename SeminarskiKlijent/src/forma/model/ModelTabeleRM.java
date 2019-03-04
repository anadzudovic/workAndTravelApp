/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.RadnoMesto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabeleRM extends AbstractTableModel {

    List<RadnoMesto> lista;
    
    String kolone[] = new String[]{"Tip", "Poslodavac", "Datum od", "Datum do", "Satnica", "Napojnica", "Preostao br izvrsioca"};

    public List<RadnoMesto> getLista() {
        return lista;
    }

    public ModelTabeleRM() {
        lista = new ArrayList<>();
        
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
        RadnoMesto r = lista.get(rowIndex);
        if (r != null) {
            switch (columnIndex) {
                case 0:
                    return r.getTipRadnogMesta();
                case 1:
                    return r.getPoslodavac();
                case 2:
                    return r.getDatumOd();
                case 3:
                    return r.getDatumDo();
                case 4:
                    return r.getSatnica();
                case 5:
                    return r.isMogucaNapojnica();
                case 6:
                    return r.getPreostaoBrojIzvrsioca();

            }

        }
        return null;
    }

    public void ubaci(RadnoMesto s) {
        if (!lista.contains(s) && s != null) {
            lista.add(s);
            lista.sort(Comparator.comparing(RadnoMesto::getSatnica).reversed());
            fireTableDataChanged();

        }
    }

  
}
