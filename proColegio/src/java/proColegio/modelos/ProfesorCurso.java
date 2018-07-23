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
public class ProfesorCurso {
    private String pcu_id;
    private Profesor pro_id;
    private Curso cur_id;

    public String getPcu_id() {
        return pcu_id;
    }

    public void setPcu_id(String pcu_id) {
        this.pcu_id = pcu_id;
    }

    public Profesor getPro_id() {
        return pro_id;
    }

    public void setPro_id(Profesor pro_id) {
        this.pro_id = pro_id;
    }

    public Curso getCur_id() {
        return cur_id;
    }

    public void setCur_id(Curso cur_id) {
        this.cur_id = cur_id;
    }
    
    
    
}
