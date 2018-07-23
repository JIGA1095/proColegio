/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

import java.sql.Timestamp;


/**
 *
 * @author Ghaos
 */
public class HorarioCursoEspecifico {
    private String hcu_id;
    private int hcu_dia;
    private Timestamp hcu_inicio;
    private Timestamp hcu_fin;
    private int hcu_estado;
    private CursoEspecifico hcu_cursoespecifico;

    public String getHcu_id() {
        return hcu_id;
    }

    public void setHcu_id(String hcu_id) {
        this.hcu_id = hcu_id;
    }

    public int getHcu_dia() {
        return hcu_dia;
    }

    public void setHcu_dia(int hcu_dia) {
        this.hcu_dia = hcu_dia;
    }

    public Timestamp getHcu_inicio() {
        return hcu_inicio;
    }

    public void setHcu_inicio(Timestamp hcu_inicio) {
        this.hcu_inicio = hcu_inicio;
    }

    public Timestamp getHcu_fin() {
        return hcu_fin;
    }

    public void setHcu_fin(Timestamp hcu_fin) {
        this.hcu_fin = hcu_fin;
    }

    public int getHcu_estado() {
        return hcu_estado;
    }

    public void setHcu_estado(int hcu_estado) {
        this.hcu_estado = hcu_estado;
    }

    public CursoEspecifico getHcu_cursoespecifico() {
        return hcu_cursoespecifico;
    }

    public void setHcu_cursoespecifico(CursoEspecifico hcu_cursoespecifico) {
        this.hcu_cursoespecifico = hcu_cursoespecifico;
    }
        
}
