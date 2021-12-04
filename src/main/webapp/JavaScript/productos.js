var usuarios = $.ajax({
	type: "GET",
	url: "./productos",
	success: function(data){
		$.each(data, function(i, item){
			lista = document.getElementById("myTable");				
			var tr = document.createElement("tr");
			var columna1 = document.createElement("td");
			columna1.innerHTML = item.codigo_producto;
			var columna2 = document.createElement("td");
			columna2.innerHTML = item.iva_compra;
			var columna3 = document.createElement("td");
			columna3.innerHTML = item.nombre_producto;
			var columna4 = document.createElement("td");
			columna4.innerHTML = item.precio_compra;
			var columna5 = document.createElement("td");
			columna5.innerHTML = item.precio_venta;
			var columna6 = document.createElement("td");
			columna6.innerHTML = item.nit_proveedor;
			tr.appendChild(columna1);
			tr.appendChild(columna2);
			tr.appendChild(columna3);
			tr.appendChild(columna4);
			tr.appendChild(columna5);
			tr.appendChild(columna6);
			lista.appendChild(tr);
		});
	}
});
	



$(document).ready(function(){
	  $("#cargar").click(function(){
		  var form = new FormData();
		  form.append("file", $("#archivo")[0].files[0]);
			var request = $.ajax({
	            url: "./productos",
	            method: "post",
	            data: form,
	            dataType: "json",
	            contentType: false,
	            processData: false,
	            mimeType: "multipart/form-data"
	        });
			request.done(function(respuesta) {
	            if(respuesta.message ==="Carga del archivo exitosa"){
	            	sessionStorage.setItem('exito', true);
	            	window.location.href= "./Productos.jsp?img=productos1";
	            }
	            else{
	            	$('.toast').toast('show');
	            	$("#strong").text("Error");
	            	$("#small").text("Error al cargar");
	            	$("#toast_body").text("No se pudieron cargar los productos.");        	
	            }
			});
			request.fail(function(textStatus) {
				$('.toast').toast('show');
	        	$("#strong").text("Error");
	        	$("#small").text("Error al cargar");
	        	$("#toast_body").text(textStatus.responseJSON.message);
	        });  
	  	});
	  if(sessionStorage.getItem('exito')){
		  	$('.toast').toast('show');
	    	$("#strong").text("Exito");
	    	$("#small").text("Exito al cargar");
	    	$("#toast_body").text("los productos fueron cargados exitosamente.");
	    	sessionStorage.removeItem('exito');
	  }
});






