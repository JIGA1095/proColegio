var iniciarAjax = function () {
    $.blockUI({
        message: '<div class="form-group"><h1>Procesando<i class="fa fa-spinner fa-pulse fa-lg fa-fw"></i></h1></div>',
        css: {
            message: 'Procesando...',
            border: 'none',
            padding: '10px 10px',
            backgroundColor: '#000',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: .5,
            color: '#fff'
        }
    });
};

var notificacion = function (title,message) {
    ios.notify({
        title: title,
        message: message
    });

}


