<%-- 
    Document   : index
    Created on : 21-07-2018, 1:23:52
    Author     : Ghaos
--%>
<%@page import="java.util.Objects"%>
<%@page import="utilidades.DEF"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>

<%@page import="proColegio.modelos.Usuario"%>
<%@page import="proColegio.beans.BNUsuario"%>
<%
    BNUsuario BNU = new BNUsuario(request);
    Usuario usu = BNU.getUsuarioSession();
%>
<html class="no-js" lang="en">
    <head>    
        <title> Pro_Colegio </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.html">
        <script src="template/js/jquery-2.1.3.min.js" type="text/javascript"></script>
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
        <script>
            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
                    {};
            var themeName = themeSettings.themeName || '';
            if (themeName)
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
            } else
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
            }
        </script>
        <script src="template/js/jquery.blockUI.js" type="text/javascript"></script>
        <script src="template/js/adminFile.js" type="text/javascript"></script>

    </head>
    <body>
        <div class="auth">
            <div class="auth-container">
                <div class="card" id="cardID">
                    <header class="auth-header">
                        <img src="img/logo.png" height="80px" width="200px" alt=""/>
                    </header>
                    <div class="auth-content">
                        <p class="text-center">INICIO DE SESI&Oacute;N</p>
                        <form id="login-form" class="no-margin" action="cmd" method="post">
                            <input type="hidden" name="to" value="login">
                            <div class="form-group" id="usernameGroup">
                                <label for="username">Nombre de Usuario</label>
                                <input type="text" class="form-control underlined" name="username" id="username" placeholder="Nombre de Usuario" required> </div>
                            <div class="form-group" id="passwordGroup">
                                <label for="password">Contrase&ntilde;a</label>
                                <input type="password" class="form-control underlined" name="password" id="password" placeholder="Contrase&ntilde;a" required> </div>
                            <div class="form-group">
                                
                                <a href="#" onclick="go('reset')" class="forgot-btn pull-right">Recuperar Contrase&ntilde;a</a>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-block btn-primary">Iniciar Sesi&oacute;n</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
    </body>


    <script>
        $(function () {
            $(document).ajaxStop($.unblockUI);

            switch ("<%= (String) session.getAttribute("estado")%>") {
                case "p":
                    $("#username").val("<%= (String) session.getAttribute("usuario")%>")
                    $("#passwordGroup").addClass("has-error");
                    $("#passwordGroup").append("<span class='has-error'>Contrase&ntilde;a no corresponde.</span>");
                    $('#cardID').addClass('animated shake');
                    break;
                case "u":
                    $("#username").val("<%= (String) session.getAttribute("usuario")%>")
                    $("#usernameGroup").addClass("has-error");
                    $("#usernameGroup").append("<span class='has-error'>Usuario no encontrado en sistema.</span>");
                    $('#cardID').addClass('animated shake');
                    break;
                case "b":
                    $("#username").val("<%= (String) session.getAttribute("usuario")%>")
                    $("#usernameGroup").addClass("has-error");
                    $("#usernameGroup").append("<span class='has-error'>Usuario bloqueado por sistema.</span>");
                    $('#cardID').addClass('animated shake');
                    break;
            }

        });

    </script>
</html>