$(document).ready(function(){
	function crearActualizar(strong,small){
		  // los parametros que se enviaran a la API (JSON)
	       var datos = JSON.stringify({
	          	codigo_producto: $("#texto_codigo").val(),
	          	iva_compra:$("#texto_iva").val(),
	          	nit_proveedor: $("#texto_proveedor").val(),
	          	nombre_producto: $("#texto_producto").val(),
	          	precio_compra: $("#texto_compra").val(),
				precio_venta: $("#texto_venta").val()
				
	        });
			  //el request con toda la informacion del lugar que se consultará
	        var request = $.ajax({
	            url: "./productos/agregar",
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
	            	$("#toast_body").text("Producto no se pudo "+ small +".");
	            }
	            else{
	            	$('.toast').toast('show');
	            	$("#strong").text(strong);
	            	$("#small").text("Exito al "+strong);
	            	$("#toast_body").text("Producto se "+small+" exitosamente.");		            	
	            }
	        });
			  //en caso de que el requerimiento falle
	        request.fail(function(jqXHR, textStatus) {
	            alert("Hubo un error: " + textStatus);
	        });  
	  }
	
		
	//CONSULTAR	por Id
	  $("#consultar").click(function(){
		if($("#texto_codigo").val()===""){
				$('.toast').toast('show');
            	$("#strong").text("Vacios");
            	$("#small").text("Espacios vacios");
            	$("#toast_body").text("Por favor llene el codigo");
		}else{
	        var request = $.ajax({
		        url: "./productos/" + $("#texto_codigo").val() ,
		        method: "get",
		        dataType: "json",
		        contentType:'application/json'
	        });
	        request.done(function(respuesta) {
	        	console.log(respuesta);
	            if(respuesta === null){
	            	$('.toast').toast('show');
	            	$("#strong").text("Consultar");
	            	$("#small").text("Error al consultar");
	            	$("#toast_body").text("Producto no existe.");
	            }
	            else{
	            	$("#texto_codigo").val(respuesta.codigo_producto);
	            	$("#texto_iva").val(respuesta.iva_compra);
	            	$("#texto_proveedor").val(respuesta.nit_proveedor);
	            	$("#texto_producto").val(respuesta.nombre_producto);
	            	$("#texto_compra").val(respuesta.precio_compra);
					$("#texto_venta").val(respuesta.precio_venta);
	            }
	        });
	        request.fail(function(jqXHR, textStatus) {
	            alert("Hubo un error: " + textStatus);
	        });	
		}

	  });
	
	//CREAR
	  $("#crear").click(function(){
			if($("#texto_codigo").val()==="" || $("#texto_iva").val()==="" || $("#texto_proveedor").val()==="" || $("#texto_producto").val()==="" || $("#texto_compra").val()===""|| $("#texto_venta").val()===""){
					$('.toast').toast('show');
		        	$("#strong").text("Vacios");
		        	$("#small").text("Espacios vacios");
		        	$("#toast_body").text("Por favor no deje espacios vacios");	
			}else{
				crearActualizar("Crear","crea"); 
			}  
	  });
	//ACTUALIZAR
	  $("#actualizar").click(function(){
			if($("#texto_codigo").val()==="" || $("#texto_iva").val()==="" || $("#texto_proveedor").val()==="" || $("#texto_producto").val()==="" || $("#texto_compra").val()===""|| $("#texto_venta").val()===""){
					$('.toast').toast('show');
		        	$("#strong").text("Vacios");
		        	$("#small").text("Espacios vacios");
		        	$("#toast_body").text("Por favor no deje espacios vacios");	
			}else{
				crearActualizar("Actualizar","actualiza");
			}	
  		});
    
	  //BORRAR
   	  $("#borrar").click(function(){
			if($("#texto_codigo").val()===""){
					$('.toast').toast('show');
	            	$("#strong").text("Vacios");
	            	$("#small").text("Espacios vacios");
	            	$("#toast_body").text("Por favor llene el Codigo");
			}else{
					var request = $.ajax({
					            url: "./productos/"+ $("#texto_codigo").val() ,
					            method: "delete",
					            dataType: "text",
					            contentType:'application/json'
		    		});
				    request.done(function(respuesta) {
			        	if(respuesta==="Error Eliminado Cliente"){
			        		$('.toast').toast('show');
			            	$("#strong").text("Borrar");
			            	$("#small").text("Error al borrar");
			            	$("#toast_body").text("Producto no se pudo borrar.");
			        	}
			        	else{
				        	$('.toast').toast('show');
			            	$("#strong").text("Borrar");
			            	$("#small").text("Exito al borrar");
			            	$("#toast_body").text("Producto se borra exitosamente.");
				        }
				    });
				    request.fail(function(jqXHR, textStatus) {
			            alert("Hubo un error: " + textStatus);
			        });
			}
   		});
		function bordesTodos(){
			  	$('#texto_codigo').css('border-color', 'red'); 
	   			$('#texto_iva').css('border-color', 'red');
	   			$('#texto_proveedor').css('border-color', 'red'); 
	   			$('#texto_producto').css('border-color', 'red');
	   			$('#texto_compra').css('border-color', 'red');
				$('#texto_venta').css('border-color', 'red');
	  	}
		function resetTodos(){
			  $('#texto_codigo').css('border-color', ''); 
 				$('#texto_iva').css('border-color', '');
 				$('#texto_proveedor').css('border-color', ''); 
	   			$('#texto_producto').css('border-color', '');
	   			$('#texto_compra').css('border-color', '');
				$('#texto_venta').css('border-color', '');
 		}
		
		$('#consultar').hover(function() { 
	   			$('#texto_codigo').css('border-color', 'red'); 
	   			}, function() { // on mouseout, reset the background colour 
	   				$('#texto_codigo').css('border-color', ''); 
		}); 
	   	$('#crear').hover(function() { 
	   			 bordesTodos();
	   			}, function() { // on mouseout, reset the background colour 
	   				 resetTodos();
		}); 
	   	$('#actualizar').hover(function() { 
	   			 bordesTodos();
	   			}, function() { // on mouseout, reset the background colour 
	   				 resetTodos();
		}); 
	   	$('#borrar').hover(function() { 
	   			$('#texto_codigo').css('border-color', 'red'); 
	   			}, function() { // on mouseout, reset the background colour 
	   				$('#texto_codigo').css('border-color', ''); 
		});
		
	
	});
	
	