/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




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
            respuestaAjax("Error al guardar, contacte con proveedor", "error")
        }
    });
}