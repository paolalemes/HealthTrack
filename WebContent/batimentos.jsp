<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Health Track - Batimentos</title>
	<%@ include file="head.jsp" %>
</head>
<body>
	<header class="container fixed-top">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                  <a class="nav-link active" href="batimentos?acao=listar">Batimentos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link text-info" href="pressao?acao=listar">Pressão</a>
                </li>
              </ul>
        </header>
        <main class="batimentos container text-center">
            <div class="row border-bottom border-info p-0">
                <div class="col">
                    <p class="p-0 m-0">Data</p>
                </div>
                <div class="col">
                    <p class="p-0 m-0">Batimentos</p>
                </div>
                <div class="col">
                   <p class="p-0 m-0">Opcões</p>
                </div>
            </div>

           <c:forEach items="${batimentos}" var="b">
           	 <div class="row border-bottom">
				<div class="col">
				    <small>${b.data }</small>
				</div>
				<div class="col">
				    <small>${b.batimentos } <small>b.p.m.</small></small>
				</div>
				<div class="col">
					<c:url value="batimentos" var="link">
						<c:param name="acao" value="abrir-form-edicao"/>
						<c:param name="codigo" value="${b.codigoBatimento}"/>
					</c:url>
				    <a class="text-info" href="${link }"><i class="fas fa-pencil-alt"></i></a>
				    <button type="button" class="text-info border-0 shadow-0 bg-white" data-toggle="modal" data-target="#excluirModal" onclick="codigoExcluir.value = ${b.codigoBatimento}">
  							<i class="fas fa-trash"></i>
						</button>
				</div>
			</div>
				
			</c:forEach>
            
        </main>
        <div class="fixed-bottom text-center mb-5">
            <a class="btn btn-info rounded-pill mb-1" href="adicionarBatimentos.jsp">Adicionar Batimento Cardíaco</a>
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
		        		Deseja realmente excluir o batimento?
		      </div>
		      <div class="modal-footer">
		      	<form action="batimentos" method="post">
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