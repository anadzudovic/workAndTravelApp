/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabeleStudent extends AbstractTableModel {

    List<Student> lista;

    public List<Student> getLista() {
        return lista;
    }
    String kolone[] = new String[]{"Ime i prezime", "Datum rodjenja", "Kontakt telefon", "Elektronska posta", "Adresa"};

    public ModelTabeleStudent(List<Student> lista) {
        this.lista = lista;
    }

    public ModelTabeleStudent() {
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
        Student s = lista.get(rowIndex);
        if(s!=null){
        switch (columnIndex) {
            case 0:
                return s.getImeIPrezime();
            case 1:
                return s.getDatumRodjenja();
            case 2:
                return s.getKontaktTelefon();
            case 3:
                return s.getElektronskaPosta();
            case 4:
                return s.getAdresa();
            default:
                return null;

        }
        }
        return null;

    }

    public void ubaci(Student s) {
        if(!lista.contains(s)){
        lista.add(s);
        lista.sort(Comparator.comparing(Student  :: getImeIPrezime));
        fireTableDataChanged();
        }
    }
}
