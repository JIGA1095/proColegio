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
public class Tipo {

    private String tip_id;
    private String tip_detalle;

    public Tipo(String tip_id, String tip_detalle) {
        this.tip_id = tip_id;
        this.tip_detalle = tip_detalle;
    }

    public Tipo(String tip_id) {
        this.tip_id = tip_id;
    }

    public Tipo() {
    }

    public String getTip_id() {
        return tip_id;
    }

    public void setTip_id(String tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip_detalle() {
        return tip_detalle;
    }

    public void setTip_detalle(String tip_detalle) {
        this.tip_detalle = tip_detalle;
    }

}
