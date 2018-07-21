/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.beans;

import BBDD.CONN;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import proColegio.modelos.Usuario;
import proColegio.request.Request;
import utilidades.DEF;
import utilidades.ENCRIPTAR;

/**
 *
 * @author Ghaos
 */
public class BNUsuario extends Request {

    public Usuario login(String usuario, String clave) throws SQLException, UnknownHostException {
        Usuario user = null;
        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "";
        cn = CONN.getConn();
        sql = "select usu_id, usu_nombre, usu_apellido,usu_password,usu_estado from " + BBDD.CONN.ESQUEMA_OP + "usuarios\n"
                + "where usu_usuario = '" + usuario + "'";
        try {
            stmt = cn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                user = new Usuario();

                user.setUsu_id(rs.getString("usu_id"));
                user.setUsu_nombre(rs.getString("usu_nombre"));
                user.setUsu_apellido(rs.getString("usu_apellido"));
                user.setUsu_password(rs.getString("usu_password"));
                user.setUsu_estado(rs.getInt("usu_estado"));
            }
            stmt.close();
        } finally {
            CONN.desconectar(cn);
        }
        return user;
    }

    public Usuario newPass(Usuario usuario) throws SQLException {
//        Usuario user = null;
        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        cn = CONN.getConn();

        String sql = "UPDATE " + CONN.ESQUEMA_OP + "usuarios\n"
                + "SET usu_password='" + ENCRIPTAR.toMD5(usuario.getUsu_password()) + "', usu_estado=" + DEF.ESTADO.ACTIVO.getValue() + "\n"
                + "WHERE usu_id='" + usuario.getUsu_id() + "'";

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            usuario.setUsu_estado((pst.executeUpdate() > 0) ? DEF.ESTADO.ACTIVO.getValue() : DEF.ESTADO.USERERROR.getValue());
            pst.close();

        } finally {
            CONN.desconectar(cn);
        }

        return usuario;
    }

    public Usuario resetPass(String usuario) throws SQLException {
        Usuario user = null;
        Connection cn = null;
        Statement stmt = null;
        ResultSet rs = null;
        cn = CONN.getConn();
        String sql = "select usu_id, usu_nombre, usu_apellido, usu_estado,usu_correo from " + CONN.ESQUEMA_OP + "usuarios\n"
                + "where usu_usuario = '" + usuario + "' ";
        try {
            stmt = cn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                user = new Usuario();
                user.setUsu_id(rs.getString("usu_id"));
                user.setUsu_nombre(rs.getString("usu_nombre"));
                user.setUsu_apellido(rs.getString("usu_apellido"));
                user.setUsu_correo(rs.getString("usu_correo"));
                user.setUsu_estado(rs.getInt("usu_estado"));
            }
            stmt.close();

            if (user != null && user.getUsu_estado() != DEF.ESTADO.INACTIVO.getValue()) {
                String uuid = UUID.randomUUID().toString();
                uuid = uuid.substring(0, 8);
//                System.out.println(uuid);

                sql = "UPDATE " + CONN.ESQUEMA_OP + "usuarios\n"
                        + "SET usu_password='" + ENCRIPTAR.toMD5("123456") + "', usu_estado=" + DEF.ESTADO.PASSRESET.getValue() + "\n"
                        + "WHERE usu_id='" + user.getUsu_id() + "'";

                try (PreparedStatement pst = cn.prepareStatement(sql)) {
                    user.setUsu_estado((pst.executeUpdate() > 0) ? DEF.ESTADO.PASSRESET.getValue() : DEF.ESTADO.USERERROR.getValue());
                    pst.close();
                }
            }

        } finally {
            CONN.desconectar(cn);
        }

        return user;
    }

    public BNUsuario(HttpServletRequest request) {
        super(request);
    }

}
