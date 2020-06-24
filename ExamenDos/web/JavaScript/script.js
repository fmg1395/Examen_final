function obtenerLogin()
{
    var correo = document.getElementById('idCorreo').value;
    console.log(correo);
    var pass = document.getElementById('idPass').value;

    var usr = {
        'correo': correo,
        'password': pass
    };

    enviarLogIn(usr, (redireccionar));
}
function enviarLogIn(datos, callback)
{
    fetch('Servlet_login?datos=' + JSON.stringify(datos)).then(function (resultado) {
        return resultado.json();
    }).then(callback);
}

function redireccionar(jsp) {
    if (jsp.respuesta) {
        window.location.href = 'sesion.jsp';
    }
}