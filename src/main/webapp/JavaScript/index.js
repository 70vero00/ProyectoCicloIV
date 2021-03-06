$(document).ready(function(){
		// evento de darle clic al boton con id="inicio"
	  $("#inicio").click(function(){
		  // los parametros que se enviaran a la API (JSON)
	    var datos = JSON.stringify({
	      	"usuario": $("#usuario").val(),
	    	"password": $("#password").val()
	    });
		  //el request con toda la informacion del lugar que se consultar√°
	    var request = $.ajax({
	        url: "./usuarios/login", 
	        method: "post", 
	        data: datos,
	        dataType: "json",
	        contentType:'application/json'
	    });
		  //esta es la respuesta obtenida de la API
	    request.done(function(respuesta) {
	        if(respuesta.cedula_usuario === 0){
	        	$('.toast').toast('show');
	        }
	        else{
				sessionStorage.setItem('usuario', respuesta.cedula_usuario);
	        	window.location.href = "./Inicio.jsp?rol="+respuesta.rol;
	        }
	    });
		  //en caso de que el requerimiento falle
	    request.fail(function(jqXHR, textStatus) {
	        alert("Hubo un error: " + textStatus);
	    });
	  });
	});