<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- añado jstl para meter código java. Lo llamo c -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Anuncios</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<div class="container my-5">
	<form action="ServletList">
		<div class="form-row">
			<div class="form-group col-md-4">
				<label>Artículo</label>
				<input  class="form-control" type="text" name="article" value="${searchArticle}"/>
			</div>
			<div class="form-group col-md-4">
				<label>Categoría</label>
				<select class="form-control"name="id_category">
					<option>Todas las categorías</option>
					<c:forEach items="${categories}" var="cat">
						<option value="${cat.id}">${cat.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group col-md-4 d-flex align-items-end">	
				<button class="btn btn-primary mr-2" type="submit">Buscar</button> 
			<a href="ServletList" class="btn btn-secondary">Resetear</a>
			</div>
		</div>
	</form>
	
	<p>Total de Anuncios: ${total}</p>
	
	<div style="margin:10px">
	<!-- en test se pone lo que quieres comparar  -->
		<c:if test="${previous >= 0}">
		<a href="ServletList?begin=${previous}&article=${searchArticle}&id_category=${searchId_category}">Anterior</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		<!-- en test se pone lo que quieres comparar  -->
		<c:if test="${next < total}">
		<a href="ServletList?begin=${next}&article=${searchArticle}&id_category=${searchId_category}">Siguiente</a>
		</c:if>
	</div>
	
	<br/>
	
	<c:forEach items="${items}" var="ads">
	
		<div class="card mb-5" >
			<div class="row no-gutters">
				<div class="col-md-4 d-flex align-items-center">
					<img src="images/${ads.id}.jpg" class="card-img imgAd m-auto" onerror="this.src='img/isinimagen.jpg'" /> 
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">${ads.articulo.toUpperCase()}</h5>
						<div class="card-text">
							<p>Categoría: ${ads.categoria.nombre}</p>
						 	<p>Admite cambio: ${ads.cambio}</p>
						 	<p>${ads.anuncio}</p>
						 	<p>Envío: <c:if test="${ads.envio}">Si</c:if>
						 			<c:if test="${!ads.envio}">No</c:if>
						 	</p>
						 	<p>${ads.precio}€</p>
						 	<p>Contacto: ${ads.email} &nbsp;&nbsp;Tlf: ${ads.telefono}</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

</body>
</html>