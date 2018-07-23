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
public class RamoCurso {
    private String rcu_id;
    private Ramo ram_id;
    private Curso cur_id;
    private int rcu_horas;

    public String getRcu_id() {
        return rcu_id;
    }

    public void setRcu_id(String rcu_id) {
        this.rcu_id = rcu_id;
    }

    public Ramo getRam_id() {
        return ram_id;
    }

    public void setRam_id(Ramo ram_id) {
        this.ram_id = ram_id;
    }

    public Curso getCur_id() {
        return cur_id;
    }

    public void setCur_id(Curso cur_id) {
        this.cur_id = cur_id;
    }

    public int getRcu_horas() {
        return rcu_horas;
    }

    public void setRcu_horas(int rcu_horas) {
        this.rcu_horas = rcu_horas;
    }
    
}
