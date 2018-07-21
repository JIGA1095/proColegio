/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.servlet;

import controlador.cmd;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author Ghaos
 */
@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class usuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, JSONException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        BNUsuario BNU = new BNUsuario(request);
        JSONObject json = new JSONObject();
        Usuario user = BNU.getUsuarioSession();
        switch (accion) {
            case "reset":
                user = BNU.resetPass(request.getParameter("usuario"));

                if (user != null) {

                    switch (user.getUsu_estado()) {
                        case 0:
                            json.put("estado", 0);
                            break;
                        case 3:
                            json.put("estado", 3);
                            break;
                        case 99:
                            json.put("estado", 99);
                            break;
                    }

                } else {
                    json.put("estado", 404);
                }

                response.getWriter().write(json.toString());
                break;

            case "newPass":

                Usuario usu = BNU.getUsuarioSession();
                System.out.println(usu.getUsu_id());
                usu.setUsu_password(request.getParameter("clave"));

                usu = BNU.newPass(usu);

                if (usu.getUsu_estado() != DEF.ESTADO.USERERROR.getValue()) {
//                    toPage(DEF.PAGINAS.PRINCIPAL, request, response);
                    json.put("estado", 200);
                } else {
                    json.put("estado", 500);

                }
                response.getWriter().write(json.toString());

                break;

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
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
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
}
