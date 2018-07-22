/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

import java.sql.Timestamp;

/**
 *
 * @author Diego
 */
public class HorarioProfesor {
    private String hpr_id;
    private int hpr_dia;
    private Timestamp hpr_inicio;
    private Timestamp hpr_fin;
    private int hpr_estado;
    private Profesor hpr_profesor;

    public String getHpr_id() {
        return hpr_id;
    }

    public void setHpr_id(String hpr_id) {
        this.hpr_id = hpr_id;
    }

    public int getHpr_dia() {
        return hpr_dia;
    }

    public void setHpr_dia(int hpr_dia) {
        this.hpr_dia = hpr_dia;
    }

    public Timestamp getHpr_inicio() {
        return hpr_inicio;
    }

    public void setHpr_inicio(Timestamp hpr_inicio) {
        this.hpr_inicio = hpr_inicio;
    }

    public Timestamp getHpr_fin() {
        return hpr_fin;
    }

    public void setHpr_fin(Timestamp hpr_fin) {
        this.hpr_fin = hpr_fin;
    }

    public int getHpr_estado() {
        return hpr_estado;
    }

    public void setHpr_estado(int hpr_estado) {
        this.hpr_estado = hpr_estado;
    }

    public Profesor getHpr_profesor() {
        return hpr_profesor;
    }

    public void setHpr_profesor(Profesor hpr_profesor) {
        this.hpr_profesor = hpr_profesor;
    }
    
}
