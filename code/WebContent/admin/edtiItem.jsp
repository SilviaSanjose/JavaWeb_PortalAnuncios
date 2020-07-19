<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- añado jstl para meter código java. Lo llamo c -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Anuncio</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<div class="container">


	<h3 class="my-5">Actualiza tu anuncio</h3>
	
	<form name="form" action="ServletSaveChanges" method="post" enctype="multipart/form-data">
		<div class="form-row">
			<div class="form-group col-md-8">
				<label>Artículo</label>
				<input  class="form-control" type="text" name="articulo" value="${item.articulo}"/> 
			</div>
			<div class="form-group col-md-4">
				<label>Categoría</label>
				<select class="form-control" name="id_Category">
					<c:forEach items="${categories}" var="cat">
					 	<c:if test="${cat.id == item.idCategoria}">
							<option selected value="${cat.id}">${cat.nombre}</option>
						</c:if>
							<option value="${cat.id}">${cat.nombre}</option>
					</c:forEach>
				</select> 
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-12">
				<span class="pr-3">Acepta Cambios</span>
				<div class="form-check-inline form-check">
					<input  class="form-check-input" type="radio" name="cambio" value="Si" ${checkedSi}/>
					<label class="form-check-label">Si</label>
				</div>
				<div class="form-check-inline form-check">
					<input  class="form-check-input" type="radio" name="cambio" value="No" ${checkedNo}/>
					<label class="form-check-label">No</label>
				</div> 
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-12">
				<label>Anuncio</label>
				<textarea class="form-control"name="anuncio" rows="7"  maxlength="300" >${item.anuncio}</textarea> 
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="envio" value="true" ${check}>   
					<label class="form-check-label">Envío</label>
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-2">
				<label>Precio</label>
				<input  class="form-control" type="number" step="0.01" name="precio" value="${item.precio}"/> 
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label>Teléfono</label>
				<input  class="form-control" type="number" name="telefono" maxlength="9" value="${item.telefono}"/>
			</div>
			<div class="form-group col-md-6">
				<label>Email</label>
				<input  class="form-control" type="email" name="email" value="${item.email}"/> 
			</div>
		</div>
		<div class="form-row mb-4">
			<input class="col-md-6" type="file" name="img" id="imJs" onchange="document.getElementById('newfile').setAttribute('checked','true')" > <br/>
		</div>	
		<input  class="form-control" type="checkbox" hidden="true" name="newfile" id="newfile" >
		<input  class="form-control" type="hidden" name="id" value="${item.id}"/>
		
		<button class="btn btn-primary" type="submit">ACTUALIZAR</button>  
		
	</form>
</div>
</body>
</html>