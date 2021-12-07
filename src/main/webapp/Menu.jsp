
<script type="text/javascript">
    	var usuario = sessionStorage.getItem('usuario');
    	if(usuario == null){
    		window.location.href = "./Index.html";
    	}
    </script>
<%
int rol=0;
try{
	rol = (int)session.getAttribute("rol");
}
catch(Exception e){
	%>
	<script>window.location.href = "./Index.html";
	</script>
	<%
}
%>
<main>
    <nav class="navbar navbar-expand-md navbar-light"
        style="background: linear-gradient(to right, #51ceff, #5980ff);" aria-label="Fourth navbar example">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"> <img src="./img/<%=request.getParameter("img")%>.png" alt="" width="30" height="24"> Tienda de
                Viveres</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExample04">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="./Inicio.jsp">Inicio</a>
                    </li>
                    <%
                	if(rol == 1){
                	%>
	                    <li class="nav-item">
	                        <a class="nav-link active" href="./Usuarios.jsp?img=usuario1">Usuarios</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link active" href="./Clientes.jsp?img=clientes1">Clientes</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link active" href="./Proveedores.jsp?img=proveedores1">Proveedores</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link active" href="./Productos.jsp?img=productos1">Productos</a>
	                    </li>
                    <% }%>
                    <li class="nav-item">
                        <a class="nav-link active" href="./Ventas.jsp?img=compras1">Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="./Reportes.jsp?img=reportes1">Reportes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="./Consolidado.jsp?img=consolidacion">Consolidación</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown" style="text-align: right; width: 220px">
			
			<button style="border: none"
				class="btn btn-outline-light dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="true">
				Usuario logeado
			</button>
			<div class="dropdown-menu text-center">
				<a class="dropdown-item" href="#"><img src="img/usuario.png"
					alt="30" width="30" /></a> <a class="dropdown-item" href="#">Usuario
					logeado</a> <a class="dropdown-item" href="#"></a>
				
				<div class="dropdown-divider"></div>
				<a class="dropdown btn btn-outline-primary" style="border: none"
					href="Index.html">SALIR</a>
			</div>
		</div>
        </div>
    </nav>
</main>
