<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilos_agregar.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <title>Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  	<script src="./JavaScript/usuarios.js"></script>    
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<%try{
	int rol = (int)session.getAttribute("rol");
	if(rol!=1){
		%>
		<script>window.location.href = "./SinPermiso.jsp?img=usuario1";
		</script>
		<%
	}
}
catch(Exception e){
	
}
%>

<div class="container py-3">
    
     <h1 class="titulo">GESTIONAR USUARIO</h1>
    <div class="card bg-dark text-white" >
    
	<form method="post" accept-charset="utf-8" id="form">
	<img class="img" src="img/3.jpg" alt="100" width="420" />
	
	<div class="card-body">
	<div class="contenedor">
	<div class="row justify-content-center">
	<div class="col-md-11">
	    <div class="container pt-3">
	        <div class="mb-3">
	            <label for="texto_cedula" class="form-label">Cédula</label>
	            <input type="number" class="form-control" id="texto_cedula"
	                placeholder="Ingrese numero de documento de identidad" name="texto_cedula" value="">
	        </div>        
	        <div class="mb-3">
	            <label for="texto_nombre" class="form-label">Nombre Completo</label>
	            <input type="text" class="form-control" id="texto_nombre" placeholder="Ingrese Nombres y apellidos" name="texto_nombre"
	            	value="">
	        </div>
	        <div class="mb-3">
	            <label for="texto_correo" class="form-label">Correo Electronico</label>
	            <input type="email" class="form-control" id="texto_correo" placeholder="Ingrese Correo Electronico" name="texto_correo"
	            	value="">
	        </div>
	        <div class="mb-3">
	            <label for="texto_usuario" class="form-label">Usuario</label>
	            <input type="text" class="form-control" id="texto_usuario" placeholder="Ingrese Usuario" name="texto_usuario"
	            	value="">
	        </div>
	        <div class="mb-3">
	            <label for="texto_contra" class="form-label">Contraseña</label>
	            <input type="password" class="form-control" id="password" placeholder="Ingrese Constraseña" name="password">
	            <input type="hidden" id="rol" name="rol" value="">
	        </div>
	
	        <div class="d-grid gap-3 d-md-block">
	            <button class="btn btn-primary" type="button" name="boton_consultar_usuario" id="consultar">Consultar</button>
	            <button class="btn btn-success" type="button" name="boton_crear_usuario" id="crear">Crear</button>
	            <button class="btn btn-info" type="button" name="boton_actualizar_usuario" id="actualizar">Actualizar</button>
	            <button class="btn btn-danger" type="button" name="boton_borrar_usuario" id="borrar">Borrar</button>
	        </div>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</body>
</html>