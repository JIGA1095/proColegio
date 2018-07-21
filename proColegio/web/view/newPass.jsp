<%-- 
    Document   : newPass
    Created on : 21-07-2018, 10:47:49
    Author     : Ghaos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Nueva Contrase&ntilde;a </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="template/js/jquery-2.1.3.min.js" type="text/javascript"></script>
        <link rel="apple-touch-icon" href="apple-touch-icon.html">
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
        <script src="template/js/mensajes.js" type="text/javascript"></script>

    </head>
    <body>
        <div class="auth">
            <div class="auth-container">
                <div class="card" id="cardID">
                    <header class="auth-header">
                        <img src="img/logo.png" height="80px" width="200px" alt=""/>
                    </header>
                    <div class="auth-content">
                        <p class="text-center">Ingrese la nueva contrase&ntilde;a</p>
                        <div id="signup-form" >
                            <!--<label for="password">Password</label>-->
                            <div class="form-group">
                                <label class="control-label">Nueva contrase&ntilde;a</label>
                                <input id="clv1" type="password" class="form-control underlined" placeholder="Nueva contrase&ntilde;a"> </div>
                            <div class="form-group" id="passwordGroup">
                                <label class="control-label">Repita contrase&ntilde;a</label>
                                <input id="clv2" type="password" class="form-control underlined" placeholder="Repita contrase&ntilde;a"> </div>

                            <div class="form-group">
                                <button type="button" onclick="validarClave()" class="btn btn-block btn-primary">Actualizar</button>
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

        function validarClave() {
            var clv1 = $("#clv1").val();
            var clv2 = $("#clv2").val();
            if (clv1 == clv2) {
                iniciarAjax();
                $.ajax({
                    url: 'usuario',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        accion: 'newPass',
                        clave: $("#clv1").val()
                    }, success: function (data, textStatus, jqXHR) {
                        console.log(data.estado);

                        switch (data.estado) {
                            case 200:
                                go('home');
                                break;


                            case 500:
                                $("#passwordGroup").find('span').remove()
                                $("#passwordGroup").addClass("has-error");
                                $("#passwordGroup").append("<span class='has-error' id='error'>Error al cambiar contrase&ntilde;as, intente denuevo.</span>");
                                $('#cardID').animateCss('shake', function () {
                                    $('#cardID').removeClass('animated shake');
                                });
                                break;
                        }

                    }, error: function (error) {
                        respuestaAjax("Error al guardar, contacte con proveedor", "error")
                    }
                });




            } else {
                $("#passwordGroup").find('span').remove()
                $("#passwordGroup").addClass("has-error");
                $("#passwordGroup").append("<span class='has-error' id='error'>Las contrase&ntilde;as no coinciden.</span>");
                $('#cardID').animateCss('shake', function () {
                    $('#cardID').removeClass('animated shake');
                });
            }

        }
    </script>

</html>
