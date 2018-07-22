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
public class Profesor {
    private String pro_id;
    private String pro_nombre;
    private String pro_apellidop;
    private String pro_apellidom;
    private String pro_rut;
    private String pro_correo;
    private String pro_telefono;
    private int pro_disponibilidad;

    public int getPro_disponibilidad() {
        return pro_disponibilidad;
    }

    public void setPro_disponibilidad(int pro_disponibilidad) {
        this.pro_disponibilidad = pro_disponibilidad;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public String getPro_apellidop() {
        return pro_apellidop;
    }

    public void setPro_apellidop(String pro_apellidop) {
        this.pro_apellidop = pro_apellidop;
    }

    public String getPro_apellidom() {
        return pro_apellidom;
    }

    public void setPro_apellidom(String pro_apellidom) {
        this.pro_apellidom = pro_apellidom;
    }

    public String getPro_rut() {
        return pro_rut;
    }

    public void setPro_rut(String pro_rut) {
        this.pro_rut = pro_rut;
    }

    public String getPro_correo() {
        return pro_correo;
    }

    public void setPro_correo(String pro_correo) {
        this.pro_correo = pro_correo;
    }

    public String getPro_telefono() {
        return pro_telefono;
    }

    public void setPro_telefono(String pro_telefono) {
        this.pro_telefono = pro_telefono;
    }
    
}
