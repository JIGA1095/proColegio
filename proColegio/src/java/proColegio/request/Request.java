/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import proColegio.modelos.Usuario;
import utilidades.DEF;

/**
 *
 * @author JIGA
 */
public class Request {

    HttpServletRequest request = null;

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * metodo que retorna un objeto dentro de la session del usuario activo
     *
     * @param a String con el nombre del objto a buscar
     * @return null si el objeto no se encuentra
     */
    public Object getAttribute(String a) {
        return getSession().getAttribute(a);
    }

    public void setAttribute(String s, Object a) {
        getSession().setAttribute(s, a);
    }

    public Request(HttpServletRequest request) {
        this.request = request;
    }

    public Usuario getUsuarioSession() {
        return (Usuario) getSession().getAttribute(DEF.SESSION.USUARIO.name());
    }

    public Object getAttribute(DEF.SESSION ATRIBUTO) {
        return getSession().getAttribute(ATRIBUTO.name());
    }

    public boolean setAttribute(DEF.SESSION ATRIBUTO, Object VALOR) {
        getSession().setAttribute(ATRIBUTO.name(), VALOR);
        return true;
    }

    public boolean setUsuarioSession(Usuario usuario) {
        setAttribute(DEF.SESSION.USUARIO, null);
        setAttribute(DEF.SESSION.USUARIO, usuario);
        return true;
    }

}
