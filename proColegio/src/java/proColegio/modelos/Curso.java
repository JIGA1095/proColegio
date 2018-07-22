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
public class Curso {
    private String cur_id;
    private String cur_nombre;
    private TipoCurso cur_tipo;

    public TipoCurso getCur_tipo() {
        return cur_tipo;
    }

    public void setCur_tipo(TipoCurso cur_tipo) {
        this.cur_tipo = cur_tipo;
    }
    
    
    public String getCur_id() {
        return cur_id;
    }

    public void setCur_id(String cur_id) {
        this.cur_id = cur_id;
    }

    public String getCur_nombre() {
        return cur_nombre;
    }

    public void setCur_nombre(String cur_nombre) {
        this.cur_nombre = cur_nombre;
    }
    
    
}
