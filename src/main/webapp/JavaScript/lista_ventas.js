


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
			columna2.innerHTML = item.cedula_cliente;
			var columna3 = document.createElement("td");
			columna3.innerHTML = item.total_venta;
			tr.appendChild(columna1);
			tr.appendChild(columna2);
			tr.appendChild(columna3);
			lista.appendChild(tr);
					
		});
	}
});


 






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




