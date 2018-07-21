/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BBDD.CONN;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import proColegio.beans.BNUsuario;
import proColegio.modelos.Usuario;
import utilidades.DEF;
import utilidades.ENCRIPTAR;

/**
 *
 * @author JIGA
 */
@WebServlet(name = "cmd", urlPatterns = {"/cmd"})
public class cmd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    BNUsuario BNU;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, UnknownHostException, JSONException {
        response.setContentType("text/html;charset=UTF-8");
        BNU = new BNUsuario(request);
        Usuario user = BNU.getUsuarioSession();
        if (user != null) {
            if (request.getParameter("to") != null) {
                String to = request.getParameter("to").toLowerCase();
                switch (to) {

                    case "login": {
                        
                        proccesLogIn(request, response);
                        break;
                    }
                    case "newPass": {
                        toPage(DEF.PAGINAS.NEWPASS, request, response);
                        break;
                    }
                    case "logout": {
                        proccesLogOut(request, response);
                        break;
                    }
                    case "home": {
                        request.getSession().setAttribute("menu", "Principal");
                        toPage(DEF.PAGINAS.PRINCIPAL, request, response);
                        break;
                    }
                    default: {
                        proccesLogIn(request, response);
                        break;
                    }
                }
                return;
            } else {
                toPage(DEF.PAGINAS.LOGIN, request, response);
                return;
            }
        } else if (request.getParameter(
                "to") != null && request.getParameter("to").equalsIgnoreCase("login")) {
            //intento de log
            proccesLogIn(request, response);

        } else if (request.getParameter(
                "to") != null && request.getParameter("to").equalsIgnoreCase("reset")) {
            irReset(request, response);
        } else {
            toPage(DEF.PAGINAS.LOGIN, request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void irReset(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        toPage(DEF.PAGINAS.RESET, request, response);
    }

    private void toPage(DEF.PAGINAS page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try {
            if (page == null) {
                page = DEF.PAGINAS.ERROR_404;
            } else if (request == null) {
                page = DEF.PAGINAS.ERROR_500;
            } else if (response == null) {
                page = DEF.PAGINAS.ERROR_500;
            }
            RequestDispatcher dist = getServletContext().getRequestDispatcher(page.getValue() + ".jsp");
            dist.forward(request, response);
        } catch (IOException ioe) {
//            System.out.println("ERROR");
        } catch (NullPointerException npe) {
//             System.out.println("ERROR");
        }
    }

    public void proccesLogIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, JSONException {

        String username = request.getParameter("username") != null ? request.getParameter("username") : "";
        String password = request.getParameter("password") != null ? request.getParameter("password") : "";
        String Epass = ENCRIPTAR.toMD5(password);

        Usuario user = null;

        try {
            user = BNU.login(username, Epass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
            if (Epass.equalsIgnoreCase(user.getUsu_password())) {

                switch (user.getUsu_estado()) {

                    case 0:
                        request.getSession().setAttribute("usuario", username);
                        request.getSession().setAttribute("estado", "b");
                        BNU.setUsuarioSession(null);
                        toPage(DEF.PAGINAS.LOGIN, request, response);
                        break;
                    case 1:
                        BNU.setUsuarioSession(user);
                        request.getSession().setAttribute("menu", "Principal");
                        toPage(DEF.PAGINAS.PRINCIPAL, request, response);
                        break;
                    case 3:

                        BNU.setUsuarioSession(user);
                        toPage(DEF.PAGINAS.NEWPASS, request, response);

                        break;
                    default:
                        request.getSession().setAttribute("usuario", username);
                        request.getSession().setAttribute("estado", "b");
                        BNU.setUsuarioSession(null);
                        toPage(DEF.PAGINAS.LOGIN, request, response);
                        break;
                }

            } else {
                request.getSession().setAttribute("usuario", username);
                request.getSession().setAttribute("estado", "p");
                BNU.setUsuarioSession(null);
                toPage(DEF.PAGINAS.LOGIN, request, response);
            }

        } else {
            request.getSession().setAttribute("usuario", username);
            request.getSession().setAttribute("estado", "u");
            BNU.setUsuarioSession(user);
            toPage(DEF.PAGINAS.LOGIN, request, response);
        }
    }

    public void proccesLogOut(HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, SQLException {

        try {
            if (request.getSession(false) != null) {

                request.getSession(false).invalidate();
                BNU.setUsuarioSession(null);
            }
        } catch (Exception e) {
        }
        toPage(DEF.PAGINAS.LOGIN,
                request,
                response
        );
    }

}
