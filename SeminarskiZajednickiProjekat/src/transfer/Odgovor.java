/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import transfer.util.StatusOdgovora;

/**
 *
 * @author User
 */
public class Odgovor implements Serializable {

    private StatusOdgovora status;
    private Object podaci;
    private Object greska;

    public Odgovor(StatusOdgovora status, Object podaci, Object greska) {
        this.status = status;
        this.podaci = podaci;
        this.greska = greska;
    }

    public Odgovor() {
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public Object getGreska() {
        return greska;
    }

    public void setGreska(Object greska) {
        this.greska = greska;
    }

    @Override
    public String toString() {
        return "Odgovor{" + "status=" + status + ", podaci=" + podaci + ", greska=" + greska + '}';
    }

}
