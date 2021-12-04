<%@ page language="java"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilos_agregar.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    
    <title>Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   	<script src="./JavaScript/productos.js"></script>

</head>

<body>
<jsp:include page="Menu.jsp"></jsp:include>
<%try{
	int rol = (int)session.getAttribute("rol");
	if(rol!=1){
		%>
		<script>window.location.href = "./SinPermiso.jsp?img=productos1";
		</script>
		<%
	}
}
catch(Exception e){
	
}
%>
	<div align='center'>
		<div class="toast">
	    	<div class="toast-header">
	      		<strong class="mr-auto text-primary" id="strong"></strong>
	      		<small class="text-muted" id="small"></small>
	    	</div>
	    	<div class="toast-body" id="toast_body"></div>
	  	</div>
	</div>
	<br>
    <container pt-3>
	    <form enctype="multipart/form-data">
	    <br>
	        <div class="mb-3">
	        <h3>
	            <label for="archivo" class="form-label">Ingrese archivo de productos</label>
	            
	            </h3>
	            <div class="input-group">
  <input type="file" class="form-control" id="archivo" name="file" placeholder="" accept='.csv' required aria-describedby="inputGroupFileAddon04" aria-label="Upload" required>
  <button class="btn btn-outline-primary" type="button" name="boton_cargar_archivo_productos" id="cargar">Cargar</button>
</div>

	                
	        </div>
	       
        </form>
    </container>
    
    
    
    
    
    <div class="container py-3">
    
    
    <div class="card bg-dark text-white" >
    
    <form id="from">
    
    
    <img class="img" src="img/productos.jpg" alt="50" width="370" />
    
    <div class="card-body">
    
	<div class="contenedor">
    <div class="row justify-content-center">
    <div class="col-md-10">
    
        <div class="mb-3">
        
            <label for="texto_codigo" class="form-label">Código</label>
            <input type="number" class="form-control" id="texto_codigo"
                placeholder="Ingrese numero de código del producto" name="texto_codigo_producto" value="">
        </div>
        
        <div class="mb-3">
            <label for="texto_iva" class="form-label">Iva Compra</label>
            <input type="text" class="form-control" id="texto_iva" placeholder="Ingrese el valor del IVA" name="texto_iva_compra" value="">
        </div>
        <div class="mb-3">
            <label for="texto_producto" class="form-label">Producto</label>
            <input type="text" class="form-control" id="texto_producto" placeholder="Ingrese el nombre del Producto" name="texto_nombre_producto" value="">
        </div>
        <div class="mb-3">
            <label for="texto_compra" class="form-label">Precio Compra</label>
            <input type="tel" class="form-control" id="texto_compra" placeholder="Ingrese el precio de compra" name="texto_precio_compra" value="">
        </div>
        <div class="mb-3">
            <label for="texto_venta" class="form-label">Precio Venta</label>
            <input type="email" class="form-control" id="texto_venta" placeholder="Ingrese el precio de venta" name="texto_precio_venta" value="">
        </div>
        <div class="mb-3">
            <label for="texto_proveedor" class="form-label">NIT Proveedor</label>
            <input type="email" class="form-control" id="texto_proveedor" placeholder="Ingrese el número NIT del Proveedor" name="texto_nit_proveedor" value="">
        </div>

        <div class="d-grid gap-3 d-md-block">
            <button class="btn btn-primary" type="button" name="boton_consultar_cliente" id = "consultar">Consultar</button>
            <button class="btn btn-success" type="button" name="boton_crear_cliente" id = "crear">Crear</button>
            <button class="btn btn-info" type="button" name="boton_actualizar_cliente" id = "actualizar">Actualizar</button>
            <button class="btn btn-danger" type="button" name="boton_borrar_cliente" id = "borrar">Borrar</button>
        </div>
    </div>
    </div>
    </div>
    </div>
    
    </form>
    </div>
    
    </div>
    

<div align='center'>
		<div class="toast">
	    	<div class="toast-header">
	      		<strong class="mr-auto text-primary" id="strong"></strong>
	      		<small class="text-muted" id="small"></small>
	    	</div>
	    	<div class="toast-body" id="toast_body"></div>
	  	</div>
	</div>
    
    
    <h2 class="text-center">Lista de Productos</h2>
    <div class="container py-3">
    <div class="col-md-15">
    <div class="row justify-content-center">
    <table class="table table-striped">
        <thead class="table-dark"> 
            <tr>
                <th scope="col" >Código</th>
                <th scope="col">Iva Compra</th>
                <th scope="col">Producto</th>
                <th scope="col">Precio Compra</th>
                <th scope="col">Precio Venta</th>
                <th scope="col">NIT Proveedor</th>
            </tr>
        </thead>
        <tbody id = "myTable">
        
        </tbody>
    </table>
    </div>
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>

</html>