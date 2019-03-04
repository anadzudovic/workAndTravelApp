/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma.model;

import domen.Agent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabele extends AbstractTableModel {

    List<Agent> agenti;
    String header[] = new String[]{"Ime i prezime", "Korisnicko ime"};

    public ModelTabele(List<Agent> agenti) {
        this.agenti = agenti;
    }

    public ModelTabele() {
        agenti = new ArrayList<Agent>();

    }

    @Override
    public int getRowCount() {
        return agenti.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;

    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Agent a = agenti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getImeIPrezime();
            case 1:
                return a.getKorisnickoIme();
            default:
                return "N/A";

        }
    }

    public Agent izbaciRed(int index) {
        Agent a = agenti.get(index);
        agenti.remove(index);
        fireTableDataChanged();
        return a;
        
    }

    public void dodajAgenta(Agent a) {
        agenti.add(a);
        fireTableDataChanged();
    }

    public void izbaciAgenta(Agent agent) {
        agenti.remove(agent);
        fireTableDataChanged();
    }

}
