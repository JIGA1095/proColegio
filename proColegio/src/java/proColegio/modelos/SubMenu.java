/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Ghaos
 */
public class SubMenu {

    private String sub_id;
    private String sub_menu_id;
    private String sub_titulo;
    private String sub_url;
    private String sub_usuario;
    private String sub_icono;
    private Date sub_fechaCreaador;
    private Date sub_fechaModificador;
    private Tipo tipo;
    private ArrayList<SubMenu> subMenu;
    private String menu_men_id;
    private HashMap<String, SubMenu> hmSubMenu;

    public String getSub_menu_id() {
        return sub_menu_id;
    }

    public void setSub_menu_id(String sub_menu_id) {
        this.sub_menu_id = sub_menu_id;
    }

    public SubMenu(HashMap<String, SubMenu> hmSubMenu) {
        this.hmSubMenu = hmSubMenu;
    }

    public HashMap<String, SubMenu> getHmSubMenu() {
        return hmSubMenu;
    }

    public void setHmSubMenu(HashMap<String, SubMenu> hmSubMenu) {
        this.hmSubMenu = hmSubMenu;
    }

    public SubMenu() {
    }

    public SubMenu(String sub_id, String sub_titulo, String sub_url, String sub_icono) {
        this.sub_id = sub_id;
        this.sub_titulo = sub_titulo;
        this.sub_url = sub_url;
        this.sub_icono = sub_icono;
    }

    public String getMenu_men_id() {
        return menu_men_id;
    }

    public void setMenu_men_id(String menu_men_id) {
        this.menu_men_id = menu_men_id;
    }

    public ArrayList<SubMenu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(ArrayList<SubMenu> subMenu) {
        this.subMenu = subMenu;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_icono() {
        return sub_icono;
    }

    public void setSub_icono(String sub_icono) {
        this.sub_icono = sub_icono;
    }

    public String getSub_titulo() {
        return sub_titulo;
    }

    public void setSub_titulo(String sub_titulo) {
        this.sub_titulo = sub_titulo;
    }

    public String getSub_url() {
        return sub_url;
    }

    public void setSub_url(String sub_url) {
        this.sub_url = sub_url;
    }

    public String getSub_usuario() {
        return sub_usuario;
    }

    public void setSub_usuario(String sub_usuario) {
        this.sub_usuario = sub_usuario;
    }

    public Date getSub_fechaCreaador() {
        return sub_fechaCreaador;
    }

    public void setSub_fechaCreaador(Date sub_fechaCreaador) {
        this.sub_fechaCreaador = sub_fechaCreaador;
    }

    public Date getSub_fechaModificador() {
        return sub_fechaModificador;
    }

    public void setSub_fechaModificador(Date sub_fechaModificador) {
        this.sub_fechaModificador = sub_fechaModificador;
    }

}
