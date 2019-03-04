/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.Angazovanje;
import domen.RadnoMesto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabeleAngazovanje extends AbstractTableModel {

    List<Angazovanje> lista;

    public List<Angazovanje> getLista() {
        return lista;
    }
    String[] kolone = new String[]{"Poslodavac", "Student", "Radno mesto", " Datum od", " Datum do", "Status ugovora"};

    public ModelTabeleAngazovanje() {
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
        Angazovanje a = lista.get(rowIndex);
        if (a != null) {
            switch (columnIndex) {
                case 0:
                    return a.getRadnoMesto().getPoslodavac().getNazivKompanije();
                case 1:
                    return a.getStudent().getImeIPrezime();
                case 2:
                    return a.getRadnoMesto().getTipRadnogMesta().getNazivTipaRadnogMesta();
                case 3:
                    return a.getRadnoMesto().getDatumOd();
                case 4:
                    return a.getRadnoMesto().getDatumDo();
                case 5:
                    return a.getStatusUgovora().toString();
                default:
                    return null;
            }

        } else {
            return null;
        }
    }

    public void ubaci(Angazovanje s) {
        if (!lista.contains(s) && s != null) {
            lista.add(s);
            lista.sort(Comparator.comparing(Angazovanje::getStatusUgovora));

            fireTableDataChanged();

        }

    }
    public void ubaciUTabelu(Angazovanje s){
     lista.add(s);
            lista.sort(Comparator.comparing(Angazovanje::getStatusUgovora));

            fireTableDataChanged();

        
    }

    public void izbaci(Angazovanje a) {
        lista.remove(a);
        fireTableDataChanged();

    }

}
