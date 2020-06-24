function obtenerLogin()
{
    var correo = document.getElementById('idCorreo').value;
    console.log(correo);
    var pass = document.getElementById('idPass').value;

    var usr = {
        'correo': correo,
        'password': pass
    };
    enviarLogIn(usr);
}
function eliminarCorreo(){
    console.log("Se elimina correo");
}
function enviarLogIn(datos, callback)
{
    var form_data = new FormData();
    form_data.append('usuario',JSON.stringify(datos));
    var xobj = new XMLHttpRequest();
    xobj.overrideMimeType("application/json");
   
    xobj.open('POST', 'Servlet_login?usuario='+JSON.stringify(datos), true);
    xobj.send();
    
    xobj.onreadystatechange = function () {
        if (xobj.readyState === 4 && xobj.status === 200) {
            console.log(JSON.parse(xobj.responseText));
        }
    }
}