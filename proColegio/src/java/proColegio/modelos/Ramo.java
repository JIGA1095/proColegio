/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

import java.util.ArrayList;

/**
 *
 * @author Ghaos
 */
public class Ramo {
    private String ram_id;
    private String ram_nombre;
    private RamoTipo ram_tipo;
    private ArrayList<Curso> ram_curso;
    private boolean ram_isObligatorio;

    public String getRam_id() {
        return ram_id;
    }

    public void setRam_id(String ram_id) {
        this.ram_id = ram_id;
    }

    public String getRam_nombre() {
        return ram_nombre;
    }

    public void setRam_nombre(String ram_nombre) {
        this.ram_nombre = ram_nombre;
    }

    public RamoTipo getRam_tipo() {
        return ram_tipo;
    }

    public void setRam_tipo(RamoTipo ram_tipo) {
        this.ram_tipo = ram_tipo;
    }

    public ArrayList<Curso> getRam_curso() {
        return ram_curso;
    }

    public void setRam_curso(ArrayList<Curso> ram_curso) {
        this.ram_curso = ram_curso;
    }

    public boolean isRam_isObligatorio() {
        return ram_isObligatorio;
    }

    public void setRam_isObligatorio(boolean ram_isObligatorio) {
        this.ram_isObligatorio = ram_isObligatorio;
    }
    
    
}
