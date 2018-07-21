/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

/**
 *
 * @author Ghaos
 */
public class Profesor {
    private String pro_id;
    private String pro_nombre;
    private String pro_apellido;
    private boolean pro_isProfesorJefe;

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

    public String getPro_apellido() {
        return pro_apellido;
    }

    public void setPro_apellido(String pro_apellido) {
        this.pro_apellido = pro_apellido;
    }

    public boolean isPro_isProfesorJefe() {
        return pro_isProfesorJefe;
    }

    public void setPro_isProfesorJefe(boolean pro_isProfesorJefe) {
        this.pro_isProfesorJefe = pro_isProfesorJefe;
    }
    
    
    
    
}
