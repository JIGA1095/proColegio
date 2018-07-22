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
public class CursoEspecifico {
    
    private String ces_id;
    private String ces_nombre;
    private Date ces_ano;
    private Curso ces_curso;
    private Profesor ces_profesorjefe;

    public Date getCes_ano() {
        return ces_ano;
    }

    public void setCes_ano(Date ces_ano) {
        this.ces_ano = ces_ano;
    }

    public Curso getCes_curso() {
        return ces_curso;
    }

    public void setCes_curso(Curso ces_curso) {
        this.ces_curso = ces_curso;
    }

    public Profesor getCes_profesorjefe() {
        return ces_profesorjefe;
    }

    public void setCes_profesorjefe(Profesor ces_profesorjefe) {
        this.ces_profesorjefe = ces_profesorjefe;
    }

    public String getCes_id() {
        return ces_id;
    }

    public void setCes_id(String ces_id) {
        this.ces_id = ces_id;
    }

    public String getCes_nombre() {
        return ces_nombre;
    }

    public void setCes_nombre(String ces_nombre) {
        this.ces_nombre = ces_nombre;
    }
    
}
