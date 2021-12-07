
 




var venta = $.ajax({
	type: "GET",
	url: "./ventas",
	success: function(data){
			var tr = document.createElement("tr");
			var column1 = document.createElement("td");	
			//var column2 = document.createElement("td");	
			lista2 = document.getElementById("Tabla_total_ventas");
			//lista3 = documemt.getElementById("cedula_cliente");	
			var suma=0;
		$.each(data, function(x, item){						
             suma+=(parseFloat(item.total_venta));             			
		});
		  document.getElementById('total').innerHTML = suma;
		  tr.appendChild(column1);
		  lista2.appendChild(tr);
	      //lista3.appendChild(tr);
	}
});



$(document).ready(function(){
	var usuario = sessionStorage.getItem('usuario');
	var ventas = $.ajax({
	type: "GET",
	url: "./ventas",
	success: function(data){
		
		$.each(data, function(i, item){
			
			lista = document.getElementById("Tabla_lista_ventas");				
			var tr = document.createElement("tr");		
			var columna1 = document.createElement("td");
			columna1.innerHTML = item.cliente;
			var columna2 = document.createElement("td");
			columna2.innerHTML = item.nombre_cliente;
			var columna3 = document.createElement("td");
			columna3.innerHTML = item.total_venta;
			tr.appendChild(columna1);
			tr.appendChild(columna2);
			tr.appendChild(columna3);
			lista.appendChild(tr);
			
			
					
		});
	}
});


	

	function crearActualizar(strong,small){
		//var totalventa = parseFloat($("#total").val());
		var venta = $.ajax({
	type: "GET",
	url: "./ventas",
	success: function(data){
			var tr = document.createElement("tr");
			var column1 = document.createElement("td");	
			//var column2 = document.createElement("td");	
			lista2 = document.getElementById("Tabla_total_ventas");
			//lista3 = documemt.getElementById("cedula_cliente");	
			var suma=0;
		$.each(data, function(x, item){						
             suma+=(parseFloat(item.total_venta));             			
		});
		  var totalventa = document.getElementById('total').innerHTML = suma;
		  tr.appendChild(column1);
		  lista2.appendChild(tr);
	      //lista3.appendChild(tr);
var datos = JSON.stringify({
	          	"id": 1,
			    	"ciudad": "BOGOTA",
					//"totalventas": parseFloat($("#total").val())
					"totalventas": totalventa
	        });
			  //el request con toda la informacion del lugar que se consultará
	        var request = $.ajax({
		            url: "./consolidado",
		            method: "post",
					data: datos,
		            dataType: "json",
		            contentType:'application/json'
		        });
 //esta es la respuesta obtenida de la API
	        request.done(function(respuesta) {
	            if(respuesta === null){
	            	$('.toast').toast('show');
	            	$("#strong").text(strong);
	            	$("#small").text("Error al "+small);
	            	$("#toast_body").text("El consolidado no se pudo "+ small +".");
	            }
	            else{
	            	$('.toast').toast('show');
	            	$("#strong").text(strong);
	            	$("#small").text("Exito al "+strong);
	            	$("#toast_body").text("El Total Ventas se "+small+" exitosamente al consolidado de la Tienda.");		            	
	            }
	        });
			  //en caso de que el requerimiento falle
	        request.fail(function(jqXHR, textStatus) {
	            alert("Hubo un error: " + textStatus);
	        });  

	}
	
	 
	  
});

	
	        
	  }
	
		
	
	
	//CREAR
	  $("#crear").click(function(){
			crearActualizar("Crear","envio");
	
	  });
	
		
		
	});
	
	
