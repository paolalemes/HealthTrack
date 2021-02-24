<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Health Track - Refeição</title>
<%@ include file="head.jsp" %>
</head>
<body>
        <header class="container fixed-top bg-white">
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                      <a class="nav-link active" href="refeicao.jsp">Alimentos Consumidos</a>
                    </li>
                </ul>
        </header>
        <main class="refeicao container text-center">
            <div class="row border-bottom border-info">
                <div class="col-3 p-0">
                    <p class="p-0 m-0">Refeição</p>
                </div>
                <div class="col p-0">
                    <p class="p-0 m-0">Calorias</p>
                </div>
                <div class="col-4 p-0">
                    <p class="p-0 m-0">Descrição</p>
                </div>
                <div class="col p-0">
                    <p class="p-0 m-0">Opções</p>
                </div>
            </div>

            <c:forEach items="${refeicoes}" var="r">
	            <div class="row border-bottom align-items-center">
	                <div class="col-3 p-0 m-0">
	                    <small class=""> ${r.tipoRefeicao.nomeRefeicao } </small>
	                </div>
	                <div class="col p-0">
	                    <small class="p-0 m-0">${r.calorias }<small class="text-muted">kcal</small></small>
	                </div>
	                <div class="col-4 p-0">
	                    <small class="p-0 m-0">${r.descricao} </small>
	                </div>
	                <div class="col p-0">
	                	<c:url value="refeicao" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="codigo" value="${r.codigoRefeicao}"/>
						</c:url>
	                    <a class="text-info" href="${link }"><i class="fas fa-pencil-alt"></i></a>
	                    <button type="button" class="text-info border-0 shadow-0 bg-white" data-toggle="modal" data-target="#excluirModal" onclick="codigoExcluir.value = ${r.codigoRefeicao}">
  							<i class="fas fa-trash"></i>
						</button>
	                </div>
	            </div>
			</c:forEach>
			
        <div class="fixed-bottom text-center mb-5">
            <a class="btn btn-info rounded-pill mb-1" href="adicionarRefeicao.jsp">Adicionar Refeição</a>
        </div>
        
        <%@ include file="footer.jsp" %>
        
         <!-- Modal -->
		<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        		Deseja realmente excluir a refeição?
		      </div>
		      <div class="modal-footer">
		      	<form action="refeicao" method="post">
		      		<input type="hidden" name="acao" value="excluir">
		      		<input type="hidden" name="codigo" id="codigoExcluir">
			        <button type="button" class="btn btn-outline-info" data-dismiss="modal">Cancelar</button>
			        <button type="submit" class="btn btn-info">Excluir</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
        
		<%@ include file="scripts.jsp" %>

</body>
</html>