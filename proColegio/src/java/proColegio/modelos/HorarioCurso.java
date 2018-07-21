/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

import java.sql.Date;

/**
 *
 * @author Ghaos
 */
public class HorarioCurso {
    private String hcu_id;
    private Date hcu_horarioInicio;
    private Date hcu_horarioTermino;

    public String getHcu_id() {
        return hcu_id;
    }

    public void setHcu_id(String hcu_id) {
        this.hcu_id = hcu_id;
    }

    public Date getHcu_horarioInicio() {
        return hcu_horarioInicio;
    }

    public void setHcu_horarioInicio(Date hcu_horarioInicio) {
        this.hcu_horarioInicio = hcu_horarioInicio;
    }

    public Date getHcu_horarioTermino() {
        return hcu_horarioTermino;
    }

    public void setHcu_horarioTermino(Date hcu_horarioTermino) {
        this.hcu_horarioTermino = hcu_horarioTermino;
    }
    
    
    
}
