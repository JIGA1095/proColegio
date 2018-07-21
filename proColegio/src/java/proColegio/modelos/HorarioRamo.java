/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

import java.util.Date;

/**
 *
 * @author Ghaos
 */
public class HorarioRamo {
    private String hra_id;
    private Date hra_horarioInicio;
    private Date hra_horarioTermino;
    private Profesor hra_profesor;
    private CursoEspecifico hra_cursoEspecifico;

    public String getHra_id() {
        return hra_id;
    }

    public void setHra_id(String hra_id) {
        this.hra_id = hra_id;
    }

    public Date getHra_horarioInicio() {
        return hra_horarioInicio;
    }

    public void setHra_horarioInicio(Date hra_horarioInicio) {
        this.hra_horarioInicio = hra_horarioInicio;
    }

    public Date getHra_horarioTermino() {
        return hra_horarioTermino;
    }

    public void setHra_horarioTermino(Date hra_horarioTermino) {
        this.hra_horarioTermino = hra_horarioTermino;
    }

    public Profesor getHra_profesor() {
        return hra_profesor;
    }

    public void setHra_profesor(Profesor hra_profesor) {
        this.hra_profesor = hra_profesor;
    }

    public CursoEspecifico getHra_cursoEspecifico() {
        return hra_cursoEspecifico;
    }

    public void setHra_cursoEspecifico(CursoEspecifico hra_cursoEspecifico) {
        this.hra_cursoEspecifico = hra_cursoEspecifico;
    }
    
    
    
    
}
