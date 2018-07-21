/**
 * ADMIN LTE - Responsive Admin Theme
 *  *
 */


/*$(window).bind("load", function () {
 // Remove splash screen after load
 loader(false);
 });*/

var loader = function (estado) {
    if (estado) {
        $('.splash').css('display', 'initial');
    } else {
        $('.splash').css('display', 'none');
    }
};

/**
 * Metodo que redirecciona la pagina
 * @param {Strig} page string con el comando a ejecutar
 * @param {JSON} param Json con los parametros a enviar en formato [{"id":"x","val":"x"},{"id":"x","val":"x"}]
 */
function go(page, param, target, cmd) {
    var form;
    var acc;
    var metod = 'POST';
    var Cmd = cmd || 'cmd';
    var formId = 'Redirect';
    if (document.getElementById(formId) === undefined || document.getElementById(formId) === null) {
        form = document.createElement('form');
        form.id = formId;
        form.action = Cmd;
        form.method = metod;
        document.body.appendChild(form);
    } else {

        form = document.getElementById(formId);
        form.action = Cmd;
        form.method = metod;
    }

    if (target != undefined && target == true) {
        form.target = '_blank';
    } else {
        form.removeAttribute("target");
    }

    if (document.getElementById('to') === undefined || document.getElementById('to') === null) {
        acc = document.createElement('input');
        acc.id = 'to';
        acc.name = 'to';
        acc.type = 'hidden';
        form.appendChild(acc);
    } else {
        acc = document.getElementById('to');
        acc.name = 'to';
        acc.type = 'hidden';
    }
    if ((param !== undefined && param !== null) && param.length > 0) {
        addParams(param, form);
    }
    acc.value = page;
    form.submit();
}
;
/**
 * Metodo que agrega parametros para enviar a un formulario html
 * @param {JSON} params
 * @param {HTMLFORM} form
 * @returns {undefined}
 */
function addParams(params, form) {
    var nelem;
    if (params.length > 0) {
        $.each(params, function (i, field) {


            nelem = $(form).find("[name='" + field.id + "']").is('input') ? document.getElementById(field.id) : document.createElement('input');
            nelem.type = 'hidden';
            nelem.id = field.id;
            nelem.name = field.id;
            nelem.value = field.val;
            form.appendChild(nelem);
        });
    }
}
;

function logOut() {
    loader(true);
    go("logout");
}

/**
 * 
 * @param {String} url
 * @param {type} data
 * @param {type} async
 * @param {type} st_200
 * @param {type} st_404
 * @param {type} st_500
 * @param {type} metod
 * @param {type} st_301
 * @param {type} mime
 * @returns {returndata|undefined}La diferencia  con el getJson solo es que este no verifica la session
 */
function getJson(url, data, async, st_200, st_500, st_404, st_301, metod, mime) {
    var contenido;
    $.ajax({
        url: url,
        data: data,
        type: metod || "POST",
        async: async || false,
        'beforeSend': function (xhr) {
            try {
                if (mime === undefined || mime === true) {
                    xhr.overrideMimeType('text/html; charset=iso-8859-1');
                }
            } catch (e) {
                console.log(e.message);
            }
        },
        statusCode: {
            200: function (returndata) {
                try {
                    returndata = $.parseJSON(returndata);
                } catch (err) {
                    try {
                        returndata = JSON.parse(returndata);
                    } catch (err) {
                    }

                }
                if (st_200 != undefined) {
                    st_200(returndata);
                }
                contenido = returndata;

            },
            404: function (xhr, status, error) {
                if (st_404 != undefined) {
                    st_404(xhr, status, error);
                } else {
                    console.log("Recurso no encontrado");
                }
            },
            500: function (xhr, status, error) {

                if (st_500 != undefined) {
                    st_500(xhr, status, error);
                } else if (st_404 != undefined) {
                    st_404(xhr, status, error);
                } else {
                    console.log("Ocurrio un problema al realizar la solicitud. intentelo mas tarde<br>");
                }
            },
            301: function (xhr, status, error) {
                if (st_301 != undefined) {
                    st_301(xhr, status, error);
                } else if (st_404 != undefined) {
                    st_404(xhr, status, error);
                } else {
                    console.log("Ocurrio un problema al realizar la solicitud. intentelo mas tarde<br>");
                }
            },
            300: function (xhr, status, error) {
                console.log("Sesion a expirado");
            }, 401: function (xhr, status, error) {
                swal("", MG.error_session, "error")
            }

        }
    });


    return contenido;
}
;

var respuestaAjax = function (texto, tipo) {
    Messenger.options = {theme: 'air'}, Messenger().post({
        message: texto,
        type: tipo,
        showCloseButton: !0
    });
};

$.fn.extend({
  animateCss: function(animationName, callback) {
    var animationEnd = (function(el) {
      var animations = {
        animation: 'animationend',
        OAnimation: 'oAnimationEnd',
        MozAnimation: 'mozAnimationEnd',
        WebkitAnimation: 'webkitAnimationEnd',
      };

      for (var t in animations) {
        if (el.style[t] !== undefined) {
          return animations[t];
        }
      }
    })(document.createElement('div'));

    this.addClass('animated ' + animationName).one(animationEnd, function() {
      $(this).removeClass('animated ' + animationName);

      if (typeof callback === 'function') callback();
    });

    return this;
  },
});