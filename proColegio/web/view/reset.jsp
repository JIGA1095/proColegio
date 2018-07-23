<%-- 
    Document   : reset
    Created on : 21-07-2018, 7:52:33
    Author     : Ghaos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <!-- Mirrored from modularcode.io/modular-admin-html/reset.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 Jul 2018 01:19:53 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Reset </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.html">
        <script src="template/js/jquery-2.1.3.min.js" type="text/javascript"></script>
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
        <!-- Theme initialization -->
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
        <script src="template/js/mensajes.js" ></script>
        <script src="template/messenger/js/messenger.min.js" ></script>
        <script src="template/messenger/js/messenger-theme-future.js"></script>
        <link href="template/messenger/css/messenger.css" rel="stylesheet" type="text/css"/>
        <link href="template/messenger/css/messenger-theme-future.css" rel="stylesheet" type="text/css"/>



    </head>
    <body>
        <div class="auth">
            <div class="auth-container">
                <div class="card" id="cardID">
                    <header class="auth-header">
                        <img src="img/logo.png" height="80px" width="200px" alt=""/>
                    </header>
                    <div class="auth-content">
                        <p class="text-center">Recuperar Contrase&ntilde;a</p>
                        <p class="text-muted text-center">
                            <small>Ingrese su correo para recuperar la contrase&ntilde;a.</small>
                        </p>
                        <div id="reset-form" >
                            <div class="form-group" id="usuarioGroup">
                                <label for="usuario">Usuario</label>
                                <input type="text" class="form-control underlined" name="usuario" id="usuario" placeholder="Ingrese su usuario de sistema" required> </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-block btn-primary" onclick="resetPass();" id="btnENV">Enviar</button>
                            </div>
                            <div class="form-group clearfix">
                                <a class="pull-left" href="#" onclick="go('login')" >Regresar a ingreso</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>


    <script>

        $(function () {
            $(document).ajaxStop($.unblockUI);

        });
        function resetPass() {
            iniciarAjax();
            $.ajax({
                url: 'usuario',
                type: 'POST',
                dataType: 'json',
                data: {
                    accion: 'reset',
                    usuario: $("#usuario").val()
                }, success: function (data, textStatus, jqXHR) {
                    switch (data.estado) {

                        case 404:
                            $("#usuarioGroup").find('span').remove()
                            $("#usuarioGroup").addClass("has-error");
                            $("#usuarioGroup").append("<span class='has-error' id='error'>Usuario no exite en sistema.</span>");
                            $('#cardID').animateCss('shake', function () {
                                $('#cardID').removeClass('animated shake');
                            });
                            break;

                        case 0:
                            $("#usuarioGroup").find('span').remove()
                            $("#usuarioGroup").addClass("has-error");
                            $("#usuarioGroup").append("<span class='has-error' id='error'>Usuario bloqueado por sistema.</span>");
                            $('#cardID').animateCss('shake', function () {
                                $('#cardID').removeClass('animated shake');
                            });
                            break;
                        case 99:
                            $("#usuarioGroup").find('span').remove()
                            $("#usuarioGroup").addClass("has-error");
                            $("#usuarioGroup").append("<span class='has-error' id='error'>Error al cambiar clave.</span>");
                            $('#cardID').animateCss('shake', function () {
                                $('#cardID').removeClass('animated shake');
                            });
                            break;
                        case 3:
                            respuestaAjax("Nueva contrase&ntilde;a generada", "success")
                            $("#btnENV").hide();
                            $("#usuarioGroup").find('span').remove()
                            $("#usuarioGroup").addClass("has-success");
                            $("#usuarioGroup").append("<span class='has-success' id='error'>Cambio correcto de contraseña.</span>");
                            $('#cardID').animateCss('pulse', function () {
                                $('#cardID').removeClass('animated pulse');
                            });
                            break;

                    }

                }, error: function (error) {
                    respuestaAjax("Error al guardar, contacte con proveedor", "error")
                }
            });

        }
    </script>
</html>
