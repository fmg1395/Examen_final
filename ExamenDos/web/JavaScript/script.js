var correo;
var pass;


function obtenerLogin()
{
    correo = document.getElementById('idCorreo');
    pass = document.getElementById('idPass');

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
    }
    else
    {
        correo.value = '';
        pass.value ='';
    }
}
