
function obtenerLogin()
{
    var correo = document.getElementById('idCorreo');
    var pass = document.getElementById('idPass');

    document.cookie = 'usuario = ' + correo.value;

    var usr = {
        'correo': correo.value,
        'password': pass.value
    };

    var data = new FormData();
    data.append("usr", JSON.stringify(usr));


    enviarDatos('Servlet_login', data, redireccionar);
    return false;
}
function enviarDatos(servicio, datos, callback)
{
    fetch(servicio, {
        method: 'POST',
        body: datos
    }).then((result) => {
        return result.json();
    }).then(callback);
}

function redireccionar(res) {
    if (res.respuesta) {
        window.location.href = 'sesion.jsp';
    } else
    {
        correo.value = '';
        pass.value = '';
    }
}

function enviarCorreo()
{
    var destinatario = document.getElementById("correo").value;
    var asunto = document.getElementById("asunto").value;
    var mensaje = document.getElementById("msg").value;
    var estado = destinatario.indexOf("@eif209.una.ac.cr") !== -1;
    var usr = document.cookie.split('=')[1];
    var email = {
        'destinatario': destinatario,
        'asunto': asunto,
        'mensaje': mensaje,
        'emisor': usr,
        'isEstado':estado
    };

    var formdata = new FormData();

    formdata.append('email', JSON.stringify(email));

    enviarDatos('Servicio_email',formdata,(res)=>{console.log(res);})
}
