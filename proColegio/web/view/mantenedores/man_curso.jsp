<%-- 
    Document   : principal
    Created on : 21-07-2018, 12:15:46
    Author     : Ghaos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>

<html class="no-js" lang="en">
    <body>
        <div class="main-wrapper">
            <div class="app" id="app">
                <jsp:include page="../../seccion/header.jsp" />
                <jsp:include page="../../seccion/menu.jsp" />


                <article class="content cards-page">




                </article>


                <jsp:include page="../../seccion/footer.jsp" />
            </div>
        </div>
    </body>
    <script>
        function iniciarTipoCurso(select) {
//    iniciarAjax();
            $.ajax({
                url: 'SVLCurso',
                type: 'POST',
                dataType: 'json',
                data: {
                    accion: 'getTipoCurso'
                }, success: function (data, textStatus, jqXHR) {

                    console.log(data.datos);

                }, error: function (error) {
                    respuestaAjax("Error al guardar, contacte con proveedor", "error");
                }
            });
        }
    </script>

</html>
