/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proColegio.beans;

import BBDD.CONN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import proColegio.modelos.TipoCurso;

/**
 *
 * @author Ghaos
 */
public class BNCurso {

    public ArrayList<TipoCurso> getTiposCursos() throws SQLException {
        ArrayList<TipoCurso> resp = new ArrayList();

        Connection cn;
        Statement stmt;
        ResultSet rs;

        String sql = "select tcu_id,tcu_descripcion from " + BBDD.CONN.ESQUEMA_OP + "tipo_curso";

        cn = CONN.getConn();
        try {
            stmt = cn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                resp.add(new TipoCurso(rs.getString("tcu_id"), rs.getString("tcu_descripcion")));
            }
            stmt.close();
        } finally {
            CONN.desconectar(cn);
        }

        return resp;
    }
}
