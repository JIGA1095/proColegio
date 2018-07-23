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
    private TipoRamo ram_tiporamo;
    private TipoObligatorio ram_obligatorio;
    private int ram_isprofejefe;

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

    public TipoRamo getRam_tiporamo() {
        return ram_tiporamo;
    }

    public void setRam_tiporamo(TipoRamo ram_tiporamo) {
        this.ram_tiporamo = ram_tiporamo;
    }

    public TipoObligatorio getRam_obligatorio() {
        return ram_obligatorio;
    }

    public void setRam_obligatorio(TipoObligatorio ram_obligatorio) {
        this.ram_obligatorio = ram_obligatorio;
    }

    public int getRam_isprofejefe() {
        return ram_isprofejefe;
    }

    public void setRam_isprofejefe(int ram_isprofejefe) {
        this.ram_isprofejefe = ram_isprofejefe;
    }
    
    
}
