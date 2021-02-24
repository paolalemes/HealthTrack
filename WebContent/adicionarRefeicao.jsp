<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Health Track - Adicionar Refei��o</title>
<%@ include file="head.jsp" %>
</head>
<body>
	<main class="container p-md-5">
            <div class="card border-info container mt-5">
                <div class="row card-header border-info text-info my-0 py-0">
                    <p class="col p-0 m-0"><i class="fas fa-utensils"></i> Refei��o</p>            
                </div>
                <c:if test="${not empty msg }">
                	<div class="alert alert-success">${msg}</div>
                </c:if>  
                <c:if test="${not empty erro }">
                	<div class="alert alert-danger">${erro}</div>
                </c:if>                         
                <div class="card-body text-center">
                    <form method="post" action="refeicao">
                    <input type="hidden" value="cadastrar" name="acao" required>
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
                                <label class="input-group-text" for="refeicao">Refei��o</label>
                            </div>
                            <select class="custom-select" name="refeicao" id="refeicao" required>
                                <option value="1">Caf� da Manh�</option>
                                <option value="2">Lanche</option>
                                <option value="3">Almo�o</option>
                                <option value="4">Jantar</option>
                                <option value="5">Ceia</option>
                            </select>
                        </div>
    
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="kcal">Calorias</label>
                            </div>
                            <input class="form-control" type="number" name="kcal" id="kcal" placeholder="kcal" required>
                        </div>
    
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="descr">Descri��o</label>
                            </div>
                            <input class="form-control" type="text" name="descr" id="descr" placeholder="">
                        </div>
    
                    <input class="btn btn-info rounded-pill text-center" type="submit" value="Adicionar">
                    <a class="btn btn-info rounded-pill text-center" href="refeicao?acao=listar">Cancelar</a>
                    </form>
                </div>
            </div>
        </main>
        
        <%@ include file="scripts.jsp" %>
</body>
</html>