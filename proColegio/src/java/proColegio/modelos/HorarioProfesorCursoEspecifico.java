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
public class HorarioProfesorCursoEspecifico {
    private String hpc_id;
    private int hpc_dia;
    private Timestamp hpc_inicio;
    private Timestamp hpc_fin;
    private int hpc_estado;
    private Profesor hpc_profesor;
    private CursoEspecifico hpc_cursoespecifico;

    public String getHpc_id() {
        return hpc_id;
    }

    public void setHpc_id(String hpc_id) {
        this.hpc_id = hpc_id;
    }

    public int getHpc_dia() {
        return hpc_dia;
    }

    public void setHpc_dia(int hpc_dia) {
        this.hpc_dia = hpc_dia;
    }

    public Timestamp getHpc_inicio() {
        return hpc_inicio;
    }

    public void setHpc_inicio(Timestamp hpc_inicio) {
        this.hpc_inicio = hpc_inicio;
    }

    public Timestamp getHpc_fin() {
        return hpc_fin;
    }

    public void setHpc_fin(Timestamp hpc_fin) {
        this.hpc_fin = hpc_fin;
    }

    public int getHpc_estado() {
        return hpc_estado;
    }

    public void setHpc_estado(int hpc_estado) {
        this.hpc_estado = hpc_estado;
    }

    public Profesor getHpc_profesor() {
        return hpc_profesor;
    }

    public void setHpc_profesor(Profesor hpc_profesor) {
        this.hpc_profesor = hpc_profesor;
    }

    public CursoEspecifico getHpc_cursoespecifico() {
        return hpc_cursoespecifico;
    }

    public void setHpc_cursoespecifico(CursoEspecifico hpc_cursoespecifico) {
        this.hpc_cursoespecifico = hpc_cursoespecifico;
    }
    
}
