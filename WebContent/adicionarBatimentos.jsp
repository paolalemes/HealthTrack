<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Health Track - Adicionar Batimentos</title>
<%@ include file="head.jsp" %>
</head>
<body>
	<main class="container p-md-5">
            <div class="card border-info container mt-5">
                <div class="row card-header border-info text-info my-0 py-0">
                    <p class="col p-0 m-0"><i class="fas fa-heartbeat"></i> Batimentos</p>            
                </div>  
                <c:if test="${not empty msg }">
                	<div class="alert alert-success">${msg}</div>
                </c:if>  
                <c:if test="${not empty erro }">
                	<div class="alert alert-danger">${erro}</div>
                </c:if>                         
                <div class="card-body text-center">
                    <form action="batimentos" method="post" class="">
                    <input type="hidden" value="cadastrar" name="acao">
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="dt">Data</label>
                            </div>
                            <input class="form-control" type="date" name="dt" id="dt" required>
                        </div>
    
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="hr">Hora</label>
                            </div>
                            <input class="form-control" type="time" name="hr" id="hr" required>
                        </div>
    
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="bpm">Batimentos</label>
                            </div>
                            <input class="form-control" type="number" name="bpm" id="bpm" placeholder="b.p.m." required>
                        </div>
    
	                    <input class="btn btn-info rounded-pill text-center" value="Adicionar" type="submit">
	                    <a class="btn btn-info rounded-pill text-center" href="batimentos?acao=listar">Cancelar</a>
                    </form>

                </div>
            </div>
        </main>
        
        <%@ include file="scripts.jsp" %>
</body>
</html>