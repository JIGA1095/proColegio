/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

/**
 *
 * @author Diego
 */
public class TipoCurso {
    private String tcu_id;
    private String tcu_descripcion;

    public TipoCurso(String tcu_id, String tcu_descripcion) {
        this.tcu_id = tcu_id;
        this.tcu_descripcion = tcu_descripcion;
    }

    public String getTcu_id() {
        return tcu_id;
    }

    public void setTcu_id(String tcu_id) {
        this.tcu_id = tcu_id;
    }

    public String getTcu_descripcion() {
        return tcu_descripcion;
    }

    public void setTcu_descripcion(String tcu_descripcion) {
        this.tcu_descripcion = tcu_descripcion;
    }
    
    
}
